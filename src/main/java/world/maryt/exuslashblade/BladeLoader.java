package world.maryt.exuslashblade;

import mods.flammpfeil.slashblade.SlashBlade;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import world.maryt.exuslashblade.blade.BladeFreshBrave;

public class BladeLoader {
	public BladeLoader(FMLPreInitializationEvent event) {
		SlashBlade.InitEventBus.register(new BladeFreshBrave(Item.ToolMaterial.WOOD, 5.0f));
	}
}
