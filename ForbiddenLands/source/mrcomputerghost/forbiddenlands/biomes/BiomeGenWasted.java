package mrcomputerghost.forbiddenlands.biomes;

import java.util.Random;

import mrcomputerghost.forbiddenlands.worldgen.WorldGenEvilWell;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenDesertWells;
import net.minecraft.world.gen.feature.WorldGenDungeons;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.entity.monster.*;
import net.minecraft.world.biome.SpawnListEntry;

public class BiomeGenWasted extends BiomeGenBase
{
    public BiomeGenWasted(int par1)
    {
        super(par1);
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.topBlock = (byte)Block.dirt.blockID;
        this.fillerBlock = (byte)Block.dirt.blockID;
        this.theBiomeDecorator.treesPerChunk = -999;
        this.theBiomeDecorator.deadBushPerChunk = 2;
        this.theBiomeDecorator.reedsPerChunk = 50;
        this.theBiomeDecorator.cactiPerChunk = 10;
        this.waterColorMultiplier = 15745542;
        this.spawnableMonsterList.add(new SpawnListEntry(EntityZombie.class, 15, 15, 15));
        
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
    
    public int getSkyColorByTemp(float par1)
    {
        return 1;
    }

}
