package org.darkar.cog_works.item;

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.extensions.IItemExtension;
import org.darkar.cog_works.item.component.IsDiggingSample;
import org.darkar.cog_works.item.renderer.ProspectingPickItemRenderer;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;

import static org.darkar.cog_works.Registry.Items.DataComponents.IS_DIGGING_SAMPLE;

public class ProspectingPickItem extends Item implements GeoItem, IItemExtension {

	private static final RawAnimation DIG_SAMPLE = RawAnimation.begin().thenPlay("animation.prospecting_pick.dig_sample");
	private static final RawAnimation COLLECT_SAMPLE = RawAnimation.begin().thenPlay("animation.prospecting_pick.collect_sample");
	private static final Properties itemProperties = new Properties().stacksTo(1).durability(128)
	                                                                 .component(IS_DIGGING_SAMPLE,
	                                                                            IsDiggingSample.DEFAULT);

	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

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
		controllers.add(new AnimationController<>(this, "dig_sample_controller", 20, state -> PlayState.STOP).triggerableAnim("dig_sample", DIG_SAMPLE));

		controllers.add(new AnimationController<>(this, "collect_sample_controller", 20, state -> PlayState.STOP).triggerableAnim("collect_sample", COLLECT_SAMPLE));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		if (level instanceof ServerLevel serverLevel)
			triggerAnim(player, GeoItem.getOrAssignId(player.getItemInHand(hand), serverLevel), "collect_sample_controller", "collect_sample");
		return super.use(level, player, hand);
	}


	@Override
	public boolean canAttackBlock(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer) {
		return false;
	}

	private static final int COOLDOWN_TICKS = 8 * 20;

	public void handleLeftClickBlock(Player player, Level level, BlockPos pos) {
		if (level instanceof ServerLevel serverLevel) {

			BlockState blockState = serverLevel.getBlockState(pos);
			ItemStack itemStack = player.getItemInHand(InteractionHand.MAIN_HAND);

			IsDiggingSample isDiggingSample = itemStack.getOrDefault(IS_DIGGING_SAMPLE, IsDiggingSample.DEFAULT);
			// Check if block is stone or deepslate
			if ((blockState.is(BlockTags.STONE_ORE_REPLACEABLES) || blockState.is(BlockTags.DEEPSLATE_ORE_REPLACEABLES)) && !isDiggingSample.value()) {

				isDiggingSample = new IsDiggingSample(true);
				itemStack.set(IS_DIGGING_SAMPLE, isDiggingSample);
				player.sendSystemMessage(Component.literal("Is Digging Sample After: " + isDiggingSample.value() ));
				triggerAnim(player, GeoItem.getOrAssignId(itemStack, serverLevel), "dig_sample_controller", "dig_sample");
				player.getCooldowns().addCooldown(this, COOLDOWN_TICKS);
			}

		}
	}

	private int lastedCooldownTicks = 0;
	@Override
	public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
		if(!level.isClientSide()) {
			IsDiggingSample isDiggingSample = stack.getOrDefault(IS_DIGGING_SAMPLE, IsDiggingSample.DEFAULT);
			if(isDiggingSample.value()) lastedCooldownTicks++;
			boolean shouldResetCooldown = isDiggingSample.value() && lastedCooldownTicks >= COOLDOWN_TICKS;
			if(shouldResetCooldown) {
				stack.set(IS_DIGGING_SAMPLE, IsDiggingSample.DEFAULT);
				lastedCooldownTicks = 0;
			}

		}
	}
}
