package rpg.gui.panels;

import rpg.gui.UIConstants;
import rpg.utils.cache.ImageCache;

import javax.swing.*;

public class TopPanel extends BackgroundPanel {

    @Override
    protected void init() {
        // Buscamos la imagen por ahora directamente en los directorios
        backgroundImage = new ImageIcon(ImageCache.addImage("topPanel",
                "panels/statusPanel.jpg"));
        setDimension(UIConstants.TOP_DIMENSION);
        setBorder(UIConstants.EMPTY_BORDER);
    }
}
