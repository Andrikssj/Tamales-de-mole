package rpg.gui.internalFrames;

import rpg.gui.UIConstants;
import rpg.gui.panels.InternPanel;
import rpg.gui.ui.TransparentFrameUI;
import rpg.gui.windows.MainWindow;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class InventoryFrame extends JInternalFrame {

    private JPanel mainPanel;
    private MainWindow window;
    private Dimension dimension;

    public InventoryFrame(MainWindow window) {

        this.window = window;
        setContentPane(mainPanel);
        dimension = new Dimension(UIConstants.STATUS_FRAME_WIDTH, 600);
        setUI(new TransparentFrameUI(this, dimension));
        setSize(getPreferredSize());
    }

    private void createUIComponents() {
        int displayHeight = 525;
        mainPanel = new InternPanel(UIConstants.STATUS_FRAME_WIDTH, displayHeight);
        mainPanel.setBorder(new EmptyBorder(10, 5, 10, 5));
    }
}
