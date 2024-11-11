package rpg.enums;

import rpg.utils.cache.ImageCache;

import javax.swing.*;
import java.awt.image.BufferedImage;

public enum BarType {

    LIFE, MAGIC, EXPERIENCE;

    BufferedImage container;
    BufferedImage icon;
    BufferedImage bar;

    BarType() {
        switch (this) {
            case LIFE -> {
                container = ImageCache.addImage("life_container", "bars/life_container.png");
                icon = ImageCache.addImage("life_icon", "bars/life_icon.png");
                bar = ImageCache.addImage("life_bar", "bars/life_bar.png");
            }
            case MAGIC -> {
                // Se cargan las imágenes para la barra de magia
            }
            case EXPERIENCE -> {
                // Se cargan las imágenes para la barra de experiencia
            }
        }
    }

    public BufferedImage getContainer() {
        return container;
    }

    public BufferedImage getIcon() {
        return icon;
    }

    public BufferedImage getBar() {
        return bar;
    }
}
