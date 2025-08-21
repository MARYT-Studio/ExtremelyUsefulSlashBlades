package world.maryt.exuslashblade.events;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import mods.flammpfeil.slashblade.ItemSlashBlade;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.UUID;

public class NewbieEffect {

    private static Multimap<String, AttributeModifier> getAttributeModifiers() {
        Multimap<String, AttributeModifier> multimap = HashMultimap.create();
        multimap.put(SharedMonsterAttributes.ARMOR.getName(), new AttributeModifier(UUID.fromString("8C62445C-DB27-0A49-F5B6-60825F9A8C9B"), "Newbie armor", 4.0f, 0));
        multimap.put(SharedMonsterAttributes.ARMOR_TOUGHNESS.getName(), new AttributeModifier(UUID.fromString("8C62445C-DB27-0A49-F5B6-60825F9A8C9B"), "Newbie armor toughness", 2.0f, 0));
        return multimap;
    }

    @SubscribeEvent
    public static void onUpdateItemSlashBlade(TickEvent.PlayerTickEvent event) {
        EntityPlayer player = event.player;
        if (!(player.getHeldItemMainhand().getItem() instanceof ItemSlashBlade)) {
            player.getAttributeMap().removeAttributeModifiers(getAttributeModifiers());
        } else {
            ItemStack blade = player.getHeldItemMainhand();
            NBTTagCompound tag = blade.getTagCompound();
            if (tag != null && tag.hasKey("SB.SEffect") && tag.getCompoundTag("SB.SEffect").hasKey("Newbie")) {
                player.getAttributeMap().applyAttributeModifiers(getAttributeModifiers());
                player.sendMessage(new TextComponentString("held"));
            }
        }
    }
}
