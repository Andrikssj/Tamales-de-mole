package rpg.utils;

import rpg.entities.Player;

import java.io.*;

public class FileManager {

    private static final String BASE_PATH = "files/";

    public static Player loadGame(int slot) throws FileNotFoundException {

        Player player;
        String fileName = BASE_PATH + "player_" + slot + ".dat";
        try {
            player = (Player) new ObjectInputStream(
                    new FileInputStream(fileName)).readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new FileNotFoundException("No se encontró el archivo");
        }
        return player;
    }

    public static void saveGame(Player player, int slot) {

        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(
                    new FileOutputStream(BASE_PATH + "player_" + slot + ".dat"));
            oos.writeObject(player);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
