package ru.ezz.client.common.theme;

import java.util.ArrayList;
import java.util.List;

public final class ThemeManager {
    private final List<Theme> themes = new ArrayList<>(List.of(
            Theme.MIDNIGHT_BLOOM, Theme.EZZ_PURPLE, Theme.SUNSET, Theme.FOREST, Theme.LIGHT));
    private int index;

    public void loadDefaults() { index = 0; }

    public Theme current() { return themes.get(index); }
    public List<Theme> all() { return List.copyOf(themes); }

    public void next() { index = (index + 1) % themes.size(); }
    public void prev() { index = (index - 1 + themes.size()) % themes.size(); }
    public void select(String name) {
        for (int i = 0; i < themes.size(); i++) if (themes.get(i).name().equals(name)) index = i;
    }
}
