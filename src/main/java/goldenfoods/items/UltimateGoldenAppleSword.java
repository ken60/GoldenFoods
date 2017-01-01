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

public class UltimateGoldenAppleSword extends ItemSword
{
	public UltimateGoldenAppleSword()
	{
		super(ModMaterial.ultimateGoldenAppleSword);

		setCreativeTab(ModCreativeTab.tabMod);
		setUnlocalizedName("ultimateGoldenAppleSword");
		this.setTextureName("goldenfoods:ultimateGoldenAppleSword");
		setFull3D();
		setMaxStackSize(1);
	}

	@Override
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List itemList)
	{
		ItemStack itemStack = new ItemStack(this, 1, 0);

		itemStack.addEnchantment(Enchantment.sharpness, 4);
		itemStack.addEnchantment(Enchantment.knockback, 2);
		itemStack.addEnchantment(Enchantment.fireAspect, 4);

		itemList.add(itemStack);
	}

	public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5)
	{
		super.onUpdate(stack, world, entity, par4, par5);

		if(stack.isItemEnchanted() == false)
		{
			stack.addEnchantment(Enchantment.sharpness, 4);
			stack.addEnchantment(Enchantment.knockback, 2);
			stack.addEnchantment(Enchantment.fireAspect, 4);

			super.onUpdate(stack, world, entity, par4, par5);
		}

	}
}
