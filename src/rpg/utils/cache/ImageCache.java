package rpg.utils.cache;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase que se encarga de almacenar en caché las imágenes que se cargan en la aplicación.
 */
public class ImageCache {

    private static final String IMAGE_PATH = "image/";
    private static final Map<String, BufferedImage> CACHE = new HashMap<>();

    /**
     * Función que se encarga de añadir una imagen a la caché.
     *
     * @param name Nombre de la imagen.
     * @param path Ruta de la imagen.
     */
    public static BufferedImage addImage(String name, String path) {

        BufferedImage image;
        if (!CACHE.containsKey(name)) {

            image = ImageLoader.loadImage(IMAGE_PATH + path);
            CACHE.put(name, image);
        } else {
            image = CACHE.get(name);
        }
        return image;
    }

    /**
     * Función que se encarga de obtener una imagen de la caché.
     *
     * @param imageName Nombre de la imagen.
     * @return Imagen a retornar de la cáche o null en caso de que la imagen a buscar no exista.
     */
    public static BufferedImage getImage(String imageName) {

        return CACHE.getOrDefault(imageName, null);
    }

    /**
     * Método que se encarga de obtener el tamaño de la caché.
     *
     * @param imageName Nombre de la imagen.
     * @return ImageIcon de la imagen a retornar de la caché o null en caso de que la imagen a buscar no exista.
     */
    public static ImageIcon getImageIcon(String imageName) {

        return new ImageIcon(getImage(imageName));
    }
}
