package ru.ezz.client.common.module;

/** Базовый модуль клиента. minVersion = null значит "совместим со всеми версиями". */
public abstract class Module {
    private final String id, name, category, description;
    private final String minVersion;
    private boolean enabled;

    protected Module(String id, String name, String category, String description, String minVersion) {
        this.id = id; this.name = name; this.category = category;
        this.description = description; this.minVersion = minVersion;
    }

    public String id() { return id; }
    public String name() { return name; }
    public String category() { return category; }
    public String description() { return description; }
    public String minVersion() { return minVersion; }
    public boolean enabled() { return enabled; }

    public void toggle() {
        if (!compatible()) return;
        enabled = !enabled;
        if (enabled) onEnable(); else onDisable();
    }

    public boolean compatible() {
        return minVersion == null || VersionCompat.atLeast(minVersion);
    }

    protected void onEnable() {}
    protected void onDisable() {}

    /** Хук рендера HUD, вызывает платформенный адаптер каждый кадр. */
    public void renderHud(RenderContext ctx) {}
}
