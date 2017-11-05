package kor.kortech.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import kor.kortech.tileentity.TileKT;

//Rotate in 4 directions - N,S,E,W
public class RotatableBlock extends MultiTTextureBlock
{
    protected RotatableBlock(Material material, String[] iconsName)
    {
        super(material, iconsName);
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemstack)
    {
        getRotation(world, x, y, z, entity, itemstack);
    }

    protected void getRotation(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemstack)
    {
        /*
        0 - bottom
        1 - top
        2 - north
        3 - south
        4 - west
        5 - east
        */

        if (itemstack.hasDisplayName())
        {
            ((TileKT) world.getTileEntity(x, y, z)).setCustomName(itemstack.getDisplayName());
        }

        int l = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0)
        {
            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        }

        if (l == 1)
        {
            world.setBlockMetadataWithNotify(x, y, z, 5, 2);
        }

        if (l == 2)
        {
            world.setBlockMetadataWithNotify(x, y, z, 3, 2);
        }

        if (l == 3)
        {
            world.setBlockMetadataWithNotify(x, y, z, 4, 2);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return side == 1 ? this.icons[1] : (side == 0 ? this.icons[1] : (side != meta ? this.icons[1] : this.icons[0]));
    }
}
