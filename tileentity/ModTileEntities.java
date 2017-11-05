package kor.kortech.tileentity;

import cpw.mods.fml.common.registry.GameRegistry;

public final class ModTileEntities
{

    public static void initTileEntities()
    {
        GameRegistry.registerTileEntity(TileCustomChest.class, "custom_chest_tile_entity");
        GameRegistry.registerTileEntity(TileCustomMachine.class, "custom_machine_tile_entity");
    }

}