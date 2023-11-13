package net.darkhax.ohmysherd;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;

public class OhMySherdFabric implements ModInitializer {

    @Override
    public void onInitialize() {

        OhMySherd.registerItems((id, item) -> Registry.register(BuiltInRegistries.ITEM, id, item));
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, OhMySherd.TAB_ID, OhMySherd.createTab(FabricItemGroup.builder()));
    }
}