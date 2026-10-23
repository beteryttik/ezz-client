package ru.ezz.client.common.module;

/** Абстракция рисования HUD. Платформенный адаптер реализует её средствами загрузчика. */
public interface RenderContext {
    /** x, y — левый верхний угол; scale — множитель GUI Scale. */
    void drawText(String text, int x, int y, int argb, float scale);

    /** Прямоугольник с прозрачностью (для плашек модулей). */
    void fill(int x, int y, int w, int h, int argb);
}
