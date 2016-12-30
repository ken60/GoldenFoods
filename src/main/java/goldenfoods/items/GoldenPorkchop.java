package goldenfoods.items;

import goldenfoods.registry.ModCreativeTab;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class GoldenPorkchop extends ItemFood
{
	public GoldenPorkchop(int par2, float par3, boolean par4)
	{
		super(par2, par3, par4);
		this.setCreativeTab(ModCreativeTab.tabMod);
		this.setUnlocalizedName("goldenPorkchop");
		this.setTextureName("goldenfoods:goldenPorkchop");
		this.setMaxStackSize(64);
		this.setAlwaysEdible();
	}

	protected void onFoodEaten(ItemStack itemStack, World world, EntityPlayer entity)
	{
		if(entity instanceof EntityLivingBase) ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(5, 3600, 0));
		if(entity instanceof EntityLivingBase) ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(10, 3600, 1));
		if(entity instanceof EntityLivingBase) ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(11, 3600, 0));
	}
}
