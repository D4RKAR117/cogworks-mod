package dev.darkar.cog_works;

import dev.darkar.cog_works.block.TransmissionShaftBlock;
import dev.darkar.cog_works.block.entity.TransmissionShaftBlockEntity;
import dev.darkar.cog_works.item.EmptySampleTubeItem;
import dev.darkar.cog_works.item.FilledSampleTubeItem;
import dev.darkar.cog_works.item.ProspectingPickItem;
import dev.darkar.cog_works.item.ScrewdriverItem;
import dev.darkar.cog_works.item.component.IsDiggingSample;
import dev.darkar.cog_works.item.component.SampleLocation;
import dev.darkar.cog_works.world.level.chunk.attachment.ChunkSampleSiteMap;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.*;

import static dev.darkar.cog_works.CogWorks.LOGGER;
import static dev.darkar.cog_works.CogWorks.MOD_ID;

public class Registry {
	static void initialize(IEventBus bus) {
		LOGGER.info("[Cog Works] Initializing registries ...");
		Blocks.init(bus);
		Blocks.Entities.init(bus);
		Items.init(bus);
		Items.DataComponents.init(bus);
		DataAttachments.init(bus);
	}
	
	public static class Blocks {
		
		private static final DeferredRegister.Blocks DEFERRED_REGISTRY = DeferredRegister.createBlocks(MOD_ID);
		
		//region Machines
		
		public static final DeferredBlock<Block> TRANSMISSION_SHAFT = DEFERRED_REGISTRY.register(
				"transmission_shaft", TransmissionShaftBlock::new);
		
		//endregion
		
		private static void init(IEventBus bus) {
			LOGGER.info("[Cog Works] Registering blocks ...");
			DEFERRED_REGISTRY.register(bus);
		}
		
		public static class Tags {
		
			
			private static TagKey<Block> createConventional(String name) {
				return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("c", name));
			}
			
			private static TagKey<Block> createCustom(String name) {
				return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MOD_ID, name));
			}
		}
		
		public static class Entities {
			
			private static final DeferredRegister<BlockEntityType<?>> DEFERRED_REGISTRY =
				DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, MOD_ID);
			
			//region Machine Block Entities
			
			public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TransmissionShaftBlockEntity>> TRANSMISSION_SHAFT =
				DEFERRED_REGISTRY.register("transmission_shaft_entity",
				                           () -> BlockEntityType.Builder.of(TransmissionShaftBlockEntity::new,
				                                                            Blocks.TRANSMISSION_SHAFT.get()).build(null));
			
			//endregion
			
			public static void init(IEventBus bus) {
				LOGGER.info("[Cog Works] Registering block entities ...");
				DEFERRED_REGISTRY.register(bus);
			}
		
		}
	}
	
	public static class Items {
		//region Deferred Items
		private static final DeferredRegister.Items DEFERRED_REGISTRY = DeferredRegister.createItems(MOD_ID);
		
		//region BlockItems
		
		//region Machines
		public static final DeferredItem<BlockItem> TRANSMISSION_SHAFT = registerBlockItem(Blocks.TRANSMISSION_SHAFT);
		//endregion
		
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
