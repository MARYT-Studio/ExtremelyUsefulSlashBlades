package world.maryt.exuslashblade.se;

import mods.flammpfeil.slashblade.specialeffect.ISpecialEffect;
import mods.flammpfeil.slashblade.util.SlashBladeEvent;
import mods.flammpfeil.slashblade.util.SlashBladeHooks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class Newbie implements ISpecialEffect {
    private static final String EffectKey = "Newbie";

    @SubscribeEvent
    public void onUpdateItemSlashBlade(SlashBladeEvent.OnUpdateEvent event) {
        if (event.isCurrent && event.entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.entity;
            ItemStack blade = event.blade;
            NBTTagCompound tag = blade.getTagCompound();
            if (tag != null && tag.hasKey("SB.SEffect") && tag.getCompoundTag("SB.SEffect").hasKey("Newbie")) {
                player.sendMessage(new TextComponentString("held"));
            }
        }
    }


    @Override
    public void register()
    {
        SlashBladeHooks.EventBus.register(this);
    }

    @Override
    public int getDefaultRequiredLevel()
    {
        return 0;
    }

    @Override
    public String getEffectKey()
    {
        return EffectKey;
    }
}