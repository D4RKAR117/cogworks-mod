package org.darkar.cog_works.item.renderer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.darkar.cog_works.item.EmptySampleTubeItem;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

import static org.darkar.cog_works.CogWorks.MOD_ID;

public class EmptySampleTubeItemRenderer extends GeoItemRenderer<EmptySampleTubeItem> {
	public EmptySampleTubeItemRenderer() {
		super(new DefaultedItemGeoModel<>(ResourceLocation.fromNamespaceAndPath(MOD_ID, "empty_sample_tube")));
	}
	
	@Override
	public @Nullable RenderType getRenderType(EmptySampleTubeItem animatable, ResourceLocation texture,
	                                          @Nullable MultiBufferSource bufferSource, float partialTick)
	{
		return RenderType.entityTranslucentCull(texture);
	}
}
