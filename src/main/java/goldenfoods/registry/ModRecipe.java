package goldenfoods.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ModRecipe
{
	public static void RegisterRecipe()
	{
		Material();
		Food();
		Block();
		Tool();
		Armor();
		Furnace();
	}

	private static void Material()
	{
		GameRegistry.addShapelessRecipe(new ItemStack(ModItem.appleSeed, 1), Items.apple);
	}

	private static void Food()
	{
		GameRegistry.addRecipe(new ItemStack(ModItem.goldenBeef, 1),
				"GGG",
				"GMG",
				"GGG",
				'G', Items.gold_ingot,
				'M', Items.cooked_beef
				);

		GameRegistry.addRecipe(new ItemStack(ModItem.goldenChicken, 1),
				"GGG",
				"GMG",
				"GGG",
				'G', Items.gold_ingot,
				'M', Items.cooked_chicken
				);


		GameRegistry.addRecipe(new ItemStack(ModItem.goldenPorkchop, 1),
				"GGG",
				"GMG",
				"GGG",
				'G', Items.gold_ingot,
				'M', Items.cooked_porkchop
				);

		GameRegistry.addRecipe(new ItemStack(ModItem.magicGoldenApple, 1),
				"GGG",
				"GAG",
				"GGG",
				'G', Items.gold_ingot,
				'A', Items.golden_apple
				);

		GameRegistry.addRecipe(new ItemStack(ModItem.ultimateMagicGoldenApple, 1),
				"GGG",
				"GGG",
				"GGG",
				'G', ModItem.magicGoldenApple
				);

		GameRegistry.addRecipe(new ItemStack(ModItem.gpldenAppleJuice, 1),
				"SSS",
				"AAA",
				" B ",
				'S', Items.sugar,
				'A', Items.golden_apple,
				'B', Items.glass_bottle
				);

		GameRegistry.addRecipe(new ItemStack(ModItem.goldenApplePie, 1),
				"ASE",
				"   ",
				"   ",
				'A', Items.golden_apple,
				'S', Items.sugar,
				'E', Items.egg
				);

		GameRegistry.addRecipe(new ItemStack(ModItem.goldenApplePie, 1),
				"   ",
				"ASE",
				"   ",
				'A', Items.golden_apple,
				'S', Items.sugar,
				'E', Items.egg
				);

		GameRegistry.addRecipe(new ItemStack(ModItem.goldenApplePie, 1),
				"   ",
				"   ",
				"ASE",
				'A', Items.golden_apple,
				'S', Items.sugar,
				'E', Items.egg
				);
	}

	private static void Block()
	{

	}

	private static void Tool()
	{
		GameRegistry.addRecipe(new ItemStack(ModItem.goldenAppleSword, 1),
				"A  ",
				"A  ",
				"S  ",
				'A', ModItem.magicGoldenApple,
				'S', Items.stick
				);

		GameRegistry.addRecipe(new ItemStack(ModItem.goldenAppleSword, 1),
				" A ",
				" A ",
				" S ",
				'A', ModItem.magicGoldenApple,
				'S', Items.stick
				);

		GameRegistry.addRecipe(new ItemStack(ModItem.goldenAppleSword, 1),
				"  A",
				"  A",
				"  S",
				'A', ModItem.magicGoldenApple,
				'S', Items.stick
				);

		GameRegistry.addRecipe(new ItemStack(ModItem.ultimateGoldenAppleSword, 1),
				"DAD",
				"DAD",
				" S ",
				'A', ModItem.ultimateMagicGoldenApple,
				'D', Items.diamond,
				'S', Items.stick
				);
	}

	private static void Armor()
	{

	}

	private static void Furnace()
	{

	}
}
