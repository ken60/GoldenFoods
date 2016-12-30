package goldenfoods.items;

import java.util.List;

import goldenfoods.registry.ModCreativeTab;
import goldenfoods.registry.ModMaterial;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class GoldenAppleSword extends ItemSword
{
	public GoldenAppleSword()
	{
		super(ModMaterial.goldenAppleSword);

		setCreativeTab(ModCreativeTab.tabMod);
		setUnlocalizedName("goldenAppleSword");
		this.setTextureName("goldenfoods:goldenAppleSword");
		setFull3D();
		setMaxStackSize(1);
	}

	@Override
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List itemList)
	{
		ItemStack itemStack = new ItemStack(this, 1, 0);

		itemStack.addEnchantment(Enchantment.sharpness, 2);
		itemStack.addEnchantment(Enchantment.knockback, 2);

		itemList.add(itemStack);
	}

	public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5)
	{
		super.onUpdate(stack, world, entity, par4, par5);

		if(stack.isItemEnchanted() == false)
		{
			stack.addEnchantment(Enchantment.sharpness, 2);
			stack.addEnchantment(Enchantment.knockback, 2);

			super.onUpdate(stack, world, entity, par4, par5);
		}

	}
}
