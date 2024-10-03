package rpg;

import rpg.entities.Player;
import rpg.entities.enemy.Enemy;
import rpg.entities.enemy.goblins.RookieGoblin;
import rpg.entities.enemy.slimes.BasicSlime;

import java.util.Random;


public class Game {

    private Player player;
    private Enemy enemy;

    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }

    public Game() {
        this.player = new Player("Odin");
        int enemyType = new Random().nextInt(3) + 1;
        this.enemy = switch (enemyType) {
            case 1 -> new RookieGoblin();
            case 2 -> new BasicSlime("Basic Slime");
            default -> new Enemy("Otro enemigo");
        };
    }

    public void startGame() {
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
}