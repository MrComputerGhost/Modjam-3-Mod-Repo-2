package mrcomputerghost.forbiddenlands;

import java.util.logging.Logger;

import mrcomputerghost.forbiddenlands.biomes.BiomeGenCorruptedForest;
import mrcomputerghost.forbiddenlands.biomes.BiomeGenEnchantedForest;
import mrcomputerghost.forbiddenlands.biomes.BiomeGenEvilForest;
import mrcomputerghost.forbiddenlands.biomes.BiomeGenGraves;
import mrcomputerghost.forbiddenlands.biomes.BiomeGenThorns;
import mrcomputerghost.forbiddenlands.biomes.BiomeGenWasted;
import mrcomputerghost.forbiddenlands.blocks.ForbiddenBlocks;
import mrcomputerghost.forbiddenlands.items.ForbiddenItems;
import mrcomputerghost.forbiddenlands.lib.ForbiddenRecipes;
import mrcomputerghost.forbiddenlands.worldgen.WorldGenGrave;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;



@Mod (modid = "ForbiddenLands", name = "Forbidden Lands", version = "4.4")
@NetworkMod (clientSideRequired = true, serverSideRequired = false)
public class ForbiddenLands 
{
	
	public static final Logger logger = Logger.getLogger("ForbiddenLands");
			
	@Instance("ForbiddenLands")
	public static ForbiddenLands instance;
        
	@SidedProxy(clientSide = "mrcomputerghost.forbiddenlands.ClientProxy", serverSide = "mrcomputerghost.forbiddenlands.CommonProxy")
	public static CommonProxy proxy; 
    
	public static CreativeTabs ForbiddenTab = new ForbiddenCreativeTab(CreativeTabs.getNextID(), "Forbidden Lands");
	//Dimension ID's
	public static int ForbiddenDimID = 42;
	public static int ParadoxDimID = -42;
	//Biomes  
	public static BiomeGenBase CorruptedBiome;
	public static BiomeGenBase ForbiddenLandsBiome;
	public static BiomeGenBase ThornForest;
	public static BiomeGenBase Wasted;
	public static BiomeGenBase EnchantedForest;
	public static BiomeGenBase EnchantedForestHills;
	public static BiomeGenBase Graveyard;
	public static BiomeGenBase ForbiddenHills;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		proxy.init();
        
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();
		
        ForbiddenBlocks.DeathWoodDefaultID = config.getBlock("Death Logs", 4042).getInt();
        ForbiddenBlocks.DeathLeavesDefaultID = config.getBlock("Death Leaves", 4043).getInt();
        ForbiddenBlocks.DeathPlanksDefaultID = config.getBlock("Death Planks", 4044).getInt();
        ForbiddenBlocks.ParadoxBlockDefaultID = config.getBlock("Dead Grass", 4045).getInt();
        ForbiddenBlocks.ThornShrubDefaultID = config.getBlock("Thorn Shrub", 4046).getInt();
        ForbiddenBlocks.ThornsDefaultID = config.getBlock("Thorns", 4047).getInt();
        ForbiddenBlocks.CorruptedBarkDefaultID = config.getBlock("Corrupted Bark", 4048).getInt();
        BiomeGenThorns.useOldThornBushes = config.get("Biome Stuff", "Use Old Thorn Bushes", false).getBoolean(false);
        WorldGenGrave.useCustomGrave = config.get("Biome Stuff", "Use Custom Grave", true).getBoolean(true);
        
        config.save();
        
        ForbiddenBlocks.initBlocks();
        logger.info("Initialized " + "Forbidden Lands Blocks");
        ForbiddenItems.initItems();
        logger.info("Initialized " + "Forbidden Lands Items");
        ForbiddenRecipes.initRecipes();
        logger.info("Initialized " + "Forbidden Lands Recipes");
        
        AchievementPage.registerAchievementPage(new ForbiddenAchievementPage());
        
		//Biomes
		CorruptedBiome = new BiomeGenCorruptedForest(41).setColor(00000).setBiomeName("Corrupted Forest").setMinMaxHeight(0.5F, 1.0F).setDisableRain();
        ForbiddenLandsBiome = new BiomeGenEvilForest(42).setColor(616363).setBiomeName("Forbidden Lands").func_76733_a(9154376).setMinMaxHeight(0.3F, 0.5F).setDisableRain();
		ThornForest = new BiomeGenThorns(43).setColor(616363).setBiomeName("Thorn Forest").func_76733_a(9154376).setMinMaxHeight(0.3F, 0.5F).setDisableRain();
		Wasted = new BiomeGenWasted(44).setColor(616363).setBiomeName("Wasteland\n(May Be Replaced!)").func_76733_a(9154376).setMinMaxHeight(-0.1F, 0.0F).setDisableRain();
		EnchantedForest = new BiomeGenEnchantedForest(45).setColor(616363).setBiomeName("Enchanted Forest").setMinMaxHeight(0.2F, 0.5F).setDisableRain();
		EnchantedForestHills = new BiomeGenEnchantedForest(46).setColor(616363).setBiomeName("Enchanted Forest Mountains").setMinMaxHeight(0.8F, 1.0F).setDisableRain();
		Graveyard = new BiomeGenGraves(47).setColor(616363).setBiomeName("Graveyard").setMinMaxHeight(0.2F, 0.4F).setDisableRain();
		ForbiddenHills = new BiomeGenEvilForest(48).setColor(616363).setBiomeName("Forbidden Forest Mountains").setMinMaxHeight(0.8F, 1.0F).setDisableRain();
		
		/**GameRegistry.addBiome(ForbiddenLandsBiome);
		GameRegistry.addBiome(ThornForest);
		GameRegistry.addBiome(Wasted);
		GameRegistry.addBiome(EnchantedForest);
		GameRegistry.addBiome(EnchantedForestHills);
		GameRegistry.addBiome(Graveyard);
		GameRegistry.addBiome(ForbiddenHills);
		BiomeManager.addSpawnBiome(ForbiddenLandsBiome);
		BiomeManager.addSpawnBiome(ThornForest);
		BiomeManager.addSpawnBiome(Wasted);
		BiomeManager.addSpawnBiome(EnchantedForest);
		BiomeManager.addSpawnBiome(EnchantedForestHills);
		BiomeManager.addSpawnBiome(Graveyard);**/
		GameRegistry.addBiome(CorruptedBiome);
		BiomeManager.addSpawnBiome(CorruptedBiome);
		BiomeManager.addVillageBiome(EnchantedForest, true);
		BiomeManager.addVillageBiome(EnchantedForestHills, true);
		BiomeManager.addVillageBiome(Wasted, false);
		BiomeManager.addVillageBiome(ForbiddenLandsBiome, false);
		BiomeManager.addStrongholdBiome(ForbiddenLandsBiome);
		BiomeManager.addStrongholdBiome(EnchantedForestHills);
		BiomeManager.addStrongholdBiome(Graveyard);
		BiomeManager.addStrongholdBiome(CorruptedBiome);
		BiomeDictionary.registerAllBiomesAndGenerateEvents();
		proxy.registerRenderers();
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
	}
	
	@EventHandler
    public void load(FMLInitializationEvent event)
    {
		//Register WorldProvider for Dimension
		/**DimensionManager.registerProviderType(ForbiddenDimID, WorldProviderForbidden.class, true);
		DimensionManager.registerDimension(ForbiddenDimID, ForbiddenDimID);**/
    }
    
	
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	logger.info("Forbidden Lands Mod Loaded Up!");
    }
    
    
	public ForbiddenLands() 
	{
		
		//JOptionPane.showMessageDialog(null, "Warning: \n This version of Forbidden Lands is very unstable \n and will most likely break. \n You have been warned.", null, JOptionPane.WARNING_MESSAGE);
		
	}
	
}
