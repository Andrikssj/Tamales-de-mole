package rpg.gui.labels;

import rpg.utils.cache.ImageCache;

import java.awt.*;

public class PlayerSpriteLabel extends PortraitLabel {

    public PlayerSpriteLabel() {

        super(null);
    }

    @Override
    public void initComponents() {
        ImageCache.addImage("playerSprite", "player/player (1).png");
        icon = ImageCache.getImageIcon("playerSprite");
        setPreferredSize(new Dimension(icon.getIconWidth(),
                icon.getIconHeight()));
        setIcon(icon);
    }
}
