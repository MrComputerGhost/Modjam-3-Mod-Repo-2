package mrcomputerghost.forbiddenlands.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class ItemStacker extends Item {

	public ItemStacker(int par1) {
		super(par1);
		this.setHasSubtypes(true);
		this.setMaxDamage(1);
		this.setCreativeTab(CreativeTabs.tabMisc);
	}

	public void registerIcons(IconRegister registerIcon) {
		this.itemIcon = registerIcon.registerIcon("minecraft:lead");
	}

	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player,
			Entity entity) {
		if ((player.ridingEntity == entity)) {
			player.dismountEntity(entity);
			player.fallDistance = 0;
			entity.fallDistance = 0;
		} else if ((entity.ridingEntity == player)) {
			EntityLivingBase e = (EntityLivingBase) entity;
			e.dismountEntity(player);
			entity.ridingEntity = null;
			entity.motionY += 0.5D;
			player.fallDistance = 0;
			entity.fallDistance = 0;
		}
		return true;
	}

	public boolean itemInteractionForEntity(ItemStack par1ItemStack,
			EntityPlayer player, EntityLivingBase entity) {

		if (!player.isSneaking()) {
			if ((entity.riddenByEntity != player)
					&& (player.riddenByEntity == null)) {
				entity.mountEntity(player);
				entity.fallDistance = 0;
			} else if ((entity.riddenByEntity != player)
					&& (player.riddenByEntity != null)
					&& (player.riddenByEntity.riddenByEntity == null)) {
				EntityLivingBase e = (EntityLivingBase) player.riddenByEntity;
				entity.mountEntity(e);
			} else if ((entity.riddenByEntity != player)
					&& (player.riddenByEntity != null)
					&& (player.riddenByEntity.riddenByEntity != null)
					&& (player.riddenByEntity.riddenByEntity.riddenByEntity == null)) {
				EntityLivingBase e = (EntityLivingBase) player.riddenByEntity.riddenByEntity;
				entity.mountEntity(e);
			}
		} else if (player.isSneaking()) {
			if (player.riddenByEntity != null
					&& entity != player.riddenByEntity) {
				EntityLivingBase e = (EntityLivingBase) player.riddenByEntity;
				e.mountEntity(entity);
				e.dismountEntity(player);
				// e.ridingEntity = null;

			}
		}
		return true;

	}

	public ItemStack onItemRightClick(ItemStack par1ItemStack, World world,
			EntityPlayer player) {
		if (!world.isRemote && player.isSneaking()) {
			player.addChatMessage("Rider Mode Set To Ride");
			par1ItemStack.setItemName("\u00A7rRider - Ride Mode");
			par1ItemStack.itemID = ForbiddenItems.Rider.itemID;

		}
		return par1ItemStack;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list,
			boolean par4) {
		switch (stack.getItemDamage()) {
		case 0:
			list.add("\u00A75Mode: Stack");
			list.add("\u00A75Left-Click Entity to Stack it");
			list.add("\u00A75Right-Click to Change");
			break;
		}
	}

}
