package org.darkar.cog_works.item.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

public record IsDiggingSample(boolean value) {

	public static final IsDiggingSample DEFAULT = new IsDiggingSample(false);

	public static final Codec<IsDiggingSample> CODEC = RecordCodecBuilder.create(instance -> instance.group(
		Codec.BOOL.fieldOf("value").forGetter(IsDiggingSample::value)
		).apply(instance, IsDiggingSample::new));


	public static final StreamCodec<ByteBuf, IsDiggingSample> STREAM_CODEC = StreamCodec.composite(
		ByteBufCodecs.BOOL, IsDiggingSample::value,
		IsDiggingSample::new
	                                                                                              );

}
