package org.darkar.cog_works.item.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.level.ChunkPos;
import net.neoforged.neoforge.network.codec.NeoForgeStreamCodecs;
import org.darkar.cog_works.utils.enums.SampleSiteRegion;

public record SampleLocation(ChunkPos chunkPos, SampleSiteRegion region) {
	
	public static final SampleLocation DEFAULT = new SampleLocation(ChunkPos.ZERO, SampleSiteRegion.SURFACE);
	
	public static final Codec<SampleLocation> CODEC = RecordCodecBuilder.create(
		instance -> instance.group(Codec.LONG.xmap(ChunkPos::new, ChunkPos::toLong).fieldOf("chunkPos")
		                                     .forGetter(SampleLocation::chunkPos),
		                           SampleSiteRegion.CODEC.fieldOf("region").forGetter(SampleLocation::region))
		                    .apply(instance, SampleLocation::new));
	
	public static final StreamCodec<FriendlyByteBuf, SampleLocation> STREAM_CODEC = StreamCodec.composite(
		NeoForgeStreamCodecs.CHUNK_POS, SampleLocation::chunkPos,
		SampleSiteRegion.STREAM_CODEC, SampleLocation::region,
		SampleLocation::new);
}
