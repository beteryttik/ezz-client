package ru.ezz.client.common.modules;

import ru.ezz.client.common.module.Module;
import ru.ezz.client.common.module.RenderContext;

/** Ezz-эксклюзив: предсказание урона булавы от высоты падения.
 *  Базовый урон 6 + 3 за каждый блок свыше первого (упрощённая ванильная формула). */
public class MaceIndicatorModule extends Module {
    private volatile double fallDistance;

    public MaceIndicatorModule() { super("maceindicator", "Mace Indicator", "OTHER", "Показывает урон булавы с учётом высоты падения", "1.21"); }

    public void setFallDistance(double d) { this.fallDistance = Math.max(0, d); }

    /** Урон в половинках сердца. */
    public double damage() {
        double bonus = fallDistance > 1.0 ? Math.floor(fallDistance - 1.0) * 3.0 : 0.0;
        return 6.0 + bonus;
    }

    @Override public void renderHud(RenderContext ctx) {
        int color = damage() >= 20.0 ? 0xFFFF5555 : 0xFFFFFFFF;
        ctx.drawText(String.format("Mace: %.0f dmg", damage()), 4, 76, color, 1.0f);
    }
}
