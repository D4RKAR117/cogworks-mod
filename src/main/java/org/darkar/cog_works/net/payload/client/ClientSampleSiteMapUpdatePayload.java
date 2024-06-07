package org.darkar.cog_works.net.payload.client;

import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.darkar.cog_works.level.chunk.attachment.ChunkSampleSiteMap;

import static org.darkar.cog_works.CogWorks.MOD_ID;
import static org.darkar.cog_works.Registry.DataAttachments.CHUNK_SAMPLE_SITE_MAP;

public record ClientSampleSiteMapUpdatePayload(BlockPos surfacePos, BlockPos deepPos, BlockState surfaceState,
                                               BlockState deepState, Direction surfaceFace,
                                               Direction deepFace) implements CustomPacketPayload
{
	
	public static final CustomPacketPayload.Type<ClientSampleSiteMapUpdatePayload> TYPE =
		new CustomPacketPayload.Type<>(new ResourceLocation(MOD_ID, "update_chunk_sample_site_map"));
	
	@SuppressWarnings("deprecation")
	public static final StreamCodec<ByteBuf, ClientSampleSiteMapUpdatePayload> STREAM_CODEC = StreamCodec.composite(
		BlockPos.STREAM_CODEC, ClientSampleSiteMapUpdatePayload::surfacePos, BlockPos.STREAM_CODEC,
		ClientSampleSiteMapUpdatePayload::deepPos, ByteBufCodecs.idMapper(Block.BLOCK_STATE_REGISTRY),
		ClientSampleSiteMapUpdatePayload::surfaceState, ByteBufCodecs.idMapper(Block.BLOCK_STATE_REGISTRY),
		ClientSampleSiteMapUpdatePayload::deepState, Direction.STREAM_CODEC,
		ClientSampleSiteMapUpdatePayload::surfaceFace, Direction.STREAM_CODEC,
		ClientSampleSiteMapUpdatePayload::deepFace, ClientSampleSiteMapUpdatePayload::new);
	
	public static void handle(final ClientSampleSiteMapUpdatePayload data, final IPayloadContext ctx) {
		
		ctx.enqueueWork(() -> {
			if (FMLEnvironment.dist.isClient()) {
				Player player =  ctx.player();
				Level level = player.level();
				BlockPos surfacePos = data.surfacePos();
				BlockPos deepPos = data.deepPos();
				BlockState surfaceState = data.surfaceState();
				BlockState deepState = data.deepState();
				Direction surfaceFace = data.surfaceFace();
				Direction deepFace = data.deepFace();
				
				level.getChunk(surfacePos).setData(CHUNK_SAMPLE_SITE_MAP,
				                                   new ChunkSampleSiteMap(surfacePos, deepPos, surfaceState, deepState,
				                                                          surfaceFace, deepFace));
				
			}
		});
		
	}
	
	@Override
	public Type<? extends CustomPacketPayload> type() {
		return TYPE;
	}
}
