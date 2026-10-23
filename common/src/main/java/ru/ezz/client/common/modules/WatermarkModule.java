package ru.ezz.client.common.modules;

import ru.ezz.client.common.EzzClient;
import ru.ezz.client.common.module.Module;
import ru.ezz.client.common.module.RenderContext;
import ru.ezz.client.common.module.VersionCompat;

public class WatermarkModule extends Module {
    public WatermarkModule() { super("watermark", "Watermark", "HUD", "Логотип и версия Ezz Client в углу экрана", null); }

    @Override public void renderHud(RenderContext ctx) {
        ctx.drawText("Ezz Client " + VersionCompat.gameVersion() + " | " +
                EzzClient.themes().current().name(), 4, 4, 0xFFFFFFFF, 1.0f);
    }
}
