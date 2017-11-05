package kor.kortech.util;

import com.google.common.collect.Maps;
import kor.kortech.items.ModItems;
import net.minecraft.item.ItemStack;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CMRecipeManager
{
    private static final CMRecipeManager instanse = new CMRecipeManager();

    private final Map<List<ItemStack>,CMRecipe> handlingList = Maps.newHashMap();
    private final Map<CMRecipe, Float> experienceList = Maps.newHashMap();

    public void initCMRecipes()
    {
        addCustomMachineRecipe(Arrays.asList(new ItemStack(ModItems.tutorialItem),new ItemStack(ModItems.tutorialItem),new ItemStack(ModItems.tutorialItem),new ItemStack(ModItems.tutorialItem)), new CMRecipe(new ItemStack(ModItems.tutorialItem), new ItemStack(ModItems.tutorialItem), new ItemStack(ModItems.tutorialItem), new ItemStack(ModItems.tutorialItem,10)) ,0);

    }

    public static CMRecipeManager instance()
    {
        return instanse;
    }

    public void addCustomMachineRecipe(List<ItemStack> parItemStacksIn, CMRecipe recipe, float parExperience)
    {
        handlingList.put(parItemStacksIn, recipe);
        experienceList.put(recipe, Float.valueOf(parExperience));
    }

    public ItemStack getHandlingResult(ItemStack parItemStack)
    {
        Iterator iterator = handlingList.entrySet().iterator();
        Map.Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return null;
            }

            entry = (Map.Entry)iterator.next();
        }
        while (!areItemStacksEqual(parItemStack, (ItemStack)entry
                .getKey()));

        return (ItemStack)entry.getValue();
    }

    private boolean areItemStacksEqual(ItemStack parItemStack1,
                                       ItemStack parItemStack2)
    {
        return parItemStack2.getItem() == parItemStack1.getItem()
                && (parItemStack2.getItemDamage() == 32767
                || parItemStack2.getItemDamage() == parItemStack1
                .getItemDamage());
    }

    public Map getCustomMachineList()
    {
        return handlingList;
    }

    public float getCustomMachineExperience(ItemStack parItemStack)
    {
        Iterator iterator = experienceList.entrySet().iterator();
        Map.Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return 0.0F;
            }

            entry = (Map.Entry)iterator.next();
        }
        while (!areItemStacksEqual(parItemStack,
                (ItemStack)entry.getKey()));

        return ((Float)entry.getValue()).floatValue();
    }
}
