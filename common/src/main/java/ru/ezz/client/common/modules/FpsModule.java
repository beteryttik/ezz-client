package ru.ezz.client.common.modules;

import ru.ezz.client.common.module.Module;
import ru.ezz.client.common.module.RenderContext;

/** FPS подставляет платформенный адаптер через setFps(). */
public class FpsModule extends Module {
    private volatile int fps;

    public FpsModule() { super("fps", "FPS", "HUD", "Счётчик кадров в секунду", null); }

    public void setFps(int fps) { this.fps = fps; }

    @Override public void renderHud(RenderContext ctx) {
        ctx.drawText("FPS: " + fps, 4, 16, 0xFFFFFFFF, 1.0f);
    }
}
