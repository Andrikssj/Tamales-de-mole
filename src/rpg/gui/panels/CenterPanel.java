package rpg.gui.panels;

import rpg.gui.UIConstants;
import rpg.utils.cache.ImageCache;

import javax.swing.*;

public class CenterPanel extends BackgroundPanel{

    @Override
    protected void init() {
        // Buscamos la imagen por ahora directamente en los directorios
        backgroundImage = new ImageIcon(ImageCache.addImage("centerPanel",
                "panels/topCenter.png"));
        setDimension(UIConstants.CENTER_DIMENSION);
    }
}
