package world.maryt.exuslashblade;

import mods.flammpfeil.slashblade.client.model.BladeSpecialRender;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SuppressWarnings("unused")
@EventBusSubscriber
public class ClientProxy extends CommonProxy {
	private static final ModelResourceLocation modelLoc = new ModelResourceLocation(
			"flammpfeil.slashblade:model/named/blade.obj");
	
	@SideOnly(Side.CLIENT)
	public static void Slashblade_model(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, modelLoc);
		item.setTileEntityItemStackRenderer(new BladeSpecialRender());
	}

	public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
    }

	public void init(FMLInitializationEvent event) {
        super.init(event);
    }

	public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }
}
