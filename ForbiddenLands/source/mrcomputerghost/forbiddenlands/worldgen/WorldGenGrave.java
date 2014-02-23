package mrcomputerghost.forbiddenlands.worldgen;

import java.util.Random;

import mrcomputerghost.forbiddenlands.blocks.ForbiddenBlocks;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.ChestGenHooks;

public class WorldGenGrave extends WorldGenerator {
	
	int customGraveID;
	public static boolean useCustomGrave = true;

	public int[] GetValidSpawnBlocks() {
		return new int[] { Block.dirt.blockID, Block.grass.blockID,
				Block.mycelium.blockID };
	}
	
	
	
	public boolean LocationIsValidSpawn(World world, int i, int j, int k) {
		int distanceToAir = 0;
		int checkID = world.getBlockId(i, j, k);

		while (checkID != 0) {
			distanceToAir++;
			checkID = world.getBlockId(i, j + distanceToAir, k);
		}

		if (distanceToAir > 3) {
			return false;
		}
		j += distanceToAir - 1;

		int blockID = world.getBlockId(i, j, k);
		int blockIDAbove = world.getBlockId(i, j + 1, k);
		int blockIDBelow = world.getBlockId(i, j - 1, k);
		for (int x : GetValidSpawnBlocks()) {
			if (blockIDAbove != 0) {
				return false;
			}
			if (blockID == x) {
				return true;
			} else if (blockID == Block.snow.blockID && blockIDBelow == x) {
				return true;
			}
		}
		return false;
	}

	public WorldGenGrave() {
		if (useCustomGrave) customGraveID = ForbiddenBlocks.TombStone.blockID;
		else if (!useCustomGrave) customGraveID = Block.stoneDoubleSlab.blockID;
	}

	public boolean generate(World world, Random rand, int i, int j, int k) {
		// check that each corner is one of the valid spawn blocks
		if (!LocationIsValidSpawn(world, i, j, k)
				|| !LocationIsValidSpawn(world, i + 0, j, k)
				|| !LocationIsValidSpawn(world, i + 0, j, k + 2)
				|| !LocationIsValidSpawn(world, i, j, k + 2)) {
			return false;
		}
		System.out.println("Graves at " + i + ", " + k);
		world.setBlock(i + 0, j - 1, k + 0, Block.slowSand.blockID);
		world.setBlock(i + 0, j - 1, k + 1, Block.slowSand.blockID);
		world.setBlock(i + 0, j - 1, k + 2, Block.slowSand.blockID);
		world.setBlock(i + 0, j + 0, k + 2, this.customGraveID);
		world.setBlock(i + 2, j - 1, k + 0, Block.slowSand.blockID);
		world.setBlock(i + 2, j - 1, k + 1, Block.slowSand.blockID);
		world.setBlock(i + 2, j - 1, k + 2, Block.slowSand.blockID);
		world.setBlock(i + 2, j + 0, k + 2, this.customGraveID);
		world.setBlock(i + 3, j - 3, k + 1, Block.chest.blockID);
		TileEntityChest tileentitychest = (TileEntityChest)world.getBlockTileEntity(i + 2, j - 2, k + 2);
        if (tileentitychest != null)
        {
            ChestGenHooks info = ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST);
            WeightedRandomChestContent.generateChestContents(rand, info.getItems(rand), tileentitychest, info.getCount(rand));
        }
		world.setBlock(i - 4, j - 1, k + 0, Block.slowSand.blockID);
		world.setBlock(i - 4, j - 1, k + 1, Block.slowSand.blockID);
		world.setBlock(i - 4, j - 1, k + 2, Block.slowSand.blockID);
		world.setBlock(i - 4, j + 0, k + 2, this.customGraveID);
		world.setBlock(i - 2, j - 1, k + 0, Block.slowSand.blockID);
		world.setBlock(i - 2, j - 1, k + 1, Block.slowSand.blockID);
		world.setBlock(i - 2, j - 1, k + 2, Block.slowSand.blockID);
		world.setBlock(i - 2, j + 0, k + 2, this.customGraveID);;

		return true;
	}
}