package org.darkar.cog_works.generation.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.darkar.cog_works.Registry;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static org.darkar.cog_works.CogWorks.MOD_ID;
import static org.darkar.cog_works.Registry.Blocks.Tags.*;

public class BlockTagGenerator extends BlockTagsProvider {
	public BlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, MOD_ID, existingFileHelper);
	}

	@Override
	protected void addTags(HolderLookup.Provider pProvider) {



		 tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
			Registry.Blocks.TUNGSTEN_ORE.get(),
			Registry.Blocks.TITANIUM_ORE.get(),
			Registry.Blocks.COBALT_ORE.get(),
			Registry.Blocks.NICKEL_ORE.get(),
			Registry.Blocks.PLATINUM_ORE.get(),
			Registry.Blocks.BAUXITE_ORE.get(),
			Registry.Blocks.MOLYBDENUM_ORE.get(),
			Registry.Blocks.LITHIUM_ORE.get(),
			Registry.Blocks.IRIDIUM_ORE.get(),
			Registry.Blocks.GRAPHITE_ORE.get(),
			Registry.Blocks.DEEPSLATE_TUNGSTEN_ORE.get(),
			Registry.Blocks.DEEPSLATE_TITANIUM_ORE.get(),
			Registry.Blocks.DEEPSLATE_COBALT_ORE.get(),
			Registry.Blocks.DEEPSLATE_NICKEL_ORE.get(),
			Registry.Blocks.DEEPSLATE_PLATINUM_ORE.get(),
			Registry.Blocks.DEEPSLATE_BAUXITE_ORE.get(),
			Registry.Blocks.DEEPSLATE_MOLYBDENUM_ORE.get(),
			Registry.Blocks.DEEPSLATE_LITHIUM_ORE.get(),
			Registry.Blocks.DEEPSLATE_IRIDIUM_ORE.get(),
			Registry.Blocks.DEEPSLATE_GRAPHITE_ORE.get()
		                                              );

		 tag(BlockTags.NEEDS_IRON_TOOL).add(
			 Registry.Blocks.COBALT_ORE.get(),
			 Registry.Blocks.DEEPSLATE_COBALT_ORE.get(),
			 Registry.Blocks.NICKEL_ORE.get(),
			 Registry.Blocks.DEEPSLATE_NICKEL_ORE.get(),
			 Registry.Blocks.BAUXITE_ORE.get(),
			 Registry.Blocks.DEEPSLATE_BAUXITE_ORE.get(),
			 Registry.Blocks.LITHIUM_ORE.get(),
			 Registry.Blocks.DEEPSLATE_LITHIUM_ORE.get(),
			 Registry.Blocks.GRAPHITE_ORE.get(),
			 Registry.Blocks.DEEPSLATE_GRAPHITE_ORE.get()
		                                         );

		 tag(BlockTags.NEEDS_DIAMOND_TOOL).add(
			 Registry.Blocks.TUNGSTEN_ORE.get(),
			 Registry.Blocks.DEEPSLATE_TUNGSTEN_ORE.get(),
			 Registry.Blocks.TITANIUM_ORE.get(),
			 Registry.Blocks.DEEPSLATE_TITANIUM_ORE.get(),
			 Registry.Blocks.PLATINUM_ORE.get(),
			 Registry.Blocks.DEEPSLATE_PLATINUM_ORE.get(),
			 Registry.Blocks.MOLYBDENUM_ORE.get(),
			 Registry.Blocks.DEEPSLATE_MOLYBDENUM_ORE.get(),
			 Registry.Blocks.IRIDIUM_ORE.get(),
			 Registry.Blocks.DEEPSLATE_IRIDIUM_ORE.get()
		                                         );

		 tag(BAUXITE_ORES).add(Registry.Blocks.BAUXITE_ORE.get(), Registry.Blocks.DEEPSLATE_BAUXITE_ORE.get());
		 tag(GRAPHITE_ORES).add(Registry.Blocks.GRAPHITE_ORE.get(), Registry.Blocks.DEEPSLATE_GRAPHITE_ORE.get());
		 tag(LITHIUM_ORES).add(Registry.Blocks.LITHIUM_ORE.get(), Registry.Blocks.DEEPSLATE_LITHIUM_ORE.get());
		 tag(MOLYBDENUM_ORES).add(Registry.Blocks.MOLYBDENUM_ORE.get(), Registry.Blocks.DEEPSLATE_MOLYBDENUM_ORE.get());
		 tag(IRIDIUM_ORES).add(Registry.Blocks.IRIDIUM_ORE.get(), Registry.Blocks.DEEPSLATE_IRIDIUM_ORE.get());
		 tag(TUNGSTEN_ORES).add(Registry.Blocks.TUNGSTEN_ORE.get(), Registry.Blocks.DEEPSLATE_TUNGSTEN_ORE.get());
		 tag(TITANIUM_ORES).add(Registry.Blocks.TITANIUM_ORE.get(), Registry.Blocks.DEEPSLATE_TITANIUM_ORE.get());
		 tag(COBALT_ORES).add(Registry.Blocks.COBALT_ORE.get(), Registry.Blocks.DEEPSLATE_COBALT_ORE.get());
		 tag(NICKEL_ORES).add(Registry.Blocks.NICKEL_ORE.get(), Registry.Blocks.DEEPSLATE_NICKEL_ORE.get());
		 tag(PLATINUM_ORES).add(Registry.Blocks.PLATINUM_ORE.get(), Registry.Blocks.DEEPSLATE_PLATINUM_ORE.get());

		 tag(Tags.Blocks.ORES).addTags(
			 BAUXITE_ORES,
			 GRAPHITE_ORES,
			 LITHIUM_ORES,
			 MOLYBDENUM_ORES,
			 IRIDIUM_ORES,
			 TUNGSTEN_ORES,
			 TITANIUM_ORES,
			 COBALT_ORES,
			 NICKEL_ORES,
			 PLATINUM_ORES
		                               );
	}
}