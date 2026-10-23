package ru.ezz.client.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import ru.ezz.client.common.EzzClient;
import ru.ezz.client.common.module.VersionCompat;

/** Точка входа Fabric. HUD-рендер и нажатия подключаются здесь (см. TODO ниже). */
public class EzzFabric implements ClientModInitializer {
    @Override public void onInitializeClient() {
        String ver = MinecraftClient.getInstance().getGameVersion();
        VersionCompat.setGameVersion(ver);
        EzzClient.init(ver);
        EzzClient.config().setDir(net.fabricmc.loader.api.FabricLoader.getInstance()
                .getConfigDir().resolve("ezclient"));

        // TODO: HudRenderCallback -> ModuleManager.renderAll(...)
        // TODO: KeyBinding Right Shift -> открытие ClickGUI
    }
}
