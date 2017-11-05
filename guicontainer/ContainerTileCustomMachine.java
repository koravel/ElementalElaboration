package kor.kortech.guicontainer;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.Slot;

import kor.kortech.tileentity.TileCustomMachine;

public class ContainerTileCustomMachine extends BaseContainer
{


    public ContainerTileCustomMachine(IInventory playerInv, TileCustomMachine tileEntity)
    {
        super(0,3, 4,40);
        setTileEntity(tileEntity);

        CustomMachineSlot slotFirst = new CustomMachineSlot((ISidedInventory) tileEntity, 0, 52, 16);
        CustomMachineSlot slotSecond = new CustomMachineSlot((ISidedInventory) tileEntity, 1, 80, 16);
        CustomMachineSlot slotThird = new CustomMachineSlot((ISidedInventory) tileEntity, 2, 107, 16);
        CustomMachineSlot slotOut = new CustomMachineSlot((ISidedInventory) tileEntity, 3, 80, 46);

        // Tile Entity, Slot 0-3, Slot IDs 0-3
        this.addSlotToContainer(slotFirst);
        this.addSlotToContainer(slotSecond);
        this.addSlotToContainer(slotThird);

        this.addSlotToContainer(slotOut);

        // Player Inventory, Slot 4-35, Slot IDs 4-35
        for (int y = 0; y < 3; ++y)
            for (int x = 0; x < 9; ++x)
                this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));

        // Player Inventory, Slot 0-8, Slot IDs 36-44
        for (int x = 0; x < 9; ++x)
            this.addSlotToContainer(new Slot(playerInv, x, 8 + x * 18, 142));
    }
}
