package ru.ezz.client.common.theme;

/** Тема GUI: палитра цветов + сила блюра. Темы можно добавлять JSON-файлами позже. */
public record Theme(String name, int panelBg, int panelBorder, int accent,
                    int buttonIdle, int buttonHover, int toggleOn, int hudText, float blurRadius) {

    public static final Theme MIDNIGHT_BLOOM = new Theme(
            "Midnight Bloom", 0xF0101014, 0xFF2A2A3A, 0xFF7B6CFF,
            0xFF1A1A26, 0xFF26263A, 0xFF7B6CFF, 0xFFFFFFFF, 5.0f);
    public static final Theme EZZ_PURPLE = new Theme(
            "Ezz Purple", 0xF0140A1E, 0xFF4A2A7A, 0xFFA855F7,
            0xFF221035, 0xFF331A52, 0xFFA855F7, 0xFFFFFFFF, 5.0f);
    public static final Theme SUNSET = new Theme(
            "Sunset", 0xF01E1012, 0xFF5A2A1A, 0xFFFF7043,
            0xFF2A1618, 0xFF3F2020, 0xFFFF7043, 0xFFFFFFFF, 5.0f);
    public static final Theme FOREST = new Theme(
            "Forest", 0xF00E1410, 0xFF1F3A24, 0xFF66BB6A,
            0xFF16221A, 0xFF20321F, 0xFF66BB6A, 0xFFFFFFFF, 5.0f);
    public static final Theme LIGHT = new Theme(
            "Light", 0xF0F2F2F8, 0xFFD0D0E0, 0xFF5B5BD6,
            0xFFE4E4F0, 0xFFD8D8EC, 0xFF5B5BD6, 0xFF1A1A2A, 2.0f);
}
