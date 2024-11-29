package rpg.gui.internalFrames;

import rpg.enums.Stats;
import rpg.gui.UIConstants;
import rpg.gui.labels.IconLabel;
import rpg.gui.labels.NameLabel;
import rpg.gui.panels.InternPanel;
import rpg.gui.panels.ItemDisplayPanel;
import rpg.gui.ui.TransparentFrameUI;
import rpg.gui.windows.MainWindow;
import rpg.utils.cache.ImageCache;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class StatusFrame extends JInternalFrame {

    private JPanel mainPanel;
    private JLabel attackIcon;
    private JLabel defenseIcon;
    private JLabel headIcon;
    private JLabel chestIcon;
    private JLabel legsIcon;
    private JLabel feetIcon;
    private JLabel handIcon;
    private JLabel weaponIcon;
    private JPanel headItemDisplay;
    private JPanel chestItemDisplay;
    private JPanel legsItemDisplay;
    private JPanel feetItemDisplay;
    private JPanel handItemDisplay;
    private JPanel weaponItemDisplay;
    private JLabel attackDisplay;
    private JLabel defenseDisplay;
    private InternalStatusBar internalStatusBar;
    private Dimension dimension;
    private MainWindow window;

    public StatusFrame(MainWindow window) {

        this.window = window;
        setContentPane(mainPanel);
        dimension = new Dimension(UIConstants.STATUS_FRAME_WIDTH, UIConstants.STATUS_FRAME_HEIGHT);
        setUI(new TransparentFrameUI(this, dimension));
        setSize(getPreferredSize());
    }

    private void createUIComponents() {
        int displayHeight = UIConstants.STATUS_FRAME_HEIGHT -
                UIConstants.INTERNAL_FRAME_HEADER_HEIGHT;
        mainPanel = new InternPanel(UIConstants.STATUS_FRAME_WIDTH, displayHeight);
        mainPanel.setBorder(new EmptyBorder(2, 10, 18, 10));
        ImageCache.addImage("attackIcon", "icons/attackIcon.png");
        ImageCache.addImage("defenseIcon", "icons/defenseIcon.png");
        ImageCache.addImage("headIcon", "icons/headArmorIcon.png");
        ImageCache.addImage("chestIcon", "icons/chestArmorIcon.png");
        ImageCache.addImage("legsIcon", "icons/legArmorIcon.png");
        ImageCache.addImage("feetIcon", "icons/feetArmorIcon.png");
        ImageCache.addImage("handIcon", "icons/handArmorIcon.png");
        ImageCache.addImage("weaponIcon", "icons/weaponIcon.png");
        attackIcon = new IconLabel(ImageCache.getImageIcon("attackIcon"));
        attackDisplay = new NameLabel(window.getPlayer().getStats().get(Stats.ATTACK).toString());
        defenseIcon = new IconLabel(ImageCache.getImageIcon("defenseIcon"));
        defenseDisplay = new NameLabel(window.getPlayer().getStats().get(Stats.DEFENSE).toString());
        headIcon = new IconLabel(ImageCache.getImageIcon("headIcon"));
        headItemDisplay = new ItemDisplayPanel(null);
        chestIcon = new IconLabel(ImageCache.getImageIcon("chestIcon"));
        chestItemDisplay = new ItemDisplayPanel(null);
        legsIcon = new IconLabel(ImageCache.getImageIcon("legsIcon"));
        legsItemDisplay = new ItemDisplayPanel(null);
        feetIcon = new IconLabel(ImageCache.getImageIcon("feetIcon"));
        feetItemDisplay = new ItemDisplayPanel(null);
        handIcon = new IconLabel(ImageCache.getImageIcon("handIcon"));
        handItemDisplay = new ItemDisplayPanel(null);
        weaponIcon = new IconLabel(ImageCache.getImageIcon("weaponIcon"));
        weaponItemDisplay = new ItemDisplayPanel(null);
    }
}
