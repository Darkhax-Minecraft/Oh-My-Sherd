package net.darkhax.ohmysherd.lib;

import net.minecraft.world.entity.EntityType;

import javax.annotation.Nullable;

public interface ISpawner {

    @Nullable
    EntityType<?> ohmysherd$getEntityType();
}
