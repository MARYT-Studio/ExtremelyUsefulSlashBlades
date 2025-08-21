package world.maryt.exuslashblade;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import world.maryt.exuslashblade.events.NewbieEffect;
import world.maryt.exuslashblade.se.SELoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


@SuppressWarnings("InstantiationOfUtilityClass")
public class CommonProxy {
	public void preInit(FMLPreInitializationEvent event){
		 new SELoader();
		 new BladeLoader(event);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new NewbieEffect());
	}

    public void postInit(FMLPostInitializationEvent event) {}
}
