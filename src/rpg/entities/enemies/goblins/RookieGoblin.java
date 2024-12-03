package rpg.entities.enemies.goblins;

import rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.EnemyType;
import rpg.enums.Stats;
import rpg.exceptions.EnemyDeathException;
import rpg.utils.Randomize;
import rpg.utils.cache.ImageCache;

import javax.swing.*;

/**
 * Clase que representa a un Goblin novato.
 */
public class RookieGoblin extends Enemy {

    /**
     * Constructor de la clase.
     */
    public RookieGoblin() {

        super("Rookie Goblin");
        ImageCache.addImage("rookie_goblin", "enemies/goblins/rookie_goblin.png");
    }

    /**
     * Función que permite recuperar el botín del enemigo.
     */
    @Override
    public void getLoot() {
        System.out.println("The Rookie Goblin drops a small bag of coins.");
    }

    /**
     * Función sobrescrita que inicializa las características del Goblin.
     */
    @Override
    protected void initCharacter() {
        this.type = EnemyType.BASIC;
        this.stats.put(Stats.MAX_HP, 35);
        this.stats.put(Stats.HP, 35);
        this.stats.put(Stats.ATTACK, 6);
        this.stats.put(Stats.DEFENSE, 2);
        this.stats.put(Stats.EXPERIENCE, 20);
        this.stats.put(Stats.GOLD, 10);
    }

    /**
     * Función que permite al Goblin novato atacar al enemigo. El Goblin tiene dos ataques
     * especiales: lanzar una roca y morder al enemigo. Si no se elige ninguno de los dos ataques
     * especiales, el Goblin atacará al enemigo de forma normal.
     * Teniendo en cuenta que el Goblin novato tiene un 50% de probabilidad de atacar normalmente,
     * un 25% de probabilidad de morder y un 25% de probabilidad de lanzar una roca.
     *
     * @param enemy el enemigo a atacar.
     */
    @Override
    public String attack(GameCharacter enemy) {
        String message;
        // Se elige un número aleatorio entre 1 y 100
        int random = Randomize.getRandomInt(1, 100);
        // 50% de probabilidad de atacar normalmente
        // 25% de probabilidad de morder
        // 25% de probabilidad de lanzar una roca
        int attack = (random <= 50) ? 3 : (random <= 75) ? 2 : 1;
        // Se elige el ataque a realizar
        switch (attack) {
            case 1:
                try {
                    message = throwRock(enemy);
                } catch (EnemyDeathException e) {
                    enemy.getStats().put(Stats.HP, 0);
                    message = """
                            El Goblin novato lanza una roca y te hace 2 de daño.
                            ¡Has muerto!
                            """;
                }
                break;
            case 2:
                try {
                    message = savageBite(enemy);
                } catch (EnemyDeathException e) {
                    enemy.getStats().put(Stats.HP, 0);
                    message = """
                            El Goblin novato muerde salvajemente y te hace 3 de daño.
                            ¡Has muerto!
                            """;
                }
                break;
            default:
                message = ((GameCharacter) this).attack(enemy);
                break;
        }
        return message;
    }

    /**
     * Función que permite al Goblin novato lanzar una roca al enemigo.
     * La roca hace 2 puntos de daño.
     *
     * @param enemy el enemigo a atacar.
     */
    protected String throwRock(GameCharacter enemy) throws EnemyDeathException {
        int damage = 2;
        int newHP = reduceHP(enemy, damage);
        String enemyName = enemy.getName();
        String message = String.format("""
                ¡%s lanza una roca a %s por %d de daño!
                %s tiene %d HP restantes.
                """, this.name, enemyName, damage, enemyName, newHP);
        return message;
    }

    /**
     * Función que permite al Goblin novato morder al enemigo.
     * La mordida hace 3 puntos de daño.
     *
     * @param enemy el enemigo a atacar.
     */
    protected String savageBite(GameCharacter enemy) throws EnemyDeathException {
        int damage = 3;
        int newHP = reduceHP(enemy, damage);
        String enemyName = enemy.getName();
        String message = String.format("""
                ¡%s muerde salvajemente a %s por %d de daño!
                %s tiene %d HP restantes.
                """, this.name, enemyName, damage, enemyName, newHP);
        return message;
    }

    @Override
    public ImageIcon getSprite() {

        return ImageCache.getImageIcon("rookie_goblin");
    }
}
