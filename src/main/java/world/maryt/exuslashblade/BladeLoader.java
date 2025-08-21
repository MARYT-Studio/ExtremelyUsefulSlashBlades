package world.maryt.exuslashblade;

import mods.flammpfeil.slashblade.SlashBlade;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import world.maryt.exuslashblade.blade.BladeFreshBrave;

public class BladeLoader {
	public BladeLoader(FMLPreInitializationEvent event) {
		SlashBlade.InitEventBus.register(new BladeFreshBrave());
	}
}
