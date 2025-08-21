package world.maryt.exuslashblade;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import world.maryt.exuslashblade.events.NewbieEffect;
import world.maryt.exuslashblade.se.SELoader;

@SuppressWarnings("InstantiationOfUtilityClass")
@Mod(modid = ExtremelyUsefulSlashBlades.MOD_ID,
        name = ExtremelyUsefulSlashBlades.MOD_NAME,
        version = Tags.VERSION,
        acceptedMinecraftVersions = "1.12.2",
        dependencies = "required-after:flammpfeil.slashblade@[mc1.12-r32,);required-after:mm_lib@[2.3.0,)"
)
public class ExtremelyUsefulSlashBlades {
    public static final String MOD_ID = Tags.MOD_ID;
    public static final String MOD_NAME = Tags.MOD_NAME;

    @SuppressWarnings("unused")
    public static final Logger LOGGER = LogManager.getLogger(MOD_NAME);

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        new SELoader();
        new BladeLoader(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new NewbieEffect());
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {}
}
