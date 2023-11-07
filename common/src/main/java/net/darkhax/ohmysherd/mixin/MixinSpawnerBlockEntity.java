package net.darkhax.ohmysherd.mixin;

import net.darkhax.ohmysherd.lib.ISpawner;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.entity.SpawnerBlockEntity;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SpawnerBlockEntity.class)
public class MixinSpawnerBlockEntity implements ISpawner {

    @Unique
    private EntityType<?> spawnerType;

    @Inject(method = "setEntityId", at = @At("HEAD"))
    private void setEntityId(EntityType<?> type, RandomSource rng, CallbackInfo cbi) {

        this.spawnerType = type;
    }

    @Override
    public EntityType<?> ohmysherd$getEntityType() {

        return this.spawnerType;
    }
}
