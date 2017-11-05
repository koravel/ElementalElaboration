package kor.kortech.tileentity;

import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;

public class TileKTWithSidedInventory extends TileKTWithInventory implements ISidedInventory
{
    protected int[] insertAssecibleSlots;
    protected int[] extractAssecibleSlots;

    public TileKTWithSidedInventory(int inventorySize, int inventoryStackLimit, int[] insertAssecibleSlots, int[] extractAssecibleSlots)
    {
        super(inventorySize, inventoryStackLimit);
        this.insertAssecibleSlots = insertAssecibleSlots;
        this.extractAssecibleSlots = insertAssecibleSlots;
    }


    @Override
    public int[] getAccessibleSlotsFromSide(int side)
    {
        return insertAssecibleSlots;
    }

    @Override
    public boolean canInsertItem(int slot, ItemStack itemstack, int side)
    {
        return this.isItemValidForSlot(slot, itemstack);
    }

    @Override
    public boolean canExtractItem(int slot, ItemStack itemstack, int side)
    {
        for(int i = 0; i < extractAssecibleSlots.length; i++)
            if(slot == extractAssecibleSlots[i])
                return true;
        return false;
    }

}
