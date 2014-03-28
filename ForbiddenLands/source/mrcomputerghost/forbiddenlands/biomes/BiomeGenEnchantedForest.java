package mrcomputerghost.forbiddenlands.biomes;

import java.util.Random;

import mrcomputerghost.forbiddenlands.worldgen.WorldGenEnchTree;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenTaiga1;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeGenEnchantedForest extends BiomeGenBase
{
    
	public WorldGenMinable theWorldGenerator;
	
	public BiomeGenEnchantedForest(int par1)
    {
        super(par1);
        this.theBiomeDecorator.treesPerChunk = 18;
        this.theBiomeDecorator.flowersPerChunk = 58;
        this.theBiomeDecorator.grassPerChunk = 24;
        this.theBiomeDecorator.mushroomsPerChunk = 18;
        this.theBiomeDecorator.bigMushroomsPerChunk = 4;
        this.waterColorMultiplier = 15745542;
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCreatureList.add(new SpawnListEntry(EntityBat.class, 8, 4, 8));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityZombie.class, 2, 4, 8));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityCow.class, 5, 5, 5));
        this.theWorldGenerator = new WorldGenMinable(Block.blockLapis.blockID, 25);
        this.theWorldGenerator = new WorldGenMinable(Block.oreEmerald.blockID, 10);
        
    }
    
    public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
    {
        return new WorldGenEnchTree(true);
    }
    
    public int getSkyColorByTemp(float par1)
    {
        return 1;
    }
}

