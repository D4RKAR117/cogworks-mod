package org.darkar.cog_works.item;

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.darkar.cog_works.item.component.SampleLocation;
import org.darkar.cog_works.item.renderer.FilledSampleTubeItemRenderer;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.List;
import java.util.function.Consumer;

import static org.darkar.cog_works.CogWorks.MOD_ID;
import static org.darkar.cog_works.Registry.Items.DataComponents.SAMPLE_LOCATION;

public class FilledSampleTubeItem extends Item implements GeoItem {
	private static final RawAnimation OPEN_LID = RawAnimation
		.begin()
		.thenPlay("animation.filled_sample_tube.open_lid");
	
	private static final Properties itemProperties = new Properties()
		.stacksTo(1)
		.component(SAMPLE_LOCATION, SampleLocation.DEFAULT);
	
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	
	public FilledSampleTubeItem() {
		super(itemProperties);
		SingletonGeoAnimatable.registerSyncedAnimatable(this);
	}
	
	@Override
	public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
		consumer.accept(new GeoRenderProvider() {
			private FilledSampleTubeItemRenderer renderer;
			
			@Override
			public BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
				if (renderer == null) {
					renderer = new FilledSampleTubeItemRenderer();
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
	
	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> componentList,
	                            TooltipFlag tooltipFlag)
	{
		boolean hasLocation = stack.has(SAMPLE_LOCATION) && !stack
			.get(SAMPLE_LOCATION)
			.equals(SampleLocation.DEFAULT);
		if (hasLocation) {
			SampleLocation location = stack.get(SAMPLE_LOCATION);
			MutableComponent chunkText = Component.translatable(
				String.format("tooltip.%s.sample_location.chunk_pos", MOD_ID), location.chunkPos().x,
				location.chunkPos().z);
			MutableComponent regionText = Component.translatable(
				String.format("tooltip.%s.sample_location.region", MOD_ID), location
					.region()
					.name());
			
			componentList.add(chunkText);
			componentList.add(regionText);
		}
		
		super.appendHoverText(stack, context, componentList, tooltipFlag);
	}
}
