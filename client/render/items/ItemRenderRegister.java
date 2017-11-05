package kor.kortech.client.render.items;

import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import kor.kortech.util.References;
import kor.kortech.items.ModItems;

public class ItemRenderRegister
{
    public static void registerItemRenderer()
    {
        reg(ModItems.tutorialItem);
    }

    public static void reg(Item item)
    {
        //Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(References.MODID + ":" + item.getUnlocalizedName().substring(item.getUnlocalizedName().indexOf(".") + 1), "inventory"));
    }
}
