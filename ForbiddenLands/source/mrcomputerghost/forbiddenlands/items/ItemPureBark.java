package mrcomputerghost.forbiddenlands.items;

import javax.swing.JOptionPane;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;

public class ItemPureBark extends Item {

	public ItemPureBark(int par1) {
        super(par1);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setCreativeTab(CreativeTabs.tabMaterials);
	}
		
	@Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
            this.itemIcon = par1IconRegister.registerIcon("forbiddenlands:purebark");
    }
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        Boolean bob = false;
        bob = true;
        while(bob) {
        String input = JOptionPane.showInputDialog("What is your name?");
        
        if (input != null) { 
        	JOptionPane.showMessageDialog(null, "You suck " + input);
        	bob = false;
        }
        else {
        	bob = false;
        	bob = true;
        }}
		return par1ItemStack;
    }
	
}
