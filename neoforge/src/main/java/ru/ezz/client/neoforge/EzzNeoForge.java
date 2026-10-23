package ru.ezz.client.neoforge;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@Mod("ezzclient")
public class EzzNeoForge {
    public EzzNeoForge(IEventBus modBus) {
        modBus.addListener(this::setup);
    }

    private void setup(FMLClientSetupEvent e) {
        String ver = "1.21.1"; // TODO: брать из реального контекста игры
        ru.ezz.client.common.module.VersionCompat.setGameVersion(ver);
        ru.ezz.client.common.EzzClient.init(ver);
        // TODO: подписка на рендер HUD через NeoForge-события
    }
}
