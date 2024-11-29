package rpg.gui.ui;

import javax.swing.*;
import javax.swing.plaf.basic.BasicLabelUI;
import java.awt.*;

public class GameLabelUI extends BasicLabelUI {

    protected final Dimension size;
    protected final ImageIcon icon;
    protected Rectangle paintIconR = new Rectangle();
    protected Rectangle paintTextR = new Rectangle();

    public GameLabelUI(Dimension size, ImageIcon icon) {

        this.size = size;
        this.icon = icon;
    }

    @Override
    protected void installDefaults(JLabel c) {

        c.setOpaque(false);
        c.setBorder(null);
    }

    @Override
    public void paint(Graphics g, JComponent c) {

        JLabel label = (JLabel) c;
        FontMetrics fm = g.getFontMetrics();
        String clippedText = layout(label, fm, c.getWidth(), c.getHeight());
        int textX = 40 + ((paintIconR.width - 40 - (fm.stringWidth(label.getText()))) / 2);
        int textY = paintTextR.y + fm.getAscent();
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.drawImage(icon.getImage(), 0, 0, size.width, size.height, c);
        super.paintEnabledText(label, g, clippedText, textX, textY);
    }

    protected String layout(JLabel label, FontMetrics fm,
                            int width, int height) {
        Insets insets = label.getInsets(null);
        String text = label.getText();
        Icon icon = (label.isEnabled()) ? label.getIcon() :
                label.getDisabledIcon();
        Rectangle paintViewR = new Rectangle();
        paintViewR.x = insets.left;
        paintViewR.y = insets.top;
        paintViewR.width = width - (insets.left + insets.right);
        paintViewR.height = height - (insets.top + insets.bottom);
        paintIconR.x = paintIconR.y = paintIconR.width = paintIconR.height = 0;
        paintTextR.x = paintTextR.y = paintTextR.width = paintTextR.height = 0;
        return layoutCL(label, fm, text, icon, paintViewR, paintIconR,
                paintTextR);
    }
}