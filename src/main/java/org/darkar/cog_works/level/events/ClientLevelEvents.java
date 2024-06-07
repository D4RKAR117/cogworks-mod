package org.darkar.cog_works.level.events;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.culling.Frustum;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import org.darkar.cog_works.level.renderer.SampleSiteRenderBehaviour;

import static org.darkar.cog_works.CogWorks.MOD_ID;

@EventBusSubscriber(modid = MOD_ID, value = Dist.CLIENT)
public class ClientLevelEvents {
	
	@SubscribeEvent
	public static void onRenderLevelStage(final RenderLevelStageEvent event) {
		RenderLevelStageEvent.Stage stage = event.getStage();
		Minecraft minecraft = Minecraft.getInstance();
		if (stage == RenderLevelStageEvent.Stage.AFTER_PARTICLES) {
			if (minecraft.player != null) {
				Frustum frustum = event.getFrustum();
				PoseStack poseStack = event.getPoseStack();
				Camera camera = event.getCamera();
				SampleSiteRenderBehaviour.render(frustum, poseStack, camera);
				
			}
		}
	}
}
