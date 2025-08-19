package world.maryt.exuslashblade;

import mods.flammpfeil.slashblade.SlashBlade;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class BladeLoader {
	public BladeLoader(FMLPreInitializationEvent event) {
		SlashBlade.InitEventBus.register(event);
	}
}
