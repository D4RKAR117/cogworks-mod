package dev.darkar.cog_works.generation.data.lang;

import dev.darkar.cog_works.Registry;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

import static dev.darkar.cog_works.CogWorks.MOD_ID;

public class EN_US_Generator extends LanguageProvider {
	public EN_US_Generator(PackOutput output) {
		super(output, MOD_ID, "en_us");
	}
	
	@Override
	protected void addTranslations() {
		
		// region Blocks
		
		//region Machines
		addBlock(Registry.Blocks.TRANSMISSION_SHAFT, "Transmission Shaft");
		//endregion
		
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
