package kor.kortech.network;

import cpw.mods.fml.common.network.NetworkRegistry;

import kor.kortech.KorTech;

public class ModGUIs
{
    public static void initGUIHadler()
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(KorTech.instance, new GuiHandler());
    }
}
