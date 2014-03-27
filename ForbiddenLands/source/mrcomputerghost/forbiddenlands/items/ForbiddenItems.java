package mrcomputerghost.forbiddenlands.items;

import mrcomputerghost.forbiddenlands.ForbiddenLands;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ForbiddenItems {
	
	public static Item PureBark;
	public static Item Rider;
	public static Item Stacker;
	public static Item PureBarkChunk;
	public static Item ParadoxDust;
	public static Item ParadoxCrystal;
	public static Item ParadoxShard;
	public static Item ParadoxSword;
	public static Item ParadoxPick;
	public static Item ParadoxBow;
	public static Item ParadoxHelm;
	public static Item ParadoxChest;
	public static Item ParadoxLegs;
	public static Item ParadoxBoots;
	public static Item StabbbingKnife;
	public static Item Debugger;
	public static Item LParadoxCrystal;
	public static Item ParadoxStaff;
	
	public static int PureBarkDefaultID = 4242;
	public static int RiderDefaultID = 4243;
	public static int StackerDefaultID = 4244;
	public static int PureBarkChunkDefaultID = 4245;
	public static int ParadoxDustDefaultID = 4246;
	public static int ParadoxCrystalDefaultID = 4247;
	public static int ParadoxShardDefaultID = 4248;
	public static int ParadoxSwordDefaultID = 4249;
	public static int ParadoxPickDefaultID = 4250;
	public static int ParadoxBowDefaultID = 4251;
	public static int ParadoxHelmDefaultID = 4252;
	public static int ParadoxChestDefaultID = 4253;
	public static int ParadoxLegsDefaultID = 4254;
	public static int ParadoxBootsDefaultID = 4255;
	public static int StabbingKnifeDefaultID = 4256;
	public static int DebuggerDefaultID = 4257;
	public static int LParadoxCrystalDefaultID = 4258;
	public static int ParadoxStaffDefaultID = 4259;
	
	public static final EnumToolMaterial EnumToolParadox = EnumHelper.addToolMaterial("Paradox", 3, 2570, 10.0F, 4.5F, 35);
	public static final EnumToolMaterial EnumToolStab = EnumHelper.addToolMaterial("Paradox", 3, 2570, 6.0F, 4.5F, 50);
	public static final EnumArmorMaterial EnumArmorParadox = EnumHelper.addArmorMaterial("Paradox", 33, new int[]{3, 8, 6, 3}, 35);
	
	
	public static void initItems()
    {
		PureBark = new ItemPureBark(PureBarkDefaultID).setUnlocalizedName("Pure Bark").setTextureName("forbiddenlands:purebark").setCreativeTab(ForbiddenLands.ForbiddenTab);
        GameRegistry.registerItem(PureBark, "Pure Bark");
        LanguageRegistry.addName(PureBark, "Purified Bark");
        Rider = new ItemRider(RiderDefaultID).setUnlocalizedName("Rider").setTextureName("minecraft:lead").setCreativeTab(ForbiddenLands.ForbiddenTab);
		GameRegistry.registerItem(Rider, "Rider");
		LanguageRegistry.addName(Rider, "Rider");
		Stacker = new ItemStacker(StackerDefaultID).setUnlocalizedName("Stacker").setTextureName("minecraft:lead");
		GameRegistry.registerItem(Stacker, "Stacker");
		LanguageRegistry.addName(Stacker, "Rider");
		PureBarkChunk = new ItemPureBarkChunk(PureBarkChunkDefaultID).setUnlocalizedName("Pure Bark Chunk").setTextureName("forbiddenlands:purebarkchunk").setCreativeTab(ForbiddenLands.ForbiddenTab);
		GameRegistry.registerItem(PureBarkChunk, "Pure Bark Chunk");
		LanguageRegistry.addName(PureBarkChunk, "Purified Bark Chunk");
		ParadoxDust = new ItemParadoxDust(ParadoxDustDefaultID).setUnlocalizedName("Paradox Dust").setTextureName("forbiddenlands:paradoxdust").setCreativeTab(ForbiddenLands.ForbiddenTab);
		GameRegistry.registerItem(ParadoxDust, "Paradox Dust");
		LanguageRegistry.addName(ParadoxDust, "Paradox Dust");
		ParadoxCrystal = new ItemParadoxCrystal(ParadoxCrystalDefaultID).setUnlocalizedName("Paradox Crystal").setTextureName("forbiddenlands:paradoxcrystal").setCreativeTab(ForbiddenLands.ForbiddenTab);
		GameRegistry.registerItem(ParadoxCrystal, "Paradox Crystal");
		LanguageRegistry.addName(ParadoxCrystal, "Paradox Crystal");
		ParadoxShard = new ItemParadoxShard(ParadoxShardDefaultID).setUnlocalizedName("Paradox Shard").setTextureName("forbiddenlands:paradoxshard").setCreativeTab(ForbiddenLands.ForbiddenTab);
		GameRegistry.registerItem(ParadoxShard, "Paradox Shard");
		LanguageRegistry.addName(ParadoxShard, "Paradox Shard");
		ParadoxSword = new ItemParadoxSword(ParadoxSwordDefaultID, EnumToolParadox).setUnlocalizedName("Paradox Sword").setTextureName("forbiddenlands:paradoxsword").setCreativeTab(ForbiddenLands.ForbiddenTab);
		GameRegistry.registerItem(ParadoxSword, "Paradox Sword");
		LanguageRegistry.addName(ParadoxSword, "Paradox Sword");
		ParadoxPick = new ItemParadoxPick(ParadoxPickDefaultID, EnumToolParadox).setUnlocalizedName("Paradox Pick").setTextureName("forbiddenlands:paradoxpick").setCreativeTab(ForbiddenLands.ForbiddenTab);
		GameRegistry.registerItem(ParadoxPick, "Paradox Pick");
		LanguageRegistry.addName(ParadoxPick, "Paradox Pick");
		//ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ParadoxDust), 3, 5, 25));
		//ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ParadoxShard), 1, 4, 20));
		//ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ParadoxShard), 1, 2, 10));
		ParadoxBow = new ItemParadoxBow(ParadoxBowDefaultID).setUnlocalizedName("Paradox Bow").setTextureName("forbiddenlands:bonebow").setCreativeTab(ForbiddenLands.ForbiddenTab);
		GameRegistry.registerItem(ParadoxBow, "Paradox Bow");
		LanguageRegistry.addName(ParadoxBow, "Paradox Rocket");
		/**StabbbingKnife = new ItemStabbingKnife(StabbingKnifeDefaultID, EnumToolStab).setUnlocalizedName("Stabbing Knife").setTextureName("forbiddenlands:StabbingKnife").setCreativeTab(ForbiddenLands.ForbiddenTab);
		GameRegistry.registerItem(StabbbingKnife, "Stabbing Knife");
		LanguageRegistry.addName(StabbbingKnife, "Stabbing Knife");**/
		Debugger = new ItemDebugger(DebuggerDefaultID).setUnlocalizedName("Debugger").setTextureName("minecraft:command");
		GameRegistry.registerItem(Debugger, "Debugger");
		LanguageRegistry.addName(Debugger, "Debugger");
		ParadoxStaff = new ItemParadoxStaff(ParadoxStaffDefaultID, EnumToolParadox).setUnlocalizedName("ParadoxStaff");
		GameRegistry.registerItem(ParadoxStaff, "ParadoxStaff");
		LanguageRegistry.addName(ParadoxStaff, "Paradox Staff");
		/*ParadoxHelm = (new ItemParadoxArmor(ParadoxHelmDefaultID, EnumArmorParadox, 0).setUnlocalizedName("Paradox Helm").setCreativeTab(ForbiddenLands.ForbiddenTab));
		ParadoxChest = (new ItemParadoxArmor(ParadoxChestDefaultID, EnumArmorParadox, 1).setUnlocalizedName("Paradox Chest").setCreativeTab(ForbiddenLands.ForbiddenTab));
		ParadoxLegs = (new ItemParadoxArmor(ParadoxLegsDefaultID, EnumArmorParadox, 2).setUnlocalizedName("Paradox Legs").setCreativeTab(ForbiddenLands.ForbiddenTab));
		ParadoxBoots = (new ItemParadoxArmor(ParadoxBootsDefaultID, EnumArmorParadox, 3).setUnlocalizedName("Paradox Boots").setCreativeTab(ForbiddenLands.ForbiddenTab));
		LanguageRegistry.addName(ParadoxHelm, "Paradox Helmet");
		LanguageRegistry.addName(ParadoxChest, "Paradox Chestplate");
		LanguageRegistry.addName(ParadoxLegs, "Paradox Leggings");
		LanguageRegistry.addName(ParadoxBoots, "Paradox Boots");
		GameRegistry.registerItem(ParadoxHelm, "Paradox Helm");
		GameRegistry.registerItem(ParadoxChest, "Paradox Chest");
		GameRegistry.registerItem(ParadoxLegs, "Paradox Legs");
		GameRegistry.registerItem(ParadoxBoots, "Paradox Boots");*/
		
		
	}

}
