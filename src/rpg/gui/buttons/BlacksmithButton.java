package rpg.gui.buttons;

import rpg.utils.cache.ImageCache;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class BlacksmithButton extends BaseButton {

    public BlacksmithButton() {
        super("Herrero");
    }

    @Override
    protected void initIcons() {
        BufferedImage blacksmithIdle = ImageCache.addImage(
                "blacksmithIdle", "icons/blacksmithIdle.png");
        BufferedImage blacksmithHover = ImageCache.addImage(
                "blacksmithHover", "icons/blacksmithHover.png");
        setIcon(new ImageIcon(blacksmithIdle));
        setRolloverIcon(new ImageIcon(blacksmithHover));
    }
}
