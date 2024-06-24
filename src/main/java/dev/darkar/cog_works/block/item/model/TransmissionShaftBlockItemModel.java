package dev.darkar.cog_works.block.item.model;

import dev.darkar.cog_works.block.item.TransmissionShaftBlockItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

import static dev.darkar.cog_works.CogWorks.MOD_ID;

public class TransmissionShaftBlockItemModel extends GeoModel<TransmissionShaftBlockItem> {

	@Override
	public ResourceLocation getModelResource(TransmissionShaftBlockItem animatable) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, "geo/block/transmission_shaft.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(TransmissionShaftBlockItem animatable) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/block/transmission_shaft.png");
	}
	
	
	@Override
	public ResourceLocation getAnimationResource(TransmissionShaftBlockItem animatable) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, "animations/block/transmission_shaft.animation.json");
	}
}
