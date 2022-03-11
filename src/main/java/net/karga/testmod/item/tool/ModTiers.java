package net.karga.testmod.item.tool;

import net.karga.testmod.item.ModItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers
{
    public static final ForgeTier TEST = new ForgeTier(4, 2000, 20, 8, 50,
            BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(ModItems.TESTER.get()));
}
