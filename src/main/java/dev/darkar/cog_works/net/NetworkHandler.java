package dev.darkar.cog_works.net;

import dev.darkar.cog_works.net.payload.client.ClientSampleSiteMapUpdatePayload;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.HandlerThread;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;


public class NetworkHandler {
	
	private static final String PROTOCOL_VERSION = "1";
	
	@SubscribeEvent
	public static void onPayloadHandlersRegister(final RegisterPayloadHandlersEvent event) {
		final PayloadRegistrar registrar = event.registrar(PROTOCOL_VERSION);
		registrar
			.executesOn(HandlerThread.NETWORK)
			.playToClient(ClientSampleSiteMapUpdatePayload.TYPE, ClientSampleSiteMapUpdatePayload.STREAM_CODEC,
			              ClientSampleSiteMapUpdatePayload::handle);
	}
}
