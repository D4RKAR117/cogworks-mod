package org.darkar.cog_works.generation.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.darkar.cog_works.generation.world.BiomeModifiers;
import org.darkar.cog_works.generation.world.ConfiguredFeatures;
import org.darkar.cog_works.generation.world.PlacedFeatures;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

import static org.darkar.cog_works.CogWorks.MOD_ID;

public class WorldDataGenerator extends DatapackBuiltinEntriesProvider {
	public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
		.add(Registries.CONFIGURED_FEATURE, ConfiguredFeatures::bootstrap)
		.add(Registries.PLACED_FEATURE, PlacedFeatures::bootstrap)
		.add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, BiomeModifiers::bootstrap);

	/**
	 * Constructs a new data pack provider which generates all registry objects
	 * from the provided mods using the holder.
	 *
	 * @param output     the target directory of the data generator
	 * @param registries a future of a lookup for registries and their objects
	 */
	public WorldDataGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
		super(output, registries, BUILDER,Set.of(MOD_ID));
	}
}
