package dev.darkar.cog_works.utils.enums;


import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

import java.util.Optional;

public enum SampleSiteRegion {
	SURFACE(75, 0), DEEP(0, -60);
	
	
	public static final Codec<SampleSiteRegion> CODEC = Codec.STRING.comapFlatMap((regionName) -> {
		Optional<SampleSiteRegion> sampleSiteRegion = SampleSiteRegion.getRegion(regionName);
		return sampleSiteRegion
			.<DataResult<? extends SampleSiteRegion>>map(DataResult::success)
			.orElseGet(
				() -> DataResult.error(() -> String.format("Invalid Sample Site Region name provided %s",
				                                           regionName)));
	}, SampleSiteRegion::name);
	
	public static final StreamCodec<ByteBuf, SampleSiteRegion> STREAM_CODEC = ByteBufCodecs.STRING_UTF8.map(
		(regionName) -> {
			Optional<SampleSiteRegion> sampleSiteRegion = SampleSiteRegion.getRegion(regionName);
			return sampleSiteRegion.orElseThrow(
				() -> new IllegalArgumentException("Invalid Sample Site Region name provided " + regionName));
		}, SampleSiteRegion::name);
	
	
	/**
	 * Represents the maximum Y (Top)
	 * of the sample region
	 */
	private final int maxY;
	/**
	 * Represents the minimum Y (Bottom)
	 * of the sample region
	 */
	private final int minY;
	
	SampleSiteRegion(int maxY, int minY) {
		this.maxY = maxY;
		this.minY = minY;
	}
	
	/**
	 * A method to get the sample region based on the Y coordinate
	 *
	 * @param yPos the Y coordinate to determine the sample region
	 *
	 * @return the sample region
	 */
	public static Optional<SampleSiteRegion> getRegion(int yPos) {
		for (SampleSiteRegion region : SampleSiteRegion.values()) {
			if (yPos >= region.getMinY() && yPos <= region.getMaxY()) {
				return Optional.of(region);
			}
		}
		return Optional.empty();
	}
	
	/**
	 * A method to get the sample region based on the region name
	 *
	 * @param regionName the name of the region
	 *
	 * @return the sample region
	 */
	public static Optional<SampleSiteRegion> getRegion(String regionName) {
		for (SampleSiteRegion region : SampleSiteRegion.values()) {
			if (region
				.name()
				.equalsIgnoreCase(regionName))
			{
				return Optional.of(region);
			}
		}
		return Optional.empty();
	}
	
	/**
	 * A method to get the maximum Y coordinate (Top) value of the sample region.
	 *
	 * @return the maximum Y value of the sample region
	 */
	public int getMaxY() {
		return maxY;
	}
	
	/**
	 * A method to get the minimum Y coordinate (Bottom) value of the sample region.
	 *
	 * @return the minimum Y value of the sample region
	 */
	public int getMinY() {
		return minY;
	}
	
}
