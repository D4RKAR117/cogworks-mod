package org.darkar.cog_works;

import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

import static org.darkar.cog_works.CogWorks.LOGGER;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT, modid = CogWorks.MOD_ID)
public class CogWorksClient {
	
	@SubscribeEvent
	public static void onClientSetup(FMLClientSetupEvent event)
	{
		// Some client setup code
		LOGGER.info("[Cog Works]: HELLO FROM CLIENT SETUP");
		LOGGER.info("MINECRAFT NAME >> {}", Minecraft
			.getInstance()
			.getUser()
			.getName());
	}
}
