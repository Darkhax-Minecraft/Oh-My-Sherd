package net.darkhax.ohmysherd.common.impl.config;

import net.darkhax.pricklemc.common.api.annotations.Value;

public class Config {

    @Value(comment = "When enabled, the mod will log all spawn positions to the console.")
    public boolean log_spawn_positions = false;

    @Value(comment = "The remains sherd can be found in suspicious gravel that has been inserted into the floor of vanilla skeleton dungeons.", writeDefault = false)
    public RemainsConfig remains = new RemainsConfig();

    @Value(comment = "Drowned can spawn holding the snip sherd on rare occasions.", writeDefault = false)
    public SnipConfig snip = new SnipConfig();

    @Value(comment = "The invader sherd can be found in suspicious sand that generates inside of a vanilla dessert pyramid.", writeDefault = false)
    public InvaderConfig invader = new InvaderConfig();
}