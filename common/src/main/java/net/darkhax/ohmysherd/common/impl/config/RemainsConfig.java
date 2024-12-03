package net.darkhax.ohmysherd.common.impl.config;

import net.darkhax.pricklemc.common.api.annotations.RangedInt;
import net.darkhax.pricklemc.common.api.annotations.Value;

public class RemainsConfig {

    @Value(comment = "When enabled the mod will try to spawn suspicious gravel in dungeons with a skeleton spawner.")
    public boolean enable_generation = true;

    @Value(comment = "When enabled the mod will always try to place a suspicious gravel under the spawner block.")
    public boolean under_spawner = true;

    @Value(comment = "The number of additional suspicious gravel the mod should attempt to generate.")
    @RangedInt(min = 0)
    public int floor_attempts = 5;

    @Value(comment = "The maximum distance away from the spawner that suspicious gravel should generate.")
    @RangedInt(min = 1, max = 8)
    public int floor_range = 4;
}
