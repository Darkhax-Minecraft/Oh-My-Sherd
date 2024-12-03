package net.darkhax.ohmysherd.common.impl.config;

import net.darkhax.pricklemc.common.api.annotations.RangedFloat;
import net.darkhax.pricklemc.common.api.annotations.Value;

public class InvaderConfig {

    @Value(comment = "When enabled te mod will try to spawn suspicious sand with the invader sherd inside of pyramids.")
    public boolean enable_generation = true;

    @Value(comment = "The percent chance that a suspicious sand will have the invader loot table. The default is 10%.")
    @RangedFloat(min = 0f, max = 1f)
    public float generation_chance = 0.1f;
}
