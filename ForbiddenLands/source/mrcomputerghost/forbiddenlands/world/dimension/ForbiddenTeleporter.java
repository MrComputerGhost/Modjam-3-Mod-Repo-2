package mrcomputerghost.forbiddenlands.world.dimension;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import mrcomputerghost.forbiddenlands.blocks.ForbiddenBlocks;
import net.minecraft.entity.Entity;
import net.minecraft.util.Direction;
import net.minecraft.util.LongHashMap;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.PortalPosition;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class ForbiddenTeleporter extends Teleporter
{
	private final Random random;
	/** Stores successful portal placement locations for rapid lookup. */
	private final LongHashMap destinationCoordinateCache = new LongHashMap();

	/**
	 * A list of valid keys for the destinationCoordainteCache. These are based on the X & Z of the players initial
	 * location.
	 */
	private final List destinationCoordinateKeys = new ArrayList();
	private final WorldServer worldServerInstance;

	public ForbiddenTeleporter(WorldServer par1WorldServer)
	{
		super(par1WorldServer);
		this.worldServerInstance = par1WorldServer;
		this.random = new Random(par1WorldServer.getSeed());
	}

	@Override
	public void placeInPortal(Entity par1Entity, double par2, double par4, double par6, float par8)
	{
		if (this.worldServerInstance.provider.dimensionId != 1)
		{
			if (!this.placeInExistingPortal(par1Entity, par2, par4, par6, par8))
			{
				this.makePortal(par1Entity);
				this.placeInExistingPortal(par1Entity, par2, par4, par6, par8);
			}
		}
		else
		{
			int var9 = MathHelper.floor_double(par1Entity.posX);
			int var10 = MathHelper.floor_double(par1Entity.posY) - 1;
			int var11 = MathHelper.floor_double(par1Entity.posZ);
			byte var12 = 1;
			byte var13 = 0;

			for (int var14 = -2; var14 <= 2; ++var14)
			{
				for (int var15 = -2; var15 <= 2; ++var15)
				{
					for (int var16 = -1; var16 < 3; ++var16)
					{
						int var17 = var9 + var15 * var12 + var14 * var13;
						int var18 = var10 + var16;
						int var19 = var11 + var15 * var13 - var14 * var12;
						boolean var20 = var16 < 0;
						this.worldServerInstance.setBlock(var17, var18, var19, var20 ? ForbiddenBlocks.ParadoxBlock.blockID : 0);
					}
				}
			}

			par1Entity.setLocationAndAngles((double) var9, (double) var10 + 5, (double) var11, par1Entity.rotationYaw, 0.0F);
			par1Entity.motionX = par1Entity.motionY = par1Entity.motionZ = 0.0D;
		}
	}

	@Override
	public boolean placeInExistingPortal(Entity par1Entity, double par2, double par4, double par6, float par8)
	{
		short var9 = 128;
		double var10 = -1.0D;
		int var12 = 0;
		int var13 = 0;
		int var14 = 0;
		int var15 = MathHelper.floor_double(par1Entity.posX);
		int var16 = MathHelper.floor_double(par1Entity.posZ);
		long var17 = ChunkCoordIntPair.chunkXZ2Int(var15, var16);
		boolean var19 = true;
		double var27;
		int var48;

		if (this.destinationCoordinateCache.containsItem(var17))
		{
			PortalPosition var20 = (PortalPosition) this.destinationCoordinateCache.getValueByKey(var17);
			var10 = 0.0D;
			var12 = var20.posX;
			var13 = var20.posY;
			var14 = var20.posZ;
			var20.lastUpdateTime = this.worldServerInstance.getTotalWorldTime();
			var19 = false;
		}
		else
		{
			for (var48 = var15 - var9; var48 <= var15 + var9; ++var48)
			{
				double var21 = (double) var48 + 0.5D - par1Entity.posX;

				for (int var23 = var16 - var9; var23 <= var16 + var9; ++var23)
				{
					double var24 = (double) var23 + 0.5D - par1Entity.posZ;

					for (int var26 = this.worldServerInstance.getActualHeight() - 1; var26 >= 0; --var26)
					{
						if (this.worldServerInstance.getBlockId(var48, var26, var23) == ForbiddenBlocks.FBPortal.blockID)
						{
							while (this.worldServerInstance.getBlockId(var48, var26 - 1, var23) == ForbiddenBlocks.FBPortal.blockID)
							{
								--var26;
							}

							var27 = (double) var26 + 0.5D - par1Entity.posY;
							double var29 = var21 * var21 + var27 * var27 + var24 * var24;

							if (var10 < 0.0D || var29 < var10)
							{
								var10 = var29;
								var12 = var48;
								var13 = var26;
								var14 = var23;
							}
						}
					}
				}
			}
		}

		if (var10 >= 0.0D)
		{
			if (var19)
			{
				this.destinationCoordinateCache.add(var17, new PortalPosition(this, var12, var13, var14, this.worldServerInstance.getTotalWorldTime()));
				this.destinationCoordinateKeys.add(Long.valueOf(var17));
			}

			double var49 = (double) var12 + 0.5D;
			double var25 = (double) var13 + 0.5D;
			var27 = (double) var14 + 0.5D;
			int var50 = -1;

			if (this.worldServerInstance.getBlockId(var12 - 1, var13, var14) == ForbiddenBlocks.FBPortal.blockID)
			{
				var50 = 2;
			}

			if (this.worldServerInstance.getBlockId(var12 + 1, var13, var14) == ForbiddenBlocks.FBPortal.blockID)
			{
				var50 = 0;
			}

			if (this.worldServerInstance.getBlockId(var12, var13, var14 - 1) == ForbiddenBlocks.FBPortal.blockID)
			{
				var50 = 3;
			}

			if (this.worldServerInstance.getBlockId(var12, var13, var14 + 1) == ForbiddenBlocks.FBPortal.blockID)
			{
				var50 = 1;
			}

			int var30 = par1Entity.getTeleportDirection();

			if (var50 > -1)
			{
				int var31 = Direction.rotateLeft[var50];
				int var32 = Direction.offsetX[var50];
				int var33 = Direction.offsetZ[var50];
				int var34 = Direction.offsetX[var31];
				int var35 = Direction.offsetZ[var31];
				boolean var36 = !this.worldServerInstance.isAirBlock(var12 + var32 + var34, var13, var14 + var33 + var35) || !this.worldServerInstance.isAirBlock(var12 + var32 + var34, var13 + 1, var14 + var33 + var35);
				boolean var37 = !this.worldServerInstance.isAirBlock(var12 + var32, var13, var14 + var33) || !this.worldServerInstance.isAirBlock(var12 + var32, var13 + 1, var14 + var33);

				if (var36 && var37)
				{
					var50 = Direction.rotateOpposite[var50];
					var31 = Direction.rotateOpposite[var31];
					var32 = Direction.offsetX[var50];
					var33 = Direction.offsetZ[var50];
					var34 = Direction.offsetX[var31];
					var35 = Direction.offsetZ[var31];
					var48 = var12 - var34;
					var49 -= (double) var34;
					int var22 = var14 - var35;
					var27 -= (double) var35;
					var36 = !this.worldServerInstance.isAirBlock(var48 + var32 + var34, var13, var22 + var33 + var35) || !this.worldServerInstance.isAirBlock(var48 + var32 + var34, var13 + 1, var22 + var33 + var35);
					var37 = !this.worldServerInstance.isAirBlock(var48 + var32, var13, var22 + var33) || !this.worldServerInstance.isAirBlock(var48 + var32, var13 + 1, var22 + var33);
				}

				float var38 = 0.5F;
				float var39 = 0.5F;

				if (!var36 && var37)
				{
					var38 = 1.0F;
				}
				else if (var36 && !var37)
				{
					var38 = 0.0F;
				}
				else if (var36 && var37)
				{
					var39 = 0.0F;
				}

				var49 += (double)((float) var34 * var38 + var39 * (float) var32);
				var27 += (double)((float) var35 * var38 + var39 * (float) var33);
				float var40 = 0.0F;
				float var41 = 0.0F;
				float var42 = 0.0F;
				float var43 = 0.0F;

				if (var50 == var30)
				{
					var40 = 1.0F;
					var41 = 1.0F;
				}
				else if (var50 == Direction.rotateOpposite[var30])
				{
					var40 = -1.0F;
					var41 = -1.0F;
				}
				else if (var50 == Direction.rotateRight[var30])
				{
					var42 = 1.0F;
					var43 = -1.0F;
				}
				else
				{
					var42 = -1.0F;
					var43 = 1.0F;
				}

				double var44 = par1Entity.motionX;
				double var46 = par1Entity.motionZ;
				par1Entity.motionX = var44 * (double) var40 + var46 * (double) var43;
				par1Entity.motionZ = var44 * (double) var42 + var46 * (double) var41;
				par1Entity.rotationYaw = par8 - (float)(var30 * 90) + (float)(var50 * 90);
			}
			else
			{
				par1Entity.motionX = par1Entity.motionY = par1Entity.motionZ = 0.0D;
			}

			par1Entity.setLocationAndAngles(var49, var25 + 8, var27, par1Entity.rotationYaw, par1Entity.rotationPitch);
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean makePortal(Entity entity)
	{
		World world = worldServerInstance;

		int x = (int) entity.posX;
		int y = (int) entity.posY;
		int z = (int) entity.posZ;

		world.setBlock(x, y - 1, z, ForbiddenBlocks.ParadoxBlock.blockID);
		world.setBlock(x, y + 3, z, ForbiddenBlocks.ParadoxBlock.blockID);

		world.setBlock(x + 1, y + 2, z, ForbiddenBlocks.ParadoxBlock.blockID);
		world.setBlock(x + 2, y + 2, z, ForbiddenBlocks.ParadoxBlock.blockID);
		world.setBlock(x + 2, y + 1, z, ForbiddenBlocks.ParadoxBlock.blockID);
		world.setBlock(x + 2, y, z, ForbiddenBlocks.ParadoxBlock.blockID);

		world.setBlock(x - 1, y + 2, z, ForbiddenBlocks.ParadoxBlock.blockID);
		world.setBlock(x - 2, y + 2, z, ForbiddenBlocks.ParadoxBlock.blockID);
		world.setBlock(x - 2, y + 1, z, ForbiddenBlocks.ParadoxBlock.blockID);
		world.setBlock(x - 2, y, z, ForbiddenBlocks.ParadoxBlock.blockID);

		world.setBlock(x, y + 2, z + 1, ForbiddenBlocks.ParadoxBlock.blockID);
		world.setBlock(x, y + 2, z + 2, ForbiddenBlocks.ParadoxBlock.blockID);
		world.setBlock(x, y + 1, z + 2, ForbiddenBlocks.ParadoxBlock.blockID);
		world.setBlock(x, y, z + 2, ForbiddenBlocks.ParadoxBlock.blockID);

		world.setBlock(x, y + 2, z - 1, ForbiddenBlocks.ParadoxBlock.blockID);
		world.setBlock(x, y + 2, z - 2, ForbiddenBlocks.ParadoxBlock.blockID);
		world.setBlock(x, y + 1, z - 2, ForbiddenBlocks.ParadoxBlock.blockID);
		world.setBlock(x, y, z - 2, ForbiddenBlocks.ParadoxBlock.blockID);

		world.setBlock(x, y, z, ForbiddenBlocks.FBPortal.blockID,0,2);
		world.setBlock(x, y + 1, z, ForbiddenBlocks.FBPortal.blockID,0,2);
		
		world.setBlockToAir(x, y + 4, z);
		world.setBlockToAir(x, y + 5, z);
		world.setBlockToAir(x, y + 6, z);
		world.setBlockToAir(x, y + 7, z);
		world.setBlockToAir(x, y + 8, z);
		world.setBlockToAir(x, y + 9, z);
		world.setBlockToAir(x, y + 10, z);
		world.setBlockToAir(x, y + 11, z);
		world.setBlockToAir(x, y + 12, z);
		world.setBlockToAir(x, y + 13, z);
		world.setBlockToAir(x, y + 14, z);
		world.setBlockToAir(x, y + 15, z);
		world.setBlockToAir(x, y + 16, z);
		world.setBlockToAir(x, y + 17, z);
		world.setBlockToAir(x, y + 18, z);
		world.setBlockToAir(x, y + 19, z);
		world.setBlockToAir(x, y + 20, z);
		world.setBlockToAir(x, y + 21, z);
		world.setBlockToAir(x, y + 22, z);
		world.setBlockToAir(x, y + 23, z);
		world.setBlockToAir(x, y + 24, z);

		return true;
	}

	/**
	 * called periodically to remove out-of-date portal locations from the cache list. Argument par1 is a
	 * WorldServer.getTotalWorldTime() value.
	 */
	 public void removeStalePortalLocations(long par1)
	{
		if (par1 % 100L == 0L)
		{
			Iterator iterator = this.destinationCoordinateKeys.iterator();
			long j = par1 - 600L;

			while (iterator.hasNext())
			{
				Long olong = (Long)iterator.next();
				PortalPosition portalposition = (PortalPosition)this.destinationCoordinateCache.getValueByKey(olong.longValue());

				if (portalposition == null || portalposition.lastUpdateTime < j)
				{
					iterator.remove();
					this.destinationCoordinateCache.remove(olong.longValue());
				}
			}
		}
	}
}
