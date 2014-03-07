package mrcomputerghost.forbiddenlands.tileentities;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.network.PacketDispatcher;
import mrcomputerghost.forbiddenlands.lib.Reference;
import mrcomputerghost.forbiddenlands.lib.Textures;
import mrcomputerghost.forbiddenlands.model.ModelRecordPlayer;
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
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class RecordPlayerRenderer extends TileEntitySpecialRenderer
{
	ModelRecordPlayer rp = new ModelRecordPlayer();
	
	private boolean hasFirstChecked = false;
	
	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y,	double z, float f) 
	{
		GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        TileEntityRecordPlayer disp = (TileEntityRecordPlayer)te;
        int block = disp.getBlockMetadata();
        
        Minecraft.getMinecraft().renderEngine.bindTexture(Textures.RECORD_TEXTURE);
        
        
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        rp.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
        
        if(disp != null)
        {
            
        	if(disp != null && disp.hasObject && disp.disc != null && disp.disc != new ItemStack(0, 0, 0))
            {
                int ind = 1;
                GL11.glPushMatrix();
                GL11.glDisable(GL11.GL_LIGHTING);
                GL11.glScalef(1.6F, 3F, 1.06F);
                
                EntityItem entityitem = new EntityItem(te.worldObj, 0.0D, 0.0D, 0.0D, disp.disc);
                entityitem.hoverStart = -1.57F;
                disp.disc.stackSize = 1;
                
                //GL11.glRotatef(180F, 0F, 0.0F, 0F);
                /**if(RenderManager.instance.options.fancyGraphics)
                    RenderManager.instance.renderEntityWithPosYaw(entityitem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
                else
                {*/
                    GL11.glRotatef(180F, 1F, 1F, 0F);
                    RenderManager.instance.options.fancyGraphics = true;
                    RenderManager.instance.renderEntityWithPosYaw(entityitem, 0.25D, -0.125D, 0.039D, 0.0F, 0.0F);
                    RenderManager.instance.options.fancyGraphics = false;
                //}
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
