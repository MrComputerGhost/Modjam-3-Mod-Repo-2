package mrcomputerghost.forbiddenlands.items;

import cpw.mods.fml.common.FMLLog;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

public class ItemDebugger extends Item {

	public ItemDebugger(int par1) 
	{
        super(par1);
        this.setHasSubtypes(true);
        this.setMaxDamage(1);
        this.setCreativeTab(CreativeTabs.tabMisc);
	}
	
	
	
	public void registerIcons(IconRegister registerIcon) {
		this.itemIcon = registerIcon.registerIcon("minecraft:command_block");
	}
	
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer player, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
		if (!world.isRemote) {
		String seed = "Seed: " + world.getSeed();
		String time = "Time: " + world.getWorldTime();
		String memory = "Memory: " + Minecraft.memoryReserve;
		String entity = "Entities: \n" + Minecraft.getMinecraft().debugInfoEntities() + "\n" + Minecraft.getMinecraft().getEntityDebug();
		String ren = "Renderers: \n" + Minecraft.getMinecraft().debugInfoRenders();
		player.addChatMessage(seed);
		player.addChatMessage(time);
		player.addChatMessage(memory);
		player.addChatMessage(entity);
		player.addChatMessage(ren);
		return true;
		}
		else {
		return false;
		}
    }
	
	
	
}