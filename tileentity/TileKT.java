package kor.kortech.tileentity;

import net.minecraft.tileentity.TileEntity;

public class TileKT extends TileEntity
{
    public String customName;
    protected String defaultName;

    public TileKT()
    {

    }

    public void setCustomName(String customName)
    {
        this.customName = customName;
    }
}
