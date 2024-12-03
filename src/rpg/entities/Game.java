package rpg.entities;

import rpg.entities.enemies.Enemy;
import rpg.entities.enemies.bears.WoodBear;
import rpg.entities.enemies.goblins.RookieGoblin;
import rpg.entities.enemies.slimes.BasicSlime;
import rpg.entities.enemies.wolfs.StrayWolf;
import rpg.utils.Randomize;

/**
 * The type Game.
 */
public class Game {

    /**
     * The Player.
     */
    private Player player;
    /**
     * The Enemy.
     */
    private Enemy enemy;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }

    /**
     * Instantiates a new Game.
     */
    public Game() {
        this.player = new Player("Player");
        int enemyType = Randomize.getRandomInt(1, 4);
        this.enemy = switch (enemyType) {
            case 1 -> new RookieGoblin();
            case 2 -> new WoodBear();
            case 3 -> new StrayWolf();
            default -> new BasicSlime();
        };
    }

    /**
     * Start game.
     */
    public void startGame() {

        while (player.isAlive() && enemy.isAlive()) {
            player.attack(enemy);
            if (enemy.isAlive()) {
                enemy.attack(player);
            }
        }
        if (player.isAlive()) {

            enemy.getLoot();
            System.out.println(player.getName() + " wins!");
        } else {
            System.out.println(enemy.getName() + " wins!");
        }
    }
}
