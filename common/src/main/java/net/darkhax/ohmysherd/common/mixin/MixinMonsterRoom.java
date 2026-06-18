package net.darkhax.ohmysherd.common.mixin;

import net.darkhax.ohmysherd.common.impl.OhMySherd;
import net.darkhax.ohmysherd.common.impl.util.ISpawner;
import net.darkhax.ohmysherd.common.impl.util.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BrushableBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.MonsterRoomFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.function.Predicate;

@Mixin(MonsterRoomFeature.class)
public abstract class MixinMonsterRoom extends Feature<NoneFeatureConfiguration> {

    private MixinMonsterRoom() {
        super(null);
    }

    @Inject(locals = LocalCapture.CAPTURE_FAILHARD, method = "place(Lnet/minecraft/world/level/levelgen/feature/FeaturePlaceContext;)Z", at = @At(value = "INVOKE", shift = At.Shift.AFTER, target = "Lnet/minecraft/world/level/block/entity/SpawnerBlockEntity;setEntityId(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/util/RandomSource;)V"))
    private void onStructureGenerate(FeaturePlaceContext<NoneFeatureConfiguration> context, CallbackInfoReturnable<Boolean> cir, Predicate<BlockState> cantReplace, BlockPos currentPos, RandomSource rng, WorldGenLevel level) {
        if (OhMySherd.CONFIG.remains.enable_generation && level.getBlockEntity(currentPos) instanceof ISpawner spawner) {
            if (spawner.ohmysherd$getEntityType() == EntityTypes.SKELETON) {
                final BlockPos floorPos = currentPos.below();
                if (OhMySherd.CONFIG.remains.under_spawner) {
                    ohmysherd$placeSusBlocks(floorPos, level, cantReplace);
                }
                if (OhMySherd.CONFIG.remains.floor_attempts > 0) {
                    for (int i = 0; i < OhMySherd.CONFIG.remains.floor_attempts; i++) {
                        ohmysherd$placeSusBlocks(Utils.randomOffsetHorizontal(floorPos, rng, OhMySherd.CONFIG.remains.floor_range), level, cantReplace);
                    }
                }
                if (OhMySherd.CONFIG.log_spawn_positions) {
                    OhMySherd.LOG.info("Skeleton dungeon generated at {}", currentPos);
                }
            }
        }
    }

    @Unique
    private void ohmysherd$placeSusBlocks(BlockPos susPos, WorldGenLevel level, Predicate<BlockState> cantReplace) {
        final Block oldState = level.getBlockState(susPos).getBlock();
        if (oldState == Blocks.COBBLESTONE || oldState == Blocks.MOSSY_COBBLESTONE) {
            this.safeSetBlock(level, susPos, Blocks.SUSPICIOUS_GRAVEL.defaultBlockState(), cantReplace);
            if (level.getBlockEntity(susPos) instanceof BrushableBlockEntity brushable) {
                brushable.setLootTable(OhMySherd.LOOT_TABLE_SKELETON_DUNGEON, susPos.asLong());
            }
        }
    }
}