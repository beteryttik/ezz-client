package ru.ezz.client.common.modules;

import ru.ezz.client.common.module.Module;

/** Zoom: адаптер изменяет FOV, пока модуль включён (обычно на зажатую клавишу C). */
public class ZoomModule extends Module {
    private double factor = 4.0;

    public ZoomModule() { super("zoom", "Zoom", "VISUAL", "Приближение камеры (удерживайте C)", null); }

    public double factor() { return factor; }
    public void setFactor(double f) { this.factor = f; }
}
