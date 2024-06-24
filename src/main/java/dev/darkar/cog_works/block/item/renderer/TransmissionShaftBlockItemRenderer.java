package dev.darkar.cog_works.block.item.renderer;

import dev.darkar.cog_works.block.item.TransmissionShaftBlockItem;
import dev.darkar.cog_works.block.item.model.TransmissionShaftBlockItemModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class TransmissionShaftBlockItemRenderer extends GeoItemRenderer<TransmissionShaftBlockItem> {
	
	public TransmissionShaftBlockItemRenderer() {
		super(new TransmissionShaftBlockItemModel());
	}
}
