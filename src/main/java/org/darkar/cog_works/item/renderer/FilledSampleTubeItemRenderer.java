package org.darkar.cog_works.item.renderer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.darkar.cog_works.item.FilledSampleTubeItem;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

import static org.darkar.cog_works.CogWorks.MOD_ID;

public class FilledSampleTubeItemRenderer extends GeoItemRenderer<FilledSampleTubeItem> {
	public FilledSampleTubeItemRenderer() {
		super(new DefaultedItemGeoModel<>(new ResourceLocation(MOD_ID, "filled_sample_tube")));
	}
	
	@Override
	public @Nullable RenderType getRenderType(FilledSampleTubeItem animatable, ResourceLocation texture,
	                                          @Nullable MultiBufferSource bufferSource, float partialTick)
	{
		return RenderType.entityTranslucentCull(texture);
	}
}
