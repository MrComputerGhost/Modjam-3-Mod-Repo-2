package mrcomputerghost.forbiddenlands.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class ItemStacker extends Item {

	public ItemStacker(int par1) 
	{
        super(par1);
        this.setHasSubtypes(true);
        this.setMaxDamage(1);
        this.setCreativeTab(CreativeTabs.tabMisc);
	}
	
	
	
	public void registerIcons(IconRegister registerIcon) {
		this.itemIcon = registerIcon.registerIcon("minecraft:lead");
	}
	
	
	
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
		{
			
	    
			if ((entity.riddenByEntity != player)) {
				entity.mountEntity(player);
				entity.fallDistance = 0;
				return true;
			}
			
			else {
				return false;
			}
		}
	
	
	
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer player, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
		switch (par1ItemStack.getItemDamage())
        {
        case 0:
        	par1ItemStack.itemID = ForbiddenItems.Rider.itemID;
        	par1ItemStack.setItemName("\u00A7rRider - Ride Mode");
        	player.addChatMessage("Rider Mode Set To Ride");
        	break;
        }
		return true;
    }
	
	@Override
    @SideOnly(Side.CLIENT)
    public void addInformation (ItemStack stack, EntityPlayer player, List list, boolean par4)
    {
        switch (stack.getItemDamage())
        {
        case 0:
            list.add("\u00A75Mode: Stack");
            list.add("\u00A75Left-Click Entity to Stack it");
            list.add("\u00A75Right-Click to Change");
            break;
        }
    }
	
}
