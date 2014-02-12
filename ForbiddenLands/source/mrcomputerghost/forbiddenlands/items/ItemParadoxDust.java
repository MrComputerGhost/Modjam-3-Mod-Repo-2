package mrcomputerghost.forbiddenlands.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;

public class ItemParadoxDust extends Item {

	public ItemParadoxDust(int par1) {
        super(par1);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setCreativeTab(CreativeTabs.tabMaterials);
	}
		
	@Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
            this.itemIcon = par1IconRegister.registerIcon("forbiddenlands:paradoxdust");
    }
	
	public boolean isFull3D()
    {
        return true;
    }
	
	public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player)
    {
		world.spawnParticle("portal", player.posX + 1, player.posY + 1, player.posZ + 1, 0.0D, 0.0D, 0.0D);
		return item;
    }

}
