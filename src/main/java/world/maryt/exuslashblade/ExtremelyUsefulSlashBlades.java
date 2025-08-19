package world.maryt.exuslashblade;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
    private static final Logger LOGGER = LogManager.getLogger(MOD_NAME);

    @SidedProxy(clientSide = "world.maryt.exuslashblade.ClientProxy", serverSide = "world.maryt.exuslashblade.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) { proxy.init(event); }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
