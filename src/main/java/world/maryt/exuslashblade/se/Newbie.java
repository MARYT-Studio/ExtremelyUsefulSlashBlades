package world.maryt.exuslashblade.se;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import mods.flammpfeil.slashblade.specialeffect.ISpecialEffect;
import mods.flammpfeil.slashblade.util.SlashBladeEvent;
import mods.flammpfeil.slashblade.util.SlashBladeHooks;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.UUID;

import static world.maryt.exuslashblade.ExtremelyUsefulSlashBlades.LOGGER;

@Mod.EventBusSubscriber
public class Newbie implements ISpecialEffect {
    private static final String EffectKey = "Newbie";

    public static Multimap<String, AttributeModifier> getAttributeModifiers() {
        Multimap<String, AttributeModifier> multimap = HashMultimap.create();
        multimap.put(SharedMonsterAttributes.ARMOR.getName(), new AttributeModifier(UUID.fromString("8C62445C-DB27-0A49-F5B6-60825F9A8C9B"), "Newbie armor", 4.0f, 0));
        multimap.put(SharedMonsterAttributes.ARMOR_TOUGHNESS.getName(), new AttributeModifier(UUID.fromString("8C62445C-DB27-0A49-F5B6-60825F9A8C9B"), "Newbie armor toughness", 2.0f, 0));
        return multimap;
    }

    @SubscribeEvent
    public void onUpdateItemSlashBlade(SlashBladeEvent.OnUpdateEvent event) {
        if (event.isCurrent && event.entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.entity;
            ItemStack blade = event.blade;
            NBTTagCompound tag = blade.getTagCompound();
            if (tag != null && tag.hasKey("SB.SEffect") && tag.getCompoundTag("SB.SEffect").hasKey("Newbie")) {
                LOGGER.info("apply");
                player.getAttributeMap().applyAttributeModifiers(getAttributeModifiers());
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