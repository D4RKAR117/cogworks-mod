package org.darkar.cog_works.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.darkar.cog_works.Registry;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

public class TransmissionShaftBlockEntity extends BlockEntity implements GeoBlockEntity {
	
	protected static final RawAnimation WORK = RawAnimation.begin().thenLoop("animation.transmission_shaft.work");
	
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	
	public TransmissionShaftBlockEntity(BlockPos pPos, BlockState pBlockState)
	{
		super(Registry.Blocks.Entities.TRANSMISSION_SHAFT.get(), pPos, pBlockState);
	}
	
	protected <E extends TransmissionShaftBlockEntity> PlayState workAnimController(final AnimationState<E> state) {
		return state.setAndContinue(WORK);
	}
	
	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
		controllers.add(new AnimationController<>(this, this::workAnimController));
	}
	
	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.cache;
	}
}
