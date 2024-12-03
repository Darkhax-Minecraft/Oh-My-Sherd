package net.darkhax.ohmysherd.common.mixin;

import net.darkhax.ohmysherd.common.impl.util.ISpawner;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.entity.SpawnerBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SpawnerBlockEntity.class)
public class MixinSpawnerBlockEntity implements ISpawner {

    @Unique
    private EntityType<?> ohmysherd$spawnerType;

    @Inject(method = "setEntityId", at = @At("HEAD"))
    private void setEntityId(EntityType<?> type, RandomSource rng, CallbackInfo cbi) {
        this.ohmysherd$spawnerType = type;
    }

    @Override
    public EntityType<?> ohmysherd$getEntityType() {
        return this.ohmysherd$spawnerType;
    }
}