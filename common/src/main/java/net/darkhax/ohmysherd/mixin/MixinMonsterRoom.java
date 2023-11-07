package net.darkhax.ohmysherd.mixin;

import net.darkhax.ohmysherd.OhMySherd;
import net.darkhax.ohmysherd.Utils;
import net.darkhax.ohmysherd.lib.ISpawner;
import net.minecraft.client.renderer.blockentity.DecoratedPotRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BrushableBlockEntity;
import net.minecraft.world.level.block.entity.SpawnerBlockEntity;
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

        if (level.getBlockEntity(currentPos) instanceof ISpawner spawner) {

            final BlockPos floorPos = currentPos.below();

            if (spawner.ohmysherd$getEntityType() == EntityType.SKELETON) {

                System.out.println(currentPos);

                placeSusBlocks(floorPos, level, cantReplace);

                for (int i = 0; i < 5; i++) {

                    placeSusBlocks(Utils.randomOffsetHorizontal(floorPos, rng, 4), level, cantReplace);
                }
            }
        }
    }

    @Unique
    private void placeSusBlocks(BlockPos susPos, WorldGenLevel level, Predicate<BlockState> cantReplace) {

        final Block oldState = level.getBlockState(susPos).getBlock();

        if (oldState == Blocks.COBBLESTONE || oldState == Blocks.MOSSY_COBBLESTONE) {

            this.safeSetBlock(level, susPos, Blocks.SUSPICIOUS_GRAVEL.defaultBlockState(), cantReplace);

            if (level.getBlockEntity(susPos) instanceof BrushableBlockEntity brushable) {

                brushable.setLootTable(OhMySherd.LOOT_TABLE_SKELETON_DUNGEON, susPos.asLong());
            }
        }
    }
}