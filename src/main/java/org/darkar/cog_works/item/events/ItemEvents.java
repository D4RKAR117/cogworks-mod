package org.darkar.cog_works.item.events;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.LogicalSide;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import org.darkar.cog_works.item.ProspectingPickItem;

import static org.darkar.cog_works.CogWorks.MOD_ID;

@EventBusSubscriber(modid = MOD_ID)
public class ItemEvents {

	@SubscribeEvent
	public static void onPlayerLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
		ItemStack itemStack = event.getItemStack();
		Item item = itemStack.getItem();
		Level level = event.getLevel();
		Player player = event.getEntity();
		BlockPos pos = event.getPos();
		LogicalSide side = event.getSide();


		if (itemStack.isEmpty()) return;
		if (item instanceof ProspectingPickItem) {
			if (!side.isClient()) {
				if(!player.isCreative()) {
					((ProspectingPickItem) item).handleLeftClickBlock(player, level, pos);
				}
				return;
			}

			event.setCanceled(true);
		}
	}

}
