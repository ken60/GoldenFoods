package goldenfoods.blocks;

import java.util.ArrayList;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import goldenfoods.registry.ModCreativeTab;
import goldenfoods.registry.ModItem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class AppleTreeLeaves extends BlockLeavesBase
{
    int[] field_150128_a;
	protected boolean isFancy;
	protected IIcon[] iicon = new IIcon[2];

	public AppleTreeLeaves()
	{
		super(Material.leaves, false);
		this.setTickRandomly(true);
		this.setCreativeTab(ModCreativeTab.tabMod);
		this.setHardness(0.15F);
		this.setLightOpacity(1);
		this.setStepSound(soundTypeGrass);
		this.setBlockTextureName("goldenfoods:leaves_appleTree");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getBlockColor()
	{
		double d0 = 0.5D;
		double d1 = 1.0D;
		return ColorizerFoliage.getFoliageColor(d0, d1);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderColor(int color)
	{
		return ColorizerFoliage.getFoliageColorBasic();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int colorMultiplier(IBlockAccess iBlockAccess, int x, int y, int z)
	{
		//So that to some extent smooth boundary of biomes, seeking average from biomes around 9 block.
		int ir = 0;
		int ig = 0;
		int ib = 0;

		for (int iz = -1; iz <= 1; ++iz)
		{
			for (int ix = -1; ix <= 1; ++ix)
			{
				int color = iBlockAccess.getBiomeGenForCoords(x + ix, z + iz).getBiomeFoliageColor(x + ix, y, z + iz);
				ir += (color & 16711680) >> 16;
			ig += (color & 65280) >> 8;
			ib += color & 255;
			}
		}

		return (ir / 9 & 255) << 16 | (ig / 9 & 255) << 8 | ib / 9 & 255;
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int meta)
	{
		byte b0 = 1;
		int i1 = b0 + 1;

		if (world.checkChunksExist(x - i1, y - i1, z - i1, x + i1, y + i1, z + i1))
		{
			for (int j1 = -b0; j1 <= b0; ++j1)
			{
				for (int k1 = -b0; k1 <= b0; ++k1)
				{
					for (int l1 = -b0; l1 <= b0; ++l1)
					{
						Block block1 = world.getBlock(x + j1, y + k1, z + l1);
						if (block1.isLeaves(world, x + j1, y + k1, z + l1))
						{
							block1.beginLeavesDecay(world, x + j1, y + k1, z + l1);
						}
					}
				}
			}
		}
	}

	@Override
	public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_)
    {
		if (p_149674_1_.isRemote)
			return;

		if (10 <= p_149674_1_.rand.nextInt(100))
		{
			func_149690_a(p_149674_1_, p_149674_2_, p_149674_3_ - 1, p_149674_4_, 0, 0.0F, 0);
		}
        int l = p_149674_1_.getBlockMetadata(p_149674_2_, p_149674_3_, p_149674_4_);

        if ((l & 8) != 0 && (l & 4) == 0)
        {
            byte b0 = 4;
            int i1 = b0 + 1;
            byte b1 = 32;
            int j1 = b1 * b1;
            int k1 = b1 / 2;

            if (this.field_150128_a == null)
            {
                this.field_150128_a = new int[b1 * b1 * b1];
            }

            int l1;

            if (p_149674_1_.checkChunksExist(p_149674_2_ - i1, p_149674_3_ - i1, p_149674_4_ - i1, p_149674_2_ + i1, p_149674_3_ + i1, p_149674_4_ + i1))
            {
                int i2;
                int j2;

                for (l1 = -b0; l1 <= b0; ++l1)
                {
                    for (i2 = -b0; i2 <= b0; ++i2)
                    {
                        for (j2 = -b0; j2 <= b0; ++j2)
                        {
                            Block block = p_149674_1_.getBlock(p_149674_2_ + l1, p_149674_3_ + i2, p_149674_4_ + j2);

                            if (!block.canSustainLeaves(p_149674_1_, p_149674_2_ + l1, p_149674_3_ + i2, p_149674_4_ + j2))
                            {
                                if (block.isLeaves(p_149674_1_, p_149674_2_ + l1, p_149674_3_ + i2, p_149674_4_ + j2))
                                {
                                    this.field_150128_a[(l1 + k1) * j1 + (i2 + k1) * b1 + j2 + k1] = -2;
                                }
                                else
                                {
                                    this.field_150128_a[(l1 + k1) * j1 + (i2 + k1) * b1 + j2 + k1] = -1;
                                }
                            }
                            else
                            {
                                this.field_150128_a[(l1 + k1) * j1 + (i2 + k1) * b1 + j2 + k1] = 0;
                            }
                        }
                    }
                }

                for (l1 = 1; l1 <= 4; ++l1)
                {
                    for (i2 = -b0; i2 <= b0; ++i2)
                    {
                        for (j2 = -b0; j2 <= b0; ++j2)
                        {
                            for (int k2 = -b0; k2 <= b0; ++k2)
                            {
                                if (this.field_150128_a[(i2 + k1) * j1 + (j2 + k1) * b1 + k2 + k1] == l1 - 1)
                                {
                                    if (this.field_150128_a[(i2 + k1 - 1) * j1 + (j2 + k1) * b1 + k2 + k1] == -2)
                                    {
                                        this.field_150128_a[(i2 + k1 - 1) * j1 + (j2 + k1) * b1 + k2 + k1] = l1;
                                    }

                                    if (this.field_150128_a[(i2 + k1 + 1) * j1 + (j2 + k1) * b1 + k2 + k1] == -2)
                                    {
                                        this.field_150128_a[(i2 + k1 + 1) * j1 + (j2 + k1) * b1 + k2 + k1] = l1;
                                    }

                                    if (this.field_150128_a[(i2 + k1) * j1 + (j2 + k1 - 1) * b1 + k2 + k1] == -2)
                                    {
                                        this.field_150128_a[(i2 + k1) * j1 + (j2 + k1 - 1) * b1 + k2 + k1] = l1;
                                    }

                                    if (this.field_150128_a[(i2 + k1) * j1 + (j2 + k1 + 1) * b1 + k2 + k1] == -2)
                                    {
                                        this.field_150128_a[(i2 + k1) * j1 + (j2 + k1 + 1) * b1 + k2 + k1] = l1;
                                    }

                                    if (this.field_150128_a[(i2 + k1) * j1 + (j2 + k1) * b1 + (k2 + k1 - 1)] == -2)
                                    {
                                        this.field_150128_a[(i2 + k1) * j1 + (j2 + k1) * b1 + (k2 + k1 - 1)] = l1;
                                    }

                                    if (this.field_150128_a[(i2 + k1) * j1 + (j2 + k1) * b1 + k2 + k1 + 1] == -2)
                                    {
                                        this.field_150128_a[(i2 + k1) * j1 + (j2 + k1) * b1 + k2 + k1 + 1] = l1;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            l1 = this.field_150128_a[k1 * j1 + k1 * b1 + k1];

            if (l1 >= 0)
            {
                p_149674_1_.setBlockMetadataWithNotify(p_149674_2_, p_149674_3_, p_149674_4_, l & -9, 4);
            }
            else
            {
                this.removeLeaves(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_);
            }
        }
    }

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random)
	{
		//Drip the water
		if (world.canLightningStrikeAt(x, y + 1, z) && !World.doesBlockHaveSolidTopSurface(world, x, y - 1, z) && random.nextInt(15) == 1)
		{
			double dx = x + random.nextFloat();
			double dy = y - 0.05D;
			double dz = z + random.nextFloat();
			world.spawnParticle("dripWater", dx, dy, dz, 0.0D, 0.0D, 0.0D);
		}
	}

	private void removeLeaves(World world, int x, int y, int z)
	{
		this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
		world.setBlockToAir(x, y, z);
	}

	@Override
	public int quantityDropped(Random random)
	{
		return random.nextInt(20) == 0 ? 1 : 0;
	}

	@Override
	public Item getItemDropped(int meta, Random random, int fortune)
	{
		return Item.getItemFromBlock(this);
	}

	@Override
	public void dropBlockAsItemWithChance(World world, int x, int y, int z, int meta, float chance, int par7)
	{
		super.dropBlockAsItemWithChance(world, x, y, z, meta, 1.0f, par7);
	}

	protected void func_150124_c(World world, int x, int y, int z, int meta, int chance) {}

	protected int func_150123_b(int meta)
	{
		return 20;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return !isFancy;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta)
	{
		return iicon[isFancy ? 0 : 1];
	}

	@SideOnly(Side.CLIENT)
	public void setGraphicsLevel(boolean isFancy)
	{
		this.isFancy = isFancy;
	}

	@Override
	protected ItemStack createStackedBlock(int meta)
	{
		return new ItemStack(Item.getItemFromBlock(this), 1, 0);
	}

	public String[] func_150125_e()
	{
		return null;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess iBlockAccess, int x, int y, int z, int side)
	{
		Block block = iBlockAccess.getBlock(x, y, z);
		//When was the same block is next in processing priority false.
		return !isFancy && block == this ? false : super.shouldSideBeRendered(iBlockAccess, x, y, z, side);
	}

	public boolean isShearable(ItemStack item, IBlockAccess world, int x, int y, int z)
	{
		return true;
	}

	public ArrayList<ItemStack> onSheared(ItemStack item, IBlockAccess world, int x, int y, int z, int fortune)
	{
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		ret.add(new ItemStack(this, 1, world.getBlockMetadata(x, y, z) & 3));
		return ret;
	}

	@Override
	public void beginLeavesDecay(World world, int x, int y, int z)
	{
		int meta = world.getBlockMetadata(x, y, z);

		if ((meta & 8) == 0)
		{
			world.setBlockMetadataWithNotify(x, y, z, meta | 8, 4);
		}
		world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) | 8, 4);
	}

	@Override
	public boolean isLeaves(IBlockAccess world, int x, int y, int z)
	{
		return true;
	}

	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int meta, int fortune)
	{
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		int chance = this.func_150123_b(meta);

		if (fortune > 0)
		{
			chance -= 2 << fortune;
			if (chance < 10)
				chance = 10;
		}

		if (world.rand.nextInt(chance) == 0)
			ret.add(new ItemStack(this.getItemDropped(meta, world.rand, fortune), 1, this.damageDropped(meta)));

		chance = 200;
		if (fortune > 0)
		{
			chance -= 10 << fortune;
			if (chance < 40)
				chance = 40;
		}

		this.captureDrops(true);
		this.func_150124_c(world, x, y, z, meta, chance);
		ret.addAll(this.captureDrops(false));
		return ret;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register)
	{
		iicon[0] = register.registerIcon(this.getTextureName());
		iicon[1] = register.registerIcon(this.getTextureName() + "_opaque");
	}

	public void func_149690_a(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
	{
		if (!par1World.isRemote)
		{
			if (par1World.rand.nextInt(200) == 1)
			{
				this.dropBlockAsItem(par1World, par2, par3, par4, new ItemStack(Items.apple));
			}

			if (par1World.rand.nextInt(500) == 2)
			{
				this.dropBlockAsItem(par1World, par2, par3, par4, new ItemStack(Items.golden_apple, 1, 0));
			}

			if (par1World.rand.nextInt(700) == 3)
			{
				this.dropBlockAsItem(par1World, par2, par3, par4, new ItemStack(Items.golden_apple, 1, 1));
			}

			if (par1World.rand.nextInt(1000) == 4)
			{
				this.dropBlockAsItem(par1World, par2, par3, par4, new ItemStack(ModItem.magicGoldenApple));
			}
		}
	}
}