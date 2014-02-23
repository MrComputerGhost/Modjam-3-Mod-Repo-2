package mrcomputerghost.forbiddenlands.blocks;

import java.util.Random;

import mrcomputerghost.forbiddenlands.ForbiddenLands;
//import mrcomputerghost.forbiddenlands.world.dimension.ForbiddenTeleporter;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFBPortal extends BlockBreakable
{
	public BlockFBPortal(int par1)
	{
		super(par1, "forbiddenlands:fbportal", Material.portal, false);
		this.setTickRandomly(true);
		this.setHardness(-1.0F);
		this.setStepSound(soundGlassFootstep);
		this.setLightValue(0.75F);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public void registerIcons(IconRegister iconRegister)
	{
		blockIcon = iconRegister.registerIcon("forbiddenlands:fbportal");
	}

	/**
	 * Updates the blocks bounds based on its current state. Args: world, x, y, z
	 */
	public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
	{
		float f = 0.375F;
		float f1 = f / 2.0F;
		this.setBlockBounds(0.5F - f1, 0.0F, 0.5F - f1, 0.5F + f1, 1F, 0.5F + f1);
	}

	/**
	 * Ticks the block if it's been scheduled
	 */
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
	}

	/**
	 * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
	 * cleared to be reused)
	 */
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
	{
		return null;
	}

	/**
	 * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
	 * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
	 */
	public boolean isOpaqueCube()
	{
		return false;
	}

	/**
	 * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
	 */
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	/**
	 * Checks to see if this location is valid to create a portal and will return True if it does. Args: world, x, y, z
	 */
	public boolean tryToCreatePortal(World world, int x, int y, int z)
	{
		boolean hasMiddleBeam = world.getBlockId(x, y - 1, z) == ForbiddenBlocks.ParadoxBlock.blockID && world.getBlockId(x, y + 3, z) == ForbiddenBlocks.ParadoxBlock.blockID;
		boolean hasTopRightBeam = world.getBlockId(x + 1, y + 2, z) == ForbiddenBlocks.ParadoxBlock.blockID && world.getBlockId(x + 2, y + 2, z) == ForbiddenBlocks.ParadoxBlock.blockID && world.getBlockId(x + 2, y + 1, z) == ForbiddenBlocks.ParadoxBlock.blockID && world.getBlockId(x + 2, y, z) == ForbiddenBlocks.ParadoxBlock.blockID;
		boolean haBottomRightBeam = world.getBlockId(x - 1, y + 2, z) == ForbiddenBlocks.ParadoxBlock.blockID && world.getBlockId(x - 2, y + 2, z) == ForbiddenBlocks.ParadoxBlock.blockID && world.getBlockId(x - 2, y + 1, z) == ForbiddenBlocks.ParadoxBlock.blockID && world.getBlockId(x - 2, y, z) == ForbiddenBlocks.ParadoxBlock.blockID;
		boolean hasTopLeftBeam = world.getBlockId(x, y + 2, z + 1) == ForbiddenBlocks.ParadoxBlock.blockID && world.getBlockId(x, y + 2, z + 2) == ForbiddenBlocks.ParadoxBlock.blockID && world.getBlockId(x, y + 1, z + 2) == ForbiddenBlocks.ParadoxBlock.blockID && world.getBlockId(x, y, z + 2) == ForbiddenBlocks.ParadoxBlock.blockID;
		boolean hasBottomLeftBeam = world.getBlockId(x, y + 2, z - 1) == ForbiddenBlocks.ParadoxBlock.blockID && world.getBlockId(x, y + 2, z - 2) == ForbiddenBlocks.ParadoxBlock.blockID && world.getBlockId(x, y + 1, z - 2) == ForbiddenBlocks.ParadoxBlock.blockID && world.getBlockId(x, y, z - 2) == ForbiddenBlocks.ParadoxBlock.blockID;
		boolean hasPortalFrame = hasMiddleBeam && hasTopRightBeam && haBottomRightBeam && hasTopLeftBeam && hasBottomLeftBeam;


		if(hasPortalFrame)
		{
			world.setBlockToAir(x, y, z);
			world.addWeatherEffect(new EntityLightningBolt(world, x, y, z));
			world.setBlock(x, y, z, ForbiddenBlocks.FBPortal.blockID,0,2);
			world.setBlock(x, y + 1, z, ForbiddenBlocks.FBPortal.blockID,0,2);     
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
	 * their own) Args: x, y, z, neighbor blockID
	 */
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
	{

	}

	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	public int quantityDropped(Random par1Random)
	{
		return 0;
	}

	@SideOnly(Side.CLIENT)

	/**
	 * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
	 */
	public int getRenderBlockPass()
	{
		return 1;
	}

	@SideOnly(Side.CLIENT)

	/**
	 * A randomly called display update to be able to add particles or other items for display
	 */
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		if (par5Random.nextInt(100) == 0)
		{
			par1World.playSound((double)par2 + 0.5D, (double)par3 + 0.5D, (double)par4 + 0.5D, "portal.portal", 0.5F, par5Random.nextFloat() * 0.4F + 0.8F, false);
		}
		for (int l = 0; l < 100; ++l)
		{
			double d0 = (double)((float)par2 + par5Random.nextFloat());
			double d1 = (double)((float)par3 + par5Random.nextFloat());
			double d2 = (double)((float)par4 + par5Random.nextFloat());
			double d3 = 0.0D;
			double d4 = 0.0D;
			double d5 = 0.0D;
			int i1 = par5Random.nextInt(2) * 2 - 1;
			d3 = ((double)par5Random.nextFloat() - 0.5D) * 0.5D;
			d4 = ((double)par5Random.nextFloat() - 0.5D) * 0.5D;
			d5 = ((double)par5Random.nextFloat() - 0.5D) * 0.5D;

			if (par1World.getBlockId(par2 - 1, par3, par4) != this.blockID && par1World.getBlockId(par2 + 1, par3, par4) != this.blockID)
			{
				d0 = (double)par2 + 0.5D + 0.25D * (double)i1;
				d3 = (double)(par5Random.nextFloat() * 2.0F * (float)i1);
			}
			else
			{
				d2 = (double)par4 + 0.5D + 0.25D * (double)i1;
				d5 = (double)(par5Random.nextFloat() * 2.0F * (float)i1);
			}

			par1World.spawnParticle("portal", d0, d1, d2, d3, d4, d5);
		}

	}

	//@SideOnly(Side.CLIENT)

	/**
	 * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
	
	public int idPicked(World par1World, int par2, int par3, int par4)
	{
		return 0;
	}

	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
	{
		if (par5Entity.ridingEntity == null && par5Entity.riddenByEntity == null)
		{
			if (par5Entity instanceof EntityPlayerMP)
			{
				EntityPlayerMP thePlayer = (EntityPlayerMP) par5Entity;

				if (par5Entity.dimension != ForbiddenLands.ForbiddenDimID)
				{
					thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, ForbiddenLands.ForbiddenDimID, new ForbiddenTeleporter(thePlayer.mcServer.worldServerForDimension(ForbiddenLands.ForbiddenDimID)));
				}
				else
				{
					thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, 0, new ForbiddenTeleporter(thePlayer.mcServer.worldServerForDimension(0)));
				}
			}
		}
	}**/

}
