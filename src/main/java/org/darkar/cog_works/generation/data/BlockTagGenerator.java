package org.darkar.cog_works.generation.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static org.darkar.cog_works.CogWorks.MOD_ID;

public class BlockTagGenerator extends BlockTagsProvider {
	public BlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
	                         @Nullable ExistingFileHelper existingFileHelper)
	{
		super(output, lookupProvider, MOD_ID, existingFileHelper);
	}
	
	@Override
	protected void addTags(HolderLookup.Provider pProvider) {
	
	}
}
