package mrcomputerghost.forbiddenlands.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class ItemParadoxShard extends Item {

	public ItemParadoxShard(int par1) {
        super(par1);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
	}
		
	@Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
            this.itemIcon = par1IconRegister.registerIcon("forbiddenlands:paradoxshard");
    }

}
