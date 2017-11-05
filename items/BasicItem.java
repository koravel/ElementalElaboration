package kor.kortech.items;

import net.minecraft.item.Item;

import kor.kortech.KorTech;
import kor.kortech.util.References;

public class BasicItem extends Item
{
    public BasicItem(String unlocalizedName)
    {
        super();

        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(KorTech.customTab);
        this.setTextureName(References.MODID + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }
}
