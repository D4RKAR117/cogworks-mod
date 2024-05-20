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

		register(context, OVERWORLD_TUNGSTEN_ORE_KEY, Feature.ORE, new OreConfiguration(overworldTungstenOres, 1));
		register(context, OVERWORLD_TITANIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldTitaniumOres, 8));
		register(context, OVERWORLD_COBALT_ORE_KEY, Feature.ORE, new OreConfiguration(overworldCobaltOres, 2));
		register(context, OVERWORLD_NICKEL_ORE_KEY, Feature.ORE, new OreConfiguration(overworldNickelOres, 3));
		register(context, OVERWORLD_PLATINUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldPlatinumOres, 1));
		register(context, OVERWORLD_BAUXITE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldBauxiteOres, 12));
		register(context, OVERWORLD_MOLYBDENUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldMolybdenumOres, 1));
		register(context, OVERWORLD_LITHIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldLithiumOres, 2));
		register(context, OVERWORLD_IRIDIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldIridiumOres, 1));
		register(context, OVERWORLD_GRAPHITE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldGraphiteOres, 4));
	}



	public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
		return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(MOD_ID, name));
	}

	private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
	                                                                                      ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
		context.register(key, new ConfiguredFeature<>(feature, configuration));

	}
}
