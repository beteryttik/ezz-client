package ru.ezz.client.common.modules;

import ru.ezz.client.common.module.Module;
import ru.ezz.client.common.module.RenderContext;

/** Keystrokes: адаптер обновляет битовую маску WASD/пробел через setKeys(). */
public class KeystrokesModule extends Module {
    public static final int W = 1, A = 2, S = 4, D = 8, SPACE = 16;
    private volatile int keys;

    public KeystrokesModule() { super("keystrokes", "Keystrokes", "HUD", "Показывает нажатия WASD и пробела", null); }

    public void setKeys(int mask) { this.keys = mask; }
    private boolean has(int bit) { return (keys & bit) != 0; }

    @Override public void renderHud(RenderContext ctx) {
        String l = (has(W) ? "[W]" : "[ ]") + (has(A) ? "[A]" : "[ ]")
                 + (has(S) ? "[S]" : "[ ]") + (has(D) ? "[D]" : "[ ]");
        ctx.drawText(l, 4, 40, 0xFFFFFFFF, 1.0f);
        if (has(SPACE)) ctx.drawText("[SPACE]", 4, 52, 0xFFFFFFFF, 1.0f);
    }
}
