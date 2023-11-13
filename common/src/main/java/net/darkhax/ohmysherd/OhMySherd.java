package net.darkhax.ohmysherd;

import net.darkhax.ohmysherd.lib.SherdEntry;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

import java.util.function.BiConsumer;

public class OhMySherd {

    public static final String MOD_ID = "ohmysherd";
    public static final ResourceLocation TAB_ID = location("tab");

    public static final SherdEntry SHERD_REMAINS = SherdEntry.of("remains");
    public static final SherdEntry SHERD_SNIP = SherdEntry.of("snip");
    public static final SherdEntry SHERD_INVADER = SherdEntry.of("invader");

    public static final ResourceLocation LOOT_TABLE_SKELETON_DUNGEON = location("archaeology/skeleton_dungeon");

    public static ResourceLocation location(String path) {

        return new ResourceLocation(MOD_ID, path);
    }

    public static void registerItems(BiConsumer<ResourceLocation, Item> registry) {

        SherdEntry.SHERDS.values().forEach(entry -> registry.accept(entry.itemId, entry.item.get()));
    }

    public static void registerPatterns(BiConsumer<ResourceLocation, String> registry) {

        SherdEntry.SHERDS.values().forEach(entry -> registry.accept(entry.sherdPattern.location(), entry.sherdPattern.location().getPath()));
    }

    public static CreativeModeTab createTab(CreativeModeTab.Builder builder) {

        builder.title(Component.translatable("itemgroup." + MOD_ID + ".tab"));
        builder.icon(() -> SHERD_REMAINS.asItem().getDefaultInstance());
        builder.displayItems((params, output) -> {
            SherdEntry.SHERDS.values().forEach(output::accept);
            output.accept(Utils.debugSuspiciousGravel(LOOT_TABLE_SKELETON_DUNGEON));
        });

        return builder.build();
    }
}