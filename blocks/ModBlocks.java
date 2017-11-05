package kor.kortech.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class ModBlocks
{
    public static Block cChest;
    public static Block cMachine;
    public static Block tank;

    public static void createBlocks()
    {
        GameRegistry.registerBlock(cChest = new CustomChest(), "custom_chest");
        GameRegistry.registerBlock(cMachine = new CustomMachine(), "custom_machine");
        GameRegistry.registerBlock(tank = new FluidTank(), "fluid_tank");
    }
}
