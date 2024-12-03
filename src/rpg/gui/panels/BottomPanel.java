package rpg.gui.panels;

import rpg.gui.UIConstants;
import rpg.utils.cache.ImageCache;

import javax.swing.*;

public class BottomPanel extends BackgroundPanel {

    @Override
    protected void init() {
        // Buscamos la imagen por ahora directamente en los directorios
        backgroundImage = new ImageIcon(ImageCache.addImage("bottomPanel",
                "panels/Background 3.jpg"));
        setDimension(UIConstants.MIDDLE_DIMENSION);
        setBorder(UIConstants.EMPTY_BORDER);
    }
}
