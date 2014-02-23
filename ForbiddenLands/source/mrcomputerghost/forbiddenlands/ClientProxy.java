package mrcomputerghost.forbiddenlands;

import mrcomputerghost.forbiddenlands.tileentities.TileEntityTombStone;
import mrcomputerghost.forbiddenlands.tileentities.TileEntityTombStoneRenderer;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {

	public void registerRenderers() {

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTombStone.class,
				new TileEntityTombStoneRenderer());
		
	}

}
