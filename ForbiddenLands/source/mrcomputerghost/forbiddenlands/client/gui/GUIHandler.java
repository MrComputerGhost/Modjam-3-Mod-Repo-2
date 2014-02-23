package mrcomputerghost.forbiddenlands.client.gui;

import mrcomputerghost.forbiddenlands.tileentities.TileEntityTombStone;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GUIHandler implements IGuiHandler
{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;	
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return new GuiTombStone((TileEntityTombStone) world.getBlockTileEntity(x, y, z));
	}
}
