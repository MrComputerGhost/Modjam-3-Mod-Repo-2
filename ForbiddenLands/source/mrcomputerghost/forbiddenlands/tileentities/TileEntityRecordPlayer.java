package mrcomputerghost.forbiddenlands.tileentities;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;

public class TileEntityRecordPlayer extends TileEntity
{
	public ItemStack disc;
	
	public boolean isDirty = false; 
	public boolean hasObject = false;
	
	public TileEntityRecordPlayer()
    {
        this.disc = new ItemStack(0, 0, 0);
        this.hasObject = false;
    }
	
	
	@Override
    public void updateEntity()
    {
    	super.updateEntity();
    	if (isDirty)
        {
            isDirty = false;
            worldObj.markBlockForRenderUpdate(xCoord, yCoord, zCoord);   
        }
    }
	
	@Override
    public void writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);
        nbt.setBoolean("hasObject", hasObject);
        NBTTagCompound tag = new NBTTagCompound();
        this.disc.writeToNBT(tag);
        nbt.setCompoundTag("object", tag);
        
    }
	
    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        this.hasObject = nbt.getBoolean("hasObject");
        this.disc = new ItemStack(0, 0, 0);
        this.disc.readFromNBT(nbt.getCompoundTag("object"));
    }
    
    @Override
    public Packet getDescriptionPacket() 
    {
    	NBTTagCompound nbttagcompound = new NBTTagCompound();
        this.writeToNBT(nbttagcompound);
        return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 2, nbttagcompound);
    }

    @Override
    public void onDataPacket(INetworkManager net, Packet132TileEntityData pkt) 
    {
        super.onDataPacket(net, pkt);
        NBTTagCompound tag = pkt != null ? pkt.data : new NBTTagCompound();
        readFromNBT(tag);
        this.isDirty = true;
    }
}
