package kor.kortech.util;

import net.minecraft.item.ItemStack;

public class CMRecipe
{
    ItemStack input1;
    ItemStack input2;
    ItemStack input3;
    ItemStack output;

    public CMRecipe(ItemStack input1, ItemStack input2, ItemStack input3, ItemStack output)
    {
        this.input1 = input1;
        this.input2 = input2;
        this.input3 = input3;
        this.output = output;

        /*if (input1.stackSize <= 0)
        {
            input1.stackSize = 1;
        }
        if (input2.stackSize <= 0)
        {
            input2.stackSize = 1;
        }
        if (input3.stackSize <= 0)
        {
            input3.stackSize = 1;
        }
        if (output.stackSize <= 0)
        {
            output.stackSize = 1;
        }*/
    }
}
