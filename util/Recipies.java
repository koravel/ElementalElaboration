package kor.kortech.util;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import kor.kortech.blocks.ModBlocks;
import kor.kortech.items.ModItems;

public class Recipies
{
    public static void initShapedRecipies()
    {
        if(ConfigurationKorTech.cheapRecipe)
        {
            GameRegistry.addRecipe(new ItemStack(ModBlocks.tank),new Object[]{"GGG","G G","GGG", 'G', Blocks.glass});
        }
        else
        {
            GameRegistry.addRecipe(new ItemStack(ModBlocks.tank),new Object[]{"GGG","G G","GGG", 'G', Blocks.gold_block});
        }
    }

    public static void initShapelessRecipies()
    {
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.tutorialItem, 8),new ItemStack(Items.iron_ingot, 6));
    }

    public static void initSmeltingRecipies()
    {
        //GameRegistry.addSmelting(Blocks.iron_block,new ItemStack(ModBlocks.tutorialBlock), 120F);
    }
}
