package mrcomputerghost.forbiddenlands.items;

import java.util.Random;

import javax.swing.JOptionPane;

import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mrcomputerghost.forbiddenlands.util.ForbiddenNBT;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;

public class ItemParadoxStaff extends ItemTool {
	private static final Random RANDOM = new Random();
	public static final Block[] blocksEffectiveAgainst = new Block[] {Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay, Block.tilledField, Block.slowSand, Block.mycelium, Block.planks, Block.bookShelf, Block.wood, Block.chest, Block.stoneDoubleSlab, Block.stoneSingleSlab, Block.pumpkin, Block.pumpkinLantern, Block.cobblestone, Block.stoneDoubleSlab, Block.stoneSingleSlab, Block.stone, Block.sandStone, Block.cobblestoneMossy, Block.oreIron, Block.blockIron, Block.oreCoal, Block.blockGold, Block.oreGold, Block.oreDiamond, Block.blockDiamond, Block.ice, Block.netherrack, Block.oreLapis, Block.blockLapis, Block.oreRedstone, Block.oreRedstoneGlowing, Block.rail, Block.railDetector, Block.railPowered, Block.railActivator};
	private float weaponDamage;
	public ItemParadoxStaff(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, 3.0F, par2EnumToolMaterial, blocksEffectiveAgainst);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setCreativeTab(CreativeTabs.tabMaterials);
        this.weaponDamage = 5.5F + par2EnumToolMaterial.getDamageVsEntity();
	}
	public float func_82803_g()
    {
        return this.toolMaterial.getDamageVsEntity();
    }	
	@Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
            this.itemIcon = par1IconRegister.registerIcon("forbiddenlands:paradoxstaff");
    }
	
	public boolean canHarvestBlock(Block par1Block)
    {
        return par1Block == Block.obsidian ? this.toolMaterial.getHarvestLevel() == 3 : (par1Block != Block.blockDiamond && par1Block != Block.oreDiamond ? (par1Block != Block.oreEmerald && par1Block != Block.blockEmerald ? (par1Block != Block.blockGold && par1Block != Block.oreGold ? (par1Block != Block.blockIron && par1Block != Block.oreIron ? (par1Block != Block.blockLapis && par1Block != Block.oreLapis ? (par1Block != Block.oreRedstone && par1Block != Block.oreRedstoneGlowing ? (par1Block.blockMaterial == Material.rock ? true : (par1Block.blockMaterial == Material.iron ? true : par1Block.blockMaterial == Material.anvil)) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 2);
    }
	public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
    {
		if (par2Block.blockID == Block.web.blockID)
        {
            return 20.0F;
        }
        else
        {
            Material material = par2Block.blockMaterial;
            return par2Block != null && (par2Block.blockMaterial == Material.wood || par2Block.blockMaterial == Material.plants || par2Block.blockMaterial == Material.vine || par2Block.blockMaterial == Material.iron || par2Block.blockMaterial == Material.anvil || par2Block.blockMaterial == Material.rock) ? this.efficiencyOnProperMaterial : super.getStrVsBlock(par1ItemStack, par2Block);
        }
		
    }
	public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player)
    {
		final double RANGE = 100;
        Vec3 lookdir = player.getLook(1);  
        Vec3 src = world.getWorldVec3Pool().getVecFromPool(player.posX+lookdir.xCoord, player.posY+lookdir.yCoord+player.getEyeHeight(), player.posZ+lookdir.zCoord);
        Vec3 dst = src.addVector(lookdir.xCoord*RANGE, lookdir.yCoord*RANGE, lookdir.zCoord*RANGE);
        MovingObjectPosition mop = world.rayTraceBlocks_do_do(src, dst, true, true);
        if(mop == null) return item;
        int i = MathHelper.floor_double(mop.hitVec.xCoord);
        int j = MathHelper.floor_double(mop.hitVec.yCoord);
        int k = MathHelper.floor_double(mop.hitVec.zCoord);	
        int a = (int) player.posX;
		//if (mop.hitVec.xCoord  mop.hitVec.yCoord, mop.hitVec.zCoord)
        //player.setPositionAndUpdate(mop.hitVec.xCoord, mop.hitVec.yCoord, mop.hitVec.zCoord);
		
		if ((player.inventory.hasItem(ForbiddenItems.ParadoxDust.itemID)) || (player.capabilities.isCreativeMode)) {
		world.spawnParticle("fireworksSpark", mop.hitVec.xCoord, mop.hitVec.yCoord, mop.hitVec.zCoord, mop.hitVec.xCoord, mop.hitVec.yCoord, mop.hitVec.zCoord);
        if(!world.isRemote) world.addWeatherEffect(new EntityLightningBolt(world, mop.hitVec.xCoord, mop.hitVec.yCoord, mop.hitVec.zCoord));
        //world.createExplosion(player, mop.hitVec.xCoord, mop.hitVec.yCoord, mop.hitVec.zCoord, 5, false);	
        if (world.getBlockId(i, j - 1, k) == Block.sand.blockID) {
        		world.setBlock(i, j - 1, k, Block.glass.blockID);
        }
        
        
        	if (world.getBlockId(i, j, k - 1) == Block.sand.blockID) {
        		world.setBlock(i, j, k - 1, Block.glass.blockID);
        	}
        	if (world.getBlockId(i - 1, j, k) == Block.sand.blockID) {
        		world.setBlock(i - 1, j, k, Block.glass.blockID);
        	}
        	if (world.getBlockId(i, j + 1, k) == Block.sand.blockID) {
        		world.setBlock(i, j + 1, k, Block.glass.blockID);
        	}
        	if (world.getBlockId(i, j, k + 1) == Block.sand.blockID) {
        		world.setBlock(i, j, k + 1, Block.glass.blockID);
        	}
        	if (world.getBlockId(i + 1, j, k) == Block.sand.blockID) {
        		world.setBlock(i + 1, j, k, Block.glass.blockID);
        	}
        	if (world.getBlockId(i, j - 2, k) == Block.sand.blockID) {
        		world.setBlock(i, j - 2, k, Block.glass.blockID);
        	}
        	if (world.getBlockId(i, j, k - 2) == Block.sand.blockID) {
        		world.setBlock(i, j, k - 2, Block.glass.blockID);
        	}
        	if (world.getBlockId(i - 2, j, k) == Block.sand.blockID) {
        		world.setBlock(i - 2, j, k, Block.glass.blockID);
        	}
        	if (world.getBlockId(i, j + 2, k) == Block.sand.blockID) {
        		world.setBlock(i, j + 2, k, Block.glass.blockID);
        	}
        	if (world.getBlockId(i, j, k + 2) == Block.sand.blockID) {
        		world.setBlock(i, j, k + 2, Block.glass.blockID);
        	}
        	if (world.getBlockId(i + 2, j, k) == Block.sand.blockID) {
        		world.setBlock(i + 2, j, k, Block.glass.blockID);
        	}
        	if (world.getBlockId(i, j, k) == Block.waterMoving.blockID || world.getBlockId(i + 2, j, k) == Block.waterStill.blockID) {
        		world.setBlockToAir(i, j, k);
        	}
        	if (world.getBlockId(i, j + 1, k) == Block.waterMoving.blockID || world.getBlockId(i + 2, j, k) == Block.waterStill.blockID) {
        		world.setBlockToAir(i, j + 1, k);
        	}
        	if (world.getBlockId(i, j + 2, k) == Block.waterMoving.blockID || world.getBlockId(i + 2, j, k) == Block.waterStill.blockID) {
        		world.setBlockToAir(i, j + 2, k);
        	}
        	if (world.getBlockId(i, j + 3, k) == Block.waterMoving.blockID || world.getBlockId(i + 2, j, k) == Block.waterStill.blockID) {
        		world.setBlockToAir(i, j + 4, k);
        	}
        	if (world.getBlockId(i, j + 5, k) == Block.waterMoving.blockID || world.getBlockId(i + 2, j, k) == Block.waterStill.blockID) {
        		world.setBlockToAir(i, j + 5, k);
        	}
        	if (world.getBlockId(i, j + 6, k) == Block.waterMoving.blockID || world.getBlockId(i + 2, j, k) == Block.waterStill.blockID) {
        		world.setBlockToAir(i, j + 6, k);
        	}
        	if (world.getBlockId(i, j, k + 1) == Block.waterMoving.blockID || world.getBlockId(i + 2, j, k) == Block.waterStill.blockID) {
        		world.setBlockToAir(i, j, k + 1);
        	}
        	if (world.getBlockId(i, j + 1, k + 1) == Block.waterMoving.blockID || world.getBlockId(i + 2, j, k + 1) == Block.waterStill.blockID) {
        		world.setBlockToAir(i, j + 1, k + 1);
        	}
        	if (world.getBlockId(i, j + 2, k + 1) == Block.waterMoving.blockID || world.getBlockId(i + 2, j, k + 1) == Block.waterStill.blockID) {
        		world.setBlockToAir(i, j + 2, k + 1);
        	}
        	if (world.getBlockId(i, j + 3, k + 1) == Block.waterMoving.blockID || world.getBlockId(i + 2, j, k + 1) == Block.waterStill.blockID) {
        		world.setBlockToAir(i, j + 4, k + 1);
        	}
        	if (world.getBlockId(i, j + 5, k + 1) == Block.waterMoving.blockID || world.getBlockId(i + 2, j, k + 1) == Block.waterStill.blockID) {
        		world.setBlockToAir(i, j + 5, k + 1);
        	}
        	if (world.getBlockId(i, j + 6, k + 1) == Block.waterMoving.blockID || world.getBlockId(i + 2, j, k + 1) == Block.waterStill.blockID) {
        		world.setBlockToAir(i, j + 6, k + 1);
        	}
        	if (world.getBlockId(i, j, k - 1) == Block.waterMoving.blockID || world.getBlockId(i + 2, j, k) == Block.waterStill.blockID) {
        		world.setBlockToAir(i, j, k - 1);
        	}
        	if (world.getBlockId(i, j + 1, k - 1) == Block.waterMoving.blockID || world.getBlockId(i + 2, j, k - 1) == Block.waterStill.blockID) {
        		world.setBlockToAir(i, j + 1, k - 1);
        	}
        	if (world.getBlockId(i, j + 2, k - 1) == Block.waterMoving.blockID || world.getBlockId(i + 2, j, k - 1) == Block.waterStill.blockID) {
        		world.setBlockToAir(i, j + 2, k - 1);
        	}
        	if (world.getBlockId(i, j + 3, k - 1) == Block.waterMoving.blockID || world.getBlockId(i + 2, j, k - 1) == Block.waterStill.blockID) {
        		world.setBlockToAir(i, j + 4, k - 1);
        	}
        	if (world.getBlockId(i, j + 6, k - 1) == Block.waterMoving.blockID || world.getBlockId(i + 2, j, k - 1) == Block.waterStill.blockID || world.getBlockId(i + 2, j, k - 1) == Block.ice.blockID || world.getBlockId(i + 2, j, k - 1) == Block.snow.blockID) {
        		world.setBlockToAir(i, j + 5, k - 1);
        	}
        	if (world.getBlockId(i, j + 6, k - 1) == Block.waterMoving.blockID || world.getBlockId(i + 2, j, k - 1) == Block.waterStill.blockID || world.getBlockId(i + 2, j, k - 1) == Block.ice.blockID || world.getBlockId(i + 2, j, k - 1) == Block.snow.blockID) {
        		world.setBlockToAir(i, j + 6, k - 1);
        	}
        	
        	    	
        		//player.inventory.consumeInventoryItem(ForbiddenItems.ParadoxDust.itemID);
        }
		return item;
      }
		
     
	
	public ItemStack onItemUse(ItemStack item, World world, EntityPlayer player)
    {
		
		/**final double RANGE = 100;
        
        Vec3 lookdir = player.getLook(1);
        
        Vec3 src = world.getWorldVec3Pool().getVecFromPool(player.posX+lookdir.xCoord, player.posY+lookdir.yCoord+player.getEyeHeight(), player.posZ+lookdir.zCoord);
        Vec3 dst = src.addVector(lookdir.xCoord*RANGE, lookdir.yCoord*RANGE, lookdir.zCoord*RANGE);
        
        MovingObjectPosition mop = world.rayTraceBlocks_do_do(src, dst, true, true);
        if(mop == null)
                return item;
        
        if(!world.isRemote)
                world.addWeatherEffect(new EntityLightningBolt(world, mop.hitVec.xCoord, mop.hitVec.yCoord, mop.hitVec.zCoord));
        
        //item.damageItem(1, player);
        //world.spawnParticle("portal", par2 + par6Random.nextFloat(), par3 + 1.1F, par4 + par6Random.nextFloat(), mop.hitVec.xCoord, mop.hitVec.yCoord, mop.hitVec.zCoord);
        return item;**/
		return item;
    }
	
	public boolean isFull3D()
    {
        return true;
    }
	
	public int getItemEnchantability()
    {
        return this.toolMaterial.getEnchantability();
    }
	
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
        return ForbiddenItems.ParadoxDust.itemID == par2ItemStack.itemID ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
    }
	
	public Multimap getItemAttributeModifiers()
    {
        Multimap multimap = super.getItemAttributeModifiers();
        multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", (double)this.weaponDamage, 0));
        return multimap;
    }
	
}
