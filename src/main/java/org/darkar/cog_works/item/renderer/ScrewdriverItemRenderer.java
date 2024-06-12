package org.darkar.cog_works.item.renderer;

import net.minecraft.resources.ResourceLocation;
import org.darkar.cog_works.item.ScrewdriverItem;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

import static org.darkar.cog_works.CogWorks.MOD_ID;

public class ScrewdriverItemRenderer extends GeoItemRenderer<ScrewdriverItem> {
	
	public ScrewdriverItemRenderer() {
		super(new DefaultedItemGeoModel<>(new ResourceLocation(MOD_ID, "screwdriver")));
	}
}
