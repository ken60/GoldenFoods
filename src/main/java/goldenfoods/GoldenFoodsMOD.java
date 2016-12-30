package goldenfoods;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import goldenfoods.registry.ModBlock;
import goldenfoods.registry.ModItem;
import goldenfoods.registry.ModRecipe;

@Mod(modid = GoldenFoodsMOD.MOD_ID, name = GoldenFoodsMOD.MODNAME, version = GoldenFoodsMOD.VERSION)
public class GoldenFoodsMOD
{
	public static final String MOD_ID = "goldenfoods";
	public static final String MODNAME = "GoldenFoods Mod";
	public static final String VERSION = "0.0.1";

	@EventHandler
	public void preInit(FMLPreInitializationEvent e)
	{
		ModBlock.RegisterBlock();
		ModItem.RegisterItem();
	}

	@EventHandler
	public void init(FMLInitializationEvent e)
	{
		ModBlock.SetLanguage();
		ModItem.SetLanguage();

		ModRecipe.RegisterRecipe();
	}
}
