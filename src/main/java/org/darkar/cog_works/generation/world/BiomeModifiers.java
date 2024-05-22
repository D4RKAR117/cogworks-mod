package org.darkar.cog_works.generation.world;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers.AddFeaturesBiomeModifier;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import static org.darkar.cog_works.CogWorks.MOD_ID;

public class BiomeModifiers {
	public static final ResourceKey<BiomeModifier> ADD_TUNGSTEN_ORE_MODIFIER = registerKey("tungsten_ore");
	public static final ResourceKey<BiomeModifier> ADD_TITANIUM_ORE_MODIFIER = registerKey("titanium_ore");
	public static final ResourceKey<BiomeModifier> ADD_COBALT_ORE_MODIFIER = registerKey("cobalt_ore");
	public static final ResourceKey<BiomeModifier> ADD_NICKEL_ORE_MODIFIER = registerKey("nickel_ore");
	public static final ResourceKey<BiomeModifier> ADD_PLATINUM_ORE_MODIFIER = registerKey("platinum_ore");
	public static final ResourceKey<BiomeModifier> ADD_BAUXITE_ORE_MODIFIER = registerKey("bauxite_ore");
	public static final ResourceKey<BiomeModifier> ADD_MOLYBDENUM_ORE_MODIFIER = registerKey("molybdenum_ore");
	public static final ResourceKey<BiomeModifier> ADD_LITHIUM_ORE_MODIFIER = registerKey("lithium_ore");
	public static final ResourceKey<BiomeModifier> ADD_IRIDIUM_ORE_MODIFIER = registerKey("iridium_ore");
	public static final ResourceKey<BiomeModifier> ADD_GRAPHITE_ORE_MODIFIER = registerKey("graphite_ore");
	public static final ResourceKey<BiomeModifier> ADD_BERYLLIUM_ORE_MODIFIER = registerKey("beryllium_ore");
	public static final ResourceKey<BiomeModifier> ADD_CADMIUM_ORE_MODIFIER = registerKey("cadmium_ore");
	public static final ResourceKey<BiomeModifier> ADD_CHROMIUM_ORE_MODIFIER = registerKey("chromium_ore");
	public static final ResourceKey<BiomeModifier> ADD_MANGANESE_ORE_MODIFIER = registerKey("manganese_ore");
	public static final ResourceKey<BiomeModifier> ADD_OSMIUM_ORE_MODIFIER = registerKey("osmium_ore");
	public static final ResourceKey<BiomeModifier> ADD_PALLADIUM_ORE_MODIFIER = registerKey("palladium_ore");
	public static final ResourceKey<BiomeModifier> ADD_THORIUM_ORE_MODIFIER = registerKey("thorium_ore");
	public static final ResourceKey<BiomeModifier> ADD_URANIUM_ORE_MODIFIER = registerKey("uranium_ore");
	public static final ResourceKey<BiomeModifier> ADD_VANADIUM_ORE_MODIFIER = registerKey("vanadium_ore");
	public static final ResourceKey<BiomeModifier> ADD_ZINC_ORE_MODIFIER = registerKey("zinc_ore");

	public static void bootstrap(BootstrapContext<BiomeModifier> context) {
	  HolderGetter<PlacedFeature> placedFeatures =	context.lookup(Registries.PLACED_FEATURE);
	  HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);

	  context.register(ADD_TUNGSTEN_ORE_MODIFIER,
	                   new AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
	                                                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.TUNGSTEN_ORE_PLACED_KEY)),
	                                                GenerationStep.Decoration.UNDERGROUND_ORES
	                   ));

	  context.register(ADD_TITANIUM_ORE_MODIFIER,
	                   new AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
	                                                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.TITANIUM_ORE_PLACED_KEY)),
	                                                GenerationStep.Decoration.UNDERGROUND_ORES
	                   ));

	  context.register(ADD_COBALT_ORE_MODIFIER,
	                   new AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
	                                                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.COBALT_ORE_PLACED_KEY)),
	                                                GenerationStep.Decoration.UNDERGROUND_ORES
	                   ));

	  context.register(ADD_NICKEL_ORE_MODIFIER,
	                   new AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
	                                                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.NICKEL_ORE_PLACED_KEY)),
	                                                GenerationStep.Decoration.UNDERGROUND_ORES
	                   ));

	  context.register(ADD_PLATINUM_ORE_MODIFIER,
	                   new AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
	                                                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.PLATINUM_ORE_PLACED_KEY)),
	                                                GenerationStep.Decoration.UNDERGROUND_ORES
	                   ));

	  context.register(ADD_BAUXITE_ORE_MODIFIER,
	                   new AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
	                                                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.BAUXITE_ORE_PLACED_KEY)),
	                                                GenerationStep.Decoration.UNDERGROUND_ORES
	                   ));

	  context.register(ADD_MOLYBDENUM_ORE_MODIFIER,
	                   new AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
	                                                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.MOLYBDENUM_ORE_PLACED_KEY)),
	                                                GenerationStep.Decoration.UNDERGROUND_ORES
	                   ));

	  context.register(ADD_LITHIUM_ORE_MODIFIER,
	                   new AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
	                                                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.LITHIUM_ORE_PLACED_KEY)),
	                                                GenerationStep.Decoration.UNDERGROUND_ORES
	                   ));

	  context.register(ADD_IRIDIUM_ORE_MODIFIER,
	                   new AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
	                                                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.IRIDIUM_ORE_PLACED_KEY)),
	                                                GenerationStep.Decoration.UNDERGROUND_ORES
	                   ));

	  context.register(ADD_GRAPHITE_ORE_MODIFIER,
	                   new AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
	                                                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.GRAPHITE_ORE_PLACED_KEY)),
	                                                GenerationStep.Decoration.UNDERGROUND_ORES
	                   ));

	  context.register(ADD_BERYLLIUM_ORE_MODIFIER,
	                   new AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
	                                                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.BERYLLIUM_ORE_PLACED_KEY)),
	                                                GenerationStep.Decoration.UNDERGROUND_ORES
	                   ));

	  context.register(ADD_CADMIUM_ORE_MODIFIER,
	                   new AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
	                                                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.CADMIUM_ORE_PLACED_KEY)),
	                                                GenerationStep.Decoration.UNDERGROUND_ORES
	                   ));

	  context.register(ADD_CHROMIUM_ORE_MODIFIER,
	                   new AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
	                                                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.CHROMIUM_ORE_PLACED_KEY)),
	                                                GenerationStep.Decoration.UNDERGROUND_ORES
	                   ));

	  context.register(ADD_MANGANESE_ORE_MODIFIER,
	                   new AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
	                                                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.MANGANESE_ORE_PLACED_KEY)),
	                                                GenerationStep.Decoration.UNDERGROUND_ORES
	                   ));

	  context.register(ADD_OSMIUM_ORE_MODIFIER,
	                   new AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
	                                                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.OSMIUM_ORE_PLACED_KEY)),
	                                                GenerationStep.Decoration.UNDERGROUND_ORES
	                   ));

	  context.register(ADD_PALLADIUM_ORE_MODIFIER,
	                   new AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
	                                                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.PALLADIUM_ORE_PLACED_KEY)),
	                                                GenerationStep.Decoration.UNDERGROUND_ORES
	                   ));

	  context.register(ADD_THORIUM_ORE_MODIFIER,
	                   new AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
	                                                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.THORIUM_ORE_PLACED_KEY)),
	                                                GenerationStep.Decoration.UNDERGROUND_ORES
	                   ));

	  context.register(ADD_URANIUM_ORE_MODIFIER,
	                   new AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
	                                                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.URANIUM_ORE_PLACED_KEY)),
	                                                GenerationStep.Decoration.UNDERGROUND_ORES
	                   ));

	  context.register(ADD_VANADIUM_ORE_MODIFIER,
	                   new AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
	                                                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.VANADIUM_ORE_PLACED_KEY)),
	                                                GenerationStep.Decoration.UNDERGROUND_ORES
	                   ));

	  context.register(ADD_ZINC_ORE_MODIFIER,
	                   new AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
	                                                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.ZINC_ORE_PLACED_KEY)),
	                                                GenerationStep.Decoration.UNDERGROUND_ORES
	                   ));
	}

	private static ResourceKey<BiomeModifier> registerKey(String name) {
		return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(MOD_ID, "add_"+name));
	}

}
