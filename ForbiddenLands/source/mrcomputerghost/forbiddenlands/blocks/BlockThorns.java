package mrcomputerghost.forbiddenlands.blocks;

import java.util.Random;

import mrcomputerghost.forbiddenlands.util.ForbiddenUtil;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.client.Minecraft;

public class BlockThorns extends Block
{	
	public BlockThorns(int par1, String texture) 
    {
            super(par1, Material.circuits);
            setCreativeTab(CreativeTabs.tabDecorations);
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
    }
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        byte b0 = 0;
        float f = 0.0625F;
        return AxisAlignedBB.getAABBPool().getAABB((double)par2 + this.minX, (double)par3 + this.minY, (double)par4 + this.minZ, (double)par2 + this.maxX, (double)((float)par3 + (float)b0 * f), (double)par4 + this.maxZ);
    }
	
    public int idDropped(int par1, Random par2Random, int par3)
    {
            return this.blockID;
    }
    public int quantityDropped(Random random)
    {
            return 1;
    }

    /**
     * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
     * coordinates.  Args: blockAccess, x, y, z, side
     */
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        return par5 == 1 ? true : super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, par5);
    }
    
	/**
     * A randomly called display update to be able to add particles or other items for display
     */
    @Override
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
            super.randomDisplayTick(par1World, par2, par3, par4, par5Random);

            if (par5Random.nextInt(2) == 0)
            {
                    par1World.spawnParticle("death_suspend", par2 + par5Random.nextFloat(), par3 + 1.1F, par4 + par5Random.nextFloat(), 0.0D, 0.0D, 0.0D);
            }
    }
    
    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    
    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    
    public Icon getIcon(int par1, int par2)
    {
        return Block.tripWire.getIcon(par1, par2);
    }

    /**
     * Sets the block's bounds for rendering it as an item
     */
    public void setBlockBoundsForItemRender()
    {
        this.func_111047_d(0);
    }

    /**
     * Updates the blocks bounds based on its current state. Args: world, x, y, z
     */
    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        this.func_111047_d(par1IBlockAccess.getBlockMetadata(par2, par3, par4));
    }

    protected void func_111047_d(int par1)
    {
        byte b0 = 0;
        float f = (float)(1 * (1 + b0)) / 16.0F;
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
    }
    
    /**
     * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
     */
   
    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity entity)
    {
    
    		entity.attackEntityFrom(DamageSource.causeThornsDamage(entity), 1.5F);
    		
    }
}
