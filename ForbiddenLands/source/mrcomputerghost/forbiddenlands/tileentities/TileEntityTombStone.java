package mrcomputerghost.forbiddenlands.tileentities;

import java.util.ArrayList;
import java.util.Collections;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet130UpdateSign;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileEntityTombStone extends TileEntity
{
	private static String name;
	
    public boolean isDirty = false; 
    
    public int directionFacing = 0;
	
    public TileEntityTombStone()
    {
        this.name = "Player";
        
    }
	
    
    public void setName(String str) {
    	this.name = str;
    	this.isDirty = true;
    }
    
    @SideOnly(Side.CLIENT)
    public String getName()
    {
        return this.name;
    }
    
    @Override
    public void updateEntity()
    {
    	super.updateEntity();
    	if (isDirty)
        {
            worldObj.markBlockForRenderUpdate(xCoord, yCoord, zCoord);
            isDirty = false;
        }
    }
    
    @Override
    public void writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);

        nbt.setString("tombName", name);
        
    }
	
    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);

        this.name = nbt.getString("tombName");
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
