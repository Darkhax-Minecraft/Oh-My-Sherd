package net.darkhax.ohmysherd.common.impl.util;

import net.minecraft.world.entity.EntityType;
import org.jetbrains.annotations.Nullable;

public interface ISpawner {

    @Nullable
    EntityType<?> ohmysherd$getEntityType();
}