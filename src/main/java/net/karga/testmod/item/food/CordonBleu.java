package net.karga.testmod.item.food;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.FireworkRocketEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CordonBleu extends Item
{
    public CordonBleu(Properties pProperties)
    {
        super(pProperties);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced)
    {
        String text_top = "\u00A7o" + "\u00A77" + "Only for the elite...";
        String text_bottom = "\u00A74" + "Cemil abi düzgün basmamışsın yine!";
        pTooltipComponents.add(new TextComponent(text_top));
        pTooltipComponents.add(new TextComponent(text_bottom));
    }

    @Override
    public boolean isEdible()
    {
        return true;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity)
    {
        if (pLevel.isClientSide())
        {
            Player pPlayer = (Player) pLivingEntity;
            pPlayer.sendMessage(new TextComponent("You are an elite now *sunglasses*"), pPlayer.getUUID());
            pLevel.explode(pPlayer, pPlayer.getXRot(), pPlayer.getY(), pPlayer.getZ(),
                    10f, true, Explosion.BlockInteraction.DESTROY);
        }
        return super.finishUsingItem(pStack, pLevel, pLivingEntity);
    }
}
