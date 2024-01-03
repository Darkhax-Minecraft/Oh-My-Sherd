package net.darkhax.ohmysherd;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.RegisterEvent;

@Mod(OhMySherd.MOD_ID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class OhMySherdNeoForge {

    @SubscribeEvent
    public static void registerItems(RegisterEvent event) {

        event.register(Registries.ITEM, helper -> OhMySherd.registerItems((id, item) -> helper.register(id, item)));
        event.register(Registries.CREATIVE_MODE_TAB, helper -> helper.register(OhMySherd.TAB_ID, OhMySherd.createTab(CreativeModeTab.builder())));
    }
}