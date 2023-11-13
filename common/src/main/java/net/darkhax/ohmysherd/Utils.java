package net.darkhax.ohmysherd;

import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;

public class Utils {

    public static BlockPos randomOffsetHorizontal(BlockPos startPos, RandomSource rng, int range) {

        return randomOffset(startPos, rng, range, 0, range);
    }

    public static BlockPos randomOffset(BlockPos startPos, RandomSource rng, int rangeX, int rangeY, int rangeZ) {

        final int offsetX = rangeX != 0 ? rng.nextIntBetweenInclusive(-rangeX, rangeX) : 0;
        final int offsetY = rangeY != 0 ? rng.nextIntBetweenInclusive(-rangeY, rangeY) : 0;
        final int offsetZ = rangeZ != 0 ? rng.nextIntBetweenInclusive(-rangeZ, rangeZ) : 0;
        return startPos.offset(offsetX, offsetY, offsetZ);
    }

    public static ItemStack debugSuspiciousGravel(ResourceLocation tableId) {

        final ItemStack item = new ItemStack(Items.SUSPICIOUS_GRAVEL);
        item.setHoverName(Component.translatable(Util.makeDescriptionId("loot", tableId) + ".name").withStyle(ChatFormatting.LIGHT_PURPLE));

        final CompoundTag blockData = item.getOrCreateTagElement("BlockEntityTag");
        blockData.putString("LootTable", tableId.toString());

        return item;
    }
}
