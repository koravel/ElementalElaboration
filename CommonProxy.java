package kor.kortech;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import kor.kortech.blocks.ModBlocks;
import kor.kortech.items.ModItems;
import kor.kortech.network.ModGUIs;
import kor.kortech.tileentity.ModTileEntities;
import kor.kortech.util.CMRecipeManager;
import kor.kortech.util.Recipies;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e)
    {
        ModBlocks.createBlocks();
        ModItems.createItems();
        Recipies.initShapedRecipies();
        Recipies.initShapelessRecipies();
        Recipies.initSmeltingRecipies();
        CMRecipeManager.instance().initCMRecipes();
    }

    public void init(FMLInitializationEvent e)
    {
        ModTileEntities.initTileEntities();
        ModGUIs.initGUIHadler();
    }

    public void postInit(FMLPostInitializationEvent e)
    {

    }
}
