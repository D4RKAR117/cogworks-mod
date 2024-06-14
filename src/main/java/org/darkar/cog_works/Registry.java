package org.darkar.cog_works;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.*;
import org.darkar.cog_works.item.EmptySampleTubeItem;
import org.darkar.cog_works.item.FilledSampleTubeItem;
import org.darkar.cog_works.item.ProspectingPickItem;
import org.darkar.cog_works.item.ScrewdriverItem;
import org.darkar.cog_works.item.component.IsDiggingSample;
import org.darkar.cog_works.item.component.SampleLocation;
import org.darkar.cog_works.level.chunk.attachment.ChunkSampleSiteMap;

import static org.darkar.cog_works.CogWorks.LOGGER;
import static org.darkar.cog_works.CogWorks.MOD_ID;

public class Registry {
	static void initialize(IEventBus bus) {
		LOGGER.info("[Cog Works] Initializing registries ...");
		Blocks.init(bus);
		Items.init(bus);
		Items.DataComponents.init(bus);
		DataAttachments.init(bus);
	}
	
	public static class Blocks {
		
		private static final DeferredRegister.Blocks DEFERRED_REGISTRY = DeferredRegister.createBlocks(MOD_ID);
		// Tungsten Ore
		public static final DeferredBlock<Block> TUNGSTEN_ORE = DEFERRED_REGISTRY.registerSimpleBlock("tungsten_ore",
		                                                                                              BlockBehaviour.Properties.of()
		                                                                                                                       .strength(
			                                                                                                                       3.0F,
			                                                                                                                       3.0F)
		                                                                                                                       .lightLevel(
			                                                                                                                       (state) -> 7)
		                                                                                                                       .sound(
			                                                                                                                       SoundType.STONE)
		                                                                                             
		                                                                                             );
		public static final DeferredBlock<Block> DEEPSLATE_TUNGSTEN_ORE = DEFERRED_REGISTRY.registerSimpleBlock(
			"deepslate_tungsten_ore", BlockBehaviour.Properties.of()
			                                                   .strength(4.5F, 3.0F)
			                                                   .lightLevel((state) -> 7)
			                                                   .sound(SoundType.DEEPSLATE)
		                                                                                                       
		                                                                                                       );
		// Titanium Ore
		public static final DeferredBlock<Block> TITANIUM_ORE = DEFERRED_REGISTRY.registerSimpleBlock("titanium_ore",
		                                                                                              BlockBehaviour.Properties.of()
		                                                                                                                       .strength(
			                                                                                                                       3.0F,
			                                                                                                                       3.0F)
		                                                                                                                       .lightLevel(
			                                                                                                                       (state) -> 7)
		                                                                                                                       .sound(
			                                                                                                                       SoundType.STONE)
		                                                                                             
		                                                                                             );
		public static final DeferredBlock<Block> DEEPSLATE_TITANIUM_ORE = DEFERRED_REGISTRY.registerSimpleBlock(
			"deepslate_titanium_ore", BlockBehaviour.Properties.of()
			                                                   .strength(4.5F, 3.0F)
			                                                   .lightLevel((state) -> 7)
			                                                   .sound(SoundType.DEEPSLATE)
		                                                                                                       
		                                                                                                       );
		// Cobalt Ore
		public static final DeferredBlock<Block> COBALT_ORE = DEFERRED_REGISTRY.registerSimpleBlock("cobalt_ore",
		                                                                                            BlockBehaviour.Properties.of()
		                                                                                                                     .strength(
			                                                                                                                     3.0F,
			                                                                                                                     3.0F)
		                                                                                                                     .lightLevel(
			                                                                                                                     (state) -> 7)
		                                                                                                                     .sound(
			                                                                                                                     SoundType.STONE)
		                                                                                           
		                                                                                           );
		public static final DeferredBlock<Block> DEEPSLATE_COBALT_ORE = DEFERRED_REGISTRY.registerSimpleBlock(
			"deepslate_cobalt_ore", BlockBehaviour.Properties.of()
			                                                 .strength(4.5F, 3.0F)
			                                                 .lightLevel((state) -> 7)
			                                                 .sound(SoundType.DEEPSLATE)
		                                                                                                     
		                                                                                                     );
		// Nickel Ore
		public static final DeferredBlock<Block> NICKEL_ORE = DEFERRED_REGISTRY.registerSimpleBlock("nickel_ore",
		                                                                                            BlockBehaviour.Properties.of()
		                                                                                                                     .strength(
			                                                                                                                     3.0F,
			                                                                                                                     3.0F)
		                                                                                                                     .lightLevel(
			                                                                                                                     (state) -> 7)
		                                                                                                                     .sound(
			                                                                                                                     SoundType.STONE)
		                                                                                           
		                                                                                           );
		public static final DeferredBlock<Block> DEEPSLATE_NICKEL_ORE = DEFERRED_REGISTRY.registerSimpleBlock(
			"deepslate_nickel_ore", BlockBehaviour.Properties.of()
			                                                 .strength(4.5F, 3.0F)
			                                                 .lightLevel((state) -> 7)
			                                                 .sound(SoundType.DEEPSLATE)
		                                                                                                     
		                                                                                                     );
		// Bauxite Ore
		public static final DeferredBlock<Block> BAUXITE_ORE = DEFERRED_REGISTRY.registerSimpleBlock("bauxite_ore",
		                                                                                             BlockBehaviour.Properties.of()
		                                                                                                                      .strength(
			                                                                                                                      3.0F,
			                                                                                                                      3.0F)
		                                                                                                                      .lightLevel(
			                                                                                                                      (state) -> 7)
		                                                                                                                      .sound(
			                                                                                                                      SoundType.STONE)
		                                                                                            
		                                                                                            );
		public static final DeferredBlock<Block> DEEPSLATE_BAUXITE_ORE = DEFERRED_REGISTRY.registerSimpleBlock(
			"deepslate_bauxite_ore", BlockBehaviour.Properties.of()
			                                                  .strength(4.5F, 3.0F)
			                                                  .lightLevel((state) -> 7)
			                                                  .sound(SoundType.DEEPSLATE)
		                                                                                                      
		                                                                                                      );
		// Molybdenum Ore
		public static final DeferredBlock<Block> MOLYBDENUM_ORE = DEFERRED_REGISTRY.registerSimpleBlock(
			"molybdenum_ore", BlockBehaviour.Properties.of()
			                                           .strength(3.0F, 3.0F)
			                                           .lightLevel((state) -> 7)
			                                           .sound(SoundType.STONE)
		                                                                                               
		                                                                                               );
		public static final DeferredBlock<Block> DEEPSLATE_MOLYBDENUM_ORE = DEFERRED_REGISTRY.registerSimpleBlock(
			"deepslate_molybdenum_ore", BlockBehaviour.Properties.of()
			                                                     .strength(4.5F, 3.0F)
			                                                     .lightLevel((state) -> 7)
			                                                     .sound(SoundType.DEEPSLATE)
		                                                                                                         
		                                                                                                         );
		// Iridium Ore
		public static final DeferredBlock<Block> IRIDIUM_ORE = DEFERRED_REGISTRY.registerSimpleBlock("iridium_ore",
		                                                                                             BlockBehaviour.Properties.of()
		                                                                                                                      .strength(
			                                                                                                                      3.0F,
			                                                                                                                      3.0F)
		                                                                                                                      .lightLevel(
			                                                                                                                      (state) -> 7)
		                                                                                                                      .sound(
			                                                                                                                      SoundType.STONE)
		                                                                                            
		                                                                                            );
		public static final DeferredBlock<Block> DEEPSLATE_IRIDIUM_ORE = DEFERRED_REGISTRY.registerSimpleBlock(
			"deepslate_iridium_ore", BlockBehaviour.Properties.of()
			                                                  .strength(4.5F, 3.0F)
			                                                  .lightLevel((state) -> 7)
			                                                  .sound(SoundType.DEEPSLATE)
		                                                                                                      
		                                                                                                      );
		// Lithium Ore
		public static final DeferredBlock<Block> LITHIUM_ORE = DEFERRED_REGISTRY.registerSimpleBlock("lithium_ore",
		                                                                                             BlockBehaviour.Properties.of()
		                                                                                                                      .strength(
			                                                                                                                      3.0F,
			                                                                                                                      3.0F)
		                                                                                                                      .lightLevel(
			                                                                                                                      (state) -> 7)
		                                                                                                                      .sound(
			                                                                                                                      SoundType.STONE)
		                                                                                            
		                                                                                            );
		public static final DeferredBlock<Block> DEEPSLATE_LITHIUM_ORE = DEFERRED_REGISTRY.registerSimpleBlock(
			"deepslate_lithium_ore", BlockBehaviour.Properties.of()
			                                                  .strength(4.5F, 3.0F)
			                                                  .lightLevel((state) -> 7)
			                                                  .sound(SoundType.DEEPSLATE)
		                                                                                                      
		                                                                                                      );
		//Platinum Ore
		public static final DeferredBlock<Block> PLATINUM_ORE = DEFERRED_REGISTRY.registerSimpleBlock("platinum_ore",
		                                                                                              BlockBehaviour.Properties.of()
		                                                                                                                       .strength(
			                                                                                                                       3.0F,
			                                                                                                                       3.0F)
		                                                                                                                       .lightLevel(
			                                                                                                                       (state) -> 7)
		                                                                                                                       .sound(
			                                                                                                                       SoundType.STONE)
		                                                                                             
		                                                                                             );
		public static final DeferredBlock<Block> DEEPSLATE_PLATINUM_ORE = DEFERRED_REGISTRY.registerSimpleBlock(
			"deepslate_platinum_ore", BlockBehaviour.Properties.of()
			                                                   .strength(4.5F, 3.0F)
			                                                   .lightLevel((state) -> 7)
			                                                   .sound(SoundType.DEEPSLATE)
		                                                                                                       
		                                                                                                       );
		// Graphite Ore
		public static final DeferredBlock<Block> GRAPHITE_ORE = DEFERRED_REGISTRY.registerSimpleBlock("graphite_ore",
		                                                                                              BlockBehaviour.Properties.of()
		                                                                                                                       .strength(
			                                                                                                                       3.0F,
			                                                                                                                       3.0F)
		                                                                                                                       .lightLevel(
			                                                                                                                       (state) -> 7)
		                                                                                                                       .sound(
			                                                                                                                       SoundType.STONE)
		                                                                                             
		                                                                                             );
		public static final DeferredBlock<Block> DEEPSLATE_GRAPHITE_ORE = DEFERRED_REGISTRY.registerSimpleBlock(
			"deepslate_graphite_ore", BlockBehaviour.Properties.of()
			                                                   .strength(4.5F, 3.0F)
			                                                   .lightLevel((state) -> 7)
			                                                   .sound(SoundType.DEEPSLATE));
		// Beryllium Ore
		public static final DeferredBlock<Block> BERYLLIUM_ORE = DEFERRED_REGISTRY.registerSimpleBlock("beryllium_ore",
		                                                                                               BlockBehaviour.Properties.of()
		                                                                                                                        .strength(
			                                                                                                                        3.0F,
			                                                                                                                        3.0F)
		                                                                                                                        .lightLevel(
			                                                                                                                        (state) -> 7)
		                                                                                                                        .sound(
			                                                                                                                        SoundType.STONE));
		public static final DeferredBlock<Block> DEEPSLATE_BERYLLIUM_ORE = DEFERRED_REGISTRY.registerSimpleBlock(
			"deepslate_beryllium_ore", BlockBehaviour.Properties.of()
			                                                    .strength(4.5F, 3.0F)
			                                                    .lightLevel((state) -> 7)
			                                                    .sound(SoundType.DEEPSLATE));
		// Cadmium Ore
		public static final DeferredBlock<Block> CADMIUM_ORE = DEFERRED_REGISTRY.registerSimpleBlock("cadmium_ore",
		                                                                                             BlockBehaviour.Properties.of()
		                                                                                                                      .strength(
			                                                                                                                      3.0F,
			                                                                                                                      3.0F)
		                                                                                                                      .lightLevel(
			                                                                                                                      (state) -> 7)
		                                                                                                                      .sound(
			                                                                                                                      SoundType.STONE));
		public static final DeferredBlock<Block> DEEPSLATE_CADMIUM_ORE = DEFERRED_REGISTRY.registerSimpleBlock(
			"deepslate_cadmium_ore", BlockBehaviour.Properties.of()
			                                                  .strength(4.5F, 3.0F)
			                                                  .lightLevel((state) -> 7)
			                                                  .sound(SoundType.DEEPSLATE));
		// Chromium Ore
		public static final DeferredBlock<Block> CHROMIUM_ORE = DEFERRED_REGISTRY.registerSimpleBlock("chromium_ore",
		                                                                                              BlockBehaviour.Properties.of()
		                                                                                                                       .strength(
			                                                                                                                       3.0F,
			                                                                                                                       3.0F)
		                                                                                                                       .lightLevel(
			                                                                                                                       (state) -> 7)
		                                                                                                                       .sound(
			                                                                                                                       SoundType.STONE));
		public static final DeferredBlock<Block> DEEPSLATE_CHROMIUM_ORE = DEFERRED_REGISTRY.registerSimpleBlock(
			"deepslate_chromium_ore", BlockBehaviour.Properties.of()
			                                                   .strength(4.5F, 3.0F)
			                                                   .lightLevel((state) -> 7)
			                                                   .sound(SoundType.DEEPSLATE));
		//Manganese Ore
		public static final DeferredBlock<Block> MANGANESE_ORE = DEFERRED_REGISTRY.registerSimpleBlock("manganese_ore",
		                                                                                               BlockBehaviour.Properties.of()
		                                                                                                                        .strength(
			                                                                                                                        3.0F,
			                                                                                                                        3.0F)
		                                                                                                                        .lightLevel(
			                                                                                                                        (state) -> 7)
		                                                                                                                        .sound(
			                                                                                                                        SoundType.STONE));
		public static final DeferredBlock<Block> DEEPSLATE_MANGANESE_ORE = DEFERRED_REGISTRY.registerSimpleBlock(
			"deepslate_manganese_ore", BlockBehaviour.Properties.of()
			                                                    .strength(4.5F, 3.0F)
			                                                    .lightLevel((state) -> 7)
			                                                    .sound(SoundType.DEEPSLATE));
		// Osmium Ore
		public static final DeferredBlock<Block> OSMIUM_ORE = DEFERRED_REGISTRY.registerSimpleBlock("osmium_ore",
		                                                                                            BlockBehaviour.Properties.of()
		                                                                                                                     .strength(
			                                                                                                                     3.0F,
			                                                                                                                     3.0F)
		                                                                                                                     .lightLevel(
			                                                                                                                     (state) -> 7)
		                                                                                                                     .sound(
			                                                                                                                     SoundType.STONE));
		public static final DeferredBlock<Block> DEEPSLATE_OSMIUM_ORE = DEFERRED_REGISTRY.registerSimpleBlock(
			"deepslate_osmium_ore", BlockBehaviour.Properties.of()
			                                                 .strength(4.5F, 3.0F)
			                                                 .lightLevel((state) -> 7)
			                                                 .sound(SoundType.DEEPSLATE));
		// Palladium Ore
		public static final DeferredBlock<Block> PALLADIUM_ORE = DEFERRED_REGISTRY.registerSimpleBlock("palladium_ore",
		                                                                                               BlockBehaviour.Properties.of()
		                                                                                                                        .strength(
			                                                                                                                        3.0F,
			                                                                                                                        3.0F)
		                                                                                                                        .lightLevel(
			                                                                                                                        (state) -> 7)
		                                                                                                                        .sound(
			                                                                                                                        SoundType.STONE));
		public static final DeferredBlock<Block> DEEPSLATE_PALLADIUM_ORE = DEFERRED_REGISTRY.registerSimpleBlock(
			"deepslate_palladium_ore", BlockBehaviour.Properties.of()
			                                                    .strength(4.5F, 3.0F)
			                                                    .lightLevel((state) -> 7)
			                                                    .sound(SoundType.DEEPSLATE));
		//Thorium Ore
		public static final DeferredBlock<Block> THORIUM_ORE = DEFERRED_REGISTRY.registerSimpleBlock("thorium_ore",
		                                                                                             BlockBehaviour.Properties.of()
		                                                                                                                      .strength(
			                                                                                                                      3.0F,
			                                                                                                                      3.0F)
		                                                                                                                      .lightLevel(
			                                                                                                                      (state) -> 7)
		                                                                                                                      .sound(
			                                                                                                                      SoundType.STONE));
		public static final DeferredBlock<Block> DEEPSLATE_THORIUM_ORE = DEFERRED_REGISTRY.registerSimpleBlock(
			"deepslate_thorium_ore", BlockBehaviour.Properties.of()
			                                                  .strength(4.5F, 3.0F)
			                                                  .lightLevel((state) -> 7)
			                                                  .sound(SoundType.DEEPSLATE));
		//Uranium Ore
		public static final DeferredBlock<Block> URANIUM_ORE = DEFERRED_REGISTRY.registerSimpleBlock("uranium_ore",
		                                                                                             BlockBehaviour.Properties.of()
		                                                                                                                      .strength(
			                                                                                                                      3.0F,
			                                                                                                                      3.0F)
		                                                                                                                      .lightLevel(
			                                                                                                                      (state) -> 7)
		                                                                                                                      .sound(
			                                                                                                                      SoundType.STONE));
		public static final DeferredBlock<Block> DEEPSLATE_URANIUM_ORE = DEFERRED_REGISTRY.registerSimpleBlock(
			"deepslate_uranium_ore", BlockBehaviour.Properties.of()
			                                                  .strength(4.5F, 3.0F)
			                                                  .lightLevel((state) -> 7)
			                                                  .sound(SoundType.DEEPSLATE));
		//Vanadium Ore
		public static final DeferredBlock<Block> VANADIUM_ORE = DEFERRED_REGISTRY.registerSimpleBlock("vanadium_ore",
		                                                                                              BlockBehaviour.Properties.of()
		                                                                                                                       .strength(
			                                                                                                                       3.0F,
			                                                                                                                       3.0F)
		                                                                                                                       .lightLevel(
			                                                                                                                       (state) -> 7)
		                                                                                                                       .sound(
			                                                                                                                       SoundType.STONE));
		public static final DeferredBlock<Block> DEEPSLATE_VANADIUM_ORE = DEFERRED_REGISTRY.registerSimpleBlock(
			"deepslate_vanadium_ore", BlockBehaviour.Properties.of()
			                                                   .strength(4.5F, 3.0F)
			                                                   .lightLevel((state) -> 7)
			                                                   .sound(SoundType.DEEPSLATE));
		//Zinc Ore
		public static final DeferredBlock<Block> ZINC_ORE = DEFERRED_REGISTRY.registerSimpleBlock("zinc_ore",
		                                                                                          BlockBehaviour.Properties.of()
		                                                                                                                   .strength(
			                                                                                                                   3.0F,
			                                                                                                                   3.0F)
		                                                                                                                   .lightLevel(
			                                                                                                                   (state) -> 7)
		                                                                                                                   .sound(
			                                                                                                                   SoundType.STONE));
		public static final DeferredBlock<Block> DEEPSLATE_ZINC_ORE = DEFERRED_REGISTRY.registerSimpleBlock(
			"deepslate_zinc_ore", BlockBehaviour.Properties.of()
			                                               .strength(4.5F, 3.0F)
			                                               .lightLevel((state) -> 7)
			                                               .sound(SoundType.DEEPSLATE));
		
		private static void init(IEventBus bus) {
			LOGGER.info("[Cog Works] Registering blocks ...");
			DEFERRED_REGISTRY.register(bus);
		}
		
		public static class Tags {
			
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
			public static final TagKey<Block> BERYLLIUM_ORES = createConventional("ores/beryllium");
			public static final TagKey<Block> CADMIUM_ORES = createConventional("ores/cadmium");
			public static final TagKey<Block> CHROMIUM_ORES = createConventional("ores/chromium");
			public static final TagKey<Block> MANGANESE_ORES = createConventional("ores/manganese");
			public static final TagKey<Block> OSMIUM_ORES = createConventional("ores/osmium");
			public static final TagKey<Block> PALLADIUM_ORES = createConventional("ores/palladium");
			public static final TagKey<Block> THORIUM_ORES = createConventional("ores/thorium");
			public static final TagKey<Block> URANIUM_ORES = createConventional("ores/uranium");
			public static final TagKey<Block> VANADIUM_ORES = createConventional("ores/vanadium");
			public static final TagKey<Block> ZINC_ORES = createConventional("ores/zinc");
			
			private static TagKey<Block> createConventional(String name) {
				return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("c", name));
			}
			
			private static TagKey<Block> createCustom(String name) {
				return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MOD_ID, name));
			}
		}
	}
	
	public static class Items {
		//region Deferred Items
		private static final DeferredRegister.Items DEFERRED_REGISTRY = DeferredRegister.createItems(MOD_ID);
		
		//region BlockItems for ores
		public static final DeferredItem<BlockItem> TUNGSTEN_ORE = registerBlockItem(Blocks.TUNGSTEN_ORE);
		public static final DeferredItem<BlockItem> DEEPSLATE_TUNGSTEN_ORE = registerBlockItem(
			Blocks.DEEPSLATE_TUNGSTEN_ORE);
		public static final DeferredItem<BlockItem> TITANIUM_ORE = registerBlockItem(Blocks.TITANIUM_ORE);
		public static final DeferredItem<BlockItem> DEEPSLATE_TITANIUM_ORE = registerBlockItem(
			Blocks.DEEPSLATE_TITANIUM_ORE);
		public static final DeferredItem<BlockItem> COBALT_ORE = registerBlockItem(Blocks.COBALT_ORE);
		public static final DeferredItem<BlockItem> DEEPSLATE_COBALT_ORE = registerBlockItem(
			Blocks.DEEPSLATE_COBALT_ORE);
		public static final DeferredItem<BlockItem> NICKEL_ORE = registerBlockItem(Blocks.NICKEL_ORE);
		public static final DeferredItem<BlockItem> DEEPSLATE_NICKEL_ORE = registerBlockItem(
			Blocks.DEEPSLATE_NICKEL_ORE);
		public static final DeferredItem<BlockItem> BAUXITE_ORE = registerBlockItem(Blocks.BAUXITE_ORE);
		public static final DeferredItem<BlockItem> DEEPSLATE_BAUXITE_ORE = registerBlockItem(
			Blocks.DEEPSLATE_BAUXITE_ORE);
		public static final DeferredItem<BlockItem> MOLYBDENUM_ORE = registerBlockItem(Blocks.MOLYBDENUM_ORE);
		public static final DeferredItem<BlockItem> DEEPSLATE_MOLYBDENUM_ORE = registerBlockItem(
			Blocks.DEEPSLATE_MOLYBDENUM_ORE);
		public static final DeferredItem<BlockItem> IRIDIUM_ORE = registerBlockItem(Blocks.IRIDIUM_ORE);
		public static final DeferredItem<BlockItem> DEEPSLATE_IRIDIUM_ORE = registerBlockItem(
			Blocks.DEEPSLATE_IRIDIUM_ORE);
		public static final DeferredItem<BlockItem> LITHIUM_ORE = registerBlockItem(Blocks.LITHIUM_ORE);
		public static final DeferredItem<BlockItem> DEEPSLATE_LITHIUM_ORE = registerBlockItem(
			Blocks.DEEPSLATE_LITHIUM_ORE);
		public static final DeferredItem<BlockItem> PLATINUM_ORE = registerBlockItem(Blocks.PLATINUM_ORE);
		public static final DeferredItem<BlockItem> DEEPSLATE_PLATINUM_ORE = registerBlockItem(
			Blocks.DEEPSLATE_PLATINUM_ORE);
		public static final DeferredItem<BlockItem> GRAPHITE_ORE = registerBlockItem(Blocks.GRAPHITE_ORE);
		public static final DeferredItem<BlockItem> DEEPSLATE_GRAPHITE_ORE = registerBlockItem(
			Blocks.DEEPSLATE_GRAPHITE_ORE);
		public static final DeferredItem<BlockItem> BERYLLIUM_ORE = registerBlockItem(Blocks.BERYLLIUM_ORE);
		public static final DeferredItem<BlockItem> DEEPSLATE_BERYLLIUM_ORE = registerBlockItem(
			Blocks.DEEPSLATE_BERYLLIUM_ORE);
		public static final DeferredItem<BlockItem> CADMIUM_ORE = registerBlockItem(Blocks.CADMIUM_ORE);
		public static final DeferredItem<BlockItem> DEEPSLATE_CADMIUM_ORE = registerBlockItem(
			Blocks.DEEPSLATE_CADMIUM_ORE);
		public static final DeferredItem<BlockItem> CHROMIUM_ORE = registerBlockItem(Blocks.CHROMIUM_ORE);
		public static final DeferredItem<BlockItem> DEEPSLATE_CHROMIUM_ORE = registerBlockItem(
			Blocks.DEEPSLATE_CHROMIUM_ORE);
		public static final DeferredItem<BlockItem> MANGANESE_ORE = registerBlockItem(Blocks.MANGANESE_ORE);
		public static final DeferredItem<BlockItem> DEEPSLATE_MANGANESE_ORE = registerBlockItem(
			Blocks.DEEPSLATE_MANGANESE_ORE);
		public static final DeferredItem<BlockItem> OSMIUM_ORE = registerBlockItem(Blocks.OSMIUM_ORE);
		public static final DeferredItem<BlockItem> DEEPSLATE_OSMIUM_ORE = registerBlockItem(
			Blocks.DEEPSLATE_OSMIUM_ORE);
		public static final DeferredItem<BlockItem> PALLADIUM_ORE = registerBlockItem(Blocks.PALLADIUM_ORE);
		public static final DeferredItem<BlockItem> DEEPSLATE_PALLADIUM_ORE = registerBlockItem(
			Blocks.DEEPSLATE_PALLADIUM_ORE);
		public static final DeferredItem<BlockItem> THORIUM_ORE = registerBlockItem(Blocks.THORIUM_ORE);
		public static final DeferredItem<BlockItem> DEEPSLATE_THORIUM_ORE = registerBlockItem(
			Blocks.DEEPSLATE_THORIUM_ORE);
		public static final DeferredItem<BlockItem> URANIUM_ORE = registerBlockItem(Blocks.URANIUM_ORE);
		public static final DeferredItem<BlockItem> DEEPSLATE_URANIUM_ORE = registerBlockItem(
			Blocks.DEEPSLATE_URANIUM_ORE);
		public static final DeferredItem<BlockItem> VANADIUM_ORE = registerBlockItem(Blocks.VANADIUM_ORE);
		public static final DeferredItem<BlockItem> DEEPSLATE_VANADIUM_ORE = registerBlockItem(
			Blocks.DEEPSLATE_VANADIUM_ORE);
		public static final DeferredItem<BlockItem> ZINC_ORE = registerBlockItem(Blocks.ZINC_ORE);
		public static final DeferredItem<BlockItem> DEEPSLATE_ZINC_ORE = registerBlockItem(Blocks.DEEPSLATE_ZINC_ORE);
		//endregion
		
		//region Tools
		public static final DeferredItem<Item> PROSPECTING_PICK = DEFERRED_REGISTRY.register("prospecting_pick",
		                                                                                     ProspectingPickItem::new);
		public static final DeferredItem<Item> EMPTY_SAMPLE_TUBE = DEFERRED_REGISTRY.register("empty_sample_tube",
		                                                                                      EmptySampleTubeItem::new);
		public static final DeferredItem<Item> FILLED_SAMPLE_TUBE = DEFERRED_REGISTRY.register("filled_sample_tube",
		                                                                                       FilledSampleTubeItem::new);
		
		public static final DeferredItem<Item> SCREWDRIVER = DEFERRED_REGISTRY.register("screwdriver",
		                                                                                ScrewdriverItem::new);
		//endregion
		
		//endregion
		
		public static DeferredItem<BlockItem> registerBlockItem(DeferredBlock<?> block, Item.Properties properties) {
			return DEFERRED_REGISTRY.registerSimpleBlockItem(block, properties);
		}
		
		public static DeferredItem<BlockItem> registerBlockItem(DeferredBlock<?> block) {
			return registerBlockItem(block, new Item.Properties());
		}
		
		private static void init(IEventBus bus) {
			LOGGER.info("[Cog Works] Registering items ...");
			DEFERRED_REGISTRY.register(bus);
		}
		
		public static class DataComponents {
			private static final DeferredRegister<DataComponentType<?>> DEFERRED_REGISTRY = DeferredRegister.create(
				Registries.DATA_COMPONENT_TYPE, MOD_ID);
			
			public static final DeferredHolder<DataComponentType<?>, DataComponentType<IsDiggingSample>>
				IS_DIGGING_SAMPLE = DEFERRED_REGISTRY.register("is_digging_sample",
				                                               () -> DataComponentType.<IsDiggingSample>builder()
				                                                                      .persistent(IsDiggingSample.CODEC)
				                                                                      .networkSynchronized(
					                                                                      IsDiggingSample.STREAM_CODEC)
				                                                                      .build());
			public static final DeferredHolder<DataComponentType<?>, DataComponentType<SampleLocation>>
				SAMPLE_LOCATION = DEFERRED_REGISTRY.register("sample_chunk_location",
				                                             () -> DataComponentType.<SampleLocation>builder()
				                                                                    .persistent(SampleLocation.CODEC)
				                                                                    .networkSynchronized(
					                                                                    SampleLocation.STREAM_CODEC)
				                                                                    .build());
			
			private static void init(IEventBus bus) {
				LOGGER.info("[Cog Works] Registering item data components ...");
				DEFERRED_REGISTRY.register(bus);
			}
		}
	}
	
	public static class DataAttachments {
		private static final DeferredRegister<AttachmentType<?>> DEFERRED_REGISTRY = DeferredRegister.create(
			NeoForgeRegistries.ATTACHMENT_TYPES, MOD_ID);
		
		public static final DeferredHolder<AttachmentType<?>, AttachmentType<ChunkSampleSiteMap>>
			CHUNK_SAMPLE_SITE_MAP = DEFERRED_REGISTRY.register("chunk_sample_site_map", () -> AttachmentType.builder(
				                                                                                                () -> ChunkSampleSiteMap.DEFAULT)
			                                                                                                .serialize(
				                                                                                                ChunkSampleSiteMap.CODEC)
			                                                                                                .build());
		
		
		private static void init(IEventBus bus) {
			LOGGER.info("[Cog Works] Registering data attachments ...");
			DEFERRED_REGISTRY.register(bus);
		}
	}
}
