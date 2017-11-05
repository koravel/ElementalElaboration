package kor.kortech.util;

import cpw.mods.fml.common.FMLCommonHandler;

import kor.kortech.KorTech;

public class ConfigurationKorTech
{
    public static boolean cheapRecipe;
    public static final boolean CHEAPRECIPE_DEFAULT = false;
    public static final String CHEAPRECIPE_NAME = "Enable the cheap recipe";

    public static void syncConfig()
    {
        FMLCommonHandler.instance().bus().register(KorTech.instance);

        final String RECIPIES = KorTech.config.CATEGORY_GENERAL + KorTech.config.CATEGORY_SPLITTER + "Recipies";
        KorTech.config.addCustomCategoryComment(RECIPIES, "Enable/disable recipes");
        cheapRecipe = KorTech.config.get(RECIPIES, CHEAPRECIPE_NAME, CHEAPRECIPE_DEFAULT).getBoolean(CHEAPRECIPE_DEFAULT);
        if(KorTech.config.hasChanged())
        {
            KorTech.config.save();
        }
    }
}
