package world.maryt.exuslashblade.events;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import static world.maryt.exuslashblade.ExtremelyUsefulSlashBlades.LOGGER;
import static world.maryt.exuslashblade.se.Newbie.getAttributeModifiers;

public class NewbieEffect {


    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.player.isEntityAlive() && event.phase == TickEvent.Phase.END && event.side.isServer()) {
            EntityPlayer player = event.player;
            NBTTagCompound tag = player.getHeldItemMainhand().getTagCompound();
            if (tag == null || !tag.hasKey("SB.SEffect") || !tag.getCompoundTag("SB.SEffect").hasKey("Newbie")) {
                LOGGER.info("clear");
                player.getAttributeMap().removeAttributeModifiers(getAttributeModifiers());
            }
        }
    }
}
