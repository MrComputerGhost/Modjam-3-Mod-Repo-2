package mrcomputerghost.forbiddenlands.client.gui;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mrcomputerghost.forbiddenlands.blocks.BlockTombStone;
import mrcomputerghost.forbiddenlands.tileentities.TileEntityTombStone;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.resources.I18n;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.network.packet.Packet250CustomPayload;

@SideOnly(Side.CLIENT)
public class GuiTombStone extends GuiScreen 
{
	private static GuiTextField tombTextField;
	
	private final TileEntityTombStone tombStone;
	
	private GuiButton doneBut;
	private GuiButton nopeBut;
	
	public GuiTombStone(TileEntityTombStone ts) 
	{
		this.tombStone = ts;
	}
	
	public void updateScreen() 
	{
		this.tombTextField.updateCursorCounter();
	}
	
	public void initGui()
    {
        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();
        this.buttonList.add(this.doneBut = new GuiButton(0, this.width / 2 - 100, this.height / 4 + 96 + 12, I18n.getString("gui.done")));
        this.buttonList.add(this.nopeBut = new GuiButton(1, this.width / 2 - 100, this.height / 4 + 120 + 12, I18n.getString("gui.cancel")));
        this.tombTextField = new GuiTextField(this.fontRenderer, this.width / 2 - 150, 60, 300, 20);
        this.tombTextField.setMaxStringLength(32767);
        this.tombTextField.setFocused(true);
        this.tombTextField.setText(this.tombStone.getName());
        this.doneBut.enabled = this.tombTextField.getText().trim().length() > 0;
    }
	
	public void onGuiClosed()
    {
        Keyboard.enableRepeatEvents(false);   
    }
	
	public static String getText() {
		return tombTextField.getText();
	}
	
	protected void actionPerformed(GuiButton par1GuiButton)
	    {
	        if (par1GuiButton.enabled)
	        {
	            if (par1GuiButton.id == 1)
	            {
	                this.mc.displayGuiScreen((GuiScreen)null);
	            }
	            else if (par1GuiButton.id == 0)
	            {
	                String s = "tombName";
	                ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
	                DataOutputStream dataoutputstream = new DataOutputStream(bytearrayoutputstream);
	                
	                try
	                {
	                    dataoutputstream.writeInt(this.tombStone.xCoord);
	                    dataoutputstream.writeInt(this.tombStone.yCoord);
	                    dataoutputstream.writeInt(this.tombStone.zCoord);
	                    Packet.writeString(this.tombTextField.getText(), dataoutputstream);
	                	NBTTagCompound tag = new NBTTagCompound(); 
	                	tag.setString("tombName", this.tombTextField.getText());
	                	Packet132TileEntityData pack = new Packet132TileEntityData(this.tombStone.xCoord, this.tombStone.yCoord, this.tombStone.zCoord, 42, tag);
	                	//this.mc.getNetHandler().addToSendQueue(pack);
	                	
	                    
	                }
	                catch (Exception exception)
	                {
	                    exception.printStackTrace();
	                }
	                this.mc.displayGuiScreen((GuiScreen)null);
	            }
	        }
	    }
	
	 	protected void keyTyped(char par1, int par2) {
	        this.tombTextField.textboxKeyTyped(par1, par2);
	        this.doneBut.enabled = this.tombTextField.getText().trim().length() > 0;

	        if (par2 != 28 && par2 != 156)
	        {
	            if (par2 == 1)
	            {
	                this.actionPerformed(this.nopeBut);
	            }
	        }
	        else
	        {
	            this.actionPerformed(this.doneBut);
	        }
	    }

	    /**
	     * Called when the mouse is clicked.
	     */
	    protected void mouseClicked(int par1, int par2, int par3)
	    {
	        super.mouseClicked(par1, par2, par3);
	        this.tombTextField.mouseClicked(par1, par2, par3);
	        
	    }
	    
	    public void drawScreen(int par1, int par2, float par3)
	    {
	        this.drawDefaultBackground();
	        this.drawCenteredString(this.fontRenderer, "Tomb Stone", this.width / 2, 20, 16777215);
	        this.drawString(this.fontRenderer, I18n.getString("Type the name of a player here:"), this.width / 2 - 150, 47, 10526880);
	        this.tombTextField.drawTextBox();
	        super.drawScreen(par1, par2, par3);
	    }
}
