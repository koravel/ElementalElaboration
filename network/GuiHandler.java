package kor.kortech.network;

import cpw.mods.fml.common.network.IGuiHandler;
import kor.kortech.client.gui.GuiCustomMachineTileEntity;
import kor.kortech.guicontainer.ContainerTileCustomMachine;
import kor.kortech.tileentity.TileCustomMachine;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import kor.kortech.guicontainer.ContainerTileCustomChest;
import kor.kortech.client.gui.GuiCustomChestTileEntity;
import kor.kortech.tileentity.TileCustomChest;

public class GuiHandler implements IGuiHandler
{

    public static final int customChestGUIID = 0;
    public static final int customMachineGUIID = 1;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        switch (ID)
        {
            case customChestGUIID:
            {
                return new ContainerTileCustomChest(player.inventory, (TileCustomChest) world.getTileEntity(x, y, z));
            }
            case customMachineGUIID:
            {
                return new ContainerTileCustomMachine(player.inventory, (TileCustomMachine) world.getTileEntity(x, y, z));
            }
            default: return null;
        }

    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        switch (ID)
        {
            case customChestGUIID:
            {
                return new GuiCustomChestTileEntity(player.inventory, (TileCustomChest) world.getTileEntity(x, y, z));
            }
            case customMachineGUIID:
            {
                return new GuiCustomMachineTileEntity(player.inventory, (TileCustomMachine) world.getTileEntity(x, y, z));
            }
            default: return null;
        }
    }
}
