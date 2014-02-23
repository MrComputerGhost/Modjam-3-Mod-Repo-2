package mrcomputerghost.forbiddenlands.lib;

import mrcomputerghost.forbiddenlands.blocks.ForbiddenBlocks;
import mrcomputerghost.forbiddenlands.items.ForbiddenItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import cpw.mods.fml.common.registry.GameRegistry;

public class ForbiddenRecipes {

    
    public static void initRecipes()
    {    
    	FurnaceRecipes.smelting().addSmelting(ForbiddenBlocks.DeathWood.blockID, 0, new ItemStack(ForbiddenBlocks.CorruptedBark, 1, 0), 1.0f);
    	//FurnaceRecipes.smelting().addSmelting(ForbiddenItems.ParadoxShard.itemID, 0, new ItemStack(ForbiddenItems.ParadoxCrystal, 1, 0), 1.0f);
    	FurnaceRecipes.smelting().addSmelting(ForbiddenItems.ParadoxDust.itemID, 0, new ItemStack(ForbiddenItems.ParadoxShard, 1, 0), 1.0f);
		GameRegistry.addShapelessRecipe(new ItemStack(ForbiddenBlocks.DeathPlanks, 4), new Object[]{new ItemStack(ForbiddenBlocks.DeathWood)});
		GameRegistry.addShapelessRecipe(new ItemStack(ForbiddenItems.ParadoxCrystal, 1), new Object[]{new ItemStack(ForbiddenItems.ParadoxShard), new ItemStack(ForbiddenItems.ParadoxShard), new ItemStack(ForbiddenItems.ParadoxShard), new ItemStack(ForbiddenItems.ParadoxShard), new ItemStack(ForbiddenItems.ParadoxShard), new ItemStack(ForbiddenItems.ParadoxShard), new ItemStack(ForbiddenItems.ParadoxShard), new ItemStack(ForbiddenItems.ParadoxShard), new ItemStack(ForbiddenItems.ParadoxShard)});
		GameRegistry.addShapelessRecipe(new ItemStack(ForbiddenBlocks.Thorns, 1), new Object[]{new ItemStack(ForbiddenBlocks.ThornShrub)});
		GameRegistry.addShapelessRecipe(new ItemStack(Item.stick, 4), new Object[]{new ItemStack(ForbiddenBlocks.DeathPlanks), new ItemStack(ForbiddenBlocks.DeathPlanks)});
		GameRegistry.addShapelessRecipe(new ItemStack(Block.workbench), new Object[]{new ItemStack(ForbiddenBlocks.DeathPlanks), new ItemStack(ForbiddenBlocks.DeathPlanks), new ItemStack(ForbiddenBlocks.DeathPlanks), new ItemStack(ForbiddenBlocks.DeathPlanks)});
		GameRegistry.addShapelessRecipe(new ItemStack(ForbiddenItems.Rider, 4), new Object[]{new ItemStack(Item.leash), new ItemStack(Item.saddle)});
		GameRegistry.addRecipe(new ItemStack(Item.swordWood, 1),new Object[]{"0L0", "0L0", "0S0", 'L', ForbiddenBlocks.DeathPlanks, 'S', Item.stick});
		GameRegistry.addRecipe(new ItemStack(Item.pickaxeWood, 1),new Object[]{"LLL", "0S0", "0S0", 'L', ForbiddenBlocks.DeathPlanks, 'S', Item.stick});
		GameRegistry.addRecipe(new ItemStack(Item.shovelWood, 1),new Object[]{"0L0", "0S0", "0S0", 'L', ForbiddenBlocks.DeathPlanks, 'S', Item.stick});
		GameRegistry.addRecipe(new ItemStack(Item.axeWood, 1),new Object[]{"0LL", "0SL", "0S0", 'L', ForbiddenBlocks.DeathPlanks, 'S', Item.stick});
		GameRegistry.addRecipe(new ItemStack(Item.hoeWood, 1),new Object[]{"0LL", "0S0", "0S0", 'L', ForbiddenBlocks.DeathPlanks, 'S', Item.stick});
		GameRegistry.addRecipe(new ItemStack(Block.chest), new Object[]{"WWW", "W0W", "WWW", 'W', ForbiddenBlocks.DeathPlanks});
        GameRegistry.addRecipe(new ItemStack(Item.saddle), new Object[]{"ABA", "AAA", "S00", 'A', Item.leather, 'B', Block.cloth, 'S', Item.silk});   
        GameRegistry.addRecipe(new ItemStack(ForbiddenItems.ParadoxPick), new Object[]{"AAA", "0S0", "0S0", 'A', ForbiddenItems.ParadoxCrystal, 'S', Item.stick});
        GameRegistry.addRecipe(new ItemStack(ForbiddenItems.ParadoxSword), new Object[]{"0A0", "0A0", "0S0", 'A', ForbiddenItems.ParadoxCrystal, 'S', Item.stick});
        GameRegistry.addRecipe(new ItemStack(ForbiddenBlocks.TombStone), new Object[]{"0A0", "AAA", "AAA", 'A', Block.cobblestone});
        GameRegistry.addRecipe(new ItemStack(ForbiddenItems.ParadoxBow), new Object[]{"SA0", "SBA", "SA0", 'A', Block.wood, 'S', Item.silk, 'B', ForbiddenItems.Rider});
        GameRegistry.addRecipe(new ItemStack(ForbiddenItems.ParadoxStaff), new Object[]{"IPI", "0I0", "0I0", 'I', Block.blockGold, 'P', ForbiddenItems.ParadoxCrystal});
        GameRegistry.addShapelessRecipe(new ItemStack(ForbiddenBlocks.EnchPlanks, 4), new Object[]{new ItemStack(ForbiddenBlocks.EnchBark)});
		GameRegistry.addShapelessRecipe(new ItemStack(ForbiddenBlocks.Thorns, 1), new Object[]{new ItemStack(ForbiddenBlocks.ThornShrub)});
		GameRegistry.addShapelessRecipe(new ItemStack(Item.stick, 4), new Object[]{new ItemStack(ForbiddenBlocks.EnchPlanks), new ItemStack(ForbiddenBlocks.EnchPlanks)});
		GameRegistry.addShapelessRecipe(new ItemStack(Block.workbench), new Object[]{new ItemStack(ForbiddenBlocks.EnchPlanks), new ItemStack(ForbiddenBlocks.EnchPlanks), new ItemStack(ForbiddenBlocks.EnchPlanks), new ItemStack(ForbiddenBlocks.EnchPlanks)});
		GameRegistry.addShapelessRecipe(new ItemStack(ForbiddenItems.Rider, 4), new Object[]{new ItemStack(Item.leash), new ItemStack(Item.saddle)});
		GameRegistry.addRecipe(new ItemStack(Item.swordWood, 1),new Object[]{"0L0", "0L0", "0S0", 'L', ForbiddenBlocks.EnchPlanks, 'S', Item.stick});
		GameRegistry.addRecipe(new ItemStack(Item.pickaxeWood, 1),new Object[]{"LLL", "0S0", "0S0", 'L', ForbiddenBlocks.EnchPlanks, 'S', Item.stick});
		GameRegistry.addRecipe(new ItemStack(Item.shovelWood, 1),new Object[]{"0L0", "0S0", "0S0", 'L', ForbiddenBlocks.EnchPlanks, 'S', Item.stick});
		GameRegistry.addRecipe(new ItemStack(Item.axeWood, 1),new Object[]{"0LL", "0SL", "0S0", 'L', ForbiddenBlocks.EnchPlanks, 'S', Item.stick});
		GameRegistry.addRecipe(new ItemStack(Item.hoeWood, 1),new Object[]{"0LL", "0S0", "0S0", 'L', ForbiddenBlocks.EnchPlanks, 'S', Item.stick});
		GameRegistry.addRecipe(new ItemStack(Block.chest), new Object[]{"WWW", "W0W", "WWW", 'W', ForbiddenBlocks.EnchPlanks});
        GameRegistry.addRecipe(new ItemStack(Item.saddle), new Object[]{"ABA", "AAA", "S00", 'A', Item.leather, 'B', Block.cloth, 'S', Item.silk});   
        //GameRegistry.addRecipe(new ItemStack(Item.saddle), new Object[]{"ABA", "AAA", "S00", 'A', Item.leather, 'B', Block.cloth, 'S', Item.silk});   
        GameRegistry.addShapelessRecipe(new ItemStack(ForbiddenItems.PureBarkChunk, 1), new Object[]{new ItemStack(ForbiddenItems.ParadoxShard)});
    }
}