package dev.darkar.cog_works.item;

import dev.darkar.cog_works.Registry;
import dev.darkar.cog_works.item.component.SampleLocation;
import dev.darkar.cog_works.item.renderer.EmptySampleTubeItemRenderer;
import dev.darkar.cog_works.utils.enums.SampleSiteRegion;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
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

import static dev.darkar.cog_works.Registry.Items.DataComponents.SAMPLE_LOCATION;

public class EmptySampleTubeItem extends Item implements GeoItem {
	
	private static final RawAnimation OPEN_LID = RawAnimation
		.begin()
		.thenPlay("animation.empty_sample_tube.open_lid");
	
	private static final Properties itemProperties = new Properties().stacksTo(32);
	
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	
	public EmptySampleTubeItem() {
		super(itemProperties);
		SingletonGeoAnimatable.registerSyncedAnimatable(this);
	}
	
	@Override
	public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
		consumer.accept(new GeoRenderProvider() {
			private EmptySampleTubeItemRenderer renderer;
			
			@Override
			public BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
				if (renderer == null) {
					renderer = new EmptySampleTubeItemRenderer();
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
			new AnimationController<>(this, "open_lid_controller", 20, state -> PlayState.STOP).triggerableAnim(
				"open_lid", OPEN_LID));
		
	}
	
	
	public void handleSampleCollection(ChunkPos collectedChunkPos, SampleSiteRegion region, Player player, Level level)
	{
		if (level instanceof ServerLevel serverLevel) {
			ItemStack stack = player.getItemInHand(InteractionHand.OFF_HAND);
			
			triggerAnim(player, GeoItem.getOrAssignId(stack, serverLevel), "open_lid_controller", "open_lid");
			
			stack.setCount(stack.getCount() - 1);
			ItemStack filledSampleTube = new ItemStack(Registry.Items.FILLED_SAMPLE_TUBE.get(), 1);
			filledSampleTube.set(SAMPLE_LOCATION, new SampleLocation(collectedChunkPos, region));
			player.addItem(filledSampleTube);
		}
	}
	
}
