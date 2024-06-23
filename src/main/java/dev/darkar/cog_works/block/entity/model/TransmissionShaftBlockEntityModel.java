package dev.darkar.cog_works.block.entity.model;

import dev.darkar.cog_works.block.TransmissionShaftBlock;
import dev.darkar.cog_works.block.entity.TransmissionShaftBlockEntity;
import dev.darkar.cog_works.utils.enums.BuildMaterial;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib.model.GeoModel;

import static dev.darkar.cog_works.CogWorks.MOD_ID;

public class TransmissionShaftBlockEntityModel extends GeoModel<TransmissionShaftBlockEntity> {
	
	
	@Override
	public ResourceLocation getModelResource(TransmissionShaftBlockEntity animatable) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, "geo/block/transmission_shaft.geo.json");
	}
	
	@Override
	public ResourceLocation getTextureResource(TransmissionShaftBlockEntity animatable) {
		BlockState state = animatable.getBlockState();
		
		BuildMaterial material = state.getValue(TransmissionShaftBlock.MATERIAL);
		
		String materialPrefix = material
			.getSerializedName()
			.toLowerCase();
		
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, String.format("textures/block/%s_transmission_shaft.png",
		                                                                   materialPrefix));
	}
	
	@Override
	public ResourceLocation getAnimationResource(TransmissionShaftBlockEntity animatable) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, "animations/block/transmission_shaft.animation.json");
	}
	
}
