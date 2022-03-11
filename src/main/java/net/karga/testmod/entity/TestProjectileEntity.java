package net.karga.testmod.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;

public class TestProjectileEntity extends Entity
{
    private static final double SPEED_THRESHOLD = 0.01d;
    private int ticksSinceFired = 0;

    public TestProjectileEntity(EntityType<?> pEntityType, Level pLevel)
    {
        super(pEntityType, pLevel);
    }


    @Override
    protected void defineSynchedData()
    {

    }

    @Override
    public void tick()
    {
        ticksSinceFired++;
        if (ticksSinceFired > 100 || getDeltaMovement().lengthSqr() < SPEED_THRESHOLD)
        {
            remove(RemovalReason.KILLED);
        }
        super.tick();
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag pCompound)
    {

    }

    @Override
    protected void addAdditionalSaveData(CompoundTag pCompound)
    {

    }

    @Override
    public Packet<?> getAddEntityPacket()
    {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
