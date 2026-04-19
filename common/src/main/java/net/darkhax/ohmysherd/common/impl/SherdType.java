package net.darkhax.ohmysherd.common.impl;

import net.darkhax.bookshelf.common.api.function.CachedSupplier;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;

import java.util.Locale;

public enum SherdType {

    SNIP,
    REMAINS,
    INVADER;

    private final CachedSupplier<Item> sherdItem = CachedSupplier.cache(() -> BuiltInRegistries.ITEM.getValue(OhMySherd.id(this.itemId())));

    public Item item() {
        return this.sherdItem.get();
    }

    public String id() {
        return this.name().toLowerCase(Locale.ROOT);
    }

    public String itemId() {
        return this.id() + "_pottery_sherd";
    }

    public String patternId() {
        return this.id() + "_pottery_pattern";
    }
}