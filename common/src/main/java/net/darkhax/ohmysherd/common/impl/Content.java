package net.darkhax.ohmysherd.common.impl;

import net.darkhax.bookshelf.common.api.registry.ContentProvider;
import net.darkhax.bookshelf.common.impl.registry.adapter.ItemRegistryAdapter;
import net.darkhax.bookshelf.common.impl.registry.adapter.PotPatternAdapter;

import java.util.function.UnaryOperator;

public class Content implements ContentProvider {

    @Override
    public String namespace() {
        return OhMySherd.MOD_ID;
    }

    @Override
    public void defineItems(ItemRegistryAdapter registry) {
        for (SherdType type : SherdType.values()) {
            registry.addSimple(type.itemId(), UnaryOperator.identity());
        }
    }

    @Override
    public void definePotPatterns(PotPatternAdapter registry) {
        for (SherdType type : SherdType.values()) {
            registry.addWithItem(type.patternId(), type.item());
        }
    }
}