package net.darkhax.ohmysherd.neoforge.impl;

import net.darkhax.ohmysherd.common.impl.OhMySherd;
import net.neoforged.fml.common.Mod;

@Mod(OhMySherd.MOD_ID)
public class NeoForgeMod {

    public NeoForgeMod() {
        OhMySherd.init();
    }
}