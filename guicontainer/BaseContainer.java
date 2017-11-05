package kor.kortech.guicontainer;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import kor.kortech.tileentity.TileKTWithInventory;

public class BaseContainer extends Container
{
    private TileKTWithInventory tileEntity;
    protected int startContainerIndex, endContainerIndex, startPlayerIndex, endPlayerIndex;

    public BaseContainer(int startContainerIndex, int endContainerIndex, int startPlayerIndex, int endPlayerIndex)
    {
        this.startContainerIndex = startContainerIndex;
        this.endContainerIndex = endContainerIndex;
        this.startPlayerIndex = startPlayerIndex;
        this.endPlayerIndex = endPlayerIndex;
    }

    protected TileKTWithInventory getTileEntity()
    {
        return tileEntity;
    }

    protected void setTileEntity(TileKTWithInventory tileEntity)
    {
        this.tileEntity = tileEntity;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int fromSlot)
    {
        ItemStack previous = null;
        Slot slot = (Slot) this.inventorySlots.get(fromSlot);

        if (slot != null && slot.getHasStack())
        {
            ItemStack current = slot.getStack();
            previous = current.copy();

            // Custom behaviour //
            if (fromSlot < 3)
            {
                // From TE Inventory to Player Inventory
                if (!this.mergeItemStack(current, startPlayerIndex, endPlayerIndex, true))
                    return null;
            }
            else
            {
                // From Player Inventory to TE Inventory
                if (!this.mergeItemStack(current, startContainerIndex, endContainerIndex, false))
                    return null;
            }
            // Custom behaviour //

            if (current.stackSize == 0)
                slot.putStack(null);
            else
                slot.onSlotChanged();

            if (current.stackSize == previous.stackSize)
                return null;
            slot.onPickupFromSlot(entityPlayer, current);
        }
        return previous;
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer)
    {
        return this.getTileEntity().isUseableByPlayer(entityPlayer);
    }

    @Override
    protected boolean mergeItemStack(ItemStack stack, int startIndex, int endIndex, boolean useEndIndex)
    {
        boolean success = false;
        int index = startIndex;

        if (useEndIndex)
            index = endIndex - 1;

        Slot slot;
        ItemStack stackinslot;

        if (stack.isStackable())
        {
            while (stack.stackSize > 0 && (!useEndIndex && index < endIndex || useEndIndex && index >= startIndex))
            {
                slot = (Slot) this.inventorySlots.get(index);
                stackinslot = slot.getStack();

                if (stackinslot != null && stackinslot.getItem() == stack.getItem() && (!stack.getHasSubtypes() || stack.getItemDamage() == stackinslot.getItemDamage()) && ItemStack.areItemStackTagsEqual(stack, stackinslot))
                {
                    int l = stackinslot.stackSize + stack.stackSize;
                    int maxsize = Math.min(stack.getMaxStackSize(), slot.getSlotStackLimit());

                    if (l <= maxsize)
                    {
                        stack.stackSize = 0;
                        stackinslot.stackSize = l;
                        slot.onSlotChanged();
                        success = true;
                    } else if (stackinslot.stackSize < maxsize)
                    {
                        stack.stackSize -= stack.getMaxStackSize() - stackinslot.stackSize;
                        stackinslot.stackSize = stack.getMaxStackSize();
                        slot.onSlotChanged();
                        success = true;
                    }
                }

                if (useEndIndex)
                    --index;
                else
                    ++index;
            }
        }

        if (stack.stackSize > 0)
        {
            if (useEndIndex)
                index = endIndex - 1;
            else
                index = startIndex;

            while (!useEndIndex && index < endIndex || useEndIndex && index >= startIndex && stack.stackSize > 0)
            {
                slot = (Slot) this.inventorySlots.get(index);
                stackinslot = slot.getStack();

                // Forge: Make sure to respect isItemValid in the slot.
                if (stackinslot == null && slot.isItemValid(stack))
                {
                    if (stack.stackSize < slot.getSlotStackLimit())
                    {
                        slot.putStack(stack.copy());
                        stack.stackSize = 0;
                        success = true;
                        break;
                    }
                    else
                    {
                        ItemStack newstack = stack.copy();
                        newstack.stackSize = slot.getSlotStackLimit();
                        slot.putStack(newstack);
                        stack.stackSize -= slot.getSlotStackLimit();
                        success = true;
                    }
                }

                if (useEndIndex)
                    --index;
                else
                    ++index;
            }
        }

        return success;
    }
}
