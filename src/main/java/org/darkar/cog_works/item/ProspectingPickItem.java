package org.darkar.cog_works.item;

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.extensions.IItemExtension;
import org.darkar.cog_works.item.component.ToolBehaviour;
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

import static org.darkar.cog_works.Registry.Items.DataComponents.TOOL_BEHAVIOUR;

public class ProspectingPickItem extends Item implements GeoItem, IItemExtension {

	private static final RawAnimation DIG_SAMPLE = RawAnimation.begin().thenPlay("animation.prospecting_pick.dig_sample");
	private static final RawAnimation COLLECT_SAMPLE = RawAnimation.begin().thenPlay("animation.prospecting_pick.collect_sample");
	private static final Properties itemProperties = new Properties().stacksTo(1).durability(128)
	                                                                 .component(TOOL_BEHAVIOUR, new ToolBehaviour(
																		 "digging_sample", false))
		.component(TOOL_BEHAVIOUR, new ToolBehaviour("collecting_sample", false));
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

	public void handleLeftClickBlock(Player player, Level level, BlockPos pos) {
		if (level instanceof ServerLevel serverLevel) {

			BlockState blockState = serverLevel.getBlockState(pos);
			ItemStack itemStack = player.getItemInHand(InteractionHand.MAIN_HAND);


			// Check if block is stone or deepslate
			if (blockState.is(BlockTags.STONE_ORE_REPLACEABLES) || blockState.is(BlockTags.DEEPSLATE_ORE_REPLACEABLES)) {
				ToolBehaviour toolBehaviour = itemStack.getOrDefault(TOOL_BEHAVIOUR, new ToolBehaviour(
					"digging_sample", false));

				if(toolBehaviour.equals(new ToolBehaviour("digging_sample", true))) return;

				toolBehaviour = new ToolBehaviour("digging_sample", true);
				itemStack.set(TOOL_BEHAVIOUR, toolBehaviour);

				player.sendSystemMessage(Component.literal("Digging valid sample..."));
				triggerAnim(player, GeoItem.getOrAssignId(itemStack, serverLevel), "dig_sample_controller", "dig_sample");

				toolBehaviour = new ToolBehaviour("digging_sample", false);
				itemStack.set(TOOL_BEHAVIOUR, toolBehaviour);
			}

		}
	}
}
