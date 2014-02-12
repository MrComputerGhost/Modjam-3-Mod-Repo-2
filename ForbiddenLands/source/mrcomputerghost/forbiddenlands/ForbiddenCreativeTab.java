package mrcomputerghost.forbiddenlands;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mrcomputerghost.forbiddenlands.items.ForbiddenItems;
import net.minecraft.creativetab.CreativeTabs;

public class ForbiddenCreativeTab extends CreativeTabs{

	public ForbiddenCreativeTab(int par1, String par2Str) {
		super(par1, par2Str);
		
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex()
	{
		return ForbiddenItems.ParadoxDust.itemID;
	}

}
