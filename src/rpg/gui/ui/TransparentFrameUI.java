package rpg.gui.ui;

import rpg.gui.internalFrames.InternalStatusBar;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.awt.*;

public class TransparentFrameUI extends BasicInternalFrameUI {

    private Dimension dimension;

    public TransparentFrameUI(JInternalFrame frame, Dimension dimension) {
        super(frame);
        this.dimension = dimension;
    }

    @Override
    public Dimension getPreferredSize(JComponent x) {
        return dimension;
    }

    @Override
    public Dimension getMinimumSize(JComponent x) {
        return getPreferredSize(x);
    }

    @Override
    public Dimension getMaximumSize(JComponent x) {
        return getPreferredSize(x);
    }

    @Override
    protected void installDefaults() {
        super.installDefaults();
        frame.setOpaque(false);
        frame.setBorder(null);
    }

    @Override
    protected JComponent createNorthPane(JInternalFrame w) {
        InternalStatusBar internalStatusBar =
                new InternalStatusBar("Status",
                        dimension, w);
        internalStatusBar.setVisible(true);
        return internalStatusBar;
    }
}
