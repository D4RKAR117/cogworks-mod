package dev.darkar.cog_works.item.renderer;

import dev.darkar.cog_works.item.ScrewdriverItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

import static dev.darkar.cog_works.CogWorks.MOD_ID;

public class ScrewdriverItemRenderer extends GeoItemRenderer<ScrewdriverItem> {
	
	public ScrewdriverItemRenderer() {
		super(new DefaultedItemGeoModel<>(ResourceLocation.fromNamespaceAndPath(MOD_ID, "screwdriver")));
	}
}
