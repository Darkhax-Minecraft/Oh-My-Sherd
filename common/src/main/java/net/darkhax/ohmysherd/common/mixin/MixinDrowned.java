package net.darkhax.ohmysherd.common.mixin;

import net.darkhax.ohmysherd.common.impl.OhMySherd;
import net.darkhax.ohmysherd.common.impl.SherdType;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.monster.zombie.Drowned;
import net.minecraft.world.entity.monster.zombie.Zombie;
import net.minecraft.world.level.ServerLevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Drowned.class)
public class MixinDrowned extends Zombie {

    public MixinDrowned() {
        super(null);
    }

    @Inject(method = "finalizeSpawn(Lnet/minecraft/world/level/ServerLevelAccessor;Lnet/minecraft/world/DifficultyInstance;Lnet/minecraft/world/entity/EntitySpawnReason;Lnet/minecraft/world/entity/SpawnGroupData;)Lnet/minecraft/world/entity/SpawnGroupData;", at = @At("HEAD"))
    private void onSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, EntitySpawnReason spawnReason, SpawnGroupData groupData, CallbackInfoReturnable<SpawnGroupData> cir) {
        if (this.getItemBySlot(EquipmentSlot.OFFHAND).isEmpty() && level.getRandom().nextFloat() < OhMySherd.CONFIG.snip.spawn_chance) {
            if (OhMySherd.CONFIG.snip.only_natural_spawns && !(spawnReason == EntitySpawnReason.NATURAL || spawnReason == EntitySpawnReason.CHUNK_GENERATION || spawnReason == EntitySpawnReason.STRUCTURE)) {
                return;
            }
            this.setItemSlot(EquipmentSlot.OFFHAND, SherdType.SNIP.item().getDefaultInstance());
            this.setGuaranteedDrop(EquipmentSlot.OFFHAND);
            if (OhMySherd.CONFIG.log_spawn_positions) {
                OhMySherd.LOG.info("Spawned Drowned with snipped sherd at {}.", this.position());
            }
        }
    }
}