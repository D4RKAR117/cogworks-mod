package org.darkar.cog_works.level.events;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderBuffers;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.NeoForgeRenderTypes;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import org.darkar.cog_works.item.ProspectingPickItem;
import org.joml.Matrix4f;

import static org.darkar.cog_works.CogWorks.MOD_ID;

@EventBusSubscriber(modid = MOD_ID, value = Dist.CLIENT)
public class RenderEvents {

	private static final ResourceLocation SAMPLE_SITE_TEXTURE_KEY =
		new ResourceLocation(MOD_ID, "block/sample_stone_site");

	@SubscribeEvent
	public static void onRenderLevelStage(final RenderLevelStageEvent event) {
		RenderLevelStageEvent.Stage stage = event.getStage();
		Minecraft minecraft = Minecraft.getInstance();
		if (stage == RenderLevelStageEvent.Stage.AFTER_PARTICLES) {

				if (minecraft.player != null) {
					Frustum frustum = event.getFrustum();
					PoseStack poseStack = event.getPoseStack();
					ItemStack stack = minecraft.player.getMainHandItem();
					if (stack.getItem() instanceof ProspectingPickItem && minecraft.hitResult != null) {
						HitResult hitResult = minecraft.hitResult;
						if (hitResult.getType() == HitResult.Type.BLOCK) {
							BlockHitResult blockHit = (BlockHitResult) hitResult;
							BlockPos hitPos = blockHit.getBlockPos();
							BlockState blockState = minecraft.level.getBlockState(hitPos);
							Direction face = blockHit.getDirection();
							if(blockState.is(BlockTags.STONE_ORE_REPLACEABLES)) {
							    boolean isVisible = frustum.isVisible(new AABB(hitPos));
								if(isVisible) {
									RenderBuffers buffers = minecraft.renderBuffers();
									MultiBufferSource.BufferSource source = buffers.bufferSource();
									Camera cam = minecraft.gameRenderer.getMainCamera();
									Vec3 camPos = cam.getPosition();
									Vec3 offset = Vec3.atLowerCornerOf(hitPos).subtract(camPos);
									RenderType bufferType = NeoForgeRenderTypes.TRANSLUCENT_ON_PARTICLES_TARGET.get();
									poseStack.pushPose();
									poseStack.translate(offset.x, offset.y, offset.z);
									poseStack.translate(.5F, .5F, .5F);
									switch (face) {
										case UP -> poseStack.mulPose(Axis.XP.rotationDegrees(90F));
										case DOWN -> poseStack.mulPose(Axis.XN.rotationDegrees(90F));
										default -> poseStack.mulPose(Axis.YN.rotationDegrees((face.toYRot() + 180F) % 360F));
									}
									poseStack.translate(-.5F, -.5F, -.5F);
									VertexConsumer textureConsumer = source.getBuffer(bufferType);
									TextureAtlasSprite texture =
										minecraft.getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(SAMPLE_SITE_TEXTURE_KEY);

									Matrix4f quadMatrix = poseStack.last().pose();
									textureConsumer.vertex(quadMatrix, 0, 1, -0.01F)
									               .color(255, 255, 255, 255)
									               .uv(texture.getU0(), texture.getV0())
									               .overlayCoords(OverlayTexture.NO_OVERLAY)
									               .uv2(LightTexture.FULL_BRIGHT)
									               .normal(poseStack.last(), 0, 0, -1)
									               .endVertex();
									textureConsumer.vertex(quadMatrix, 1, 1, -0.01F)
									               .color(255, 255, 255, 255)
									               .uv(texture.getU0(), texture.getV1())
									               .overlayCoords(OverlayTexture.NO_OVERLAY)
									               .uv2(LightTexture.FULL_BRIGHT)
									               .normal(poseStack.last(), 0, 0, -1)
									               .endVertex();
									textureConsumer.vertex(quadMatrix, 1, 0, -0.01F)
									               .color(255, 255, 255, 255)
									               .uv(texture.getU1(), texture.getV1())
									               .overlayCoords(OverlayTexture.NO_OVERLAY)
									               .uv2(LightTexture.FULL_BRIGHT)
									               .normal(poseStack.last(), 0, 0, -1)
									               .endVertex();
									textureConsumer.vertex(quadMatrix, 0, 0, -0.01F)
									               .color(255, 255, 255, 255)
									               .uv(texture.getU1(), texture.getV0())
									               .overlayCoords(OverlayTexture.NO_OVERLAY)
									               .uv2(LightTexture.FULL_BRIGHT)
									               .normal(poseStack.last(), 0, 0, -1)
									               .endVertex();
									source.endBatch(bufferType);
									poseStack.popPose();
								}
							}
						}
					}

			}
		}
	}
}

