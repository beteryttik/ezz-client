package ru.ezz.client.forge;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("ezzclient")
public class EzzForge {
    public EzzForge() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);
    }

    private void setup(FMLClientSetupEvent e) {
        String ver = "1.21.1"; // TODO: брать из реального контекста игры
        ru.ezz.client.common.module.VersionCompat.setGameVersion(ver);
        ru.ezz.client.common.EzzClient.init(ver);
        // TODO: RenderGuiEvent.Pre -> рендер HUD через RenderContext-адаптер
    }
}
