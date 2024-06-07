package org.darkar.cog_works.level.chunk.attachment;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public record ChunkSampleSiteMap(BlockPos surfacePos, BlockPos deepPos, BlockState surfaceState, BlockState deepState
	, Direction surfaceFace, Direction deepFace) {

	public static final ChunkSampleSiteMap DEFAULT =
		new ChunkSampleSiteMap(BlockPos.ZERO, BlockPos.ZERO, Blocks.AIR.defaultBlockState(),
		                       Blocks.AIR.defaultBlockState(), Direction.NORTH, Direction.NORTH);

	public static final Codec<ChunkSampleSiteMap> CODEC = RecordCodecBuilder.create(instance -> instance.group(
		BlockPos.CODEC.fieldOf("surfacePos").forGetter(ChunkSampleSiteMap::surfacePos),
		BlockPos.CODEC.fieldOf("deepPos").forGetter(ChunkSampleSiteMap::deepPos),
		BlockState.CODEC.fieldOf("surfaceState").forGetter(ChunkSampleSiteMap::surfaceState),
		BlockState.CODEC.fieldOf("deepState").forGetter(ChunkSampleSiteMap::deepState),
		Direction.CODEC.fieldOf("surfaceFace").forGetter(ChunkSampleSiteMap::surfaceFace),
		Direction.CODEC.fieldOf("deepFace").forGetter(ChunkSampleSiteMap::deepFace)
		).apply(instance, ChunkSampleSiteMap::new)
	);
	
	@SuppressWarnings("deprecation")
	public static final StreamCodec<ByteBuf, ChunkSampleSiteMap> STREAM_CODEC = StreamCodec.composite(
		BlockPos.STREAM_CODEC, ChunkSampleSiteMap::surfacePos,
		BlockPos.STREAM_CODEC, ChunkSampleSiteMap::deepPos,
		ByteBufCodecs.idMapper(Block.BLOCK_STATE_REGISTRY), ChunkSampleSiteMap::surfaceState,
		ByteBufCodecs.idMapper(Block.BLOCK_STATE_REGISTRY), ChunkSampleSiteMap::deepState,
		Direction.STREAM_CODEC, ChunkSampleSiteMap::surfaceFace,
		Direction.STREAM_CODEC, ChunkSampleSiteMap::deepFace,
		ChunkSampleSiteMap::new
	                                                                                                 );
}
