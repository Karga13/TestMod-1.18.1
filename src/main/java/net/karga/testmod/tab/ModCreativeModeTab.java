package net.karga.testmod.tab;

import net.karga.testmod.item.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab
{
    public static final CreativeModeTab TESTMOD_TAB = new CreativeModeTab("testmodtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.TESTER.get());
        }
    };
}
