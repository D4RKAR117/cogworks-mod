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
	public static final ResourceKey<PlacedFeature> BERYLLIUM_ORE_PLACED_KEY = registerKey("beryllium_ore");
	public static final ResourceKey<PlacedFeature> CADMIUM_ORE_PLACED_KEY = registerKey("cadmium_ore");
	public static final ResourceKey<PlacedFeature> CHROMIUM_ORE_PLACED_KEY = registerKey("chromium_ore");
	public static final ResourceKey<PlacedFeature> MANGANESE_ORE_PLACED_KEY = registerKey("manganese_ore");
	public static final ResourceKey<PlacedFeature> OSMIUM_ORE_PLACED_KEY = registerKey("osmium_ore");
	public static final ResourceKey<PlacedFeature> PALLADIUM_ORE_PLACED_KEY = registerKey("palladium_ore");
	public static final ResourceKey<PlacedFeature> THORIUM_ORE_PLACED_KEY = registerKey("thorium_ore");
	public static final ResourceKey<PlacedFeature> URANIUM_ORE_PLACED_KEY = registerKey("uranium_ore");
	public static final ResourceKey<PlacedFeature> VANADIUM_ORE_PLACED_KEY = registerKey("vanadium_ore");
	public static final ResourceKey<PlacedFeature> ZINC_ORE_PLACED_KEY = registerKey("zinc_ore");



	public static void bootstrap(BootstrapContext<PlacedFeature> context) {
		HolderGetter<ConfiguredFeature<?,?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

		register(context, TUNGSTEN_ORE_PLACED_KEY,
		         configuredFeatures.getOrThrow(ConfiguredFeatures.OVERWORLD_TUNGSTEN_ORE_KEY),
		         OrePlacement.commonOrePlacement(3, HeightRangePlacement.uniform(VerticalAnchor.absolute(-40),
		                                                                        VerticalAnchor.absolute(60))));
		register(context, TITANIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ConfiguredFeatures.OVERWORLD_TITANIUM_ORE_KEY),
		         OrePlacement.commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.absolute(-30),
		                                                                        VerticalAnchor.absolute(80))));
		register(context, COBALT_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ConfiguredFeatures.OVERWORLD_COBALT_ORE_KEY),
		         OrePlacement.commonOrePlacement(3, HeightRangePlacement.uniform(VerticalAnchor.absolute(-20),
		                                                                        VerticalAnchor.absolute(45))));
		register(context, NICKEL_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ConfiguredFeatures.OVERWORLD_NICKEL_ORE_KEY),
		         OrePlacement.commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.absolute(-40),
		                                                                        VerticalAnchor.absolute(60))));
		register(context, PLATINUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ConfiguredFeatures.OVERWORLD_PLATINUM_ORE_KEY),
		         OrePlacement.rareOrePlacement(8, HeightRangePlacement.triangle(VerticalAnchor.absolute(-50),
		                                                                        VerticalAnchor.absolute(40))));
		register(context, BAUXITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ConfiguredFeatures.OVERWORLD_BAUXITE_ORE_KEY),
		         OrePlacement.commonOrePlacement(3, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64),
		                                                                        VerticalAnchor.absolute(80))));
		register(context, MOLYBDENUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ConfiguredFeatures.OVERWORLD_MOLYBDENUM_ORE_KEY),
		         OrePlacement.rareOrePlacement(8, HeightRangePlacement.uniform(VerticalAnchor.absolute(-30),
		                                                                        VerticalAnchor.absolute(50))));
		register(context, LITHIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ConfiguredFeatures.OVERWORLD_LITHIUM_ORE_KEY),
		         OrePlacement.rareOrePlacement(3, HeightRangePlacement.uniform(VerticalAnchor.absolute(-10),
		                                                                        VerticalAnchor.absolute(40))));
		register(context, IRIDIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ConfiguredFeatures.OVERWORLD_IRIDIUM_ORE_KEY),
		         OrePlacement.rareOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(-60),
		                                                                        VerticalAnchor.absolute(30))));
		register(context, GRAPHITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ConfiguredFeatures.OVERWORLD_GRAPHITE_ORE_KEY),
		         OrePlacement.commonOrePlacement(1, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64),
		                                                                        VerticalAnchor.absolute(64))));
		register(context, BERYLLIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ConfiguredFeatures.OVERWORLD_BERYLLIUM_ORE_KEY),
		         OrePlacement.commonOrePlacement(3, HeightRangePlacement.uniform(VerticalAnchor.absolute(-10),
		                                                                        VerticalAnchor.absolute(40))));
		register(context, CADMIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ConfiguredFeatures.OVERWORLD_CADMIUM_ORE_KEY),
		         OrePlacement.rareOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-20),
		                                                                        VerticalAnchor.absolute(30))));
		register(context, CHROMIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ConfiguredFeatures.OVERWORLD_CHROMIUM_ORE_KEY),
		         OrePlacement.commonOrePlacement(3, HeightRangePlacement.uniform(VerticalAnchor.absolute(10),
		                                                                        VerticalAnchor.absolute(60))));
		register(context, MANGANESE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ConfiguredFeatures.OVERWORLD_MANGANESE_ORE_KEY),
		         OrePlacement.commonOrePlacement(5, HeightRangePlacement.uniform(VerticalAnchor.absolute(30),
		                                                                        VerticalAnchor.absolute(80))));
		register(context, OSMIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ConfiguredFeatures.OVERWORLD_OSMIUM_ORE_KEY),
		         OrePlacement.rareOrePlacement(12, HeightRangePlacement.triangle(VerticalAnchor.absolute(-40),
		                                                                        VerticalAnchor.absolute(10))));
		register(context, PALLADIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ConfiguredFeatures.OVERWORLD_PALLADIUM_ORE_KEY),
		         OrePlacement.rareOrePlacement(9, HeightRangePlacement.triangle(VerticalAnchor.absolute(-20),
		                                                                        VerticalAnchor.absolute(50))));
		register(context, THORIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ConfiguredFeatures.OVERWORLD_THORIUM_ORE_KEY),
		         OrePlacement.rareOrePlacement(9, HeightRangePlacement.triangle(VerticalAnchor.absolute(-50),
		                                                                        VerticalAnchor.absolute(20))));
		register(context, URANIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ConfiguredFeatures.OVERWORLD_URANIUM_ORE_KEY),
		         OrePlacement.rareOrePlacement(8, HeightRangePlacement.triangle(VerticalAnchor.absolute(-30),
		                                                                        VerticalAnchor.absolute(30))));
		register(context, VANADIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ConfiguredFeatures.OVERWORLD_VANADIUM_ORE_KEY),
		         OrePlacement.rareOrePlacement(7, HeightRangePlacement.triangle(VerticalAnchor.absolute(40),
		                                                                        VerticalAnchor.absolute(90))));
		register(context, ZINC_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ConfiguredFeatures.OVERWORLD_ZINC_ORE_KEY),
		         OrePlacement.commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.absolute(20),
		                                                                        VerticalAnchor.absolute(70))));

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
