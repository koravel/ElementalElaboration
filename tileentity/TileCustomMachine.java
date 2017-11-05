package kor.kortech.tileentity;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TileCustomMachine extends ProccessMachine
{
    public TileCustomMachine()
    {
        super(4, 64, new int[] { 0, 1, 2 }, new int[] { 3 });
        this.setCustomName("Custom Machine");
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack itemStack)
    {
        switch (slot)
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

    @Override
    protected boolean canStart()
    {
        if(getStackInSlot(0) != null && getStackInSlot(0).stackSize > 0 && getStackInSlot(0).getItem().equals(Item.getItemFromBlock(Blocks.iron_ore)))
        {
            if(getStackInSlot(3) == null || getStackInSlot(3).stackSize < 64)
                return true;
            else
                return  false;
        }
        else
            return  false;

    }

    @Override
    protected void processStart()
    {
        progress = 40;
        decrStackSize(0,1);
    }

    @Override
    protected void processFinish()
    {
        if(getStackInSlot(3) == null)
        {
            setInventorySlotContents(3, new ItemStack(Items.iron_ingot, 2));
        }
        else
        {
            getStackInSlot(3).stackSize += 2;
        }
    }
}
