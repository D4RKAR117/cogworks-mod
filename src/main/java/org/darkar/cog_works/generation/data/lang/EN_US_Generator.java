package org.darkar.cog_works.generation.data.lang;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import org.darkar.cog_works.Registry;

import static org.darkar.cog_works.CogWorks.MOD_ID;

public class EN_US_Generator extends LanguageProvider {
	public EN_US_Generator(PackOutput output) {
		super(output, MOD_ID, "en_us");
	}
	
	@Override
	protected void addTranslations() {
		
		// region Blocks
		addBlock(Registry.Blocks.TUNGSTEN_ORE, "Tungsten Ore");
		addBlock(Registry.Blocks.DEEPSLATE_TUNGSTEN_ORE, "Deepslate Tungsten Ore");
		addBlock(Registry.Blocks.TITANIUM_ORE, "Titanium Ore");
		addBlock(Registry.Blocks.DEEPSLATE_TITANIUM_ORE, "Deepslate Titanium Ore");
		addBlock(Registry.Blocks.COBALT_ORE, "Cobalt Ore");
		addBlock(Registry.Blocks.DEEPSLATE_COBALT_ORE, "Deepslate Cobalt Ore");
		addBlock(Registry.Blocks.NICKEL_ORE, "Nickel Ore");
		addBlock(Registry.Blocks.DEEPSLATE_NICKEL_ORE, "Deepslate Nickel Ore");
		addBlock(Registry.Blocks.BAUXITE_ORE, "Bauxite Ore");
		addBlock(Registry.Blocks.DEEPSLATE_BAUXITE_ORE, "Deepslate Bauxite Ore");
		addBlock(Registry.Blocks.MOLYBDENUM_ORE, "Molybdenum Ore");
		addBlock(Registry.Blocks.DEEPSLATE_MOLYBDENUM_ORE, "Deepslate Molybdenum Ore");
		addBlock(Registry.Blocks.IRIDIUM_ORE, "Iridium Ore");
		addBlock(Registry.Blocks.DEEPSLATE_IRIDIUM_ORE, "Deepslate Iridium Ore");
		addBlock(Registry.Blocks.LITHIUM_ORE, "Lithium Ore");
		addBlock(Registry.Blocks.DEEPSLATE_LITHIUM_ORE, "Deepslate Lithium Ore");
		addBlock(Registry.Blocks.PLATINUM_ORE, "Platinum Ore");
		addBlock(Registry.Blocks.DEEPSLATE_PLATINUM_ORE, "Deepslate Platinum Ore");
		addBlock(Registry.Blocks.GRAPHITE_ORE, "Graphite Ore");
		addBlock(Registry.Blocks.DEEPSLATE_GRAPHITE_ORE, "Deepslate Graphite Ore");
		addBlock(Registry.Blocks.BERYLLIUM_ORE, "Beryllium Ore");
		addBlock(Registry.Blocks.DEEPSLATE_BERYLLIUM_ORE, "Deepslate Beryllium Ore");
		addBlock(Registry.Blocks.CADMIUM_ORE, "Cadmium Ore");
		addBlock(Registry.Blocks.DEEPSLATE_CADMIUM_ORE, "Deepslate Cadmium Ore");
		addBlock(Registry.Blocks.CHROMIUM_ORE, "Chromium Ore");
		addBlock(Registry.Blocks.DEEPSLATE_CHROMIUM_ORE, "Deepslate Chromium Ore");
		addBlock(Registry.Blocks.MANGANESE_ORE, "Manganese Ore");
		addBlock(Registry.Blocks.DEEPSLATE_MANGANESE_ORE, "Deepslate Manganese Ore");
		addBlock(Registry.Blocks.OSMIUM_ORE, "Osmium Ore");
		addBlock(Registry.Blocks.DEEPSLATE_OSMIUM_ORE, "Deepslate Osmium Ore");
		addBlock(Registry.Blocks.PALLADIUM_ORE, "Palladium Ore");
		addBlock(Registry.Blocks.DEEPSLATE_PALLADIUM_ORE, "Deepslate Palladium Ore");
		addBlock(Registry.Blocks.THORIUM_ORE, "Thorium Ore");
		addBlock(Registry.Blocks.DEEPSLATE_THORIUM_ORE, "Deepslate Thorium Ore");
		addBlock(Registry.Blocks.URANIUM_ORE, "Uranium Ore");
		addBlock(Registry.Blocks.DEEPSLATE_URANIUM_ORE, "Deepslate Uranium Ore");
		addBlock(Registry.Blocks.VANADIUM_ORE, "Vanadium Ore");
		addBlock(Registry.Blocks.DEEPSLATE_VANADIUM_ORE, "Deepslate Vanadium Ore");
		addBlock(Registry.Blocks.ZINC_ORE, "Zinc Ore");
		addBlock(Registry.Blocks.DEEPSLATE_ZINC_ORE, "Deepslate Zinc Ore");
		//endregion
		
		//region Items
		addItem(Registry.Items.PROSPECTING_PICK, "Prospecting Pick");
		addItem(Registry.Items.EMPTY_SAMPLE_TUBE, "Empty Sample Tube");
		addItem(Registry.Items.FILLED_SAMPLE_TUBE, "Filled Sample Tube");
		addItem(Registry.Items.SCREWDRIVER, "Screwdriver");
		//endregion
		
		//region Tooltips
		add(String.format("tooltip.%s.sample_location.chunk_pos", MOD_ID), "Chunk Sample: [x: %s, z: %s]");
		add(String.format("tooltip.%s.sample_location.region", MOD_ID), "Sample Region: %s");
		//endregion
	}
}
