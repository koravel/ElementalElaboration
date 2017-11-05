package kor.kortech.items;

import cpw.mods.fml.common.registry.GameRegistry;

public final class ModItems
{
    public static BasicItem tutorialItem;

    public static void createItems()
    {
        GameRegistry.registerItem(tutorialItem = new BasicItem("tutorial_item"), "tutorial_item");
    }
}
