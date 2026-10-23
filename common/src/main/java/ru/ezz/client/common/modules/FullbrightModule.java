package ru.ezz.client.common.modules;

import ru.ezz.client.common.module.Module;

/** Fullbright: gamma -> 10 на включение, восстановление на выключение.
 *  Платформенный адаптер применяет value в options.txt. */
public class FullbrightModule extends Module {
    private double savedGamma = 1.0;

    public FullbrightModule() { super("fullbright", "Fullbright", "VISUAL", "Максимальная яркость без зелья ночного зрения", null); }

    public double gamma() { return enabled() ? 10.0 : savedGamma; }
    public void setSavedGamma(double g) { this.savedGamma = g; }
}
