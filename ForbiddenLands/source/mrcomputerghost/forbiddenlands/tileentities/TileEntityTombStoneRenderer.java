package mrcomputerghost.forbiddenlands.tileentities;

import java.awt.Color;

import mrcomputerghost.forbiddenlands.blocks.ForbiddenBlocks;
import mrcomputerghost.forbiddenlands.lib.Textures;
import mrcomputerghost.forbiddenlands.model.ModelTombSkull;
import mrcomputerghost.forbiddenlands.model.ModelTombStone;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.FakePlayer;

import org.lwjgl.opengl.GL11;

public class TileEntityTombStoneRenderer extends TileEntitySpecialRenderer {
	
	ModelTombStone tombstone = new ModelTombStone();
	ModelTombSkull tombskull = new ModelTombSkull();
	
	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y,	double z, float f) {
        
		GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        TileEntityTombStone disp = (TileEntityTombStone)te;
        int block = disp.getBlockMetadata();
        
        Minecraft.getMinecraft().renderEngine.bindTexture(Textures.TOMBSTONE_TEXTURE);
        
        
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        tombstone.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
        
        if(disp != null)
        {
            boolean fit = false;
            if (disp.getName() != "Skeleton" && disp.getName() != "Player" && disp.getName() != "MrComputerGhost" && disp.getName() != "Grumm" && disp.getName() != "Dinnerbone") {
            	fit = true;
            }
        	if (disp.getName() != null) {
        	int ind = 5;
        	if (disp.getName() == "Player" || disp.getName() == "Skeleton") {
        	
        		GL11.glPushMatrix();
                float uf = 0.8F;
                GL11.glScalef(uf, -uf, -uf);
                String s = "";            
                TileEntitySkullRenderer.skullRenderer.func_82393_a(-0.5F, -0.79F, -0.5F, 1, 180.0F, 0, s);
                GL11.glPopMatrix(); 
        		
        	} if (disp.getName() == "Grumm" || disp.getName() == "Dinnerbone") {
        		GL11.glPushMatrix();
                float uf = 0.8F;
                float fu = 0.8F;
                GL11.glScalef(uf, uf, -uf);
                String s = disp.getName();            
                TileEntitySkullRenderer.skullRenderer.func_82393_a(-0.5F, 0.28F, -0.5F, 1, 180.0F, 3, s);
                GL11.glPopMatrix();
                GL11.glPushMatrix();
                GL11.glScalef(-fu, -fu, fu);
                renderLabel(EnumChatFormatting.DARK_GRAY + disp.getName(), 0F, (0.25F)*ind, -0.6, block, disp);
                GL11.glPopMatrix();
                ind++;  
        	} if (disp.getName() == "MrComputerGhost") {
        	
        		GL11.glPushMatrix();
                float uf = 0.8F;
                float fu = 1.0F;
                GL11.glScalef(uf, -uf, -uf);
                String s = "MrComputerGhost";            
                TileEntitySkullRenderer.skullRenderer.func_82393_a(-0.5F, -0.79F, -0.5F, 1, 180.0F, 3, "MrComputerGhost");
                GL11.glPopMatrix();
                GL11.glPushMatrix();
                GL11.glScalef(fu, fu, fu);
                renderLabel(EnumChatFormatting.GOLD + s, 0F, (-0.17F)*ind, -0.6, block, disp);
                GL11.glPopMatrix();
                ind++;
                GL11.glPushMatrix();
                GL11.glScalef(fu, fu, fu);
                renderLabel(EnumChatFormatting.GOLD + "The Creator", 0F, (-0.17F)*ind, -0.6, block, disp);
                GL11.glPopMatrix();
                ind++;
        	} else if (fit == true) {
        	
            GL11.glPushMatrix();
            float uf = 0.8F;
            float fu = 1.0F;
            GL11.glScalef(uf, -uf, -uf);
            String s = disp.getName()	;            
            TileEntitySkullRenderer.skullRenderer.func_82393_a(-0.5F, -0.79F, -0.5F, 1, 180.0F, 3, s);
            GL11.glPopMatrix();            

            GL11.glPushMatrix();
            GL11.glScalef(fu, fu, fu);
            renderLabel(EnumChatFormatting.DARK_GRAY + disp.getName(), 0F, (-0.17F)*ind, -0.6, block, disp);
            GL11.glPopMatrix();
            ind++;  
            //if (disp.extra != null) {
            /**GL11.glPushMatrix();
            playerExtra(EnumChatFormatting.LIGHT_PURPLE + "Poop", 0F, (-0.171F)*ind, -0.6, block, Minecraft.getMinecraft().thePlayer);
            GL11.glPopMatrix();
            ind++;**/
            //}
            }
            GL11.glPushMatrix();
            GL11.glDisable(GL11.GL_LIGHTING);
            
            GL11.glRotatef(180F, 1F, 0F, 0F);
            GL11.glTranslatef(0.0F, -0.6F + disp.blockMetadata/5, 0F);
            GL11.glRotatef(0, 0F, 1F, 0F);
            
            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glPopMatrix();
            }
        }
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }
        

		
	
	public void adjustLightFixture(World world, int i, int j, int k, Block block)
    {
        Tessellator tess = Tessellator.instance;
        float brightness = block.getBlockBrightness(world, i, j, k);
        int skyLight = world.getLightBrightnessForSkyBlocks(i, j, k, 0);
        int modulousModifier = skyLight % 65536;
        int divModifier = skyLight / 65536;
        tess.setColorOpaque_F(brightness, brightness, brightness);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) modulousModifier, divModifier);
    }
	
	protected void renderLabel(String par2Str, double x, double y, double z, int metadata, TileEntity te)
    {
        FontRenderer fontrenderer = RenderManager.instance.getFontRenderer();
        if(te.worldObj.getClosestPlayer((double)te.xCoord, (double)te.yCoord, (double)te.zCoord, 3.5D) != null)
        {
            float var14 = 0.01266667F * 1.5F;
            float var17 = 0.015F;
            GL11.glRotatef(180F, 0F, 0F, 1F);
            if(metadata == 0) GL11.glRotatef(0F, 0F, 1F, 0F);
            else if(metadata == 1) GL11.glRotatef(270F, 0F, 1F, 0F);
            else if(metadata == 2) GL11.glRotatef(180F, 0F, 1F, 0F);
            else if(metadata == 3) GL11.glRotatef(90F, 0F, 1F, 0F);
            GL11.glTranslatef((float)x, (float)y, (float)z + 0.45F);
            GL11.glScalef(-0.015F, -var14, 0.015F);
            GL11.glPushMatrix();
            GL11.glDisable(GL11.GL_LIGHTING);
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            GL11.glDisable(GL11.GL_DEPTH_TEST);
            GL11.glDepthMask(true);
            Tessellator tessellator = Tessellator.instance;
            GL11.glDisable(GL11.GL_TEXTURE_2D);
            int j = fontrenderer.getStringWidth(par2Str) / 2;
            tessellator.startDrawingQuads();
            tessellator.setColorRGBA_F(0.2F, 0.2F, 0.2F, 0.8F);
            tessellator.addVertex((double)(-33.333 - 0), -1D, 0.1D);
            tessellator.addVertex((double)(-33.333 - 0), 8D, 0.1D);
            tessellator.addVertex((double)(33.333 + 0), 8D, 0.1D);
            tessellator.addVertex((double)(33.333 + 0), -1D, 0.1D);
            tessellator.draw();
            if ((fontrenderer.getStringWidth(par2Str)/2) > 30) var17 = 0.9F / fontrenderer.getStringWidth(par2Str); 
            else var17 = var14;
            GL11.glScalef(var17*70F, 1F, 0F);
            GL11.glEnable(GL11.GL_TEXTURE_2D);
            fontrenderer.drawStringWithShadow(par2Str, -j, 0, Color.GRAY.getRGB());
            GL11.glEnable(GL11.GL_DEPTH_TEST);
            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glDisable(GL11.GL_BLEND);
            GL11.glPopMatrix();
        }
    }
	
	protected void playerExtra(String par2Str, double x, double y, double z, int metadata, EntityPlayer te)
    {
        FontRenderer fontrenderer = RenderManager.instance.getFontRenderer();
        
            float var14 = 0.01266667F * 1.5F;
            float var17 = 0.015F;
            GL11.glRotatef(180F, 0F, 0F, 1F);
            if(metadata == 0) GL11.glRotatef(0F, 0F, 1F, 0F);
            else if(metadata == 1) GL11.glRotatef(270F, 0F, 1F, 0F);
            else if(metadata == 2) GL11.glRotatef(180F, 0F, 1F, 0F);
            else if(metadata == 3) GL11.glRotatef(90F, 0F, 1F, 0F);
            GL11.glTranslatef((float)x, (float)y, (float)z + 0.45F);
            GL11.glScalef(-0.015F, -var14, 0.015F);
            GL11.glPushMatrix();
            GL11.glDisable(GL11.GL_LIGHTING);
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            GL11.glDisable(GL11.GL_DEPTH_TEST);
            GL11.glDepthMask(true);
            Tessellator tessellator = Tessellator.instance;
            GL11.glDisable(GL11.GL_TEXTURE_2D);
            int j = fontrenderer.getStringWidth(par2Str) / 2;
            tessellator.startDrawingQuads();
            tessellator.setColorRGBA_F(0.2F, 0.2F, 0.2F, 0.8F);
            tessellator.addVertex((double)(-33.333 - 0), -1D, 0.1D);
            tessellator.addVertex((double)(-33.333 - 0), 8D, 0.1D);
            tessellator.addVertex((double)(33.333 + 0), 8D, 0.1D);
            tessellator.addVertex((double)(33.333 + 0), -1D, 0.1D);
            tessellator.draw();
            if ((fontrenderer.getStringWidth(par2Str)/2) > 30) var17 = 0.9F / fontrenderer.getStringWidth(par2Str); 
            else var17 = var14;
            GL11.glScalef(var17*70F, 1F, 0F);
            GL11.glEnable(GL11.GL_TEXTURE_2D);
            fontrenderer.drawStringWithShadow(par2Str, -j, 0, Color.GRAY.getRGB());
            GL11.glEnable(GL11.GL_DEPTH_TEST);
            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glDisable(GL11.GL_BLEND);
            GL11.glPopMatrix();
        
    }
	

}
