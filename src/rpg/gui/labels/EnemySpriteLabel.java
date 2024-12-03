package rpg.gui.labels;

import rpg.entities.enemies.Enemy;
import rpg.gui.ui.EnemyLabelUI;

import javax.swing.*;
import java.awt.*;

public class EnemySpriteLabel extends JLabel {

    ImageIcon icon;
    Enemy enemy;

    public EnemySpriteLabel(Enemy enemy) {

        this.enemy = enemy;
        initComponents();
        setUI(new EnemyLabelUI(icon));
    }

    public void initComponents() {

        icon = enemy.getSprite();
        setPreferredSize(getMinDimension());
        setSize(getMinDimension());
        setIcon(icon);
    }

    private Dimension getMinDimension() {

        if (icon.getIconWidth() > 350 || icon.getIconHeight() > 350) {
            icon = new ImageIcon(icon.getImage().getScaledInstance(450, 250, Image.SCALE_SMOOTH));
        }
        return new Dimension(icon.getIconWidth(), icon.getIconHeight());
    }

    public void updateSprite() {

        icon = enemy.getSprite();
        setUI(new EnemyLabelUI(icon));
        setPreferredSize(getMinDimension());
        setSize(getMinDimension());
        setIcon(icon);
        revalidate();
        repaint();
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
        updateSprite();
    }
}
