package dev.darkar.cog_works.net.payload.client;

import dev.darkar.cog_works.world.level.chunk.attachment.ChunkSampleSiteMap;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.network.codec.NeoForgeStreamCodecs;
import net.neoforged.neoforge.network.handling.IPayloadContext;

import static dev.darkar.cog_works.CogWorks.MOD_ID;
import static dev.darkar.cog_works.Registry.DataAttachments.CHUNK_SAMPLE_SITE_MAP;

public record ClientSampleSiteMapUpdatePayload(ChunkPos targetChunk,
                                               ChunkSampleSiteMap sampleSiteMap) implements CustomPacketPayload
{
	
	public static final Type<ClientSampleSiteMapUpdatePayload> TYPE =
		new Type<>(ResourceLocation.fromNamespaceAndPath(MOD_ID, "update_chunk_sample_site_map"));
	
	public static final StreamCodec<FriendlyByteBuf, ClientSampleSiteMapUpdatePayload> STREAM_CODEC =
		StreamCodec.composite(NeoForgeStreamCodecs.CHUNK_POS, ClientSampleSiteMapUpdatePayload::targetChunk,
		                      ChunkSampleSiteMap.STREAM_CODEC, ClientSampleSiteMapUpdatePayload::sampleSiteMap,
		                      ClientSampleSiteMapUpdatePayload::new);
	
	
	public static void handle(final ClientSampleSiteMapUpdatePayload data, final IPayloadContext ctx) {
		
		ctx.enqueueWork(() -> {
			if (FMLEnvironment.dist.isClient()) {
				Player player = ctx.player();
				Level level = player.level();
				ChunkAccess chunk = level.getChunk(data.targetChunk().x, data.targetChunk().z);
				ChunkSampleSiteMap sampleSiteMap = data.sampleSiteMap();
				
				chunk.setData(CHUNK_SAMPLE_SITE_MAP, sampleSiteMap);
				
			}
		});
		
	}
	
	@Override
	public Type<? extends CustomPacketPayload> type() {
		return TYPE;
	}
}
