package net.karga.testmod.item.tool;

import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class TestGun extends Item
{
    public TestGun(Properties pProperties)
    {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand)
    {
        if(!pLevel.isClientSide())
        {
            Arrow arrow = new Arrow(pLevel, pPlayer);
            arrow.setBaseDamage(15);
            shootArrow(arrow, pPlayer.getXRot(), pPlayer.getYRot(), 0, 5, 0);
            pLevel.addFreshEntity(arrow);
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }

    private void shootArrow(Arrow arrow, float xRot, float yRot, float p_37255_, float speed, float spread)
    {
        float f = -Mth.sin(yRot * ((float) Math.PI / 180F)) * Mth.cos(xRot * ((float) Math.PI / 180F));
        float f1 = -Mth.sin((xRot + p_37255_) * ((float) Math.PI / 180F));
        float f2 = Mth.cos(yRot * ((float) Math.PI / 180F)) * Mth.cos(xRot * ((float) Math.PI / 180F));
        arrow.shoot((double) f, (double) f1, (double) f2, speed, spread);
    }
}
