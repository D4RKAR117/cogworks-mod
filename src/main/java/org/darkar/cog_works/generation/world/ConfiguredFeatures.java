package org.darkar.cog_works.generation.world;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import org.darkar.cog_works.Registry;

import java.util.List;

import static org.darkar.cog_works.CogWorks.MOD_ID;

public class ConfiguredFeatures {

	public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_TUNGSTEN_ORE_KEY = registerKey("tungsten_ore");
	public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_TITANIUM_ORE_KEY = registerKey("titanium_ore");
	public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_COBALT_ORE_KEY = registerKey("cobalt_ore");
	public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_NICKEL_ORE_KEY = registerKey("nickel_ore");
	public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_PLATINUM_ORE_KEY = registerKey("platinum_ore");
	public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_BAUXITE_ORE_KEY = registerKey("bauxite_ore");
	public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_MOLYBDENUM_ORE_KEY = registerKey("molybdenum_ore");
	public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_LITHIUM_ORE_KEY = registerKey("lithium_ore");
	public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_IRIDIUM_ORE_KEY = registerKey("iridium_ore");
	public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_GRAPHITE_ORE_KEY = registerKey("graphite_ore");
	public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_BERYLLIUM_ORE_KEY = registerKey("beryllium_ore");
	public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_CADMIUM_ORE_KEY = registerKey("cadmium_ore");
	public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_CHROMIUM_ORE_KEY = registerKey("chromium_ore");
	public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_MANGANESE_ORE_KEY = registerKey("manganese_ore");
	public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_OSMIUM_ORE_KEY = registerKey("osmium_ore");
	public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_PALLADIUM_ORE_KEY = registerKey("palladium_ore");
	public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_THORIUM_ORE_KEY = registerKey("thorium_ore");
	public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_URANIUM_ORE_KEY = registerKey("uranium_ore");
	public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_VANADIUM_ORE_KEY = registerKey("vanadium_ore");
	public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_ZINC_ORE_KEY = registerKey("zinc_ore");



	public static void bootstrap(BootstrapContext<ConfiguredFeature<?,?>> context) {
		RuleTest stoneReplaceTest = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
		RuleTest deepslateReplaceTest = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

		List<OreConfiguration.TargetBlockState> overworldTungstenOres = List.of(
			OreConfiguration.target(stoneReplaceTest,Registry.Blocks.TUNGSTEN_ORE.get().defaultBlockState()),
			OreConfiguration.target(deepslateReplaceTest,Registry.Blocks.DEEPSLATE_TUNGSTEN_ORE.get().defaultBlockState())
		);

		List<OreConfiguration.TargetBlockState> overworldTitaniumOres = List.of(
			OreConfiguration.target(stoneReplaceTest,Registry.Blocks.TITANIUM_ORE.get().defaultBlockState()),
			OreConfiguration.target(deepslateReplaceTest,Registry.Blocks.DEEPSLATE_TITANIUM_ORE.get().defaultBlockState())
		);

		List<OreConfiguration.TargetBlockState> overworldCobaltOres = List.of(
			OreConfiguration.target(stoneReplaceTest,Registry.Blocks.COBALT_ORE.get().defaultBlockState()),
			OreConfiguration.target(deepslateReplaceTest,Registry.Blocks.DEEPSLATE_COBALT_ORE.get().defaultBlockState())
		);

		List<OreConfiguration.TargetBlockState> overworldNickelOres = List.of(
			OreConfiguration.target(stoneReplaceTest,Registry.Blocks.NICKEL_ORE.get().defaultBlockState()),
			OreConfiguration.target(deepslateReplaceTest,Registry.Blocks.DEEPSLATE_NICKEL_ORE.get().defaultBlockState())
		);

		List<OreConfiguration.TargetBlockState> overworldPlatinumOres = List.of(
			OreConfiguration.target(stoneReplaceTest,Registry.Blocks.PLATINUM_ORE.get().defaultBlockState()),
			OreConfiguration.target(deepslateReplaceTest,Registry.Blocks.DEEPSLATE_PLATINUM_ORE.get().defaultBlockState())
		);

		List<OreConfiguration.TargetBlockState> overworldBauxiteOres = List.of(
			OreConfiguration.target(stoneReplaceTest,Registry.Blocks.BAUXITE_ORE.get().defaultBlockState()),
			OreConfiguration.target(deepslateReplaceTest,Registry.Blocks.DEEPSLATE_BAUXITE_ORE.get().defaultBlockState())
		);

		List<OreConfiguration.TargetBlockState> overworldMolybdenumOres = List.of(
			OreConfiguration.target(stoneReplaceTest,Registry.Blocks.MOLYBDENUM_ORE.get().defaultBlockState()),
			OreConfiguration.target(deepslateReplaceTest,Registry.Blocks.DEEPSLATE_MOLYBDENUM_ORE.get().defaultBlockState())
		);

		List<OreConfiguration.TargetBlockState> overworldLithiumOres = List.of(
			OreConfiguration.target(stoneReplaceTest,Registry.Blocks.LITHIUM_ORE.get().defaultBlockState()),
			OreConfiguration.target(deepslateReplaceTest,Registry.Blocks.DEEPSLATE_LITHIUM_ORE.get().defaultBlockState())
		);

		List<OreConfiguration.TargetBlockState> overworldIridiumOres = List.of(
			OreConfiguration.target(stoneReplaceTest,Registry.Blocks.IRIDIUM_ORE.get().defaultBlockState()),
			OreConfiguration.target(deepslateReplaceTest,Registry.Blocks.DEEPSLATE_IRIDIUM_ORE.get().defaultBlockState())
		);

		List<OreConfiguration.TargetBlockState> overworldGraphiteOres = List.of(
			OreConfiguration.target(stoneReplaceTest,Registry.Blocks.GRAPHITE_ORE.get().defaultBlockState()),
			OreConfiguration.target(deepslateReplaceTest,Registry.Blocks.DEEPSLATE_GRAPHITE_ORE.get().defaultBlockState())
		);

		List<OreConfiguration.TargetBlockState> overworldBerylliumOres = List.of(
			OreConfiguration.target(stoneReplaceTest,Registry.Blocks.BERYLLIUM_ORE.get().defaultBlockState()),
			OreConfiguration.target(deepslateReplaceTest,Registry.Blocks.DEEPSLATE_BERYLLIUM_ORE.get().defaultBlockState())
		                                                                       );

		List<OreConfiguration.TargetBlockState> overworldCadmiumOres = List.of(
			OreConfiguration.target(stoneReplaceTest,Registry.Blocks.CADMIUM_ORE.get().defaultBlockState()),
			OreConfiguration.target(deepslateReplaceTest,Registry.Blocks.DEEPSLATE_CADMIUM_ORE.get().defaultBlockState())
		);

		List<OreConfiguration.TargetBlockState> overworldChromiumOres = List.of(
			OreConfiguration.target(stoneReplaceTest,Registry.Blocks.CHROMIUM_ORE.get().defaultBlockState()),
			OreConfiguration.target(deepslateReplaceTest,Registry.Blocks.DEEPSLATE_CHROMIUM_ORE.get().defaultBlockState())
		);

		List<OreConfiguration.TargetBlockState> overworldManganeseOres = List.of(
			OreConfiguration.target(stoneReplaceTest,Registry.Blocks.MANGANESE_ORE.get().defaultBlockState()),
			OreConfiguration.target(deepslateReplaceTest,Registry.Blocks.DEEPSLATE_MANGANESE_ORE.get().defaultBlockState())
		);

		List<OreConfiguration.TargetBlockState> overworldOsmiumOres = List.of(
			OreConfiguration.target(stoneReplaceTest,Registry.Blocks.OSMIUM_ORE.get().defaultBlockState()),
			OreConfiguration.target(deepslateReplaceTest,Registry.Blocks.DEEPSLATE_OSMIUM_ORE.get().defaultBlockState())
		);

		List<OreConfiguration.TargetBlockState> overworldPalladiumOres = List.of(
			OreConfiguration.target(stoneReplaceTest,Registry.Blocks.PALLADIUM_ORE.get().defaultBlockState()),
			OreConfiguration.target(deepslateReplaceTest,Registry.Blocks.DEEPSLATE_PALLADIUM_ORE.get().defaultBlockState())
		);

		List<OreConfiguration.TargetBlockState> overworldThoriumOres = List.of(
			OreConfiguration.target(stoneReplaceTest,Registry.Blocks.THORIUM_ORE.get().defaultBlockState()),
			OreConfiguration.target(deepslateReplaceTest,Registry.Blocks.DEEPSLATE_THORIUM_ORE.get().defaultBlockState())
		);

		List<OreConfiguration.TargetBlockState> overworldUraniumOres = List.of(
			OreConfiguration.target(stoneReplaceTest,Registry.Blocks.URANIUM_ORE.get().defaultBlockState()),
			OreConfiguration.target(deepslateReplaceTest,Registry.Blocks.DEEPSLATE_URANIUM_ORE.get().defaultBlockState())
		);

		List<OreConfiguration.TargetBlockState> overworldVanadiumOres = List.of(
			OreConfiguration.target(stoneReplaceTest,Registry.Blocks.VANADIUM_ORE.get().defaultBlockState()),
			OreConfiguration.target(deepslateReplaceTest,Registry.Blocks.DEEPSLATE_VANADIUM_ORE.get().defaultBlockState())
		);

		List<OreConfiguration.TargetBlockState> overworldZincOres = List.of(
			OreConfiguration.target(stoneReplaceTest,Registry.Blocks.ZINC_ORE.get().defaultBlockState()),
			OreConfiguration.target(deepslateReplaceTest,Registry.Blocks.DEEPSLATE_ZINC_ORE.get().defaultBlockState())
		);


		register(context, OVERWORLD_TUNGSTEN_ORE_KEY, Feature.ORE, new OreConfiguration(overworldTungstenOres, 4));
		register(context, OVERWORLD_TITANIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldTitaniumOres, 6));
		register(context, OVERWORLD_COBALT_ORE_KEY, Feature.ORE, new OreConfiguration(overworldCobaltOres, 5));
		register(context, OVERWORLD_NICKEL_ORE_KEY, Feature.ORE, new OreConfiguration(overworldNickelOres, 6));
		register(context, OVERWORLD_PLATINUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldPlatinumOres, 1));
		register(context, OVERWORLD_BAUXITE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldBauxiteOres, 7));
		register(context, OVERWORLD_MOLYBDENUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldMolybdenumOres, 1));
		register(context, OVERWORLD_LITHIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldLithiumOres, 2));
		register(context, OVERWORLD_IRIDIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldIridiumOres, 1));
		register(context, OVERWORLD_GRAPHITE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldGraphiteOres, 4));
		register(context, OVERWORLD_BERYLLIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldBerylliumOres, 2));
		register(context, OVERWORLD_CADMIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldCadmiumOres, 2));
		register(context, OVERWORLD_CHROMIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldChromiumOres, 2));
		register(context, OVERWORLD_MANGANESE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldManganeseOres, 7));
		register(context, OVERWORLD_OSMIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOsmiumOres, 2));
		register(context, OVERWORLD_PALLADIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldPalladiumOres, 3));
		register(context, OVERWORLD_THORIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldThoriumOres, 2));
		register(context, OVERWORLD_URANIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldUraniumOres, 4));
		register(context, OVERWORLD_VANADIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldVanadiumOres, 2));
		register(context, OVERWORLD_ZINC_ORE_KEY, Feature.ORE, new OreConfiguration(overworldZincOres, 6));
	}



	public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
		return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(MOD_ID, name));
	}

	private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
	                                                                                      ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
		context.register(key, new ConfiguredFeature<>(feature, configuration));

	}
}
