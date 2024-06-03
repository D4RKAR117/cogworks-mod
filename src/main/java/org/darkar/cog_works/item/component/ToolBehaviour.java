package org.darkar.cog_works.item.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

public record ToolBehaviour(String action, boolean active) {

	public static final Codec<ToolBehaviour> CODEC = RecordCodecBuilder.create(
		builder -> builder.group(
			Codec.STRING.fieldOf("action").forGetter(ToolBehaviour::action),
			Codec.BOOL.fieldOf("active").forGetter(ToolBehaviour::active))
		                  .apply(builder, ToolBehaviour::new)
	                                                                          );
	public static final StreamCodec<ByteBuf, ToolBehaviour> STREAM_CODEC = StreamCodec.composite(
		ByteBufCodecs.STRING_UTF8, ToolBehaviour::action,
		ByteBufCodecs.BOOL, ToolBehaviour::active,
		 ToolBehaviour::new
	                                                                                      );
}
