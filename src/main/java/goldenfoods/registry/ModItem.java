package goldenfoods.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import goldenfoods.items.AppleSeed;
import goldenfoods.items.GoldenApplePie;
import goldenfoods.items.GoldenAppleSword;
import goldenfoods.items.GoldenBeef;
import goldenfoods.items.GoldenChicken;
import goldenfoods.items.GoldenPorkchop;
import goldenfoods.items.GpldenAppleJuice;
import goldenfoods.items.MagicGoldenApple;
import goldenfoods.items.UltimateGoldenAppleSword;
import goldenfoods.items.UltimateMagicGoldenApple;
import net.minecraft.item.Item;

public class ModItem
{
	public static Item appleSeed = new AppleSeed();

	public static Item goldenBeef = new GoldenBeef(10, 0.8f, false);
	public static Item goldenChicken = new GoldenChicken(8, 0.6f, false);
	public static Item goldenPorkchop = new GoldenPorkchop(5, 0.6f, false);
	public static Item magicGoldenApple = new MagicGoldenApple(6, 0.6f, false);
	public static Item ultimateMagicGoldenApple = new UltimateMagicGoldenApple(6, 0.6f, false);
	public static Item gpldenAppleJuice = new GpldenAppleJuice(2, 0.6f, false);
	public static Item goldenApplePie = new GoldenApplePie(9, 0.6f, false);

	public static Item goldenAppleSword = new GoldenAppleSword();
	public static Item ultimateGoldenAppleSword = new UltimateGoldenAppleSword();

	public static void RegisterItem()
	{
		GameRegistry.registerItem(appleSeed, "appleSeed");

		GameRegistry.registerItem(goldenBeef, "goldenBeef");
		GameRegistry.registerItem(goldenChicken, "goldenChicken");
		GameRegistry.registerItem(goldenPorkchop, "goldenPorkchop");
		GameRegistry.registerItem(magicGoldenApple, "magicGoldenApple");
		GameRegistry.registerItem(ultimateMagicGoldenApple, "ultimateMagicGoldenApple");
		GameRegistry.registerItem(gpldenAppleJuice, "gpldenAppleJuice");
		GameRegistry.registerItem(goldenApplePie, "goldenApplePie");

		GameRegistry.registerItem(goldenAppleSword, "goldenAppleSword");
		GameRegistry.registerItem(ultimateGoldenAppleSword, "ultimateGoldenAppleSword");
	}

	public static void SetLanguage()
	{
		LanguageRegistry.addName(appleSeed, "Apple Seed");

		LanguageRegistry.addName(goldenBeef, "Golden Beef");
		LanguageRegistry.addName(goldenChicken, "Golden Chicken");
		LanguageRegistry.addName(goldenPorkchop, "Golden Porkchop");
		LanguageRegistry.addName(magicGoldenApple, "Magic Golden Apple");
		LanguageRegistry.addName(ultimateMagicGoldenApple, "Ultimate Magic Golden Apple");
		LanguageRegistry.addName(gpldenAppleJuice, "GpldenApple Juice");
		LanguageRegistry.addName(goldenApplePie, "GoldenApple Pie");

		LanguageRegistry.addName(goldenAppleSword, "goldenAppleSword");
		LanguageRegistry.addName(ultimateGoldenAppleSword, "UltimateGoldenAppleSword");
	}
}
