package net.darkhax.ohmysherd.common.impl;

import net.darkhax.bookshelf.common.api.registry.IContentProvider;
import net.darkhax.bookshelf.common.api.registry.register.Register;
import net.darkhax.bookshelf.common.api.registry.register.RegisterPotPatterns;
import net.minecraft.world.item.Item;

public class Content implements IContentProvider {

    @Override
    public String contentNamespace() {
        return OhMySherd.MOD_ID;
    }

    @Override
    public void registerItems(Register<Item> registry) {
        for (SherdType type : SherdType.values()) {
            registry.add(type.itemId(), type.item());
        }
    }

    @Override
    public void registerPotPatterns(RegisterPotPatterns registry) {
        for (SherdType type : SherdType.values()) {
            registry.add(type.item(), type.patternId());
        }
    }
}