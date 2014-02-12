package mrcomputerghost.forbiddenlands.util;

import mrcomputerghost.forbiddenlands.lib.Reference;
import net.minecraft.util.ResourceLocation;

public class ResourceLocationHelper {

	public static ResourceLocation getResourceLactaion(String path) {
		return new ResourceLocation(Reference.MOD_ID.toLowerCase(), path);
	}
	
	
}
