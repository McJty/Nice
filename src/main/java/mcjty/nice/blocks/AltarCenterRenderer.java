package mcjty.nice.blocks;

import mcjty.nice.Nice;
import mcjty.nice.client.RenderTools;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class AltarCenterRenderer extends TileEntitySpecialRenderer<AltarCenterTileEntity> {

    ResourceLocation blueSphereTexture = new ResourceLocation(Nice.MODID, "textures/effects/bluesphere.png");

    @Override
    public void renderTileEntityAt(AltarCenterTileEntity te, double x, double y, double z, float partialTicks, int destroyStage) {
        IBlockState blockState = getWorld().getBlockState(te.getPos());
        if (blockState.getBlock() != ModBlocks.altarCenterBlock) {
            return;
        }

        GlStateManager.depthMask(false);
        GlStateManager.enableBlend();
//        GlStateManager.blendFunc(GL11.GL_ONE, GL11.GL_ONE);
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);

//        GlStateManager.enableAlpha();
        GlStateManager.disableAlpha();

        GlStateManager.pushMatrix();
        GlStateManager.translate((float) x + 0.5F, (float) y + 1.9F, (float) z + 0.5F);

        this.bindTexture(blueSphereTexture);
        RenderTools.renderBillboardQuadBright(1.2f, 240);

        GlStateManager.popMatrix();

//        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
    }
}
