package net.darkhax.ohmysherd.common.impl;

import net.darkhax.ohmysherd.common.impl.config.Config;
import net.darkhax.pricklemc.common.api.config.ConfigManager;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OhMySherd {

    public static final String MOD_ID = "ohmysherd";
    public static final String MOD_NAME = "OhMySherd";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);
    public static final Config CONFIG = ConfigManager.load(MOD_ID, new Config());
    public static final ResourceKey<LootTable> LOOT_TABLE_SKELETON_DUNGEON = ResourceKey.create(Registries.LOOT_TABLE, id("archaeology/skeleton_dungeon"));
    public static final ResourceKey<LootTable> LOOT_TABLE_ALIEN = ResourceKey.create(Registries.LOOT_TABLE, id("archaeology/alien_relics"));

    public static void init() {
    }

    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }
}