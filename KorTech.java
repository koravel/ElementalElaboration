package kor.kortech;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.config.Configuration;

import kor.kortech.tabs.KorTechTab;
import kor.kortech.util.ConfigurationKorTech;
import kor.kortech.util.References;

import org.apache.logging.log4j.Logger;

@Mod(modid = References.MODID, name = References.MODNAME, version = References.VERSION, guiFactory = References.MODPATH + ".util.KorTechGUIFactory")
public class KorTech
{

    private static Logger Loger = FMLLog.getLogger();
    private static boolean degug = true;

    public static void Log(Object text)
    {
        if(degug)
            KorTech.Loger.info(text);
    }

    @SidedProxy(clientSide = References.MODPATH + ".ClientProxy", serverSide = References.MODPATH + ".ServerProxy")
    public static CommonProxy proxy;

    public static CreativeTabs customTab = new KorTechTab(CreativeTabs.getNextID(), References.MODNAME);

    public static Configuration config;

    @Instance(References.MODID)
    public static KorTech instance;

    @EventHandler
    public void preInit(FMLPreInitializationEvent e)
    {
        config = new Configuration(e.getSuggestedConfigurationFile());
        ConfigurationKorTech.syncConfig();

        this.proxy.preInit(e);
    }

    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent e)
    {
        if(e.modID.equals(References.MODID))
        {
            ConfigurationKorTech.syncConfig();
        }
    }

    @EventHandler
    public void init(FMLInitializationEvent e)
    {
        FMLCommonHandler.instance().bus().register(instance);
        this.proxy.init(e);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e)
    {
        this.proxy.postInit(e);
    }
}
