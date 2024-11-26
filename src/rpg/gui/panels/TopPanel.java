package rpg.gui.panels;

import rpg.gui.windows.WindowConstants;
import rpg.utils.cache.ImageCache;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class TopPanel extends BackgroundPanel {

    @Override
    protected void init() {
        // Buscamos la imagen por ahora directamente en los directorios
        backgroundImage = new ImageIcon(ImageCache.addImage("topPanel",
                "Background 1.jpg"));
        setDimension(WindowConstants.TOP_DIMENSION);
        setBorder(null);
    }
}
