package mrcomputerghost.forbiddenlands.biomes;

import java.util.Random;

import mrcomputerghost.forbiddenlands.blocks.ForbiddenBlocks;
import mrcomputerghost.forbiddenlands.worldgen.WorldGenEvilForest3;
import mrcomputerghost.forbiddenlands.worldgen.WorldGenPortal;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BiomeGenCorruptedForest extends BiomeGenBase
{

	public BiomeGenCorruptedForest(int par1) {
		super(par1);
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.theBiomeDecorator.treesPerChunk = 0;
        this.theBiomeDecorator.flowersPerChunk = 0;
        this.theBiomeDecorator.deadBushPerChunk = 15;
        this.theBiomeDecorator.mushroomsPerChunk = 0;
        this.theBiomeDecorator.reedsPerChunk = 0;
        this.theBiomeDecorator.clayPerChunk = 0;
        this.theBiomeDecorator.waterlilyPerChunk = 0;
        this.waterColorMultiplier = 00000000;
	}
	
	public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
    {
    	return new WorldGenEvilForest3(ForbiddenBlocks.CorruptedBark.blockID);
    }
	
	@SideOnly(Side.CLIENT)

    /**
     * Provides the basic grass color based on the biome temperature and rainfall
     */
    public int getBiomeGrassColor()
    {
        double d0 = (double)this.getFloatTemperature();
        double d1 = (double)this.getFloatRainfall();
        return ((ColorizerGrass.getGrassColor(d0, d1) & 00000000) + 0000000) * 0;
    }
	
	public int getSkyColorByTemp(float par1)
    {
        return 0;
    }
	
	public void decorate(World par1World, Random par2Random, int par3, int par4)
    {
        super.decorate(par1World, par2Random, par3, par4);

        if (par2Random.nextInt(16) == 2)
        {
            int k = par3 + par2Random.nextInt(16) + 8;
            int l = par4 + par2Random.nextInt(16) + 8;
            WorldGenPortal worldgendungeons = new WorldGenPortal();
            worldgendungeons.generate(par1World, par2Random, k, par1World.getHeightValue(k, l) + 1, l);
            
        }
        
        
    }
	
	

}
