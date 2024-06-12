package org.darkar.cog_works.item;

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.Item;
import org.darkar.cog_works.item.renderer.ScrewdriverItemRenderer;
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


public class ScrewdriverItem extends Item implements GeoItem {
	private static final RawAnimation USE = RawAnimation.begin().thenPlay(
		"animation.screwdriver.use");
	
	private static final Properties itemProperties = new Properties().stacksTo(1).durability(128);
	private static final int COOLDOWN_TICKS = 3 * 20;
	
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	public ScrewdriverItem() {
		super(itemProperties);
		SingletonGeoAnimatable.registerSyncedAnimatable(this);
	}
	
	@Override
	public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
		consumer.accept(new GeoRenderProvider() {
			private ScrewdriverItemRenderer renderer;
			
			@Override
			public BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
				if (renderer == null) {
					renderer = new ScrewdriverItemRenderer();
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
			new AnimationController<>(this, "use_controller", 20, state -> PlayState.STOP).triggerableAnim(
				"use", USE));
	}
	
}
