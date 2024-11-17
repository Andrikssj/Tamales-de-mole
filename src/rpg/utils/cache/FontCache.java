package unitec.rpg.utils.cache;

import rpg.utils.cache.FontLoader;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class FontCache {

    public static final Map<String, Font> cache = new HashMap<>();

    public static Font addFont(String fontName, String fontPath) {

        Font font;
        if (!cache.containsKey(fontName)) {

            font = FontLoader.loadFont(fontPath);
            cache.put(fontName, font);
        } else {
            font = cache.get(fontName);
        }
        return font;
    }

    public static Font getFont(String fontName, int style, int size) {

        return cache.getOrDefault(fontName, Font.getFont("Arial")).deriveFont(style, size);
    }

    public static Font getFont(String fontName) {

        return getFont(fontName, Font.PLAIN, 12);
    }

    public static Font getFont(String fontName, int size) {

        return getFont(fontName, Font.PLAIN, size);
    }
}
