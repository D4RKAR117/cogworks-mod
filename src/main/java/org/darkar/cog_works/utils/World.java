package org.darkar.cog_works.utils;

import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.chunk.LevelChunk;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class World {
	
	public static List<LevelChunk> getNearbyChunks(LevelChunk chunk) {
		return getNearbyChunks(chunk, 8);
	}
	
	public  static  List<LevelChunk> getNearbyChunks(LevelChunk chunk, int radius) {
		List<LevelChunk> chunks = new ArrayList<>();
		chunks.add(chunk);
		Level level = chunk.getLevel();
		ChunkPos chunkPos = chunk.getPos();
		
		Stream<ChunkPos> chunkPosStream = ChunkPos.rangeClosed(chunkPos, radius);
		
		chunkPosStream.filter((pos) -> !chunkPos.equals(pos)).forEach(pos -> {
			LevelChunk nearbyChunk = level.getChunk(pos.x, pos.z);
			chunks.add(nearbyChunk);
		});
		
		return chunks;
	}
}
