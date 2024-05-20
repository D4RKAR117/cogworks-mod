package org.darkar.cog_works.generation.world;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

import static org.darkar.cog_works.CogWorks.MOD_ID;

public class PlacedFeatures {

	public static final ResourceKey<PlacedFeature> TUNGSTEN_ORE_PLACED_KEY = registerKey("tungsten_ore");
	public static final ResourceKey<PlacedFeature> TITANIUM_ORE_PLACED_KEY = registerKey("titanium_ore");
	public static final ResourceKey<PlacedFeature> COBALT_ORE_PLACED_KEY = registerKey("cobalt_ore");
	public static final ResourceKey<PlacedFeature> NICKEL_ORE_PLACED_KEY = registerKey("nickel_ore");
	public static final ResourceKey<PlacedFeature> PLATINUM_ORE_PLACED_KEY = registerKey("platinum_ore");
	public static final ResourceKey<PlacedFeature> BAUXITE_ORE_PLACED_KEY = registerKey("bauxite_ore");
	public static final ResourceKey<PlacedFeature> MOLYBDENUM_ORE_PLACED_KEY = registerKey("molybdenum_ore");
	public static final ResourceKey<PlacedFeature> LITHIUM_ORE_PLACED_KEY = registerKey("lithium_ore");
	public static final ResourceKey<PlacedFeature> IRIDIUM_ORE_PLACED_KEY = registerKey("iridium_ore");
	public static final ResourceKey<PlacedFeature> GRAPHITE_ORE_PLACED_KEY = registerKey("graphite_ore");



	public static void bootstrap(BootstrapContext<PlacedFeature> context) {
		HolderGetter<ConfiguredFeature<?,?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

		register(context, TUNGSTEN_ORE_PLACED_KEY,
		         configuredFeatures.getOrThrow(ConfiguredFeatures.OVERWORLD_TUNGSTEN_ORE_KEY),
		         OrePlacement.rareOrePlacement(12, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64),
		                                                                        VerticalAnchor.absolute(32))));
		register(context, TITANIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ConfiguredFeatures.OVERWORLD_TITANIUM_ORE_KEY),
		         OrePlacement.commonOrePlacement(1, HeightRangePlacement.uniform(VerticalAnchor.absolute(-32),
		                                                                        VerticalAnchor.absolute(120))));
		register(context, COBALT_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ConfiguredFeatures.OVERWORLD_COBALT_ORE_KEY),
		         OrePlacement.rareOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64),
		                                                                        VerticalAnchor.absolute(32))));
		register(context, NICKEL_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ConfiguredFeatures.OVERWORLD_NICKEL_ORE_KEY),
		         OrePlacement.commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64),
		                                                                        VerticalAnchor.absolute(64))));
		register(context, PLATINUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ConfiguredFeatures.OVERWORLD_PLATINUM_ORE_KEY),
		         OrePlacement.rareOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64),
		                                                                        VerticalAnchor.absolute(32))));
		register(context, BAUXITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ConfiguredFeatures.OVERWORLD_BAUXITE_ORE_KEY),
		         OrePlacement.commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64),
		                                                                        VerticalAnchor.absolute(120))));
		register(context, MOLYBDENUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ConfiguredFeatures.OVERWORLD_MOLYBDENUM_ORE_KEY),
		         OrePlacement.rareOrePlacement(8, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64),
		                                                                        VerticalAnchor.absolute(32))));
		register(context, LITHIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ConfiguredFeatures.OVERWORLD_LITHIUM_ORE_KEY),
		         OrePlacement.rareOrePlacement(3, HeightRangePlacement.triangle(VerticalAnchor.absolute(-32),
		                                                                        VerticalAnchor.absolute(64))));
		register(context, IRIDIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ConfiguredFeatures.OVERWORLD_IRIDIUM_ORE_KEY),
		         OrePlacement.rareOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64),
		                                                                        VerticalAnchor.absolute(32))));
		register(context, GRAPHITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ConfiguredFeatures.OVERWORLD_GRAPHITE_ORE_KEY),
		         OrePlacement.commonOrePlacement(1, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64),
		                                                                        VerticalAnchor.absolute(64))));

	}


	private static ResourceKey<PlacedFeature> registerKey(String name) {
		return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(MOD_ID, name+"_placed"));
	}

	private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
	                             Holder<ConfiguredFeature<?, ?>> configuration,
	                             List<PlacementModifier> modifiers) {
		context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
	}
}
