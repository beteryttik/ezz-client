package ru.ezz.client.common.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.ezz.client.common.module.ModuleManager;

import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

/** Конфиги = JSON в config/ezclient. Путь задаёт платформенный адаптер. */
public final class ConfigManager {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private Path dir;
    private String gameVersion = "0";
    private String active = "default";

    public void setDir(Path dir) { this.dir = dir; }
    public void setGameVersion(String v) { this.gameVersion = v; }
    public String activeName() { return active; }

    private Path file(String name) { return dir.resolve(name + ".json"); }

    public void save(String name, ModuleManager modules) {
        try {
            Files.createDirectories(dir);
            Map<String, Boolean> states = new HashMap<>();
            for (var m : modules.all()) states.put(m.id(), m.enabled());
            SavedConfig cfg = new SavedConfig(gameVersion, states);
            Files.writeString(file(name), GSON.toJson(cfg));
            active = name;
        } catch (Exception e) {
            System.err.println("[Ezz Client] save failed: " + e);
        }
    }

    public void load(String name, ModuleManager modules) {
        try {
            SavedConfig cfg = GSON.fromJson(Files.readString(file(name)), SavedConfig.class);
            if (cfg != null) modules.setStates(cfg.states == null ? Map.of() : cfg.states);
            active = name;
        } catch (Exception e) {
            System.err.println("[Ezz Client] load failed: " + e);
        }
    }

    public void delete(String name) {
        try { Files.deleteIfExists(file(name)); } catch (Exception ignored) {}
    }

    public static final class SavedConfig {
        public final String gameVersion;
        public final Map<String, Boolean> states;
        public SavedConfig(String gameVersion, Map<String, Boolean> states) {
            this.gameVersion = gameVersion; this.states = states;
        }
    }
}
