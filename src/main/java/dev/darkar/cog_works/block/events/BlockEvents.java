package dev.darkar.cog_works.block.events;

import dev.darkar.cog_works.net.payload.client.ClientSampleSiteMapUpdatePayload;
import dev.darkar.cog_works.utils.Data.AttachmentUtils.ChunkSampleSiteMapUtil;
import dev.darkar.cog_works.world.level.chunk.attachment.ChunkSampleSiteMap;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.neoforge.network.PacketDistributor;

import java.util.Optional;

import static dev.darkar.cog_works.CogWorks.MOD_ID;
import static dev.darkar.cog_works.Registry.DataAttachments.CHUNK_SAMPLE_SITE_MAP;

@EventBusSubscriber(modid = MOD_ID)
public class BlockEvents {
	
	/**
	 * Handles the logic to update the {@link ChunkSampleSiteMap} when a block is broken and is a sample site.
	 *
	 * @param levelAccessor world where the block is broken
	 * @param pos           position of the block that was broken
	 * @param player        player that broke the block
	 */
	private static void handleChunkSampleSiteMap(LevelAccessor levelAccessor, BlockPos pos, Player player) {
		ChunkAccess chunk = levelAccessor.getChunk(pos);
		Level level = player.level();
		if (level.isClientSide()) return;
		Optional<ClientSampleSiteMapUpdatePayload> payload = Optional.empty();
		if (!chunk.hasAttachments() || !chunk.hasData(CHUNK_SAMPLE_SITE_MAP)) return;
		ChunkSampleSiteMap chunkSampleSiteMap = chunk.getData(CHUNK_SAMPLE_SITE_MAP);
		if (!ChunkSampleSiteMapUtil.isDirty(chunkSampleSiteMap)) return;
		
		if (ChunkSampleSiteMapUtil.isSurface(chunkSampleSiteMap, pos)) {
			ChunkSampleSiteMap newChunkSampleSiteMap = ChunkSampleSiteMapUtil.resetDefaultSurface(chunkSampleSiteMap);
			chunk.setData(CHUNK_SAMPLE_SITE_MAP, newChunkSampleSiteMap);
			payload = Optional.of(new ClientSampleSiteMapUpdatePayload(chunk.getPos(), newChunkSampleSiteMap));
			
		}
		
		if (ChunkSampleSiteMapUtil.isDeep(chunkSampleSiteMap, pos)) {
			ChunkSampleSiteMap newChunkSampleSiteMap = ChunkSampleSiteMapUtil.resetDefaultDeep(chunkSampleSiteMap);
			chunk.setData(CHUNK_SAMPLE_SITE_MAP, newChunkSampleSiteMap);
			payload = Optional.of(new ClientSampleSiteMapUpdatePayload(chunk.getPos(), newChunkSampleSiteMap));
		}
		
		
		payload.ifPresent(updatePayload -> {
			PacketDistributor.sendToPlayersTrackingChunk((ServerLevel) level, chunk.getPos(), updatePayload);
		});
		
	}
	
	@SubscribeEvent
	public static void onBlockBreak(final BlockEvent.BreakEvent event) {
		Player player = event.getPlayer();
		LevelAccessor level = event.getLevel();
		BlockPos breakPos = event.getPos();
		
		if (!level.isClientSide()) {
			handleChunkSampleSiteMap(level, breakPos, player);
		}
	}
}
