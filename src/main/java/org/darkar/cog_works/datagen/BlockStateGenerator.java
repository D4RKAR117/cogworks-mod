package org.darkar.cog_works.datagen;


import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.darkar.cog_works.Registry;

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
	}

	private void blockWithItem(DeferredBlock<?> block) {
		simpleBlockWithItem(block.get(), cubeAll(block.get()));
	}

}
