package org.darkar.cog_works.utils;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import org.darkar.cog_works.world.level.chunk.attachment.ChunkSampleSiteMap;

public class Data {
	
	public static class AttachmentUtils {
		
		public static class ChunkSampleSiteMapUtil {
			
			/**
			 * Resets the surface position and state of the given {@link ChunkSampleSiteMap} to the default values.
			 *
			 * @param chunkSampleSiteMap the {@link ChunkSampleSiteMap} to reset
			 *
			 * @return a new {@link ChunkSampleSiteMap} with the surface position and state reset to the default values
			 */
			public static ChunkSampleSiteMap resetDefaultSurface(ChunkSampleSiteMap chunkSampleSiteMap) {
				return new ChunkSampleSiteMap(ChunkSampleSiteMap.DEFAULT.surfacePos(), chunkSampleSiteMap.deepPos(),
				                              ChunkSampleSiteMap.DEFAULT.surfaceState(),
				                              chunkSampleSiteMap.deepState(),
				                              ChunkSampleSiteMap.DEFAULT.surfaceFace(), chunkSampleSiteMap.deepFace());
			}
			
			/**
			 * Resets the deep position and state of the given {@link ChunkSampleSiteMap} to the default values.
			 *
			 * @param chunkSampleSiteMap the {@link ChunkSampleSiteMap} to reset
			 *
			 * @return a new {@link ChunkSampleSiteMap} with the deep position and state reset to the default values
			 */
			public static ChunkSampleSiteMap resetDefaultDeep(ChunkSampleSiteMap chunkSampleSiteMap) {
				return new ChunkSampleSiteMap(chunkSampleSiteMap.surfacePos(), ChunkSampleSiteMap.DEFAULT.deepPos(),
				                              chunkSampleSiteMap.surfaceState(),
				                              ChunkSampleSiteMap.DEFAULT.deepState(),
				                              chunkSampleSiteMap.surfaceFace(), ChunkSampleSiteMap.DEFAULT.deepFace());
			}
			
			/**
			 * Determines if the given {@link BlockPos} matches the surface position of the given
			 * {@link ChunkSampleSiteMap}. But only checks the position, not the state.
			 *
			 * @param chunkSampleSiteMap the {@link ChunkSampleSiteMap} to check
			 * @param blockPos           the {@link BlockPos} to check
			 *
			 * @return {@code true} if the given {@link BlockPos} matches the surface position of the given
			 */
			public static boolean isSurface(ChunkSampleSiteMap chunkSampleSiteMap, BlockPos blockPos) {
				return chunkSampleSiteMap
					.surfacePos()
					.equals(blockPos);
			}
			
			/**
			 * Determines if the given {@link BlockPos} matches the surface position of the given
			 * {@link ChunkSampleSiteMap}. Checks both the position and the state.
			 *
			 * @param chunkSampleSiteMap the {@link ChunkSampleSiteMap} to check
			 * @param blockPos           the {@link BlockPos} to check
			 * @param level              the {@link Level} to access the block state
			 *
			 * @return {@code true} if the given {@link BlockPos} matches the surface position of the given
			 * {@link ChunkSampleSiteMap}
			 * and the block state at the given {@link BlockPos} matches the surface state of the given
			 * {@link ChunkSampleSiteMap}
			 */
			public static boolean isSurface(ChunkSampleSiteMap chunkSampleSiteMap, BlockPos blockPos, Level level)
			{
				return chunkSampleSiteMap
					       .surfacePos()
					       .equals(blockPos) && chunkSampleSiteMap
					       .surfaceState()
					       .equals(level.getBlockState(blockPos));
			}
			
			/**
			 * Determines if the given {@link BlockPos} matches the deep position of the given
			 * {@link ChunkSampleSiteMap}.
			 * But only checks the position, not the state.
			 *
			 * @param chunkSampleSiteMap the {@link ChunkSampleSiteMap} to check
			 * @param blockPos           the {@link BlockPos} to check
			 *
			 * @return {@code true} if the given {@link BlockPos} matches the deep position of the given
			 * {@link ChunkSampleSiteMap}
			 */
			public static boolean isDeep(ChunkSampleSiteMap chunkSampleSiteMap, BlockPos blockPos) {
				return chunkSampleSiteMap
					.deepPos()
					.equals(blockPos);
			}
			
			/**
			 * Determines if the given {@link BlockPos} matches the deep position of the given
			 * {@link ChunkSampleSiteMap}.
			 * Checks both the position and the state.
			 *
			 * @param chunkSampleSiteMap the {@link ChunkSampleSiteMap} to check
			 * @param blockPos           the {@link BlockPos} to check
			 * @param level              the {@link Level} to access the block state
			 *
			 * @return {@code true} if the given {@link BlockPos} matches the deep position of the given
			 * {@link ChunkSampleSiteMap}
			 * and the block state at the given {@link BlockPos} matches the deep state of the given
			 * {@link ChunkSampleSiteMap}
			 */
			public static boolean isDeep(ChunkSampleSiteMap chunkSampleSiteMap, BlockPos blockPos, Level level) {
				return chunkSampleSiteMap
					       .deepPos()
					       .equals(blockPos) && chunkSampleSiteMap
					       .deepState()
					       .equals(level.getBlockState(blockPos));
			}
			
			/**
			 * Determines if the given {@link BlockPos} matches either the surface or deep position of the given
			 * {@link ChunkSampleSiteMap}. But only checks the position, not the state.
			 *
			 * @param chunkSampleSiteMap the {@link ChunkSampleSiteMap} to check
			 * @param blockPos           the {@link BlockPos} to check
			 *
			 * @return {@code true} if the given {@link BlockPos} matches either the surface or deep position of the
			 * given
			 */
			public static boolean isSurfaceOrDeep(ChunkSampleSiteMap chunkSampleSiteMap, BlockPos blockPos) {
				return isSurface(chunkSampleSiteMap, blockPos) || isDeep(chunkSampleSiteMap, blockPos);
			}
			
			/**
			 * Determines if the given {@link BlockPos} matches either the surface or deep position of the given
			 * {@link ChunkSampleSiteMap}. Checks both the position and the state.
			 *
			 * @param chunkSampleSiteMap the {@link ChunkSampleSiteMap} to check
			 * @param blockPos           the {@link BlockPos} to check
			 * @param level              the {@link Level} to access the block state
			 *
			 * @return {@code true} if the given {@link BlockPos} matches either the surface or deep position of the
			 * given
			 * {@link ChunkSampleSiteMap} and the block state at the given {@link BlockPos} matches either the surface
			 * or deep state
			 * of the given {@link ChunkSampleSiteMap}
			 */
			public static boolean isSurfaceOrDeep(ChunkSampleSiteMap chunkSampleSiteMap, BlockPos blockPos,
			                                      Level level)
			{
				return isSurface(chunkSampleSiteMap, blockPos, level) || isDeep(chunkSampleSiteMap, blockPos, level);
			}
			
			/**
			 * Determines if the given {@link ChunkSampleSiteMap} is different from its default in any member.
			 *
			 * @param chunkSampleSiteMap the {@link ChunkSampleSiteMap} to check
			 *
			 * @return {@code true} if the given {@link ChunkSampleSiteMap} is dirty
			 */
			public static boolean isDirty(ChunkSampleSiteMap chunkSampleSiteMap) {
				return !chunkSampleSiteMap.equals(ChunkSampleSiteMap.DEFAULT);
			}
		}
	}
	
}
