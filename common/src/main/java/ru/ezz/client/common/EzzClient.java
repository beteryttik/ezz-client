package ru.ezz.client.common;

import ru.ezz.client.common.config.ConfigManager;
import ru.ezz.client.common.module.ModuleManager;
import ru.ezz.client.common.theme.ThemeManager;

/** Общая точка входа для всех загрузчиков. */
public final class EzzClient {
    private static final ModuleManager MODULES = new ModuleManager();
    private static final ConfigManager CONFIG = new ConfigManager();
    private static final ThemeManager THEMES = new ThemeManager();

    public static void init(String gameVersion) {
        ModuleManager.registerDefaults(MODULES);
        THEMES.loadDefaults();
        CONFIG.setGameVersion(gameVersion);
        CONFIG.load(MODULES);
        System.out.println("[Ezz Client] initialized, version " + gameVersion
                + ", modules: " + MODULES.all().size());
    }

    public static ModuleManager modules() { return MODULES; }
    public static ConfigManager config() { return CONFIG; }
    public static ThemeManager themes() { return THEMES; }
}
