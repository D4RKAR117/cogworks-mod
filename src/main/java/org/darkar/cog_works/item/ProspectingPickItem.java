package org.darkar.cog_works.item;

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.LevelChunk;
import net.neoforged.neoforge.common.extensions.IItemExtension;
import org.darkar.cog_works.item.component.IsDiggingSample;
import org.darkar.cog_works.item.renderer.ProspectingPickItemRenderer;
import org.darkar.cog_works.level.chunk.attachment.ChunkSampleSiteMap;
import org.darkar.cog_works.utils.enums.SampleSiteRegion;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

import static org.darkar.cog_works.Registry.DataAttachments.CHUNK_SAMPLE_SITE_MAP;
import static org.darkar.cog_works.Registry.Items.DataComponents.IS_DIGGING_SAMPLE;


public class ProspectingPickItem extends Item implements GeoItem, IItemExtension {
	
	private static final RawAnimation DIG_SAMPLE = RawAnimation.begin().thenPlay(
		"animation.prospecting_pick.dig_sample");
	private static final RawAnimation COLLECT_SAMPLE = RawAnimation.begin().thenPlay(
		"animation.prospecting_pick.collect_sample");
	private static final Properties itemProperties = new Properties().stacksTo(1).durability(128).component(
		IS_DIGGING_SAMPLE, IsDiggingSample.DEFAULT);
	private static final int COOLDOWN_TICKS = 8 * 20;
	
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	private int lastedCooldownTicks = 0;
	
	public ProspectingPickItem() {
		super(itemProperties);
		SingletonGeoAnimatable.registerSyncedAnimatable(this);
	}
	
	@Override
	public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
		consumer.accept(new GeoRenderProvider() {
			private ProspectingPickItemRenderer renderer;
			
			@Override
			public BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
				if (renderer == null) {
					renderer = new ProspectingPickItemRenderer();
				}
				
				return this.renderer;
			}
		});
	}
	
	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.cache;
	}
	
	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
		controllers.add(
			new AnimationController<>(this, "dig_sample_controller", 20, state -> PlayState.STOP).triggerableAnim(
				"dig_sample", DIG_SAMPLE));
		
		controllers.add(
			new AnimationController<>(this, "collect_sample_controller", 20, state -> PlayState.STOP).triggerableAnim(
				"collect_sample", COLLECT_SAMPLE));
	}
	
	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		if (level instanceof ServerLevel serverLevel) triggerAnim(player,
		                                                          GeoItem.getOrAssignId(player.getItemInHand(hand),
		                                                                                serverLevel),
		                                                          "collect_sample_controller", "collect_sample");
		return super.use(level, player, hand);
	}
	
	@Override
	public boolean canAttackBlock(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer) {
		return false;
	}
	
	public void handleLeftClickBlock(Player player, Level level, BlockPos pos) {
		if (level instanceof ServerLevel serverLevel) {
			
			BlockState blockState = serverLevel.getBlockState(pos);
			ItemStack itemStack = player.getItemInHand(InteractionHand.MAIN_HAND);
			
			IsDiggingSample isDiggingSample = itemStack.getOrDefault(IS_DIGGING_SAMPLE, IsDiggingSample.DEFAULT);
			
			Optional<SampleSiteRegion> region = SampleSiteRegion.getRegion(pos.getY());
			
			if (region.isEmpty()) {
				player.sendSystemMessage(Component.literal("Invalid sample location!"));
				return;
			}
			
			Map<SampleSiteRegion, TagKey<Block>> tagsPerRegion = Map.of(SampleSiteRegion.SURFACE,
			                                                            BlockTags.STONE_ORE_REPLACEABLES,
			                                                            SampleSiteRegion.DEEP,
			                                                            BlockTags.DEEPSLATE_ORE_REPLACEABLES);
			
			// Check if block is stone or deepslate
			if (blockState.is(tagsPerRegion.get(region.get())) && !isDiggingSample.value()) {
				
				isDiggingSample = IsDiggingSample.ACTIVE;
				LevelChunk chunk = serverLevel.getChunkAt(pos);
				ChunkSampleSiteMap chunkSampleSiteMap = chunk.getData(CHUNK_SAMPLE_SITE_MAP);
				switch (region.get()) {
					case SURFACE -> {
						boolean needsCollection = !chunkSampleSiteMap.surfacePos().equals(BlockPos.ZERO) &&
						                          (!chunkSampleSiteMap.surfaceState().isAir() &&
						                           serverLevel.getBlockState(chunkSampleSiteMap.surfacePos()).is(
							                           tagsPerRegion.get(SampleSiteRegion.SURFACE)));
						
						itemStack.set(IS_DIGGING_SAMPLE, isDiggingSample);
						player.getCooldowns().addCooldown(this, COOLDOWN_TICKS);
						if (needsCollection) {
							String message = String.format(
								"This chunk already has a surface sampling site. Please collect the surface sample at" +
								" %s" +
								" before placing a new one",
								chunkSampleSiteMap.surfacePos());
							player.sendSystemMessage(Component.literal(message));
							return;
						}
						
						BlockState surfaceSiteState = serverLevel.getBlockState(pos);
						
						triggerAnim(player, GeoItem.getOrAssignId(itemStack, serverLevel), "dig_sample_controller",
						            "dig_sample");
						
						chunkSampleSiteMap = new ChunkSampleSiteMap(pos, chunkSampleSiteMap.deepPos(),
						                                            surfaceSiteState,
						                                            chunkSampleSiteMap.deepState());
						chunk.setData(CHUNK_SAMPLE_SITE_MAP, chunkSampleSiteMap);
					}
					
					case DEEP -> {
						boolean needsCollection = !chunkSampleSiteMap.deepPos().equals(BlockPos.ZERO) &&
						                          (!chunkSampleSiteMap.deepState().isAir() &&
						                           serverLevel.getBlockState(chunkSampleSiteMap.deepPos()).is(
							                           tagsPerRegion.get(SampleSiteRegion.DEEP)));
						
						itemStack.set(IS_DIGGING_SAMPLE, isDiggingSample);
						player.getCooldowns().addCooldown(this, COOLDOWN_TICKS);
						if (needsCollection) {
							String message = String.format(
								"This chunk already has a deep sampling site. Please collect the deep sample at %s " +
								"before placing a new one",
								chunkSampleSiteMap.deepPos());
							player.sendSystemMessage(Component.literal(message));
							return;
						}
						
						BlockState deepSiteState = serverLevel.getBlockState(pos);
						triggerAnim(player, GeoItem.getOrAssignId(itemStack, serverLevel), "dig_sample_controller",
						            "dig_sample");
						chunkSampleSiteMap = new ChunkSampleSiteMap(chunkSampleSiteMap.surfacePos(), pos,
						                                            chunkSampleSiteMap.surfaceState(), deepSiteState);
						chunk.setData(CHUNK_SAMPLE_SITE_MAP, chunkSampleSiteMap);
						
					}
				}
				
			}
		}
		
	}
	
	@Override
	public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
		if (!level.isClientSide()) {
			IsDiggingSample isDiggingSample = stack.getOrDefault(IS_DIGGING_SAMPLE, IsDiggingSample.DEFAULT);
			if (isDiggingSample.value()) lastedCooldownTicks++;
			boolean shouldResetCooldown = isDiggingSample.value() && lastedCooldownTicks >= COOLDOWN_TICKS;
			if (shouldResetCooldown) {
				stack.set(IS_DIGGING_SAMPLE, IsDiggingSample.DEFAULT);
				lastedCooldownTicks = 0;
			}
			
		}
	}
}
