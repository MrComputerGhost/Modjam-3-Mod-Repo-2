package mrcomputerghost.forbiddenlands.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;



public class ItemParadoxArmor extends ItemArmor
{
	public ItemParadoxArmor(int parl, EnumArmorMaterial par2, int par3)
	{
		super(parl, par2, par3, par3);
	}
	
	public void registerIcons(IconRegister parl)
	{
		if (this.itemID == ForbiddenItems.ParadoxHelm.itemID)
		{
			itemIcon = parl.registerIcon("forbiddenlands:paradox_helm");
		}
		else if (this.itemID == ForbiddenItems.ParadoxChest.itemID)
		{
			itemIcon = parl.registerIcon("forbiddenlands:paradox_chest");
		}
		else if (this.itemID == ForbiddenItems.ParadoxLegs.itemID)
		{
			itemIcon = parl.registerIcon("forbiddenlands:paradox_leggings");
		}
		else if (this.itemID == ForbiddenItems.ParadoxBoots.itemID)
		{
			itemIcon = parl.registerIcon("forbiddenlands:paradox_boots");
		}
		
	}
	
	public String getArmorTextureFile(ItemStack itemstack) {
		if(itemstack.itemID == ForbiddenItems.ParadoxHelm.itemID || itemstack.itemID == ForbiddenItems.ParadoxChest.itemID){
		return "forbiddenlands:armor/paradox_layer_1.png";
		}

		if(itemstack.itemID == ForbiddenItems.ParadoxBoots.itemID){
		return "forbiddenlands:armor/paradox_layer_1.png";
		}

		if(itemstack.itemID == ForbiddenItems.ParadoxLegs.itemID){
		return "assets/model/paradox_layer_2.png";
		}
		else return null;

		}
	
	
}
