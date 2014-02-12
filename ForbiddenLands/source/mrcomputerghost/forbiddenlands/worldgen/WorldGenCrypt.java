package mrcomputerghost.forbiddenlands.worldgen;

import java.util.Random;

import mrcomputerghost.forbiddenlands.blocks.ForbiddenBlocks;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.ChestGenHooks;


public class WorldGenCrypt extends WorldGenerator
{
	protected int[] GetValidSpawnBlocks() {
		return new int[] {
			Block.mycelium.blockID,
			Block.stone.blockID,
			Block.grass.blockID,
			Block.dirt.blockID,
			Block.cobblestone.blockID
		};
	}

	public boolean LocationIsValidSpawn(World world, int i, int j, int k){
		int distanceToAir = 0;
		int checkID = world.getBlockId(i, j, k);

		while (checkID != 0){
			distanceToAir++;
			checkID = world.getBlockId(i, j + distanceToAir, k);
		}

		if (distanceToAir > 3){
			return false;
		}
		j += distanceToAir - 1;

		int blockID = world.getBlockId(i, j, k);
		int blockIDAbove = world.getBlockId(i, j+1, k);
		int blockIDBelow = world.getBlockId(i, j-1, k);
		for (int x : GetValidSpawnBlocks()){
			if (blockIDAbove != 0){
				return false;
			}
			if (blockID == x){
				return true;
			}else if (blockID == Block.snow.blockID && blockIDBelow == x){
				return true;
			}
		}
		return false;
	}

	public WorldGenCrypt() { }

	public boolean generate(World world, Random rand, int i, int j, int k) {
		//check that each corner is one of the valid spawn blocks
		if(!LocationIsValidSpawn(world, i, j, k) || !LocationIsValidSpawn(world, i + 6, j, k) || !LocationIsValidSpawn(world, i + 6, j, k + 6) || !LocationIsValidSpawn(world, i, j, k + 6))
		{
			return false;
		}

		world.setBlock(i + 0, j + 0, k + 0, Block.mycelium.blockID);
		world.setBlock(i + 0, j + 0, k + 1, Block.mycelium.blockID);
		world.setBlock(i + 0, j + 0, k + 2, Block.stairsStoneBrick.blockID);
		world.setBlock(i + 0, j + 0, k + 3, Block.stairsStoneBrick.blockID);
		world.setBlock(i + 0, j + 0, k + 4, Block.stairsCobblestone.blockID);
		world.setBlock(i + 0, j + 0, k + 5, Block.mycelium.blockID);
		world.setBlock(i + 0, j + 0, k + 6, Block.mycelium.blockID);
		world.setBlock(i + 1, j + 0, k + 0, Block.mycelium.blockID);
		world.setBlock(i + 1, j + 0, k + 1, Block.mycelium.blockID);
		world.setBlock(i + 1, j + 0, k + 2, Block.mycelium.blockID);
		world.setBlock(i + 1, j + 0, k + 3, Block.dirt.blockID);
		world.setBlock(i + 1, j + 0, k + 4, Block.dirt.blockID);
		world.setBlock(i + 1, j + 0, k + 5, Block.mycelium.blockID);
		world.setBlock(i + 1, j + 0, k + 6, Block.mycelium.blockID);
		world.setBlock(i + 1, j + 1, k + 2, Block.stairsCobblestone.blockID);
		world.setBlock(i + 1, j + 1, k + 3, Block.stairsStoneBrick.blockID);
		world.setBlock(i + 1, j + 1, k + 4, Block.stairsStoneBrick.blockID);
		world.setBlock(i + 1, j + 2, k + 2, Block.fenceIron.blockID);
		world.setBlock(i + 1, j + 2, k + 4, Block.fenceIron.blockID);
		world.setBlock(i + 2, j + 0, k + 0, Block.stairsCobblestone.blockID, 2, 2);
		world.setBlock(i + 2, j + 0, k + 1, Block.mycelium.blockID);
		world.setBlock(i + 2, j + 0, k + 2, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 2, j + 0, k + 3, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 2, j + 0, k + 4, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 2, j + 0, k + 5, Block.dirt.blockID);
		world.setBlock(i + 2, j + 0, k + 6, Block.stairsCobblestone.blockID, 3, 3);
		world.setBlock(i + 2, j + 1, k + 1, Block.stairsStoneBrick.blockID, 2, 2);
		world.setBlock(i + 2, j + 1, k + 2, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 2, j + 1, k + 3, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 2, j + 1, k + 4, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 2, j + 1, k + 5, Block.stairsStoneBrick.blockID, 3, 3);
		world.setBlock(i + 2, j + 2, k + 1, Block.fenceIron.blockID);
		world.setBlock(i + 2, j + 2, k + 2, Block.stoneBrick.blockID, 3, 3);
		world.setBlock(i + 2, j + 2, k + 3, Block.stoneSingleSlab.blockID);
		world.setBlock(i + 2, j + 2, k + 4, Block.stoneBrick.blockID, 3, 3);
		world.setBlock(i + 2, j + 2, k + 5, Block.fenceIron.blockID);
		world.setBlock(i + 2, j + 3, k + 2, Block.cobblestoneWall.blockID);
		world.setBlock(i + 2, j + 3, k + 4, Block.cobblestoneWall.blockID);
		world.setBlock(i + 2, j + 4, k + 2, Block.cobblestoneWall.blockID);
		world.setBlock(i + 2, j + 4, k + 4, Block.cobblestoneWall.blockID);
		world.setBlock(i + 2, j + 5, k + 2, Block.stoneSingleSlab.blockID, 3, 3);
		world.setBlock(i + 2, j + 5, k + 3, Block.stairsCobblestone.blockID);
		world.setBlock(i + 2, j + 5, k + 4, Block.stoneSingleSlab.blockID, 3, 3);
		world.setBlock(i + 3, j + 0, k + 0, Block.stairsCobblestone.blockID, 2, 2);
		world.setBlock(i + 3, j + 0, k + 1, Block.dirt.blockID);
		world.setBlock(i + 3, j + 0, k + 2, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 3, j + 0, k + 3, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 3, j + 0, k + 4, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 3, j + 0, k + 5, Block.dirt.blockID);
		world.setBlock(i + 3, j + 0, k + 6, Block.stairsStoneBrick.blockID, 3, 3);
		world.setBlock(i + 3, j + 1, k + 1, Block.stairsCobblestone.blockID, 2, 2);
		world.setBlock(i + 3, j + 1, k + 2, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 3, j + 1, k + 3,  Block.chest.blockID, 2, 2);
		TileEntityChest tileentitychest = (TileEntityChest)world.getBlockTileEntity(i + 3, j + 1, k + 3);
        if (tileentitychest != null)
        {
            ChestGenHooks info = ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST);
            WeightedRandomChestContent.generateChestContents(rand, info.getItems(rand), tileentitychest, info.getCount(rand));
        }
		world.setBlock(i + 3, j + 1, k + 4, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 3, j + 1, k + 5, Block.stairsCobblestone.blockID, 3, 3);
		world.setBlock(i + 3, j + 2, k + 2, Block.stoneSingleSlab.blockID);
		world.setBlock(i + 3, j + 2, k + 3, Block.silverfish.blockID, 2, 2);
		world.setBlock(i + 3, j + 3, k + 3, ForbiddenBlocks.TombStone.blockID, 2, 2);
		TileEntityTombStone ts = (TileEntityTombStone)world.getBlockTileEntity(i + 3, j + 3, k + 3);
        if (ts != null)
        {
           ts.name == "Steve";
        }
		world.setBlock(i + 3, j + 2, k + 4, Block.stoneSingleSlab.blockID);
		world.setBlock(i + 3, j + 5, k + 2, Block.stairsCobblestone.blockID, 2, 2);
		world.setBlock(i + 3, j + 5, k + 3, Block.silverfish.blockID, 1, 1);
		world.setBlock(i + 3, j + 5, k + 4, Block.stairsCobblestone.blockID, 3, 3);
		world.setBlock(i + 4, j + 0, k + 0, Block.stairsStoneBrick.blockID, 2, 2);
		world.setBlock(i + 4, j + 0, k + 1, Block.dirt.blockID);
		world.setBlock(i + 4, j + 0, k + 2, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 4, j + 0, k + 3, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 4, j + 0, k + 4, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 4, j + 0, k + 5, Block.mycelium.blockID);
		world.setBlock(i + 4, j + 0, k + 6, Block.stairsCobblestone.blockID, 3, 3);
		world.setBlock(i + 4, j + 1, k + 1, Block.stairsStoneBrick.blockID, 2, 2);
		world.setBlock(i + 4, j + 1, k + 2, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 4, j + 1, k + 3, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 4, j + 1, k + 4, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 4, j + 1, k + 5, Block.stairsCobblestone.blockID, 3, 3);
		world.setBlock(i + 4, j + 2, k + 1, Block.fenceIron.blockID);
		world.setBlock(i + 4, j + 2, k + 2, Block.stoneBrick.blockID, 3, 3);
		world.setBlock(i + 4, j + 2, k + 3, Block.stoneSingleSlab.blockID);
		world.setBlock(i + 4, j + 2, k + 4, Block.stoneBrick.blockID, 3, 3);
		world.setBlock(i + 4, j + 2, k + 5, Block.fenceIron.blockID);
		world.setBlock(i + 4, j + 3, k + 2, Block.cobblestoneWall.blockID);
		world.setBlock(i + 4, j + 3, k + 4, Block.cobblestoneWall.blockID);
		world.setBlock(i + 4, j + 4, k + 2, Block.cobblestoneWall.blockID);
		world.setBlock(i + 4, j + 4, k + 4, Block.cobblestoneWall.blockID);
		world.setBlock(i + 4, j + 5, k + 2, Block.stoneSingleSlab.blockID, 3, 3);
		world.setBlock(i + 4, j + 5, k + 3, Block.stairsCobblestone.blockID, 1, 1);
		world.setBlock(i + 4, j + 5, k + 4, Block.stoneSingleSlab.blockID, 3, 3);
		world.setBlock(i + 5, j + 0, k + 0, Block.mycelium.blockID);
		world.setBlock(i + 5, j + 0, k + 1, Block.mycelium.blockID);
		world.setBlock(i + 5, j + 0, k + 2, Block.dirt.blockID);
		world.setBlock(i + 5, j + 0, k + 3, Block.mycelium.blockID);
		world.setBlock(i + 5, j + 0, k + 4, Block.dirt.blockID);
		world.setBlock(i + 5, j + 0, k + 5, Block.mycelium.blockID);
		world.setBlock(i + 5, j + 0, k + 6, Block.mycelium.blockID);
		world.setBlock(i + 5, j + 1, k + 2, Block.stairsCobblestone.blockID, 1, 1);
		world.setBlock(i + 5, j + 1, k + 3, Block.stairsStoneBrick.blockID, 1, 1);
		world.setBlock(i + 5, j + 1, k + 4, Block.stairsStoneBrick.blockID, 1, 1);
		world.setBlock(i + 5, j + 2, k + 2, Block.fenceIron.blockID);
		world.setBlock(i + 5, j + 2, k + 4, Block.fenceIron.blockID);
		world.setBlock(i + 6, j + 0, k + 0, Block.mycelium.blockID);
		world.setBlock(i + 6, j + 0, k + 1, Block.mycelium.blockID);
		world.setBlock(i + 6, j + 0, k + 2, Block.stairsCobblestone.blockID, 1, 1);
		world.setBlock(i + 6, j + 0, k + 3, Block.stairsCobblestone.blockID, 1, 1);
		world.setBlock(i + 6, j + 0, k + 4, Block.stairsStoneBrick.blockID, 1, 1);
		world.setBlock(i + 6, j + 0, k + 5, Block.mycelium.blockID);
		world.setBlock(i + 6, j + 0, k + 6, Block.mycelium.blockID);

		return true;
	}
}
