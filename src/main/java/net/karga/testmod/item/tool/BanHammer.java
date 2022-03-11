package net.karga.testmod.item.tool;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class BanHammer extends Item
{

    public BanHammer(Properties pProperties)
    {
        super(pProperties);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced)
    {
        String text = "\u00A7o" + "\u00A77" +
                "Whosoever holds this hammer, if they be worthy, shall possess the power of Ban.";
        pTooltipComponents.add(new TextComponent(text));
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity)
    {
        if(player.getLevel().isClientSide())
        {
            spawnParticles(ParticleTypes.LAVA, 0.25, 50,
                    entity.getX(), entity.getY() + entity.getBbHeight()/2, entity.getZ(), player.getLevel());
            spawnParticles(ParticleTypes.LARGE_SMOKE, 0.25, 20,
                    entity.getX(), entity.getY() + entity.getBbHeight()/2, entity.getZ(), player.getLevel());

            String message = "\u00A7l" + "\u00A74" + entity.getName().getString() +
                    " has been banned by " + player.getName().getString() + "!";
            entity.remove(Entity.RemovalReason.KILLED);
            player.sendMessage(new TextComponent(message), player.getUUID());
        }
        return super.onLeftClickEntity(stack, player, entity);
    }

    @Override
    public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, Player player)
    {
        if(!player.getLevel().isClientSide())
        {
            String block = player.getLevel().getBlockState(pos).getBlock().getName().getString();
            player.getLevel().setBlock(pos, Blocks.AIR.defaultBlockState(), 0);
            String message = "\u00A7l" + "\u00A74" + block + " has been banned by " + player.getName().getString() + "!";
            player.sendMessage(new TextComponent(message), player.getUUID());
        }

        if(player.getLevel().isClientSide())
        {
            spawnParticles(ParticleTypes.LARGE_SMOKE, 0.25, 20,
                    pos.getX(), pos.getY(), pos.getZ(), player.getLevel());
        }

        return super.onBlockStartBreak(itemstack, pos, player);
    }

    public void spawnParticles(ParticleOptions type, double radius, int amount, double x, double y, double z, Level level)
    {
        Random random = new Random();
        for(int i=0; i<amount; i++)
        {
            double pX = x + (radius * -1d) + random.nextDouble((radius * 2) + 1);
            double pY = y + (radius * -1d) + random.nextDouble((radius * 2) + 1);
            double pZ = z + (radius * -1d) + random.nextDouble((radius * 2) + 1);
            level.addParticle(type, pX, pY, pZ,
                    0d, 0d, 0d);
        }
    }
}
