package kor.kortech.guicontainer;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CustomMachineSlot extends Slot
{

    public CustomMachineSlot(IInventory inventory, int slotIndex, int xDisplayPosition, int yDisplayPosition)
    {
        super(inventory, slotIndex, xDisplayPosition, yDisplayPosition);
    }

    @Override
    public boolean isItemValid(ItemStack itemStack)
    {
        switch (getSlotIndex())
        {
            case 0:
            case 1:
            case 2:
            {
                if(itemStack != null && itemStack.getItem().equals(Item.getItemFromBlock(Blocks.iron_ore)))
                    return true;
                return false;
            }
            case 3:
            {
                return false;
            }
            default:return false;
        }
    }
}
