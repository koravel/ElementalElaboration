package kor.kortech.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import kor.kortech.KorTech;
import kor.kortech.network.GuiHandler;
import kor.kortech.tileentity.TileCustomMachine;
import kor.kortech.util.BlocksProperties;

public class CustomMachine extends RotatableBlock3D implements ITileEntityProvider,IBlockWithInventory
{
    public CustomMachine()
    {
        super(BlocksProperties.materialCustomMachine, BlocksProperties.iconsNameCustomMachine);
        this.setBlockName(BlocksProperties.unlocalizedNameCustomMachine);
        this.setHardness(BlocksProperties.hardnessCustomMachine);
        this.setResistance(BlocksProperties.resistanceCustomMachine);
        this.setHarvestLevel(BlocksProperties.harvestToolCustomMachine, BlocksProperties.harvestLevelCustomMachine);
        this.setStepSound(BlocksProperties.soundCustomMachine);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileCustomMachine();
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, Block oldblock, int oldMetadata)
    {
        breakBlockWithInventory(world, x, y, z, oldblock, oldMetadata);
        super.breakBlock(world, x, y, z, oldblock, oldMetadata);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float hitX, float hitY, float hitZ)
    {
        if (!world.isRemote)
        {
            player.openGui(KorTech.instance, GuiHandler.customMachineGUIID, world, x, y, z);
        }
        return true;
    }
}