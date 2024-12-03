package net.darkhax.ohmysherd.fabric.impl;

import net.darkhax.ohmysherd.common.impl.OhMySherd;
import net.fabricmc.api.ModInitializer;

public class FabricMod implements ModInitializer {

    @Override
    public void onInitialize() {
        OhMySherd.init();
    }
}