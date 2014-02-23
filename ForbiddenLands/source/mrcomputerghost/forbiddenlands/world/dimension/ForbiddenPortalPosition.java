package mrcomputerghost.forbiddenlands.world.dimension;

import net.minecraft.util.ChunkCoordinates;

public class ForbiddenPortalPosition extends ChunkCoordinates
{
	public long field_85087_d;

    final ForbiddenTeleporter field_85088_e;

    public ForbiddenPortalPosition(ForbiddenTeleporter par1Teleporter, int par2, int par3, int par4, long par5)
    {
        super(par2, par3, par4);
        this.field_85088_e = par1Teleporter;
        this.field_85087_d = par5;
    }
}
