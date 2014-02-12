package mrcomputerghost.forbiddenlands.util;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ForbiddenNBT {

	public static void setStaffMode(ItemStack item, int mode)
    {
        NBTTagCompound itemStackData;
        if (item.hasTagCompound())
            itemStackData = item.getTagCompound();
        else
        {
            itemStackData = new NBTTagCompound();
            item.setTagCompound(itemStackData);
        }
        NBTTagCompound modeChanger = new NBTTagCompound();
        modeChanger.setInteger("staffMode", mode);
        itemStackData.setTag("staffMode", modeChanger);
    }
	
	
	public static int modeStaff(ItemStack item) {
		if (item != null && item != new ItemStack(0, 0, 0) && item.getTagCompound().hasKey("staffMode"))
        {
            NBTTagCompound poo = (NBTTagCompound) item.getTagCompound().getTag("staffMode");
            int staffMode = poo.getInteger("staffMode");
            return staffMode;
        }
		return 0;
	}
	
	
	
	
	
}
