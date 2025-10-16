package net.darkhax.ohmysherd.common.impl;

import net.darkhax.bookshelf.common.api.registry.ContentProvider;
import net.darkhax.bookshelf.common.api.registry.adapters.GameRegistryAdapter;
import net.darkhax.bookshelf.common.impl.registry.adapter.PotPatternAdapter;
import net.minecraft.world.item.Item;

public class Content implements ContentProvider {

    @Override
    public String namespace() {
        return OhMySherd.MOD_ID;
    }

    @Override
    public void defineItems(GameRegistryAdapter<Item> registry) {
        for (SherdType type : SherdType.values()) {
            registry.add(type.itemId(), type.item());
        }
    }

    @Override
    public void definePotPatterns(PotPatternAdapter registry) {
        for (SherdType type : SherdType.values()) {
            registry.addWithItem(type.patternId(), type.item());
        }
    }
}