package rpg.gui.panels;

import rpg.gui.WindowConstants;
import rpg.utils.cache.ImageCache;

import javax.swing.*;

public class MiddlePanel extends BackgroundPanel {

    @Override
    protected void init() {
        // Buscamos la imagen por ahora directamente en los directorios
        backgroundImage = new ImageIcon(ImageCache.addImage("midPanel",
                "Background 2.jpg"));
        setDimension(WindowConstants.MIDDLE_DIMENSION);
        setBorder(WindowConstants.EMPTY_BORDER);
    }
}