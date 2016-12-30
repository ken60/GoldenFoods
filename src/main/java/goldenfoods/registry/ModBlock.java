package goldenfoods.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import goldenfoods.blocks.AppleTreeLeaves;
import net.minecraft.block.Block;

public class ModBlock
{
	public static Block appleTreeLeaves = new AppleTreeLeaves();

	public static void RegisterBlock()
	{
		GameRegistry.registerBlock(appleTreeLeaves, "appleTreeLeaves");
	}

	public static void SetLanguage()
	{
		LanguageRegistry.addName(appleTreeLeaves, "AppleTree Leaves");
	}
}
