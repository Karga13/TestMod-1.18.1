package net.karga.testmod.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class TestBlock extends Block
{
    public TestBlock(Properties properties)
    {
        super(properties);
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity)
    {
        if(!pLevel.isClientSide())
        {
            try
            {
                LivingEntity entity = (LivingEntity) pEntity;
                entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED,
                        10, 3, true, true, false));
            }
            catch(Exception e)
            {
                super.stepOn(pLevel, pPos, pState, pEntity);
            }

        }
        super.stepOn(pLevel, pPos, pState, pEntity);
    }
}
