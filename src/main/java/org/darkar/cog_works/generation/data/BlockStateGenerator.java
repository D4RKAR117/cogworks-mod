package org.darkar.cog_works.generation.data;


import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.darkar.cog_works.Registry;
import org.darkar.cog_works.block.TransmissionShaftBlock;
import org.darkar.cog_works.utils.enums.BuildMaterial;

import static org.darkar.cog_works.CogWorks.MOD_ID;

public class BlockStateGenerator extends BlockStateProvider {
	
	public BlockStateGenerator(PackOutput output, ExistingFileHelper existingFileHelper) {
		super(output, MOD_ID, existingFileHelper);
	}
	
	
	@Override
	protected void registerStatesAndModels() {
		blockWithItem(Registry.Blocks.TUNGSTEN_ORE);
		blockWithItem(Registry.Blocks.DEEPSLATE_TUNGSTEN_ORE);
		blockWithItem(Registry.Blocks.TITANIUM_ORE);
		blockWithItem(Registry.Blocks.DEEPSLATE_TITANIUM_ORE);
		blockWithItem(Registry.Blocks.COBALT_ORE);
		blockWithItem(Registry.Blocks.DEEPSLATE_COBALT_ORE);
		blockWithItem(Registry.Blocks.NICKEL_ORE);
		blockWithItem(Registry.Blocks.DEEPSLATE_NICKEL_ORE);
		blockWithItem(Registry.Blocks.PLATINUM_ORE);
		blockWithItem(Registry.Blocks.DEEPSLATE_PLATINUM_ORE);
		blockWithItem(Registry.Blocks.BAUXITE_ORE);
		blockWithItem(Registry.Blocks.DEEPSLATE_BAUXITE_ORE);
		blockWithItem(Registry.Blocks.MOLYBDENUM_ORE);
		blockWithItem(Registry.Blocks.DEEPSLATE_MOLYBDENUM_ORE);
		blockWithItem(Registry.Blocks.LITHIUM_ORE);
		blockWithItem(Registry.Blocks.DEEPSLATE_LITHIUM_ORE);
		blockWithItem(Registry.Blocks.IRIDIUM_ORE);
		blockWithItem(Registry.Blocks.DEEPSLATE_IRIDIUM_ORE);
		blockWithItem(Registry.Blocks.GRAPHITE_ORE);
		blockWithItem(Registry.Blocks.DEEPSLATE_GRAPHITE_ORE);
		blockWithItem(Registry.Blocks.BERYLLIUM_ORE);
		blockWithItem(Registry.Blocks.DEEPSLATE_BERYLLIUM_ORE);
		blockWithItem(Registry.Blocks.CADMIUM_ORE);
		blockWithItem(Registry.Blocks.DEEPSLATE_CADMIUM_ORE);
		blockWithItem(Registry.Blocks.CHROMIUM_ORE);
		blockWithItem(Registry.Blocks.DEEPSLATE_CHROMIUM_ORE);
		blockWithItem(Registry.Blocks.MANGANESE_ORE);
		blockWithItem(Registry.Blocks.DEEPSLATE_MANGANESE_ORE);
		blockWithItem(Registry.Blocks.OSMIUM_ORE);
		blockWithItem(Registry.Blocks.DEEPSLATE_OSMIUM_ORE);
		blockWithItem(Registry.Blocks.PALLADIUM_ORE);
		blockWithItem(Registry.Blocks.DEEPSLATE_PALLADIUM_ORE);
		blockWithItem(Registry.Blocks.THORIUM_ORE);
		blockWithItem(Registry.Blocks.DEEPSLATE_THORIUM_ORE);
		blockWithItem(Registry.Blocks.URANIUM_ORE);
		blockWithItem(Registry.Blocks.DEEPSLATE_URANIUM_ORE);
		blockWithItem(Registry.Blocks.VANADIUM_ORE);
		blockWithItem(Registry.Blocks.DEEPSLATE_VANADIUM_ORE);
		blockWithItem(Registry.Blocks.ZINC_ORE);
		blockWithItem(Registry.Blocks.DEEPSLATE_ZINC_ORE);
		
		getVariantBuilder(Registry.Blocks.TRANSMISSION_SHAFT.get()).forAllStates(state -> {
			BuildMaterial mat = state.getValue(TransmissionShaftBlock.MATERIAL);
			
			String variantName = String.format("%s_transmission_shaft", mat.getSerializedName());
			
			ResourceLocation matTexture = ResourceLocation.fromNamespaceAndPath(MOD_ID, String.format(
				"block/%s", variantName));
			
			
			ModelFile standardBlock = models().withExistingParent(variantName, "block/cube_all")
				.texture("all", matTexture);
			
			
			return ConfiguredModel.builder().modelFile(standardBlock).build();
		});
	}
	
	private void blockWithItem(DeferredBlock<?> block) {
		simpleBlockWithItem(block.get(), cubeAll(block.get()));
	}
	
}
