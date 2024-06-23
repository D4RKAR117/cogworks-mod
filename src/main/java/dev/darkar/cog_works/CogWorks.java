package dev.darkar.cog_works;

import com.mojang.logging.LogUtils;
import dev.darkar.cog_works.net.NetworkHandler;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(CogWorks.MOD_ID)
public class CogWorks {
	// Define mod id in a common place for everything to reference
	public static final String MOD_ID = "cog_works";
	// Directly reference a slf4j logger
	public static final Logger LOGGER = LogUtils.getLogger();
	
	@SuppressWarnings("OptionalGetWithoutIsPresent")
	public static final String VERSION = ModList
		.get()
		.getModContainerById(MOD_ID)
		.get()
		.getModInfo()
		.getVersion()
		.toString();
	
	
	// The constructor for the mod class is the first code that is run when your mod is loaded.
	// FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
	public CogWorks(IEventBus modEventBus, ModContainer modContainer)
	{
		// Register the commonSetup method for modloading
		modEventBus.addListener(this::commonSetup);
		
		// Initialize Network Handling
		modEventBus.addListener(NetworkHandler::onPayloadHandlersRegister);
		
		// Initialize mod registries
		Registry.initialize(modEventBus);
		
		// Register ourselves for server and other game events we are interested in.
		// Note that this is necessary if and only if we want *this* class (CogWorks) to respond directly to events.
		// Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like
		// onServerStarting() below.
		NeoForge.EVENT_BUS.register(this);
		
		// Register our mod's ModConfigSpec so that FML can create and load the config file for us
		//modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
	}
	
	private void commonSetup(final FMLCommonSetupEvent event)
	{
		// Some common setup code
		LOGGER.info("[Cog Works]: HELLO FROM COMMON SETUP");
	}
	
	
	// You can use SubscribeEvent and let the Event Bus discover methods to call
	@SubscribeEvent
	public void onServerStarting(ServerStartingEvent event)
	{
		// Do something when the server starts
		LOGGER.info("[Cog Works]: HELLO from server starting");
	}
}
