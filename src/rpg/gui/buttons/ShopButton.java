package rpg.gui.buttons;

import rpg.utils.cache.ImageCache;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class ShopButton extends BaseButton {

    public ShopButton() {
        super("Tienda");
    }

    @Override
    protected void initIcons() {
        BufferedImage shopIdle = ImageCache.addImage(
                "shopIdle", "icons/shopIdle.png");
        BufferedImage shopHover = ImageCache.addImage(
                "shopHover", "icons/shopHover.png");
        setIcon(new ImageIcon(shopIdle));
        setRolloverIcon(new ImageIcon(shopHover));
    }
}
