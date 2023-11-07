package net.darkhax.ohmysherd;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;

public class OhMySherdFabric implements ModInitializer {

    @Override
    public void onInitialize() {

        OhMySherd.registerItems((id, item) -> Registry.register(BuiltInRegistries.ITEM, id, item));
    }
}