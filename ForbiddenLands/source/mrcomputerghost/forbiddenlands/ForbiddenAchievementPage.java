package mrcomputerghost.forbiddenlands;

import cpw.mods.fml.common.registry.LanguageRegistry;
import mrcomputerghost.forbiddenlands.items.ForbiddenItems;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class ForbiddenAchievementPage extends AchievementPage {

	public static Achievement ridePlayer = new Achievement(4200, "ridePlayer", -2, 1, ForbiddenItems.Rider, (Achievement)null);

	public ForbiddenAchievementPage() {
		super("Forbidden Lands", new Achievement[] { ridePlayer });

		LanguageRegistry.instance().addStringLocalization("achievement.ridePlayer", "en_US", "Player Rider");
		LanguageRegistry.instance().addStringLocalization("achievement.ridePlayer.desc", "en_US", "Build a portal to the Twilight Forest");

	}

}
