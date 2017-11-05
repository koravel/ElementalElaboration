package kor.kortech.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import kor.kortech.KorTech;

public class KTBlock extends Block
{

    protected KTBlock(Material material)
    {
        super(material);

        this.setCreativeTab(KorTech.customTab);
    }
}
