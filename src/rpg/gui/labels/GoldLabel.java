package rpg.gui.labels;

import rpg.gui.UIConstants;
import rpg.utils.cache.ImageCache;

import javax.swing.*;
import java.awt.*;

public class GoldLabel extends PortraitLabel {

    private int gold;

    public GoldLabel(int gold) {
        super(null);
        this.gold = gold;
        setFont(UIConstants.LABEL_FONT.deriveFont(Font.BOLD, 20f));
        setForeground(Color.BLACK);
        setVerticalAlignment(JLabel.CENTER);
        setHorizontalAlignment(JLabel.CENTER);
        setVerticalTextPosition(JLabel.CENTER);
        setHorizontalTextPosition(JLabel.CENTER);
    }

    @Override
    public void initComponents() {
        ImageCache.addImage("gold", "labels/goldLabel.png");
        icon = ImageCache.getImageIcon("gold");
        setPreferredSize(new Dimension(
                icon.getIconWidth(), icon.getIconHeight()));
        setIcon(icon);
        setText(gold + "G");
    }
}
