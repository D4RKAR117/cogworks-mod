package org.darkar.cog_works.item.renderer;

import net.minecraft.resources.ResourceLocation;
import org.darkar.cog_works.item.ProspectingPickItem;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

import static org.darkar.cog_works.CogWorks.MOD_ID;

public class ProspectingPickItemRenderer extends GeoItemRenderer<ProspectingPickItem> {
	
	
	public ProspectingPickItemRenderer() {
		super(new DefaultedItemGeoModel<>(ResourceLocation.fromNamespaceAndPath(MOD_ID, "prospecting_pick")));
	}
}
