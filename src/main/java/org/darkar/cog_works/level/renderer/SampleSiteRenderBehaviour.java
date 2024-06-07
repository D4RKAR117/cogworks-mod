package org.darkar.cog_works.level.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
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
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.NeoForgeRenderTypes;
import org.darkar.cog_works.level.chunk.attachment.ChunkSampleSiteMap;
import org.darkar.cog_works.utils.World;
import org.joml.Matrix4f;

import java.util.List;

import static org.darkar.cog_works.CogWorks.MOD_ID;
import static org.darkar.cog_works.Registry.DataAttachments.CHUNK_SAMPLE_SITE_MAP;

public class SampleSiteRenderBehaviour {
	
	private static final ResourceLocation SAMPLE_SITE_TEXTURE_KEY = new ResourceLocation(MOD_ID,
	                                                                                     "block/sample_stone_site");
	
	public static void render(Frustum frustum, PoseStack poseStack, Camera cam) {
		Minecraft minecraft = Minecraft.getInstance();
		ClientLevel level = minecraft.level;
		LocalPlayer player = minecraft.player;
		
		BlockPos currentPos = player.getOnPos();
		LevelChunk chunk = level.getChunkAt(currentPos);
		
		List<LevelChunk> nearbyChunks = World.getNearbyChunks(chunk, 2);
		RenderBuffers buffers = minecraft.renderBuffers();
		MultiBufferSource.BufferSource source = buffers.bufferSource();
		Vec3 camPos = cam.getPosition();
		RenderType bufferType = NeoForgeRenderTypes.TRANSLUCENT_ON_PARTICLES_TARGET.get();
		
		nearbyChunks.stream().filter(
			nearbyChunk -> nearbyChunk.hasAttachments() && nearbyChunk.hasData(CHUNK_SAMPLE_SITE_MAP)).forEach(
			nearbyChunk -> {
				
				ChunkSampleSiteMap chunkSampleSiteMap = nearbyChunk.getData(CHUNK_SAMPLE_SITE_MAP);
				boolean isSurfaceVisible = frustum.isVisible(new AABB(chunkSampleSiteMap.surfacePos()));
				boolean isDeepVisible = frustum.isVisible(new AABB(chunkSampleSiteMap.deepPos()));
				if (!isSurfaceVisible && !isDeepVisible) {
					return;
				}
				
				BlockPos pos = isSurfaceVisible ? chunkSampleSiteMap.surfacePos() : chunkSampleSiteMap.deepPos();
				Direction face = isSurfaceVisible ? chunkSampleSiteMap.surfaceFace() : chunkSampleSiteMap.deepFace();
				Vec3 offset = Vec3.atLowerCornerOf(pos).subtract(camPos);
				
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
				TextureAtlasSprite texture = minecraft.getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(
					SAMPLE_SITE_TEXTURE_KEY);
				
				Matrix4f quadMatrix = poseStack.last().pose();
				textureConsumer.vertex(quadMatrix, 0, 1, -0.01F).color(255, 255, 255, 255).uv(texture.getU0(),
				                                                                              texture.getV0())
				               .overlayCoords(OverlayTexture.NO_OVERLAY).uv2(LightTexture.FULL_BRIGHT).normal(
					               poseStack.last(), 0, 0, -1).endVertex();
				textureConsumer.vertex(quadMatrix, 1, 1, -0.01F).color(255, 255, 255, 255).uv(texture.getU0(),
				                                                                              texture.getV1())
				               .overlayCoords(OverlayTexture.NO_OVERLAY).uv2(LightTexture.FULL_BRIGHT).normal(
					               poseStack.last(), 0, 0, -1).endVertex();
				textureConsumer.vertex(quadMatrix, 1, 0, -0.01F).color(255, 255, 255, 255).uv(texture.getU1(),
				                                                                              texture.getV1())
				               .overlayCoords(OverlayTexture.NO_OVERLAY).uv2(LightTexture.FULL_BRIGHT).normal(
					               poseStack.last(), 0, 0, -1).endVertex();
				textureConsumer.vertex(quadMatrix, 0, 0, -0.01F).color(255, 255, 255, 255).uv(texture.getU1(),
				                                                                              texture.getV0())
				               .overlayCoords(OverlayTexture.NO_OVERLAY).uv2(LightTexture.FULL_BRIGHT).normal(
					               poseStack.last(), 0, 0, -1).endVertex();
				source.endBatch(bufferType);
				poseStack.popPose();
			});
		
		
	}
	
}
