package goldenfoods.items;

import goldenfoods.registry.ModCreativeTab;
import goldenfoods.world.gen.AppleTree;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class AppleSeed extends Item
{
	private AppleTree appleTree = new AppleTree();

	public AppleSeed()
	{
		setMaxDamage(0);
		maxStackSize = 64;
		setUnlocalizedName("AppleSeed");
		setTextureName("goldenfoods:appleSeed");
		this.setCreativeTab(ModCreativeTab.tabMod);
	}

	public boolean onItemUse(ItemStack itemStack, EntityPlayer entity, World world, int i, int j, int k, int l, float a, float b, float c)
	{
		float var4 = 1.0F;

		appleTree.generateSurface(world, i, j, k);
		--itemStack.stackSize;

		return true;
	}
}
