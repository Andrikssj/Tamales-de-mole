package rpg.inventory;

import rpg.entities.Player;
import rpg.items.armors.helmet.IronHelmet;
import rpg.items.armors.helmet.WoodHelmet;
import rpg.items.miscs.WolfPelt;

import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 * The type Inventory test.
 */
public class InventoryTest {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        ObjectOutputStream oos = null;
        UIManager.put("OptionPane.messageFont",
                new Font("Arial", Font.BOLD, 20));
        Player player = new Player("Player 1");
        player.addItemToInventory(new IronHelmet());
        player.addItemToInventory(new WoodHelmet());
        player.addItemToInventory(new WolfPelt());
        player.showInventory();
        player.addItemToInventory(new WolfPelt());
        player.showInventory();
        player.addItemToInventory(new WoodHelmet());
        player.showInventory();
        player.sellItem(new IronHelmet());
        player.showInventory();
        player.sellItem(new WoodHelmet());
        player.showInventory();
        player.sellItem(new WolfPelt());
        player.showInventory();
        try {
            oos = new ObjectOutputStream(
                    new FileOutputStream("files/game.dat"));
            oos.writeObject(player);
            oos.close();
        } catch (Exception e) {

        }
        ObjectInputStream ois = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("files/game.dat");
            ois = new ObjectInputStream(fis);
            player.showInventory();
            ois.close();
            fis.close();
            JOptionPane.showMessageDialog(null,
                    "Game loaded successfully");
            JOptionPane.showMessageDialog(null,
                    "Player name: " + player.getName());
            player.showInventory();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,
                    "File not found");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
