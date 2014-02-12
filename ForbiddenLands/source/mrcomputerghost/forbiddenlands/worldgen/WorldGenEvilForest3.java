package mrcomputerghost.forbiddenlands.worldgen;

import java.util.Random;

import mrcomputerghost.forbiddenlands.blocks.ForbiddenBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenEvilForest3 extends WorldGenerator
{
    /** stores the ID for WorldGenDeadBush */
    private int thornBushID;

    public WorldGenEvilForest3(int par1)
    {
        this.thornBushID = ForbiddenBlocks.ThornShrub.blockID;
    }

    public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5)
    {
        int l;

        Block block = null;
        do 
        {
            block = Block.blocksList[par1World.getBlockId(par3,  par4, par5)];
            if (block != null && !block.isLeaves(par1World, par3, par4, par5))
            {
                break;
            }
            par4--;
        } while (par4 > 0);
        
        int i2 = par1World.getBlockId(par3, par4, par5);
        int i3 = par1World.getBlockId(par3, par4 + 1, par5);
        if ((i2 == Block.dirt.blockID || i2 == Block.grass.blockID))
        {
        for (int i1 = 0; i1 < 4; ++i1)
        {
            int j1 = par3 + par2Random.nextInt(8) - par2Random.nextInt(8);
            int k1 = par4 + par2Random.nextInt(4) - par2Random.nextInt(4);
            int l1 = par5 + par2Random.nextInt(8) - par2Random.nextInt(8);

            if ((!par1World.isAirBlock(j1, k1, l1)) && par1World.isAirBlock(j1, k1 + 1, l1) && Block.blocksList[this.thornBushID].canBlockStay(par1World, j1, k1, l1))
            {
                par1World.setBlock(j1, k1 + 1, l1, this.thornBushID, 1, 0);
            }
        }
        }
        return true;
        
    }
}
