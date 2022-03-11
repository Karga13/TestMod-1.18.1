package net.karga.testmod.entity;

import net.karga.testmod.TestMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = TestMod.MODID)
public class ModEntities {
    //"Inspired" (more like stolen) from GunsWithoutRoses
    public static EntityType<TestProjectileEntity> TEST_PROJECTILE;

    @SuppressWarnings("unchecked")
    @SubscribeEvent
    public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) {
        IForgeRegistry<EntityType<?>> reg = event.getRegistry();
        reg.register(EntityType.Builder
                .<TestProjectileEntity>of(TestProjectileEntity::new, MobCategory.MISC)
                .sized(0.3125f, 0.3125f).setUpdateInterval(10).setTrackingRange(64).setShouldReceiveVelocityUpdates(true)
                .build(TestMod.MODID + ":test_projectile").setRegistryName(TestMod.MODID, "test_projectile"));
        TEST_PROJECTILE = (EntityType<TestProjectileEntity>) reg.getValue(new ResourceLocation(TestMod.MODID, "test_projectile"));
    }
}
