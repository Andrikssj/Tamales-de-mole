package rpg.entities;

import rpg.entities.enemies.Enemy;
import rpg.entities.enemies.bears.WoodBear;
import rpg.entities.enemies.goblins.RookieGoblin;
import rpg.entities.enemies.slimes.BasicSlime;
import rpg.entities.enemies.wolfs.StrayWolf;
import rpg.utils.Randomize;

/**
 * La clase Game.
 */
public class Game {

    /**
     * El jugador.
     */
    private Player player;
    /**
     * El enemigo.
     */
    private Enemy enemy;

    /**
     * El punto de entrada de la aplicación.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }

    /**
     * Instancia un nuevo juego.
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
     * Comienza el juego.
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
