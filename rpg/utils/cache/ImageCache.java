package rpg.utils.cache;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class ImageCache {

    private static final Map<String, ImageIcon> cache = new HashMap<>();

    public static ImageIcon addImage(String name, String path) {
        ImageIcon image = new ImageIcon(path);
        cache.put(name, image);
        return image;
    }

    public static ImageIcon getImageIcon(String name) {
        return cache.get(name);
    }
}

