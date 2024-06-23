package dev.darkar.cog_works.generation.data;

import dev.darkar.cog_works.Registry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static dev.darkar.cog_works.CogWorks.MOD_ID;

public class ItemTagGenerator extends ItemTagsProvider {
	public ItemTagGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider,
	                        CompletableFuture<TagLookup<Block>> pBlockTags,
	                        @Nullable ExistingFileHelper existingFileHelper)
	{
		super(pOutput, pLookupProvider, pBlockTags, MOD_ID, existingFileHelper);
	}
	
	@Override
	protected void addTags(HolderLookup.Provider pProvider) {
		tag(Tags.Items.TOOLS).add(Registry.Items.PROSPECTING_PICK.get(), Registry.Items.SCREWDRIVER.get(),
		                          Registry.Items.EMPTY_SAMPLE_TUBE.get(), Registry.Items.FILLED_SAMPLE_TUBE.get());
	}
}
