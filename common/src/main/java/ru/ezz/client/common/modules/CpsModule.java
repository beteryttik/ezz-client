package ru.ezz.client.common.modules;

import ru.ezz.client.common.module.Module;
import ru.ezz.client.common.module.RenderContext;

import java.util.ArrayDeque;
import java.util.Deque;

/** CPS: адаптер вызывает click() на каждый клик мыши. */
public class CpsModule extends Module {
    private final Deque<Long> clicks = new ArrayDeque<>();

    public CpsModule() { super("cps", "CPS", "HUD", "Клики в секунду (ЛКМ/ПКМ)", null); }

    public void click() {
        long now = System.currentTimeMillis();
        clicks.addLast(now);
        while (!clicks.isEmpty() && now - clicks.peekFirst() > 1000) clicks.removeFirst();
    }

    @Override public void renderHud(RenderContext ctx) {
        ctx.drawText("CPS: " + clicks.size(), 4, 64, 0xFFFFFFFF, 1.0f);
    }
}
