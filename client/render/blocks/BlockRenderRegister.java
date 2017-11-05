package kor.kortech.client.render.blocks;

import net.minecraft.client.Minecraft;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;

import kor.kortech.util.References;
import kor.kortech.blocks.ModBlocks;

public class BlockRenderRegister
{
    public static void registerBlockRenderer()
    {
        //reg(ModBlocks.tutorialBlock);
    }

    public static void reg(Block block)
    {

        Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(References.MODID + ":" + block.getUnlocalizedName().substring(5), "inventory"));
    }
}
