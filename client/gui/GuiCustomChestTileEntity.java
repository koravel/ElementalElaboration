package kor.kortech.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import kor.kortech.guicontainer.ContainerTileCustomChest;
import kor.kortech.tileentity.TileCustomChest;
import kor.kortech.util.References;

public class GuiCustomChestTileEntity extends GuiContainer
{

    private IInventory playerInventory;
    private TileCustomChest tileEntity;

    public GuiCustomChestTileEntity(IInventory playerInventory, TileCustomChest tileEntity)
    {
        super(new ContainerTileCustomChest(playerInventory, tileEntity));

        this.playerInventory = playerInventory;
        this.tileEntity = tileEntity;

        this.xSize = 176;
        this.ySize = 166;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(new ResourceLocation(References.MODID + ":textures/gui/container/custom_chest_tile_entity.png"));
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        String s = this.tileEntity.hasCustomInventoryName() ? this.tileEntity.getInventoryName() : I18n.format(this.tileEntity.getInventoryName(), new Object[0]);;
        this.fontRendererObj.drawString(s, 88 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);            //4210752 - color of string, hexadecimal code
        this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, 72, 4210752);
    }
}
