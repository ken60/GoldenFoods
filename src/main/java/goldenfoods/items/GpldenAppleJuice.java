package goldenfoods.items;

import goldenfoods.registry.ModCreativeTab;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class GpldenAppleJuice extends ItemFood
{
	public GpldenAppleJuice(int par2, float par3, boolean par4)
	{
		super(par2, par3, par4);
		this.setCreativeTab(ModCreativeTab.tabMod);
		this.setUnlocalizedName("gpldenAppleJuice");
		this.setTextureName("goldenfoods:gpldenAppleJuice");
		this.setMaxStackSize(1);
		this.setAlwaysEdible();

		this.setPotionEffect(1, 3600, 0, 1f);
		this.setPotionEffect(5, 3600, 0, 1f);
		this.setPotionEffect(8, 3600, 1, 1f);
		this.setPotionEffect(10, 3600, 1, 1f);
		this.setPotionEffect(11, 3600, 0, 1f);
		this.setPotionEffect(12, 3600, 1, 1f);
		this.setPotionEffect(23, 3600, 0, 1f);
	}

	protected void onFoodEaten(ItemStack itemStack, World world, EntityPlayer entity)
	{
		if(entity instanceof EntityLivingBase) ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(1, 3600, 1));
		if(entity instanceof EntityLivingBase) ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(5, 3600, 0));
		if(entity instanceof EntityLivingBase) ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(10, 3600, 1));
		if(entity instanceof EntityLivingBase) ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(11, 3600, 0));
		if(entity instanceof EntityLivingBase) ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(12, 3600, 1));
	}

	public EnumAction getItemUseAction(ItemStack par1ItemStack)
	{
		return EnumAction.drink;
	}
}
