package kor.kortech.util;

import kor.kortech.materials.TestMaterial;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class BlocksProperties
{
    /*=========Template=========
    public static String unlocalizedName = "";
    public static Material material = ;
    public static float hardness = 1F;
    public static float resistance = 1F;
    public static String harvestTool = "";
    public static int harvestLevel = 0;
    public static Block.SoundType sound = Block.soundTypeGravel;
    =========Template=========*/

    /*=========CustomChest=========*/
    public static String unlocalizedNameCustomChest = "custom_chest";
    public static Material materialCustomChest = Material.wood;
    public static float hardnessCustomChest = 3F;
    public static float resistanceCustomChest = 5F;
    public static String harvestToolCustomChest = "axe";
    public static int harvestLevelCustomChest = 1;
    public static Block.SoundType soundCustomChest = Block.soundTypeWood;
    /*=========CustomChest=========*/

    /*=========CustomMachine=========*/
    public static String unlocalizedNameCustomMachine = "custom_machine";
    public static Material materialCustomMachine = Material.iron;
    public static float hardnessCustomMachine = 2F;
    public static float resistanceCustomMachine = 20F;
    public static String harvestToolCustomMachine = "pickaxe";
    public static int harvestLevelCustomMachine = 1;
    public static Block.SoundType soundCustomMachine = Block.soundTypeAnvil;
    public static String[] iconsNameCustomMachine = {"custom_machine_front","machine_casing","machine_casing","machine_casing","machine_casing","machine_casing"};
    /*=========CustomMachine=========*/

    /*=========FluidTank=========*/
    public static String unlocalizedNameFluidTank = "fluid_tank";
    public static Material materialFluidTank = new TestMaterial(MapColor.blackColor);
    public static float hardnessFluidTank = 1F;
    public static float resistanceFluidTank = 10F;
    public static String harvestToolFluidTank = "pickaxe";
    public static int harvestLevelFluidTank = 1;
    public static Block.SoundType soundFluidTank = Block.soundTypeGravel;
    /*=========FluidTank=========*/
}
