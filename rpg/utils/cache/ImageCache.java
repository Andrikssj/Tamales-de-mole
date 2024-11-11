package rpg.utils.cache;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class ImageCache {

    private static final String IMAGE_PATH = "image";
    private static final Map<String, BufferedImage> CACHE = new HashMap<>();

    public static BufferedImage addImage(String name, String path) {

        BufferedImage image;
        if (!CACHE.containsKey(name)) {

            image = rpg.utils.cache.ImageLoader.loadImage(IMAGE_PATH + path);
            CACHE.put(name, image);
        } else {
            image = CACHE.get(name);
        }
        return image;
    }

    public static BufferedImage getImage(String imageName) {

        return CACHE.getOrDefault(imageName, null);
    }

    public static ImageIcon getImageIcon(String imageName) {

        return new ImageIcon(getImage(imageName));
    }
}