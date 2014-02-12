package mrcomputerghost.forbiddenlands.handlers;

import mrcomputerghost.forbiddenlands.ForbiddenLands;
import mrcomputerghost.forbiddenlands.items.ForbiddenItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ICraftingHandler;

public class CraftingHandler implements ICraftingHandler {

	@Override
	public void onCrafting(EntityPlayer player, ItemStack item,
			IInventory craftMatrix) {
		/**if (item.itemID == ForbiddenItems.Rider.itemID) {
			player.addStat(ForbiddenLands.Forbidden, 1);
		}**/

	}

	@Override
	public void onSmelting(EntityPlayer player, ItemStack item) {
		// TODO Auto-generated method stub

	}

}
