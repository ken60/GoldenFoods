package goldenfoods.registry;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ModCreativeTab
{
	public static final CreativeTabs tabMod = new CreativeTabs("GoldenFoods")
	{
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem()
		{
			return ModItem.magicGoldenApple;
		}
	};
}
