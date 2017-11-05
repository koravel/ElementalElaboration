package kor.kortech.blocks;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import kor.kortech.tileentity.TileKTWithInventory;

import java.util.Random;

public interface IBlockWithInventory
{
    boolean keepInventory = false;
    Random rand = new Random();

    default void breakBlockWithInventory(World world, int x, int y, int z, Block oldblock, int oldMetadata)
    {
        if(!keepInventory)
        {
            TileKTWithInventory tileentity = (TileKTWithInventory) world.getTileEntity(x, y, z);

            if(tileentity != null)
            {
                for(int i = 0; i < tileentity.getSizeInventory(); i++)
                {
                    ItemStack itemstack = tileentity.getStackInSlot(i);

                    if(itemstack != null)
                    {
                        float f = this.rand.nextFloat() * 0.8F + 0.1F;
                        float f1 = this.rand.nextFloat() * 0.8F + 0.1F;
                        float f2 = this.rand.nextFloat() * 0.8F + 0.1F;

                        while(itemstack.stackSize > 0)
                        {
                            int j = this.rand.nextInt(21) + 10;

                            if(j > itemstack.stackSize)
                                j = itemstack.stackSize;

                            itemstack.stackSize -= j;

                            EntityItem item = new EntityItem(world, (double)((float)x + f), (double)((float)y + f1), (double)((float)z + f2), new ItemStack(itemstack.getItem(), j, itemstack.getItemDamage()));

                            if(itemstack.hasTagCompound())
                                item.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());

                            world.spawnEntityInWorld(item);
                        }
                    }
                }
                //Maybe this fucntion is about to replace block without meta data
                world.func_147453_f(x, y, z, oldblock);
            }
        }
        else
        {
            //some code to keep inventory
        }
    }
}
