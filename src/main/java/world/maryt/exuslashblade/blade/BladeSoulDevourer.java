package world.maryt.exuslashblade.blade;

import mods.flammpfeil.slashblade.ItemSlashBladeNamed;
import mods.flammpfeil.slashblade.SlashBlade;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import mods.flammpfeil.slashblade.named.event.LoadEvent.InitEvent;
import mods.flammpfeil.slashblade.specialeffect.SpecialEffects;
import net.minecraft.init.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import world.maryt.exuslashblade.se.SELoader;

public class BladeSoulDevourer extends ItemSlashBladeNamed {
	public static final String name = "flammpfeil.slashblade.named.souldevourerbamboolight";

    public BladeSoulDevourer(ToolMaterial par2EnumToolMaterial, float baseAttackModifiers) {
        super(par2EnumToolMaterial, baseAttackModifiers);
    }

    @SubscribeEvent
	public void init(InitEvent event){
	     ItemStack customblade = new ItemStack(SlashBlade.bladeNamed,1,0);
	        NBTTagCompound tag = new NBTTagCompound();
	        customblade.setTagCompound(tag);
	        ItemSlashBladeNamed.IsDefaultBewitched.set(tag, false);
			ItemSlashBladeNamed.CustomMaxDamage.set(tag, 35);
	        ItemSlashBladeNamed.CurrentItemName.set(tag, name);
            ItemSlashBlade.BaseAttackModifier.set(tag, 2.0f);
            ItemSlashBlade.RepairCount.set(tag, 4);

            // Enchanting
            assert Enchantments.POWER != null;
            assert Enchantments.UNBREAKING != null;
            assert Enchantments.SHARPNESS != null;
            customblade.addEnchantment(Enchantments.POWER, 1);
            customblade.addEnchantment(Enchantments.UNBREAKING, 1);
            customblade.addEnchantment(Enchantments.SHARPNESS, 1);

            ItemSlashBlade.TextureName.set(tag, "named/souldevourerbamboolight/texture");
	        ItemSlashBlade.ModelName.set(tag, "named/souldevourerbamboolight/model");
			ItemSlashBlade.StandbyRenderType.set(tag, 1);

			SpecialEffects.addEffect(customblade, SELoader.SoulDevourer);
	        
	        SlashBlade.registerCustomItemStack(name, customblade);
	        ItemSlashBladeNamed.NamedBlades.add(name);
	}

}
