package dev.darkar.cog_works.generation.data;


import dev.darkar.cog_works.Registry;
import dev.darkar.cog_works.block.TransmissionShaftBlock;
import dev.darkar.cog_works.utils.enums.BuildMaterial;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import static dev.darkar.cog_works.CogWorks.MOD_ID;

public class BlockStateGenerator extends BlockStateProvider {
	
	public BlockStateGenerator(PackOutput output, ExistingFileHelper existingFileHelper) {
		super(output, MOD_ID, existingFileHelper);
	}
	
	
	@Override
	protected void registerStatesAndModels() {
		
		getVariantBuilder(Registry.Blocks.TRANSMISSION_SHAFT.get()).forAllStates(state -> {
			BuildMaterial shaftMat = state.getValue(TransmissionShaftBlock.SHAFT_MATERIAL);
			
			String variantName = String.format("%s_transmission_shaft", shaftMat.getSerializedName());
			
			ResourceLocation matTexture = ResourceLocation.fromNamespaceAndPath(MOD_ID, "block/transmission_shaft");
			
			
			ModelFile standardBlock = models().getExistingFile(mcLoc("block/cube"));
			
			
			return ConfiguredModel
				.builder().modelFile(standardBlock).build();
		});
	}
	
	private void blockWithItem(DeferredBlock<?> block) {
		simpleBlockWithItem(block.get(), cubeAll(block.get()));
	}
	
}
