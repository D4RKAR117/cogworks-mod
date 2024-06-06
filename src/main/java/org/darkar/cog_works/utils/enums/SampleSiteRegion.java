package org.darkar.cog_works.utils.enums;


import java.util.Optional;

public enum SampleSiteRegion {
	SURFACE (75,0),
	DEEP (0,-60);
	
	
	/**
	 *  Represents the maximum Y (Top)
	 *  of the sample region
	 */
	private final int maxY;
	
	/**
	 *  Represents the minimum Y (Bottom)
	 *  of the sample region
	 */
	private final int minY;
	
	private SampleSiteRegion(int maxY, int minY) {
		this.maxY = maxY;
		this.minY = minY;
	}
	
	/**
	 * A method to get the maximum Y coordinate (Top) value of the sample region.
	 * @return the maximum Y value of the sample region
	 */
	public int getMaxY() {
		return maxY;
	}
	
	
	/**
	 * A method to get the minimum Y coordinate (Bottom) value of the sample region.
	 * @return the minimum Y value of the sample region
	 */
	public int getMinY() {
		return minY;
	}
	
	
	/**
	 * A method to get the sample region based on the Y coordinate
	 * @param yPos the Y coordinate to determine the sample region
	 * @return the sample region
	 */
	public static Optional<SampleSiteRegion> getRegion(int yPos) {
		for(SampleSiteRegion region : SampleSiteRegion.values()) {
			if(yPos >= region.getMinY() && yPos <= region.getMaxY()) {
				return Optional.of(region);
			}
		}
		return Optional.empty();
	}
	
}
