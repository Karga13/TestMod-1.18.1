package net.karga.testmod.item.tool;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.Random;

public class FlightWand extends Item
{

    public FlightWand(Properties pProperties)
    {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand)
    {
        if(pLevel.isClientSide())
        {
            double radius = 0.1;
            Random random = new Random();
            Vec3 look = pPlayer.getLookAngle().scale(-1d);

            for(int i=0; i<30; i++)
            {
                double x = pPlayer.getX() + (radius * -1d) + random.nextDouble((radius * 2) + 1);
                double y = pPlayer.getY() + pPlayer.getBbHeight()/2 + (radius * -1d) + random.nextDouble((radius * 2) + 1);
                double z = pPlayer.getZ() + (radius * -1d) + random.nextDouble((radius * 2) + 1);
                pLevel.addParticle(ParticleTypes.FLAME, x, y, z, look.x(), look.y(), look.z());
            }

            Vec3 pushV = pPlayer.getLookAngle().scale(2d);
            pPlayer.push(pushV.x(), pushV.y(), pushV.z());
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }
}
