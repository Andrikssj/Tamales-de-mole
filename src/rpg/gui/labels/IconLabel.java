package rpg.gui.labels;

import rpg.gui.ui.GameLabelUI;

import javax.swing.*;
import java.awt.*;

public class IconLabel extends JLabel {

    protected ImageIcon icon;

    public IconLabel(ImageIcon icon) {
        this.icon = icon;
        setIcon(icon);
        initComponents();
        setUI(new GameLabelUI(getPreferredSize(), icon));
    }

    public void initComponents() {
        setPreferredSize(new Dimension(icon.getIconWidth(),
                icon.getIconHeight()));
    }
}
