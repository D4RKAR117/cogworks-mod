package org.darkar.cog_works.world.level.events;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.chunk.LevelChunk;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.ChunkWatchEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import org.darkar.cog_works.net.payload.client.ClientSampleSiteMapUpdatePayload;
import org.darkar.cog_works.world.level.chunk.attachment.ChunkSampleSiteMap;

import static org.darkar.cog_works.CogWorks.MOD_ID;
import static org.darkar.cog_works.Registry.DataAttachments.CHUNK_SAMPLE_SITE_MAP;

@EventBusSubscriber(modid = MOD_ID)
public class LevelEvents {
	
	@SubscribeEvent
	public static void onChunkSent(final ChunkWatchEvent.Sent event) {
		LevelChunk chunk = event.getChunk();
		ServerLevel serverLevel = event.getLevel();
		ChunkPos pos = chunk.getPos();
		if (chunk.hasAttachments() && chunk.hasData(CHUNK_SAMPLE_SITE_MAP)) {
			ChunkSampleSiteMap chunkSampleSiteMap = chunk.getData(CHUNK_SAMPLE_SITE_MAP);
			ClientSampleSiteMapUpdatePayload payload = new ClientSampleSiteMapUpdatePayload(pos, chunkSampleSiteMap);
			PacketDistributor.sendToPlayersTrackingChunk(serverLevel, pos, payload);
		}
	}
	
}
