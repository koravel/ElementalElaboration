package kor.kortech.guicontainer;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

import kor.kortech.tileentity.TileCustomChest;

public class ContainerTileCustomChest extends BaseContainer
{

    public ContainerTileCustomChest(IInventory playerInv, TileCustomChest tileEntity)
    {
        super(0,3,3,38);
        setTileEntity(tileEntity);

        // Tile Entity, Slot 0-2, Slot IDs 0-2
        for (int y = 0; y < 1; ++y)
        {
            for (int x = 0; x < 3; ++x)
            {
                this.addSlotToContainer(new Slot(tileEntity, x + y * 3, 62 + x * 18, 17 + y * 18));
            }
        }

        // Player Inventory, Slot 3-29, Slot IDs 3-29
        for (int y = 0; y < 3; ++y)
        {
            for (int x = 0; x < 9; ++x)
            {
                this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
            }
        }

        // Player Inventory, Slot 0-8, Slot IDs 30-38
        for (int x = 0; x < 9; ++x)
        {
            this.addSlotToContainer(new Slot(playerInv, x, 8 + x * 18, 142));
        }
    }
}
