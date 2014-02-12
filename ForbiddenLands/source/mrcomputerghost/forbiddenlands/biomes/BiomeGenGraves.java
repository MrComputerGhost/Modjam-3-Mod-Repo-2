package mrcomputerghost.forbiddenlands.biomes;

import java.util.Random;

import mrcomputerghost.forbiddenlands.worldgen.WorldGenCrypt;
import mrcomputerghost.forbiddenlands.worldgen.WorldGenEnchTree;
import mrcomputerghost.forbiddenlands.worldgen.WorldGenEvilWell;
import mrcomputerghost.forbiddenlands.worldgen.WorldGenGrave;
import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenDungeons;
import net.minecraft.world.gen.feature.WorldGenSwamp;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeGenGraves extends BiomeGenBase
{
    public BiomeGenGraves(int par1)
    {
        super(par1);
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.topBlock = (byte)Block.mycelium.blockID;
        this.fillerBlock = (byte)Block.cobblestone.blockID;
        this.theBiomeDecorator.treesPerChunk = -999;
        this.theBiomeDecorator.deadBushPerChunk = 2;
        this.theBiomeDecorator.reedsPerChunk = 50;
        this.theBiomeDecorator.cactiPerChunk = 10;
        this.theBiomeDecorator.flowersPerChunk = -999;
        this.theBiomeDecorator.grassPerChunk = -999;
        this.spawnableMonsterList.add(new SpawnListEntry(EntityZombie.class, 15, 15, 15));
        this.spawnableMonsterList.add(new SpawnListEntry(EntitySkeleton.class, 1, 1, 5));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityBat.class, 15, 15, 15));
        
    }
    
    public void decorate(World par1World, Random par2Random, int par3, int par4)
    {
        super.decorate(par1World, par2Random, par3, par4);

        if (par2Random.nextInt(10) == 0)
        {
            int k = par3 + par2Random.nextInt(16) + 8;
            int l = par4 + par2Random.nextInt(16) + 8;
            WorldGenCrypt worldgenevilwell = new WorldGenCrypt();
            worldgenevilwell.generate(par1World, par2Random, k, par1World.getHeightValue(k, l) + 1, l);
        }
        if (par2Random.nextInt(100) != 0)
        {
            int k = par3 + par2Random.nextInt(16) + 8;
            int l = par4 + par2Random.nextInt(16) + 8;
            WorldGenGrave worldgenevilwell = new WorldGenGrave();
            worldgenevilwell.generate(par1World, par2Random, k, par1World.getHeightValue(k, l) + 1, l);
        }
        
    }
    
    public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
    {
        return new WorldGenGrave();
    }
    
    public int getSkyColorByTemp(float par1)
    {
        return 0;
    }
    
}
