package mrcomputerghost.forbiddenlands.blocks;

import java.util.Random;

import javax.swing.JOptionPane;

import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mrcomputerghost.forbiddenlands.ForbiddenLands;
import mrcomputerghost.forbiddenlands.client.gui.GuiTombStone;
import mrcomputerghost.forbiddenlands.items.ForbiddenItems;
import mrcomputerghost.forbiddenlands.tileentities.TileEntityRecordPlayer;
import mrcomputerghost.forbiddenlands.tileentities.TileEntityTombStone;
import mrcomputerghost.forbiddenlands.util.ForbiddenUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityCommandBlock;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockRecordPlayer extends BlockContainer {
	
	
	
	Random rand = new Random();
	
	
    protected BlockRecordPlayer(int par1, Material par2Material)
    {
    	super(par1, Material.rock);
    	this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.748F, 1.0F);
    	//this.setBlockBounds(0.25F, 0.0F, 0.25F, 0.75F, 0.5F, 0.75F);
    }

    @Override
    public TileEntity createNewTileEntity(World world)
    {
        return new TileEntityRecordPlayer();
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        return false;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public int getRenderType()
    {
        return -1;
    }
    
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int par6, float par7, float par8, float par9)
    {
        super.onBlockActivated(world, x, y, z, entityPlayer, par6, par7, par8, par9);      
            TileEntityRecordPlayer bill = (TileEntityRecordPlayer) world.getBlockTileEntity(x, y, z); 
            boolean flag = false;
            if (entityPlayer.inventory.getCurrentItem().getUnlocalizedName().contains("disc") || entityPlayer.inventory.getCurrentItem().getUnlocalizedName().contains("disk") || entityPlayer.inventory.getCurrentItem().getUnlocalizedName().contains("ball")) flag = true;
            if (!bill.hasObject && flag) {
            	bill.hasObject = true;
            	bill.disc = entityPlayer.inventory.getCurrentItem();
                bill.disc.stackSize = 1;
                entityPlayer.inventory.getCurrentItem().stackSize--;
            }
            else if (bill.hasObject && !flag) {
            	bill.hasObject = false;
            	dropItem(world, x, y, z, bill.disc);
            	bill.disc = new ItemStack(0, 0, 0);
            }
            else if (bill.hasObject && flag) {
            	dropItem(world, x, y, z, bill.disc);
            	bill.disc = entityPlayer.inventory.getCurrentItem();
            	bill.disc.stackSize = 1;
                entityPlayer.inventory.getCurrentItem().stackSize--;
            }
			return true; 
    }
    
    @Override
    public void onBlockClicked(World world, int i, int j, int k, EntityPlayer player)
    {
        return;
    }

    public void dropItem(World world, double x, double y, double z, ItemStack stack)
    {
        EntityItem entityitem = new EntityItem(world, x + 0.5D, y + 1.5D, z + 0.5D, stack);
        entityitem.motionX = -1;
        entityitem.motionZ = 1;
        entityitem.motionY = -1;
        world.spawnEntityInWorld(entityitem);
    }

    public void breakBlock(World world, int i, int j, int k, int par5, int par6)
    {
        TileEntityRecordPlayer te = (TileEntityRecordPlayer) world.getBlockTileEntity(i, j, k);

        if (te != null)
        {
            world.markTileEntityForDespawn(te);
        }

        super.breakBlock(world, i, j, k, par5, par6);
    }

    @Override
    public void onBlockPlacedBy(World world, int i, int j, int k, EntityLivingBase entityLiving, ItemStack par6ItemStack)
    {
        int rotation = MathHelper.floor_double(entityLiving.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
        world.setBlockMetadataWithNotify(i, j, k, rotation, 2);
        
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
    	this.blockIcon = par1IconRegister.registerIcon("minecraft:jukebox");
    }
    public Block setTickRandomly(boolean par1)
    {
        this.needsRandomTick = par1;
        return this;
    }
    
    public boolean getTickRandomly()
    {
        return this.needsRandomTick;
    }
    
    /**
     * A randomly called display update to be able to add particles or other items for display
     */
    public void randomDisplayTick(World world, int i, int j, int k, Random par5Random) {
    	
    }
        

}