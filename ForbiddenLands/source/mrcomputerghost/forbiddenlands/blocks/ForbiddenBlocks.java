package mrcomputerghost.forbiddenlands.blocks;

import mrcomputerghost.forbiddenlands.ForbiddenLands;
import mrcomputerghost.forbiddenlands.tileentities.TileEntityTombStone;
import net.minecraft.block.Block;
import net.minecraft.block.EnumMobType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ForbiddenBlocks {
	
	
	public static Block DeathWood;
	public static Block DeathLeaves;
	public static Block DeathPlanks;
	public static Block DeadGrass;
	public static Block ThornShrub;
	public static Block Thorns;
	public static Block CorruptedBark;
	public static Block FBPortal;
	public static Block ParadoxFire;
	public static Block EnchBark;
	public static Block EnchPlanks;
	public static Block EnchLeaves;
	public static Block TombStone;
	
	public static int DeathWoodDefaultID;
	public static int DeathLeavesDefaultID;
	public static int DeathPlanksDefaultID;
	public static int DeadGrassDefaultID;
	public static int ThornShrubDefaultID;
	public static int ThornsDefaultID;
	public static int CorruptedBarkDefaultID;
	public static int FBPortalDefaultID;
	public static int ParadoxFireDefaultID;
	public static int EnchBarkDefaultID;
	public static int EnchPlanksDefaultID;
	public static int EnchLeavesDefaultID;
	public static int TombStoneDefaultID;

	
	public static void initBlocks()
	{
		DeathWood = new BlockDeathWood(4042, "DeathWood").setUnlocalizedName("DeathWood").setHardness(1.0F).setStepSound(Block.soundWoodFootstep).setResistance(0.0F).setCreativeTab(ForbiddenLands.ForbiddenTab);
		DeathLeaves = new BlockDeathLeaves(4043, "DeathLeaves").setUnlocalizedName("DeathLeaves").setHardness(0.0F).setStepSound(Block.soundPowderFootstep).setResistance(0.0F).setCreativeTab(ForbiddenLands.ForbiddenTab);
		DeathPlanks = new BlockDeathPlanks(4044, "DeathPlanks").setUnlocalizedName("DeathPlanks").setHardness(1.0F).setStepSound(Block.soundWoodFootstep).setResistance(0.0F).setCreativeTab(ForbiddenLands.ForbiddenTab);
		DeadGrass = new BlockDeadGrass(4045, "DeadGrass").setUnlocalizedName("DeadGrass").setHardness(1.0F).setStepSound(Block.soundGrassFootstep).setResistance(0.0F).setCreativeTab(ForbiddenLands.ForbiddenTab);
		ThornShrub = new BlockThornShrub(4046, "ThornShrub").setUnlocalizedName("ThornShrub").setHardness(1.5F).setStepSound(Block.soundLadderFootstep).setResistance(1.0F).setCreativeTab(ForbiddenLands.ForbiddenTab);
		Thorns = new BlockThorns(4047, "Thorns").setUnlocalizedName("Thorns").setHardness(0.5F).setStepSound(Block.soundLadderFootstep).setResistance(1.0F).setCreativeTab(ForbiddenLands.ForbiddenTab);
		CorruptedBark = new BlockCorruptedBark(4048, "CorruptedBark").setUnlocalizedName("CorruptedBark").setHardness(0.7F).setStepSound(Block.soundLadderFootstep).setResistance(0.0F).setCreativeTab(ForbiddenLands.ForbiddenTab);
		//FBPortal = new BlockFBPortal(4049).setUnlocalizedName("FBPortal").setBlockUnbreakable().setStepSound(Block.soundGlassFootstep).setResistance(10.0F).setCreativeTab(CreativeTabs.tabAllSearch);
		ParadoxFire = new BlockParadoxFire(4050).setUnlocalizedName("ParadoxFire").setBlockUnbreakable().setStepSound(Block.soundAnvilFootstep).setResistance(0.0F).setCreativeTab(CreativeTabs.tabAllSearch);
		EnchBark = new BlockEnchantedBark(4051, "EnchBark").setUnlocalizedName("EnchBark").setHardness(1.0F).setStepSound(Block.soundPowderFootstep).setResistance(1.0F).setCreativeTab(ForbiddenLands.ForbiddenTab);
		EnchPlanks = new BlockEnchPlanks(4052, "EnchPlanks").setUnlocalizedName("EnchPlanks").setHardness(1.0F).setStepSound(Block.soundAnvilFootstep).setResistance(1.0F).setCreativeTab(CreativeTabs.tabDecorations);
		EnchLeaves = new BlockEnchLeaves(4053, "EnchLeaves").setUnlocalizedName("EnchLeaves").setHardness(1.0F).setStepSound(Block.soundAnvilFootstep).setResistance(1.0F).setCreativeTab(CreativeTabs.tabDecorations);
		TombStone = new BlockTombStone(4054, Material.rock).setUnlocalizedName("TombStone").setHardness(1.0F).setStepSound(Block.soundAnvilFootstep).setResistance(1.0F).setCreativeTab(CreativeTabs.tabDecorations).setTextureName("forbiddenlands:grave");
		
		GameRegistry.registerBlock(DeathWood, "DeathWood");
		GameRegistry.registerBlock(DeathLeaves, "DeathLeaves");
		GameRegistry.registerBlock(DeathPlanks, "DeathPlanks");
		GameRegistry.registerBlock(DeadGrass, "DeadGrass");
		GameRegistry.registerBlock(ThornShrub, "ThornShrub");
		GameRegistry.registerBlock(Thorns, "Thorns");
		GameRegistry.registerBlock(CorruptedBark, "CorruptedBark");
		GameRegistry.registerBlock(ParadoxFire, "ParadoxFire");
		GameRegistry.registerBlock(EnchBark, "EnchBark");
		GameRegistry.registerBlock(EnchPlanks, "EnchPlanks");
		GameRegistry.registerBlock(EnchLeaves, "EnchLeaves");
		GameRegistry.registerBlock(TombStone, "TombStone");
		GameRegistry.registerTileEntity(TileEntityTombStone.class, "TileEntityTombStone");
		
		LanguageRegistry.addName(DeathWood, "Death Log");
		LanguageRegistry.addName(DeathLeaves, "Death Leaves");
		LanguageRegistry.addName(DeathPlanks, "Death Planks");
		LanguageRegistry.addName(DeadGrass, "Dead Grass");
		LanguageRegistry.addName(ThornShrub, "Thorn Shrub");
		LanguageRegistry.addName(Thorns, "Deadly Sharp Thorns");
		LanguageRegistry.addName(CorruptedBark, "Corrupted Barks");
		LanguageRegistry.addName(ParadoxFire, "Paradox Fire");
		LanguageRegistry.addName(EnchBark, "Enchanted Bark");
		LanguageRegistry.addName(EnchPlanks, "Enchanted Planks");
		LanguageRegistry.addName(EnchLeaves, "Enchanted Leaves");
		LanguageRegistry.addName(TombStone, "Tomb Stone");
		
		MinecraftForge.addGrassPlant(ThornShrub, 0, 25);
		MinecraftForge.addGrassSeed(new ItemStack(Item.pumpkinSeeds), 25);
		MinecraftForge.addGrassSeed(new ItemStack(Item.melonSeeds), 25);
		MinecraftForge.addGrassSeed(new ItemStack(ThornShrub), 5);
		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ForbiddenBlocks.DeathPlanks), 1, 5, 25));
		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ForbiddenBlocks.DeathPlanks), 1, 5, 25));
				
		
	}

}