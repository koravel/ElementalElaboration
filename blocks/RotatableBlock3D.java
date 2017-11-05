package kor.kortech.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

//Rotate in all directions
public class RotatableBlock3D extends RotatableBlock
{
    protected RotatableBlock3D(Material material, String[] iconsName)
    {
        super(material, iconsName);
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemstack)
    {
        /*
        0 - bottom
        1 - top
        2 - north
        3 - south
        4 - west
        5 - east
        */

        int k = MathHelper.floor_double((double)(entity.rotationPitch * 2.0F / 90.0F));

        if(Math.abs(k) < 0.5F)
            getRotation(world, x, y, z, entity, itemstack);
        else
            if(k > 0)
                world.setBlockMetadataWithNotify(x, y, z, 1, 2);
            else
                world.setBlockMetadataWithNotify(x, y, z, 0, 2);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return side != meta ? this.icons[1] : this.icons[0];
    }

}
