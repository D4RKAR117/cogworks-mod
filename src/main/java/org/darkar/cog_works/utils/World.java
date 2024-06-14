package org.darkar.cog_works.utils;

import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.chunk.ChunkAccess;

import java.util.stream.Stream;

public class World {
	
	/**
	 * Gets a list of nearby chunks around the given {@link ChunkAccess} within a default radius of {@code 2} chunks.
	 *
	 * @param chunk the {@link ChunkAccess} that is the center to get nearby chunks from
	 * @param level the {@link Level} to get the chunks from
	 *
	 * @return a list of nearby chunks around the given {@link ChunkAccess}
	 */
	public static Stream<ChunkAccess> getNearbyChunks(ChunkAccess chunk, Level level) {
		return getNearbyChunks(chunk, level, 2);
	}
	
	/**
	 * Gets a list of nearby chunks around the given {@link ChunkAccess} within the given radius.
	 *
	 * @param chunk  the {@link ChunkAccess} that is the center to get nearby chunks from
	 * @param level  the {@link Level} to get the chunks from
	 * @param radius the radius to search for nearby chunks
	 *
	 * @return a list of nearby chunks around the given {@link ChunkAccess}
	 */
	public static Stream<ChunkAccess> getNearbyChunks(ChunkAccess chunk, Level level, int radius) {
		ChunkPos chunkPos = chunk.getPos();
		Stream<ChunkPos> chunkPosStream = ChunkPos.rangeClosed(chunkPos, radius);
		return chunkPosStream.map(pos -> level.getChunk(pos.x, pos.z));
	}
}
