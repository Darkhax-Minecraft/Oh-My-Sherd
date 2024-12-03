package net.darkhax.ohmysherd.forge.impl;

import net.darkhax.ohmysherd.common.impl.OhMySherd;
import net.minecraftforge.fml.common.Mod;

@Mod(OhMySherd.MOD_ID)
public class ForgeMod {

    public ForgeMod() {
        OhMySherd.init();
    }
}