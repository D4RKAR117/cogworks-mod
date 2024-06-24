package dev.darkar.cog_works.block.item;

import dev.darkar.cog_works.Registry;
import dev.darkar.cog_works.block.item.renderer.TransmissionShaftBlockItemRenderer;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.BlockItem;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;

public class TransmissionShaftBlockItem extends BlockItem implements GeoItem {
	
	private static final Properties itemProperties = new Properties()
		.stacksTo(64);
	
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	
	public TransmissionShaftBlockItem() {
		super(Registry.Blocks.TRANSMISSION_SHAFT.get(), itemProperties);
		SingletonGeoAnimatable.registerSyncedAnimatable(this);
	}
	
	
	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
	
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return cache;
	}
	
	@Override
	public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
		consumer.accept(new GeoRenderProvider() {
			private TransmissionShaftBlockItemRenderer renderer;
			
			@Override
			public BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
				if (renderer == null) {
					renderer = new TransmissionShaftBlockItemRenderer();
				}
				
				return this.renderer;
			}
		});
	}
}
