package mrcomputerghost.forbiddenlands;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import mrcomputerghost.forbiddenlands.client.gui.GUIHandler;
import mrcomputerghost.forbiddenlands.tileentities.TileEntityTombStone;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy
{

	public void registerRenderers()
    {   
        
    }

	public void init(){
		 NetworkRegistry.instance().registerGuiHandler(ForbiddenLands.instance, new GUIHandler());
	}
	
}