package world.maryt.exuslashblade.se;

import mods.flammpfeil.slashblade.ItemSlashBlade;
import mods.flammpfeil.slashblade.ItemSlashBladeNamed;
import mods.flammpfeil.slashblade.SlashBlade;
import mods.flammpfeil.slashblade.specialeffect.ISpecialEffect;
import mods.flammpfeil.slashblade.util.SlashBladeEvent;
import mods.flammpfeil.slashblade.util.SlashBladeHooks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import world.maryt.exuslashblade.blade.BladeSoulDevourer;

import java.util.Objects;

@Mod.EventBusSubscriber
public class SoulDevourer implements ISpecialEffect {
    private static final String EffectKey = "SoulDevourer";

    @SubscribeEvent
    public void reduceMaxDamage(SlashBladeEvent.OnUpdateEvent event) {
        ItemStack blade = event.blade;
        NBTTagCompound tag = blade.getTagCompound();
        if (!(Objects.equals(ItemSlashBladeNamed.CurrentItemName.get(tag), BladeSoulDevourer.name))) return;
        int damage = blade.getItemDamage();
        if (ItemSlashBladeNamed.CustomMaxDamage.get(tag) <= 2) {
            //            NBTTagList enchantments = blade.getEnchantmentTagList();
            if (!ItemSlashBladeNamed.IsBroken.get(tag)) return;

            ItemStack wrapper = SlashBlade.findItemStack("flammpfeil.slashblade", "slashbladeWrapper", 1);
            ItemSlashBlade.KillCount.set(wrapper.getTagCompound(), ItemSlashBlade.KillCount.get(tag));
            ItemSlashBlade.ProudSoul.set(wrapper.getTagCompound(), ItemSlashBlade.ProudSoul.get(tag));

//            for (int index = 0; index < enchantments.tagCount(); index++) {
//                NBTTagCompound enchantmentEntry = enchantments.getCompoundTagAt(index);
//                LOGGER.info(enchantmentEntry.toString());
////                wrapper.addEnchantment();
//            }

            blade.shrink(1);
            if (event.entity instanceof EntityPlayer) {
                EntityPlayer player = (EntityPlayer) event.entity;
                player.addItemStackToInventory(wrapper);
            }
        } else {
            ItemSlashBladeNamed.CustomMaxDamage.add(tag, -damage);
            blade.setItemDamage(0);
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