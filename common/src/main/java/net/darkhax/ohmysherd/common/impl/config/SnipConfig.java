package net.darkhax.ohmysherd.common.impl.config;

import net.darkhax.pricklemc.common.api.annotations.RangedFloat;
import net.darkhax.pricklemc.common.api.annotations.Value;

public class SnipConfig {

    @Value(comment = "The percent chance that a drowned will spawn with a snip sherd in the offhand slot. The default is 3%.")
    @RangedFloat(min = 0f, max = 1f)
    public float spawn_chance = 0.03f;

    @Value(comment = "When enabled, only naturally spawned drowned have a chance to spawn holding the sherd. Unnatural spawn methods like commands, spawners, and spawn eggs will not.")
    public boolean only_natural_spawns = true;
}