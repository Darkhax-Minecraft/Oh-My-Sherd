package net.darkhax.ohmysherd.common.mixin;

import net.darkhax.ohmysherd.common.impl.OhMySherd;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntityTypes;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.structures.DesertPyramidStructure;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DesertPyramidStructure.class)
public class MixinDesertPyramidStructure {

    @Inject(method = "placeSuspiciousSand(Lnet/minecraft/world/level/levelgen/structure/BoundingBox;Lnet/minecraft/world/level/WorldGenLevel;Lnet/minecraft/core/BlockPos;)V", at = @At("RETURN"))
    private static void onSusSand(BoundingBox bounds, WorldGenLevel level, BlockPos pos, CallbackInfo ci) {
        if (OhMySherd.CONFIG.invader.enable_generation && bounds.isInside(pos) && level.getRandom().nextFloat() <= OhMySherd.CONFIG.invader.generation_chance) {
            level.setBlock(pos, Blocks.SUSPICIOUS_SAND.defaultBlockState(), 2);
            level.getBlockEntity(pos, BlockEntityTypes.BRUSHABLE_BLOCK).ifPresent(be -> be.setLootTable(OhMySherd.LOOT_TABLE_ALIEN, pos.asLong()));
            if (OhMySherd.CONFIG.log_spawn_positions) {
                OhMySherd.LOG.info("Placed invader sand at {}.", pos);
            }
        }
    }
}