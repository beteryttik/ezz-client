package ru.ezz.client.common.modules;

import ru.ezz.client.common.module.Module;

/** ToggleSprint: адаптер держит спринт включённым, пока модуль активен. */
public class ToggleSprintModule extends Module {
    public ToggleSprintModule() { super("togglesprint", "ToggleSprint", "UTILITIES", "Постоянный спринт без двойного W", null); }
}
