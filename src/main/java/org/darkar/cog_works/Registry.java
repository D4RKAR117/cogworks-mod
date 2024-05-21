package org.darkar.cog_works;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static org.darkar.cog_works.CogWorks.LOGGER;
import static org.darkar.cog_works.CogWorks.MOD_ID;

public class Registry {
	static void initialize(IEventBus bus) {
		LOGGER.info("[Cog Works] Initializing registries ...");
		Blocks.init(bus);
		Items.init(bus);
	}

	public static class Blocks {

		private static final DeferredRegister.Blocks DEFERRED_REGISTRY = DeferredRegister.createBlocks(MOD_ID);

		public static class  Tags {

			public static final TagKey<Block> BAUXITE_ORES = createConventional("ores/bauxite");
			public static final TagKey<Block> GRAPHITE_ORES = createConventional("ores/graphite");
			public static final TagKey<Block> LITHIUM_ORES = createConventional("ores/lithium");
			public static final TagKey<Block> MOLYBDENUM_ORES = createConventional("ores/molybdenum");
			public static final TagKey<Block> IRIDIUM_ORES = createConventional("ores/iridium");
			public static final TagKey<Block> TUNGSTEN_ORES = createConventional("ores/tungsten");
			public static final TagKey<Block> TITANIUM_ORES = createConventional("ores/titanium");
			public static final TagKey<Block> COBALT_ORES = createConventional("ores/cobalt");
			public static final TagKey<Block> NICKEL_ORES = createConventional("ores/nickel");
			public static final TagKey<Block> PLATINUM_ORES = createConventional("ores/platinum");

			private static TagKey<Block> createConventional(String name) {
				return TagKey.create(Registries.BLOCK, new ResourceLocation("c" ,name));
			}

			private static TagKey<Block> createCustom(String name) {
				return TagKey.create(Registries.BLOCK, new ResourceLocation(MOD_ID, name));
			}
		}

		// Tungsten Ore
		public static final DeferredBlock<Block> TUNGSTEN_ORE = DEFERRED_REGISTRY.registerSimpleBlock("tungsten_ore",
			BlockBehaviour.Properties.of().
				strength(3.0F, 3.0F)
				.lightLevel((state) -> 7)
				.sound(SoundType.STONE)

		);

		public static final DeferredBlock<Block> DEEPSLATE_TUNGSTEN_ORE = DEFERRED_REGISTRY.registerSimpleBlock("deepslate_tungsten_ore",
			BlockBehaviour.Properties.of().
				strength(4.5F, 3.0F)
				.lightLevel((state) -> 7)
				.sound(SoundType.DEEPSLATE)

		);

		// Titanium Ore
		public static final DeferredBlock<Block> TITANIUM_ORE = DEFERRED_REGISTRY.registerSimpleBlock("titanium_ore",
			BlockBehaviour.Properties.of().
				strength(3.0F, 3.0F)
				.lightLevel((state) -> 7)
				.sound(SoundType.STONE)

		);

		public static final DeferredBlock<Block> DEEPSLATE_TITANIUM_ORE = DEFERRED_REGISTRY.registerSimpleBlock("deepslate_titanium_ore",
			BlockBehaviour.Properties.of().
				strength(4.5F, 3.0F)
				.lightLevel((state) -> 7)
				.sound(SoundType.DEEPSLATE)

		);

		// Cobalt Ore
		public static final DeferredBlock<Block> COBALT_ORE = DEFERRED_REGISTRY.registerSimpleBlock("cobalt_ore",
			BlockBehaviour.Properties.of().
				strength(3.0F, 3.0F)
				.lightLevel((state) -> 7)
				.sound(SoundType.STONE)

		);

		public static final DeferredBlock<Block> DEEPSLATE_COBALT_ORE = DEFERRED_REGISTRY.registerSimpleBlock("deepslate_cobalt_ore",
			BlockBehaviour.Properties.of().
				strength(4.5F, 3.0F)
				.lightLevel((state) -> 7)
				.sound(SoundType.DEEPSLATE)

		);

		// Nickel Ore
		public static final DeferredBlock<Block> NICKEL_ORE = DEFERRED_REGISTRY.registerSimpleBlock("nickel_ore",
			BlockBehaviour.Properties.of().
				strength(3.0F, 3.0F)
				.lightLevel((state) -> 7)
				.sound(SoundType.STONE)

		);

		public static final DeferredBlock<Block> DEEPSLATE_NICKEL_ORE = DEFERRED_REGISTRY.registerSimpleBlock("deepslate_nickel_ore",
			BlockBehaviour.Properties.of().
				strength(4.5F, 3.0F)
				.lightLevel((state) -> 7)
				.sound(SoundType.DEEPSLATE)

		);

		// Bauxite Ore
		public static final DeferredBlock<Block> BAUXITE_ORE = DEFERRED_REGISTRY.registerSimpleBlock("bauxite_ore",
			BlockBehaviour.Properties.of().
				strength(3.0F, 3.0F)
				.lightLevel((state) -> 7)
				.sound(SoundType.STONE)

		);

		public static final DeferredBlock<Block> DEEPSLATE_BAUXITE_ORE = DEFERRED_REGISTRY.registerSimpleBlock("deepslate_bauxite_ore",
			BlockBehaviour.Properties.of().
				strength(4.5F, 3.0F)
				.lightLevel((state) -> 7)
				.sound(SoundType.DEEPSLATE)

		);

		// Molybdenum Ore
		public static final DeferredBlock<Block> MOLYBDENUM_ORE = DEFERRED_REGISTRY.registerSimpleBlock("molybdenum_ore",
			BlockBehaviour.Properties.of().
				strength(3.0F, 3.0F)
				.lightLevel((state) -> 7)
				.sound(SoundType.STONE)

		);

		public static final DeferredBlock<Block> DEEPSLATE_MOLYBDENUM_ORE = DEFERRED_REGISTRY.registerSimpleBlock("deepslate_molybdenum_ore",
			BlockBehaviour.Properties.of().
				strength(4.5F, 3.0F)
				.lightLevel((state) -> 7)
				.sound(SoundType.DEEPSLATE)

		);

		// Iridium Ore
		public static final DeferredBlock<Block> IRIDIUM_ORE = DEFERRED_REGISTRY.registerSimpleBlock("iridium_ore",
			BlockBehaviour.Properties.of().
				strength(3.0F, 3.0F)
				.lightLevel((state) -> 7)
				.sound(SoundType.STONE)

		);

		public static final DeferredBlock<Block> DEEPSLATE_IRIDIUM_ORE = DEFERRED_REGISTRY.registerSimpleBlock("deepslate_iridium_ore",
			BlockBehaviour.Properties.of().
				strength(4.5F, 3.0F)
				.lightLevel((state) -> 7)
				.sound(SoundType.DEEPSLATE)

		);

		// Lithium Ore
		public static final DeferredBlock<Block> LITHIUM_ORE = DEFERRED_REGISTRY.registerSimpleBlock("lithium_ore",
			BlockBehaviour.Properties.of().
				strength(3.0F, 3.0F)
				.lightLevel((state) -> 7)
				.sound(SoundType.STONE)

		);

		public static final DeferredBlock<Block> DEEPSLATE_LITHIUM_ORE = DEFERRED_REGISTRY.registerSimpleBlock("deepslate_lithium_ore",
			BlockBehaviour.Properties.of().
				strength(4.5F, 3.0F)
				.lightLevel((state) -> 7)
				.sound(SoundType.DEEPSLATE)

		);

		//Platinum Ore
		public static final DeferredBlock<Block> PLATINUM_ORE = DEFERRED_REGISTRY.registerSimpleBlock("platinum_ore",
			BlockBehaviour.Properties.of().
				strength(3.0F, 3.0F)
				.lightLevel((state) -> 7)
				.sound(SoundType.STONE)

		);

		public static final DeferredBlock<Block> DEEPSLATE_PLATINUM_ORE = DEFERRED_REGISTRY.registerSimpleBlock("deepslate_platinum_ore",
			BlockBehaviour.Properties.of().
				strength(4.5F, 3.0F)
				.lightLevel((state) -> 7)
				.sound(SoundType.DEEPSLATE)

		);

		// Graphite Ore
		public static final DeferredBlock<Block> GRAPHITE_ORE = DEFERRED_REGISTRY.registerSimpleBlock("graphite_ore",
			BlockBehaviour.Properties.of().
				strength(3.0F, 3.0F)
				.lightLevel((state) -> 7)
				.sound(SoundType.STONE)

		);

		public static final DeferredBlock<Block> DEEPSLATE_GRAPHITE_ORE = DEFERRED_REGISTRY.registerSimpleBlock("deepslate_graphite_ore",
			BlockBehaviour.Properties.of().
				strength(4.5F, 3.0F)
				.lightLevel((state) -> 7)
				.sound(SoundType.DEEPSLATE)
		);


		private static void init(IEventBus bus) {
			LOGGER.info("[Cog Works] Registering blocks ...");
			DEFERRED_REGISTRY.register(bus);
		}
	}

	public static class Items {
		private static final DeferredRegister.Items DEFERRED_REGISTRY = DeferredRegister.createItems(MOD_ID);

		public static final DeferredItem<BlockItem> TUNGSTEN_ORE = registerBlockItem(Blocks.TUNGSTEN_ORE);
		public static final DeferredItem<BlockItem> DEEPSLATE_TUNGSTEN_ORE = registerBlockItem(Blocks.DEEPSLATE_TUNGSTEN_ORE);
		public static final DeferredItem<BlockItem> TITANIUM_ORE = registerBlockItem(Blocks.TITANIUM_ORE);
		public static final DeferredItem<BlockItem> DEEPSLATE_TITANIUM_ORE = registerBlockItem(Blocks.DEEPSLATE_TITANIUM_ORE);
		public static final DeferredItem<BlockItem> COBALT_ORE = registerBlockItem(Blocks.COBALT_ORE);
		public static final DeferredItem<BlockItem> DEEPSLATE_COBALT_ORE = registerBlockItem(Blocks.DEEPSLATE_COBALT_ORE);
		public static final DeferredItem<BlockItem> NICKEL_ORE = registerBlockItem(Blocks.NICKEL_ORE);
		public static final DeferredItem<BlockItem> DEEPSLATE_NICKEL_ORE = registerBlockItem(Blocks.DEEPSLATE_NICKEL_ORE);
		public static final DeferredItem<BlockItem> BAUXITE_ORE = registerBlockItem(Blocks.BAUXITE_ORE);
		public static final DeferredItem<BlockItem> DEEPSLATE_BAUXITE_ORE = registerBlockItem(Blocks.DEEPSLATE_BAUXITE_ORE);
		public static final DeferredItem<BlockItem> MOLYBDENUM_ORE = registerBlockItem(Blocks.MOLYBDENUM_ORE);
		public static final DeferredItem<BlockItem> DEEPSLATE_MOLYBDENUM_ORE = registerBlockItem(Blocks.DEEPSLATE_MOLYBDENUM_ORE);
		public static final DeferredItem<BlockItem> IRIDIUM_ORE = registerBlockItem(Blocks.IRIDIUM_ORE);
		public static final DeferredItem<BlockItem> DEEPSLATE_IRIDIUM_ORE = registerBlockItem(Blocks.DEEPSLATE_IRIDIUM_ORE);
		public static final DeferredItem<BlockItem> LITHIUM_ORE = registerBlockItem(Blocks.LITHIUM_ORE);
		public static final DeferredItem<BlockItem> DEEPSLATE_LITHIUM_ORE = registerBlockItem(Blocks.DEEPSLATE_LITHIUM_ORE);
		public static final DeferredItem<BlockItem> PLATINUM_ORE = registerBlockItem(Blocks.PLATINUM_ORE);
		public static final DeferredItem<BlockItem> DEEPSLATE_PLATINUM_ORE = registerBlockItem(Blocks.DEEPSLATE_PLATINUM_ORE);
		public static final DeferredItem<BlockItem> GRAPHITE_ORE = registerBlockItem(Blocks.GRAPHITE_ORE);
		public static final DeferredItem<BlockItem> DEEPSLATE_GRAPHITE_ORE = registerBlockItem(Blocks.DEEPSLATE_GRAPHITE_ORE);

		public static DeferredItem<BlockItem> registerBlockItem(DeferredBlock<?> block,  Item.Properties properties) {
				return DEFERRED_REGISTRY.registerSimpleBlockItem(block, properties);
		}

		public static DeferredItem<BlockItem> registerBlockItem(DeferredBlock<?> block) {
			return registerBlockItem(block, new Item.Properties());
		}

		private static void init(IEventBus bus) {
			LOGGER.info("[Cog Works] Registering items ...");
			DEFERRED_REGISTRY.register(bus);
		}
	}
}
