package mrcomputerghost.forbiddenlands.worldgen;

import java.util.Random;

import mrcomputerghost.forbiddenlands.blocks.ForbiddenBlocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenPortal extends WorldGenerator {
	public WorldGenPortal() {
	}

	public boolean generate(World world, Random rand, int i, int j, int k) {
		int spawnID = 2; 
		/**if (world.getBlockId(i, j, k) != spawnID
				|| world.getBlockId(i, j + 1, k) != 0
				|| world.getBlockId(i + 7, j, k) != spawnID
				|| world.getBlockId(i + 7, j, k + 7) != spawnID
				|| world.getBlockId(i, j, k + 7) != spawnID
				|| world.getBlockId(i + 7, j + 1, k) != 0
				|| world.getBlockId(i + 7, j + 1, k + 7) != 0
				|| world.getBlockId(i, j + 1, k + 7) != 0) {
			return false;
		} else {**/
			System.out.println("Portal at: " + i + ", " + k);
			world.setBlock(i, j - 1, k, ForbiddenBlocks.ParadoxBlock.blockID);
			world.setBlock(i, j + 3, k, ForbiddenBlocks.ParadoxBlock.blockID);

			world.setBlock(i + 1, j + 2, k, ForbiddenBlocks.ParadoxBlock.blockID);
			world.setBlock(i + 2, j + 2, k, ForbiddenBlocks.ParadoxBlock.blockID);
			world.setBlock(i + 2, j + 1, k, ForbiddenBlocks.ParadoxBlock.blockID);
			world.setBlock(i + 2, j, k, ForbiddenBlocks.ParadoxBlock.blockID);

			world.setBlock(i - 1, j + 2, k, ForbiddenBlocks.ParadoxBlock.blockID);
			world.setBlock(i - 2, j + 2, k, ForbiddenBlocks.ParadoxBlock.blockID);
			world.setBlock(i - 2, j + 1, k, ForbiddenBlocks.ParadoxBlock.blockID);
			world.setBlock(i - 2, j, k, ForbiddenBlocks.ParadoxBlock.blockID);

			world.setBlock(i, j + 2, k + 1, ForbiddenBlocks.ParadoxBlock.blockID);
			world.setBlock(i, j + 2, k + 2, ForbiddenBlocks.ParadoxBlock.blockID);
			world.setBlock(i, j + 1, k + 2, ForbiddenBlocks.ParadoxBlock.blockID);
			world.setBlock(i, j, k + 2, ForbiddenBlocks.ParadoxBlock.blockID);

			world.setBlock(i, j + 2, k - 1, ForbiddenBlocks.ParadoxBlock.blockID);
			world.setBlock(i, j + 2, k - 2, ForbiddenBlocks.ParadoxBlock.blockID);
			world.setBlock(i, j + 1, k - 2, ForbiddenBlocks.ParadoxBlock.blockID);
			world.setBlock(i, j, k - 2, ForbiddenBlocks.ParadoxBlock.blockID);

			world.setBlock(i, j, k, ForbiddenBlocks.FBPortal.blockID,0,2);
			world.setBlock(i, j + 1, k, ForbiddenBlocks.FBPortal.blockID,0,2);
			
		//}

		return true;
	}
}