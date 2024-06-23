package dev.darkar.cog_works.generation.data;

import dev.darkar.cog_works.generation.data.lang.EN_US_Generator;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

import static dev.darkar.cog_works.CogWorks.MOD_ID;

@EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerationManager {
	
	@SubscribeEvent
	public static void onGatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		PackOutput output = generator.getPackOutput();
		ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
		CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
		
		generator.addProvider(event.includeClient(), new BlockStateGenerator(output, existingFileHelper));
		BlockTagGenerator blockTagGenerator = generator.addProvider(event.includeServer(),
		                                                            new BlockTagGenerator(output, lookupProvider,
		                                                                                  existingFileHelper));
		generator.addProvider(event.includeServer(),
		                      new ItemTagGenerator(output, lookupProvider, blockTagGenerator.contentsGetter(),
		                                           existingFileHelper));
		generator.addProvider(event.includeClient(), new EN_US_Generator(output));
	}
}
