package kor.kortech.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

import kor.kortech.util.References;

public class MultiTTextureBlock extends KTBlock
{
    public IIcon[] icons = new IIcon[6];
    public String[] iconsName;

    protected MultiTTextureBlock(Material material, String[] iconsName)
    {
        super(material);
        this.iconsName = iconsName;
    }

    @Override
    public void registerBlockIcons(IIconRegister reg)
    {
        /*
        0 - front
        1 - top
        2 - bottom
        3 - behind
        4 - left
        5 - right
        */

        this.icons[0] = reg.registerIcon(References.MODID + ":" + iconsName[0]);
        this.icons[1] = reg.registerIcon(References.MODID + ":" + iconsName[1]);
        this.icons[1] = reg.registerIcon(References.MODID + ":" + iconsName[2]);
        this.icons[2] = reg.registerIcon(References.MODID + ":" + iconsName[3]);
        this.icons[4] = reg.registerIcon(References.MODID + ":" + iconsName[4]);
        this.icons[5] = reg.registerIcon(References.MODID + ":" + iconsName[5]);
    }
}
