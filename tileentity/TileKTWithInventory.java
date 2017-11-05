package kor.kortech.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import kor.kortech.util.References;

public class TileKTWithInventory extends TileKT implements IInventory
{
    private ItemStack[] inventory;
    protected int inventorySize;
    protected int inventoryStackLimit;

    public TileKTWithInventory(int inventorySize, int inventoryStackLimit)
    {
        this.defaultName = References.MODID + ":container";
        this.inventorySize = inventorySize;
        this.inventoryStackLimit = inventoryStackLimit;
        this.inventory = new ItemStack[this.getSizeInventory()];
    }

    public  void readFromNBT(NBTTagCompound tagCompound)
    {
        super.readFromNBT(tagCompound);
        NBTTagList tagList = tagCompound.getTagList("Items", 10);
        this.inventory = new ItemStack[this.getSizeInventory()];

        for(int i = 0; i < tagList.tagCount(); ++i)
        {
            NBTTagCompound tempTagCompound = tagList.getCompoundTagAt(i);
            byte slot = tempTagCompound.getByte("Slot");

            if(slot >= 0 && slot < this.inventory.length)
            {
                this.setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(tempTagCompound));
            }
        }

        if(tagCompound.hasKey("CustomName", 8))
        {
            this.customName = tagCompound.getString("CustomName");
        }
    }

    public void writeToNBT(NBTTagCompound tagCompound)
    {
        super.writeToNBT(tagCompound);

        NBTTagList tagList = new NBTTagList();

        for(int i = 0; i < this.inventory.length; ++i)
        {
            if(this.getStackInSlot(i) != null)
            {
                NBTTagCompound tempTagCompound = new NBTTagCompound();
                tempTagCompound.setByte("Slot", (byte)i);
                getStackInSlot(i).writeToNBT(tempTagCompound);
                tagList.appendTag(tempTagCompound);
            }
        }

        tagCompound.setTag("Items", tagList);

        if(this.hasCustomInventoryName())
        {
            tagCompound.setString("CustomName", this.customName);
        }
    }

    @Override
    public int getSizeInventory()
    {
        return inventorySize;
    }

    @Override
    public ItemStack getStackInSlot(int slot)
    {
        if (slot < 0 || slot >= this.getSizeInventory())
            return null;
        return this.inventory[slot];
    }

    @Override
    public ItemStack decrStackSize(int slot, int count)
    {
        if (this.getStackInSlot(slot) != null)
        {
            ItemStack itemstack;

            if (this.getStackInSlot(slot).stackSize <= count)
            {
                itemstack = this.getStackInSlot(slot);
                this.setInventorySlotContents(slot, null);
                this.markDirty();
                return itemstack;
            } else {
                itemstack = this.getStackInSlot(slot).splitStack(count);

                if (this.getStackInSlot(slot).stackSize <= 0)
                {
                    this.setInventorySlotContents(slot, null);
                } else {
                    //Just to show that changes happened
                    this.setInventorySlotContents(slot, this.getStackInSlot(slot));
                }

                this.markDirty();
                return itemstack;
            }
        }
        else
        {
            return null;
        }
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot)
    {
        ItemStack stack = this.getStackInSlot(slot);
        this.setInventorySlotContents(slot, null);
        return stack;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack itemStack)
    {
        if (slot < 0 || slot >= this.getSizeInventory())
            return;

        if (itemStack != null && itemStack.stackSize > this.getInventoryStackLimit())
            itemStack.stackSize = this.getInventoryStackLimit();

        if (itemStack != null && itemStack.stackSize == 0)
            itemStack = null;
        this.inventory[slot] = itemStack;

        this.markDirty();
    }

    @Override
    public String getInventoryName()
    {
        return this.hasCustomInventoryName() ? this.customName : defaultName;
    }

    @Override
    public boolean hasCustomInventoryName()
    {
        return this.customName != null && this.customName.length() > 0 && !this.customName.equals("");
    }

    @Override
    public int getInventoryStackLimit()
    {
        return inventoryStackLimit;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityPlayer)
    {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : entityPlayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) < 64.0D;
    }

    @Override
    public void openInventory()
    {

    }

    @Override
    public void closeInventory()
    {

    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack item)
    {
        return true;
    }
}
