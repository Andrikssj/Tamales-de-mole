package rpg.gui.panels;

import rpg.utils.cache.ImageCache;

import javax.swing.*;
import java.awt.*;

public class InternPanel extends BackgroundPanel {

    private int width;
    private int height;

    public InternPanel(int width, int height) {
        this.width = width;
        this.height = height;
        init();
    }

    @Override
    protected void init() {
        // Buscamos la imagen por ahora directamente en los directorios
        backgroundImage = new ImageIcon(ImageCache.addImage("borderPanel",
                "panels/borderPanel.png"));
        setDimension(new Dimension(width, height));
    }
}
