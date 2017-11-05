package kor.kortech.blocks;

import kor.kortech.util.BlocksProperties;

public class FluidTank extends SingleTextureBlock
{
    public FluidTank()
    {
        super(BlocksProperties.materialFluidTank, BlocksProperties.unlocalizedNameFluidTank);
        this.setHardness(BlocksProperties.hardnessFluidTank);
        this.setResistance(BlocksProperties.resistanceFluidTank);
        this.setHarvestLevel(BlocksProperties.harvestToolFluidTank, BlocksProperties.harvestLevelFluidTank);
        this.setStepSound(BlocksProperties.soundFluidTank);
    }
}
