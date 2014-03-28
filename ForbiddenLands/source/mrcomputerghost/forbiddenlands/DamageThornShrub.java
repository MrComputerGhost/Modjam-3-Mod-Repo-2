package mrcomputerghost.forbiddenlands;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.DamageSource;
import net.minecraft.util.StatCollector;



public class DamageThornShrub extends DamageSource
{
        private Entity p;
        
        private static final Random RANDOM = new Random();

        public DamageThornShrub(Entity par5Entity)
        {
                super("thornshrub");
                this.p = par5Entity;
        }

        @Override
        public ChatMessageComponent getDeathMessage(EntityLivingBase par1EntityLivingBase)
        {
        	int sel = RANDOM.nextInt(5) + 1;
            return ChatMessageComponent.createFromText(Minecraft.getMinecraft().thePlayer.username + " " + StatCollector.translateToLocal("death.message" + sel));
        }
}