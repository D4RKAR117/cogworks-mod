package dev.darkar.cog_works.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import dev.darkar.cog_works.block.entity.TransmissionShaftBlockEntity;
import dev.darkar.cog_works.block.entity.model.TransmissionShaftBlockEntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class TransmissionShaftBlockEntityRenderer extends GeoBlockRenderer<TransmissionShaftBlockEntity> {
	
	public TransmissionShaftBlockEntityRenderer()
	{
		super(new TransmissionShaftBlockEntityModel());
	}
	
	@Override
	public @Nullable RenderType getRenderType(TransmissionShaftBlockEntity animatable, ResourceLocation texture,
	                                          @Nullable MultiBufferSource bufferSource, float partialTick)
	{
		return RenderType.entityTranslucent(texture);
	}
	
	@Override
	protected void rotateBlock(Direction facing, PoseStack poseStack) {
		switch (facing) {
			case SOUTH -> poseStack.mulPose(Axis.YP.rotationDegrees(180));
			case WEST -> poseStack.mulPose(Axis.YP.rotationDegrees(90));
			case NORTH -> poseStack.mulPose(Axis.YP.rotationDegrees(0));
			case EAST -> poseStack.mulPose(Axis.YP.rotationDegrees(270));
			case UP -> {
				poseStack.mulPose(Axis.XP.rotationDegrees(90));
				poseStack.translate(0, -0.5D, -0.5D);
			}
			case DOWN -> {
				poseStack.mulPose(Axis.XN.rotationDegrees(90));
				poseStack.translate(0, -0.5D, 0.5D);
			}
		}
	}
}
