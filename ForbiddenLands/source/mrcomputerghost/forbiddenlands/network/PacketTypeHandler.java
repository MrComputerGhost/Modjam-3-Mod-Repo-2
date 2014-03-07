package mrcomputerghost.forbiddenlands.network;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import net.minecraft.network.packet.Packet250CustomPayload;

public enum PacketTypeHandler 
{

	/**TILE_UPDATE(PacketTileUpdate.class);
	
	private Class<? extends CompPacket> clazz;
	
	PacketTypeHandler(Class<? extends CompPacket> clazz)
	{
		this.clazz = clazz;
	}
	
	public static CompPacket buildPacket(byte[] data)
	{
		ByteArrayInputStream bis = new ByteArrayInputStream(data);
		DataInputStream dis = new DataInputStream(bis);

		Packet packet = null;

		try
		{
			int selector = dis.readInt();
			packet = values()[selector].clazz.newInstance();
			packet.readData(dis);
		}
		catch(Exception e)
		{
			e.printStackTrace(System.err);
		}

		return packet;
	}
	
	public static CompPacket buildPacket(PacketTypeHandler type)
	{
		Packet packet = null;

		try
		{
			packet = values()[type.ordinal()].clazz.newInstance();
		}
		catch(Exception e)
		{
			e.printStackTrace(System.err);
		}

		return packet;
	}
	
	public static Packet populatePacket(CompPacket compPacket)
	{
		byte[] data = new byte[16];
		try
		{
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			DataOutputStream dos = new DataOutputStream(baos);

			dos.writeInt(packetSci.packetType.ordinal());
			compPacket.writeData(dos);

			data = baos.toByteArray();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		Packet250CustomPayload packet250 = new Packet250CustomPayload();
		packet250.channel = SciCore.CHANNEL;
		packet250.data = data;
		packet250.length = data.length;
		packet250.isChunkDataPacket = false;

		return packet250;
	}**/
	
}
