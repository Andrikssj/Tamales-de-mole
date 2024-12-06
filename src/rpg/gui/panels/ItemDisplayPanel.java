package rpg.gui.panels;

import rpg.enums.Stats;
import rpg.gui.UIConstants;
import rpg.items.Equipment;
import rpg.items.Item;
import rpg.utils.cache.ImageCache;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ItemDisplayPanel extends BackgroundPanel {
    private JLabel itemIcon;
    private JLabel itemName;
    private JPanel mainPanel;
    private JLabel itemDescription;
    private Item item;

    public ItemDisplayPanel(Item item) {
        super();
        this.item = item;
        mainPanel.setSize(new Dimension(500, 70));
        mainPanel.setPreferredSize(mainPanel.getSize());
        add(mainPanel);
    }

    @Override
    protected void init() {
        //Buscamos la imagen por ahora directamente en los directorios
        backgroundImage = new ImageIcon(ImageCache.addImage("itemDisplayPanel",
                "labels/equipHolder.png"));
        setDimension(new Dimension(500, 85));
        setBorder(new EmptyBorder(0, 0, 0, 0));
        getInsets().set(0, 0, 0, 0);
    }

    private void createUIComponents() {

        if (item != null) {
            itemIcon = new JLabel(item.getIcon());
            Equipment equipment = (Equipment) item;
            itemName = new JLabel(String.format("%s ATQ(%d)", equipment.getName(),
                    equipment.getStats().get(Stats.ATTACK)));
            itemDescription = new JLabel(item.getDescription());
            itemName.setFont(UIConstants.FONT.deriveFont(16.5f));
            itemDescription.setFont(UIConstants.FONT.deriveFont(16.5f));
        } else {
            itemIcon = new JLabel();
            itemName = new JLabel();
            itemDescription = new JLabel();
        }
    }
}
