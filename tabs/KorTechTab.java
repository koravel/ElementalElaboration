package kor.kortech.tabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import kor.kortech.items.ModItems;

public class KorTechTab extends CreativeTabs
{

    public KorTechTab(int id, String lable)
    {
        super(id, lable);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getTabIconItem()
    {
        return ModItems.tutorialItem;
    }
}
