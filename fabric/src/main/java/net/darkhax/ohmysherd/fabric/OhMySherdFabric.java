package net.darkhax.ohmysherd.fabric;

import net.darkhax.ohmysherd.common.impl.OhMySherd;
import net.fabricmc.api.ModInitializer;

public class OhMySherdFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        OhMySherd.init();
    }
}