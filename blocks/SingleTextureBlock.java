package kor.kortech.blocks;

import net.minecraft.block.material.Material;

import kor.kortech.util.References;

public class SingleTextureBlock extends KTBlock
{

    protected SingleTextureBlock(Material material, String unlocalizedName)
    {
        super(material);
        this.setBlockName(unlocalizedName);
        this.setBlockTextureName(References.MODID + ":" + this.getUnlocalizedName().substring(5));
    }
}
