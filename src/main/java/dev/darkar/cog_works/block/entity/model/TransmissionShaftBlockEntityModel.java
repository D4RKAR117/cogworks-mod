package dev.darkar.cog_works.block.entity.model;

import dev.darkar.cog_works.block.entity.TransmissionShaftBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

import static dev.darkar.cog_works.CogWorks.MOD_ID;

public class TransmissionShaftBlockEntityModel extends GeoModel<TransmissionShaftBlockEntity> {
	
	
	@Override
	public ResourceLocation getModelResource(TransmissionShaftBlockEntity animatable) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, "geo/block/transmission_shaft.geo.json");
	}
	
	@Override
	public ResourceLocation getTextureResource(TransmissionShaftBlockEntity animatable) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/block/transmission_shaft.png");
	}
	
	@Override
	public ResourceLocation getAnimationResource(TransmissionShaftBlockEntity animatable) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, "animations/block/transmission_shaft.animation.json");
	}
	
}
