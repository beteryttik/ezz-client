package ru.ezz.client.common.module;

/** Простое сравнение версий вида "1.21.11". gameVersion задаёт платформенный адаптер. */
public final class VersionCompat {
    private static String GAME_VERSION = "0";

    private VersionCompat() {}

    public static void setGameVersion(String v) { GAME_VERSION = v == null ? "0" : v; }
    public static String gameVersion() { return GAME_VERSION; }

    public static boolean atLeast(String min) {
        return compare(GAME_VERSION, min) >= 0;
    }

    static int compare(String a, String b) {
        int[] pa = parts(a), pb = parts(b);
        for (int i = 0; i < Math.max(pa.length, pb.length); i++) {
            int x = i < pa.length ? pa[i] : 0;
            int y = i < pb.length ? pb[i] : 0;
            if (x != y) return Integer.compare(x, y);
        }
        return 0;
    }

    private static int[] parts(String s) {
        String[] raw = s.replaceAll("[^0-9.]", "").split("\\.");
        int[] out = new int[raw.length];
        for (int i = 0; i < raw.length; i++) {
            try { out[i] = Integer.parseInt(raw[i]); } catch (NumberFormatException ignored) {}
        }
        return out;
    }
}
