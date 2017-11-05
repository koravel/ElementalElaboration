package kor.kortech.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

import kor.kortech.guicontainer.ContainerTileCustomMachine;
import kor.kortech.tileentity.TileCustomMachine;
import kor.kortech.util.References;

public class GuiCustomMachineTileEntity extends GuiContainer
{
    private IInventory playerInventory;
    private TileCustomMachine tileEntity;

    public GuiCustomMachineTileEntity(IInventory playerInventory, TileCustomMachine tileEntity)
    {
        super(new ContainerTileCustomMachine(playerInventory, tileEntity));

        this.playerInventory = playerInventory;
        this.tileEntity = tileEntity;

        this.xSize = 176;
        this.ySize = 166;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        this.mc.getTextureManager().bindTexture(new ResourceLocation(References.MODID + ":textures/gui/container/custom_machine_tile_entity.png"));
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {

    }
}
