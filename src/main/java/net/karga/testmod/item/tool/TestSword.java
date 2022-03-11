package net.karga.testmod.item.tool;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class TestSword extends SwordItem
{
    public TestSword(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties)
    {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced)
    {
        String text = "\u00A7l" + "\u00A76" + "DANGER: Goes boom!";
        pTooltipComponents.add(new TextComponent(text));
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity)
    {
        if(player.getLevel().isClientSide())
        {
            boom(15, 10, player);
            String message = "\u00A7l" + "\u00A76" + "BOOM!";
            player.sendMessage(new TextComponent(message), player.getUUID());
        }
        return super.onLeftClickEntity(stack, player, entity);
    }

    private void boom(int radius, int intensity, Player player)
    {
        Random random = new Random();
        for(int i=0; i<intensity; i++)
        {
            double x = player.getX() + (radius * -1d) + random.nextInt((radius * 2) + 1);
            double z = player.getZ() + (radius * -1d) + random.nextInt((radius * 2) + 1);
            player.getLevel().explode(player, x, player.getY(), z, 5f, true,
                    Explosion.BlockInteraction.NONE);
        }
    }
}
