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
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.NeoForgeRenderTypes;
import org.darkar.cog_works.level.chunk.attachment.ChunkSampleSiteMap;
import org.darkar.cog_works.utils.Data;
import org.darkar.cog_works.utils.World;
import org.joml.Matrix4f;

import java.util.Map;
import java.util.stream.Collectors;

import static org.darkar.cog_works.CogWorks.MOD_ID;
import static org.darkar.cog_works.Registry.DataAttachments.CHUNK_SAMPLE_SITE_MAP;

public class SampleSiteRenderBehaviour {
	
	private static final ResourceLocation SAMPLE_SITE_TEXTURE_KEY = ResourceLocation.fromNamespaceAndPath(MOD_ID,
	                                                                                                      "block" +
	                                                                                                      "/sample_stone_site");
	
	public static void render(Frustum frustum, PoseStack poseStack, Camera cam) {
		Minecraft minecraft = Minecraft.getInstance();
		ClientLevel level = minecraft.level;
		LocalPlayer player = minecraft.player;
		
		BlockPos currentPos = player.getOnPos();
		ChunkAccess chunk = level.getChunk(currentPos);
		
		RenderBuffers buffers = minecraft.renderBuffers();
		MultiBufferSource.BufferSource source = buffers.bufferSource();
		Vec3 camPos = cam.getPosition();
		RenderType bufferType = NeoForgeRenderTypes.TRANSLUCENT_ON_PARTICLES_TARGET.get();
		Map<ChunkPos, ChunkSampleSiteMap> mapsToRender = World
			.getNearbyChunks(chunk, level, 4)
			.filter(nearbyChunk -> nearbyChunk.hasAttachments() && nearbyChunk.hasData(CHUNK_SAMPLE_SITE_MAP) &&
			                       Data.AttachmentUtils.ChunkSampleSiteMapUtil.isDirty(
				                       nearbyChunk.getData(CHUNK_SAMPLE_SITE_MAP)))
			.collect(Collectors.toMap(ChunkAccess::getPos, mapChunk -> mapChunk.getData(CHUNK_SAMPLE_SITE_MAP)));
		
		for (ChunkSampleSiteMap chunkSampleSiteMap : mapsToRender.values()) {
			boolean isSurfaceVisible = frustum.isVisible(new AABB(chunkSampleSiteMap.surfacePos())) &&
			                           !chunkSampleSiteMap
				                           .surfacePos()
				                           .equals(BlockPos.ZERO);
			boolean isDeepVisible = frustum.isVisible(new AABB(chunkSampleSiteMap.deepPos())) && !chunkSampleSiteMap
				.deepPos()
				.equals(BlockPos.ZERO);
			
			if (!isSurfaceVisible && !isDeepVisible) {
				return;
			}
			
			BlockPos pos = isSurfaceVisible ? chunkSampleSiteMap.surfacePos() : chunkSampleSiteMap.deepPos();
			Direction face = isSurfaceVisible ? chunkSampleSiteMap.surfaceFace() : chunkSampleSiteMap.deepFace();
			Vec3 offset = Vec3
				.atLowerCornerOf(pos)
				.subtract(camPos);
			
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
			TextureAtlasSprite texture = minecraft
				.getTextureAtlas(InventoryMenu.BLOCK_ATLAS)
				.apply(SAMPLE_SITE_TEXTURE_KEY);
			
			Matrix4f quadMatrix = poseStack
				.last()
				.pose();
			textureConsumer
				.addVertex(quadMatrix, 0, 1, -0.01F)
				.setColor(255, 255, 255, 255)
				.setUv(texture.getU0(), texture.getV0())
				.setOverlay(OverlayTexture.NO_OVERLAY)
				.setLight(LightTexture.FULL_BRIGHT)
				.setNormal(poseStack.last(), 0, 0, -1);
			textureConsumer
				.addVertex(quadMatrix, 1, 1, -0.01F)
				.setColor(255, 255, 255, 255)
				.setUv(texture.getU0(), texture.getV1())
				.setOverlay(OverlayTexture.NO_OVERLAY)
				.setLight(LightTexture.FULL_BRIGHT)
				.setNormal(poseStack.last(), 0, 0, -1);
			textureConsumer
				.addVertex(quadMatrix, 1, 0, -0.01F)
				.setColor(255, 255, 255, 255)
				.setUv(texture.getU1(), texture.getV1())
				.setOverlay(OverlayTexture.NO_OVERLAY)
				.setLight(LightTexture.FULL_BRIGHT)
				.setNormal(poseStack.last(), 0, 0, -1);
			textureConsumer
				.addVertex(quadMatrix, 0, 0, -0.01F)
				.setColor(255, 255, 255, 255)
				.setUv(texture.getU1(), texture.getV0())
				.setOverlay(OverlayTexture.NO_OVERLAY)
				.setLight(LightTexture.FULL_BRIGHT)
				.setNormal(poseStack.last(), 0, 0, -1);
			source.endBatch(bufferType);
			poseStack.popPose();
		}
		
		
	}
	
}
