package ru.ezz.client.common.modules;

import ru.ezz.client.common.module.Module;
import ru.ezz.client.common.module.RenderContext;

/** Координаты подставляет платформенный адаптер. */
public class CoordinatesModule extends Module {
    private volatile double x, y, z;

    public CoordinatesModule() { super("coordinates", "Coordinates", "HUD", "Показывает XYZ игрока", null); }

    public void setPos(double x, double y, double z) { this.x = x; this.y = y; this.z = z; }

    @Override public void renderHud(RenderContext ctx) {
        ctx.drawText(String.format("XYZ: %.1f / %.1f / %.1f", x, y, z), 4, 28, 0xFFFFFFFF, 1.0f);
    }
}
