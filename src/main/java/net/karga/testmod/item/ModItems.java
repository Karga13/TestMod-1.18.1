package net.karga.testmod.item;

import net.karga.testmod.TestMod;
import net.karga.testmod.item.food.CordonBleu;
import net.karga.testmod.item.food.ModFoods;
import net.karga.testmod.item.tool.*;
import net.karga.testmod.tab.ModCreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TestMod.MODID);

    public static final RegistryObject<Item> TESTER = ITEMS.register("tester",
            () -> new TesterItem(new Item.Properties().tab(ModCreativeModeTab.TESTMOD_TAB)));

    public static final RegistryObject<Item> BANHAMMER = ITEMS.register("banhammer",
            () -> new BanHammer(new Item.Properties().tab(ModCreativeModeTab.TESTMOD_TAB)));

    public static final RegistryObject<Item> TEST_SWORD = ITEMS.register("test_sword",
            () -> new TestSword(ModTiers.TEST, 3, 5,
                    new Item.Properties().tab(ModCreativeModeTab.TESTMOD_TAB)));

    public static final RegistryObject<Item> TEST_GUN = ITEMS.register("test_gun",
            () -> new TestGun(new Item.Properties().tab(ModCreativeModeTab.TESTMOD_TAB)));

    public static final RegistryObject<Item> FLIGHT_WAND = ITEMS.register("flight_wand",
            () -> new FlightWand(new Item.Properties().tab(ModCreativeModeTab.TESTMOD_TAB)));

    public static final RegistryObject<Item> CORDON_BLEU = ITEMS.register("cordon_bleu",
            () -> new CordonBleu(new Item.Properties().tab(ModCreativeModeTab.TESTMOD_TAB).food(ModFoods.CORDON_BLEU)));

    public static void register(IEventBus eventbus)
    {
        ITEMS.register(eventbus);
    }
}
