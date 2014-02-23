package mrcomputerghost.forbiddenlands.biomes;

import java.util.Random;

import mrcomputerghost.forbiddenlands.worldgen.WorldGenEvilForest1;
import mrcomputerghost.forbiddenlands.worldgen.WorldGenEvilWell;
import net.minecraft.block.Block;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenDungeons;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class BiomeGenEvilForest extends BiomeGenBase
{
    

	public WorldGenMinable theWorldGenerator;

	public BiomeGenEvilForest(int par1)
    {
		
        super(par1);
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.theBiomeDecorator.treesPerChunk = 69;
        this.theBiomeDecorator.flowersPerChunk = -999;
        this.theBiomeDecorator.deadBushPerChunk = 1;
        this.theBiomeDecorator.mushroomsPerChunk = 87;
        this.theBiomeDecorator.reedsPerChunk = 10;
        this.theBiomeDecorator.clayPerChunk = 15;
        this.theBiomeDecorator.waterlilyPerChunk = 6;
        this.waterColorMultiplier = 15745542;
        this.spawnableMonsterList.add(new SpawnListEntry(EntitySlime.class, 15, 5, 5));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityCaveSpider.class, 5, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityWitch.class, 5, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityBat.class, 15, 5, 5));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityEnderman.class, 5, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityChicken.class, 5, 5, 5));
        this.spawnableMonsterList.add(new SpawnListEntry(EntitySkeleton.class, 1, 0, 1));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityWither.class, (int) 0.5, 0, 1));
        this.theWorldGenerator = new WorldGenMinable(Block.silverfish.blockID, 25);
        this.theWorldGenerator = new WorldGenMinable(Block.pumpkin.blockID, 15);
        this.theWorldGenerator = new WorldGenMinable(Block.oreGold.blockID, 10);
        this.theWorldGenerator = new WorldGenMinable(Block.oreLapis.blockID, 10);
        this.theWorldGenerator = new WorldGenMinable(Block.oreEmerald.blockID, 10);
        
        
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
    {
    	return new WorldGenEvilForest1();
    }

    @SideOnly(Side.CLIENT)

    /**
     * Provides the basic grass color based on the biome temperature and rainfall
     */
    public int getBiomeGrassColor()
    {
        double d0 = (double)this.getFloatTemperature();
        double d1 = (double)this.getFloatRainfall();
        return ((ColorizerGrass.getGrassColor(d0, d1) & 16711422) + 5115470) / 2;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Provides the basic foliage color based on the biome temperature and rainfall
     */
    public int getBiomeFoliageColor()
    {
        double d0 = (double)this.getFloatTemperature();
        double d1 = (double)this.getFloatRainfall();
        return ((ColorizerFoliage.getFoliageColor(d0, d1) & 16711422) + 5115470) / 2;
    }
    
    public int getSkyColorByTemp(float par1)
    {
        return 0;
    }
    
    public void decorate(World par1World, Random par2Random, int par3, int par4)
    {
        super.decorate(par1World, par2Random, par3, par4);

        if (par2Random.nextInt(42) == 0)
        {
            int k = par3 + par2Random.nextInt(16) + 8;
            int l = par4 + par2Random.nextInt(16) + 8;
            WorldGenEvilWell worldgenevilwell = new WorldGenEvilWell();
            worldgenevilwell.generate(par1World, par2Random, k, par1World.getHeightValue(k, l) + 1, l);
        }
        if (par2Random.nextInt(16) == 2)
        {
            int k = par3 + par2Random.nextInt(16) + 8;
            int l = par4 + par2Random.nextInt(16) + 8;
            WorldGenDungeons worldgendungeons = new WorldGenDungeons();
            worldgendungeons.generate(par1World, par2Random, k, par1World.getHeightValue(k, l) + 1, l);
        }
    }
}
