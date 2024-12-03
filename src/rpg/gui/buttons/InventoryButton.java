package rpg.gui.buttons;

import rpg.gui.windows.MainWindow;
import rpg.utils.cache.ImageCache;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class InventoryButton extends BaseButton {

    private MainWindow window;

    public InventoryButton(MainWindow window) {
        super("Inventario");
        this.window = window;
        addActionListener(e -> {
            window.getInventoryFrame().setVisible(true);
        });
    }

    @Override
    protected void initIcons() {

        BufferedImage inventoryIdle = ImageCache.addImage(
                "inventoryIdle", "icons/inventoryIdle.png");
        BufferedImage inventoryHover = ImageCache.addImage(
                "inventoryHover", "icons/inventoryHover.png");
        setIcon(new ImageIcon(inventoryIdle));
        setRolloverIcon(new ImageIcon(inventoryHover));
    }
}
