package net.darkhax.ohmysherd;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;

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
}
