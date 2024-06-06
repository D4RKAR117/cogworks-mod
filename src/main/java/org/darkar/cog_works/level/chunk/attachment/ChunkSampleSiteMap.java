package org.darkar.cog_works.level.chunk.attachment;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public record ChunkSampleSiteMap(BlockPos surfacePos, BlockPos deepPos, BlockState surfaceState, BlockState deepState) {

	public static final ChunkSampleSiteMap DEFAULT =
		new ChunkSampleSiteMap(BlockPos.ZERO, BlockPos.ZERO, Blocks.AIR.defaultBlockState(), Blocks.AIR.defaultBlockState());

	public static final Codec<ChunkSampleSiteMap> CODEC = RecordCodecBuilder.create(instance -> instance.group(
		BlockPos.CODEC.fieldOf("surfacePos").forGetter(ChunkSampleSiteMap::surfacePos),
		BlockPos.CODEC.fieldOf("deepPos").forGetter(ChunkSampleSiteMap::deepPos),
		BlockState.CODEC.fieldOf("surfaceState").forGetter(ChunkSampleSiteMap::surfaceState),
		BlockState.CODEC.fieldOf("deepState").forGetter(ChunkSampleSiteMap::deepState)
		).apply(instance, ChunkSampleSiteMap::new)
	);
}
