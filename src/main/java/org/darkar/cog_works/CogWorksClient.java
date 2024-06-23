package org.darkar.cog_works;

import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import org.darkar.cog_works.block.entity.renderer.TransmissionShaftBlockEntityRenderer;

import static org.darkar.cog_works.CogWorks.LOGGER;
import static org.darkar.cog_works.CogWorks.MOD_ID;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT, modid = MOD_ID)
public class CogWorksClient {
	
	@SubscribeEvent
	public static void onClientSetup(FMLClientSetupEvent event)
	{
		// Some client setup code
		LOGGER.info("[Cog Works] Hello {}", Minecraft
			.getInstance()
			.getUser()
			.getName());
	}
	
	@SubscribeEvent
	public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer(Registry.Blocks.Entities.TRANSMISSION_SHAFT.get(),
		                                  context -> new TransmissionShaftBlockEntityRenderer());
	}
	
	
}
