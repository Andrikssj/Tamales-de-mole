package rpg.enums;

import rpg.utils.cache.ImageCache;

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
            }
            case MAGIC -> {
                container = ImageCache.addImage("magic_container", "bars/magic_container.png");
                icon = ImageCache.addImage("magic_icon", "bars/magic_icon.png");
                bar = ImageCache.addImage("magic_bar", "bars/magic_bar.png");
            }
            case EXPERIENCE -> {
                container = ImageCache.addImage("exp_container", "bars/exp_container.png");
                icon = ImageCache.addImage("exp_icon", "bars/exp_icon.png");
                bar = ImageCache.addImage("exp_bar", "bars/exp_bar.png");
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
