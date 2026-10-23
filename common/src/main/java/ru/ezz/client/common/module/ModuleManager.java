package ru.ezz.client.common.module;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public final class ModuleManager {
    private final List<Module> modules = new CopyOnWriteArrayList<>();

    public void register(Module m) {
        modules.add(m);
        sort();
    }

    /** Совместимые модули сверху, несовместимые — снизу серыми. */
    private void sort() {
        modules.sort(Comparator
                .comparing((Module m) -> m.compatible() ? 0 : 1)
                .thenComparing(Module::category)
                .thenComparing(Module::name));
    }

    public List<Module> all() { return Collections.unmodifiableList(modules); }
    public List<Module> byCategory(String cat) {
        List<Module> out = new ArrayList<>();
        for (Module m : modules) if (m.category().equals(cat)) out.add(m);
        return out;
    }
    public Module byId(String id) {
        for (Module m : modules) if (m.id().equals(id)) return m;
        return null;
    }

    public void renderAll(RenderContext ctx) {
        for (Module m : modules) if (m.enabled()) m.renderHud(ctx);
    }

    public void setStates(Map<String, Boolean> states) {
        for (Module m : modules) {
            Boolean s = states.get(m.id());
            if (s != null && s && m.compatible() && !m.enabled()) m.toggle();
        }
    }

    static void registerDefaults(ModuleManager mgr) {
        mgr.register(new ru.ezz.client.common.modules.WatermarkModule());
        mgr.register(new ru.ezz.client.common.modules.FpsModule());
        mgr.register(new ru.ezz.client.common.modules.CoordinatesModule());
        mgr.register(new ru.ezz.client.common.modules.KeystrokesModule());
        mgr.register(new ru.ezz.client.common.modules.CpsModule());
        mgr.register(new ru.ezz.client.common.modules.FullbrightModule());
        mgr.register(new ru.ezz.client.common.modules.ZoomModule());
        mgr.register(new ru.ezz.client.common.modules.ToggleSprintModule());
        mgr.register(new ru.ezz.client.common.modules.MaceIndicatorModule());
        mgr.register(new ru.ezz.client.common.modules.NoLungeCooldownModule());
    }
}
