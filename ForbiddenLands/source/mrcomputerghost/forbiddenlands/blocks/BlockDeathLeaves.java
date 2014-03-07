package mrcomputerghost.forbiddenlands.blocks;

import java.util.ArrayList;
import java.util.Random;

import mrcomputerghost.forbiddenlands.ForbiddenLands;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockDeathLeaves extends BlockLeavesBase implements IShearable
{
	public BlockDeathLeaves(int par1) 
    {
            super(par1, Material.leaves, false);
            setCreativeTab(CreativeTabs.tabBlock);
    }

    public int idDropped(int par1, Random par2Random, int par3)
    {
            return this.blockID;
    }
    public int quantityDropped(Random random)
    {
            return 1;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
            this.blockIcon = par1IconRegister.registerIcon("forbiddenlands:leaves_death");
    }
    
    public boolean isOpaqueCube()
    {
        return false;
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
                    par1World.spawnParticle("smoke", par2 + par5Random.nextFloat(), par3 + 1.1F, par4 + par5Random.nextFloat(), 0.0D, 0.0D, 0.0D);
            }
    }
    
    @Override
    public boolean isShearable(ItemStack item, World world, int x, int y, int z)
    {
        return true;
    }
    
    @Override
    public boolean isLeaves(World world, int x, int y, int z)
    {
        return true;
    }

	@Override
	public ArrayList<ItemStack> onSheared(ItemStack item, World world, int x, int y, int z, int fortune) {
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        ret.add(new ItemStack(this, 1, world.getBlockMetadata(x, y, z) & 3));
        return ret;
	}

}
