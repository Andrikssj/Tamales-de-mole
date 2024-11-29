package rpg.gui.panels;

import rpg.gui.UIConstants;
import rpg.utils.cache.ImageCache;

import javax.swing.*;

public class LeftCornerPanel extends BackgroundPanel {

    @Override
    protected void init() {
        // Buscamos la imagen por ahora directamente en los directorios
        backgroundImage = new ImageIcon(ImageCache.addImage("leftCornerPanel",
                "panels/topLeftCorner.png"));
        setDimension(UIConstants.CORNER_DIMENSION);
    }
}
