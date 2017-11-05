package kor.kortech.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import kor.kortech.KorTech;
import kor.kortech.network.GuiHandler;
import kor.kortech.tileentity.TileCustomChest;
import kor.kortech.util.BlocksProperties;

public class CustomChest extends SingleTextureBlock implements ITileEntityProvider,IBlockWithInventory
{
    public CustomChest()
    {
        super(BlocksProperties.materialCustomChest, BlocksProperties.unlocalizedNameCustomChest);
        this.setHardness(BlocksProperties.hardnessCustomChest);
        this.setResistance(BlocksProperties.resistanceCustomChest);
        this.setHarvestLevel(BlocksProperties.harvestToolCustomChest, BlocksProperties.harvestLevelCustomChest);
        this.setStepSound(BlocksProperties.soundCustomChest);

        this.isBlockContainer = true;
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileCustomChest();
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, Block oldblock, int oldMetadata)
    {
        breakBlockWithInventory(world, x, y, z, oldblock, oldMetadata);
        super.breakBlock(world, x, y, z, oldblock, oldMetadata);
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemstack)
    {
        if (itemstack.hasDisplayName())
        {
            ((TileCustomChest) world.getTileEntity(x, y, z)).setCustomName(itemstack.getDisplayName());
        }
    }

    @Override
    public boolean onBlockActivated(World world, int x,int y, int z, EntityPlayer player, int i, float hitX, float hitY, float hitZ)
    {
        if (!world.isRemote)
        {
            player.openGui(KorTech.instance, GuiHandler.customChestGUIID, world, x, y, z);
        }
        return true;
    }
}