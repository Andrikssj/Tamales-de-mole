package rpg;

import rpg.Inventory.Inventory;
import rpg.Inventory.items.*;
import rpg.entities.Player;
import rpg.entities.enemy.Enemy;
import rpg.entities.enemy.goblins.RookieGoblin;
import rpg.entities.enemy.slimes.BasicSlime;
import rpg.gui.GUIForm;


import java.util.Random;


public class Game {

    private Player player;
    private Enemy enemy;
    private Inventory inventory;

    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
        new GUIForm(game);
    }

    public Game() {
        this.player = new Player("Odin");
        int enemyType = new Random().nextInt(3) + 1;
        this.enemy = switch (enemyType) {
            case 1 -> new RookieGoblin();
            case 2 -> new BasicSlime("Basic Slime");
            default -> new Enemy("Otro enemigo");
        };
        this.inventory = new Inventory();
    }

    public void startGame() {
        manageGame();
        while (player.isAlive() && enemy.isAlive()) {
            player.attack(enemy);
            if (enemy.isAlive()) {
                enemy.attack(player);
            }
        }

        if (player.isAlive()) {
            System.out.println(player.getName() + " GANO el mas perro");
        } else {
            System.out.println(enemy.getName() + " Ganooooo ");
        }
    }

    private void manageGame() {
    }

    public void saveGame() {
        // Implementar lógica para guardar el estado del juego
        System.out.println("Juego guardado.");
    }

    public void exitGame() {
        // Lógica para salir del juego
        System.exit(0);
    }

    public void openInventory() {
        // Lógica para mostrar el inventario
        System.out.println("Inventario abierto.");
    }

    public void showStats() {
        // Lógica para mostrar las estadísticas del jugador
        System.out.println("Mostrando estadísticas del jugador.");
    }

    }




