package org.darkar.cog_works.datagen.lang;

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
	}
}
