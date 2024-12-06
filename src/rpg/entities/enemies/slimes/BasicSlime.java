package rpg.entities.enemies.slimes;

import rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.EnemyType;
import rpg.enums.Stats;
import rpg.exceptions.EnemyDeathException;
import rpg.utils.Randomize;
import rpg.utils.cache.ImageCache;

import javax.swing.*;

/**
 * La clase BasicSlime.
 */
public class BasicSlime extends Enemy {

    /**
     * Instancia un nuevo BasicSlime.
     */
    public BasicSlime() {
        super("Basic Slime");
        ImageCache.addImage("basic_slime", "enemies/Slime Fireiii.png");
    }

    @Override
    public void getLoot() {
        System.out.println("The Basic Slime drops a bottle of slime.");
    }

    /**
     * Función sobrescrita que inicializa las características del Slime.
     */
    @Override
    protected void initCharacter() {
        this.type = EnemyType.BASIC;
        this.stats.put(Stats.MAX_HP, 20);
        this.stats.put(Stats.HP, 20);
        this.stats.put(Stats.ATTACK, 4);
        this.stats.put(Stats.DEFENSE, 1);
        this.stats.put(Stats.EXPERIENCE, 10);
        this.stats.put(Stats.GOLD, 5);
    }

    /**
     * Función de ataque de salpicadura. Este ataque no hace daño.
     *
     * @param enemy el enemigo a atacar. Que en este caso no recibe daño y es el jugador.
     */
    protected String splash(GameCharacter enemy) {
        // Recuperamos el nombre del enemigo.
        String enemyName = enemy.getName();
        // Calculamos la vida del enemigo después del ataque. El daño es 0 en este caso.
        int newHP = enemy.getStats().get(Stats.HP);
        return String.format("""
                ¡%s salpica a %s con lodo!
                %s no recibe daño.
                """, this.name, enemyName, enemyName, newHP);
    }

    /**
     * Función de ataque de lanzamiento de lodo. Este ataque hace un 80% del daño de ataque.
     *
     * @param enemy el enemigo a atacar.
     */
    protected String trhowSlime(GameCharacter enemy) throws EnemyDeathException {

        String enemyName = enemy.getName();
        int damage = this.stats.get(Stats.ATTACK) * 8 / 10;
        int newHP = reduceHP(enemy, this.stats.get(Stats.ATTACK) * 8 / 10);
        return String.format("""
                ¡%s lanza baba a %s y le hace %d de daño!
                %s tiene %d HP restantes.
                """, this.name, enemyName, damage, enemyName, newHP);
    }

    /**
     * Función de ataque del enemigo. El enemigo tiene un 50% de probabilidad de hacer un ataque de salpicadura
     * y un 50% de probabilidad de hacer un ataque de lanzamiento de lodo.
     *
     * @param enemy el enemigo a atacar.
     */
    @Override
    public String attack(GameCharacter enemy) {

        String message = "";
        if (Randomize.getRandomBoolean()) splash(enemy);
        else {
            try {
                message = trhowSlime(enemy);
            } catch (EnemyDeathException e) {
                enemy.getStats().put(Stats.HP, 0);
                message += String.format("""
                                ¡%s lanza baba a %s y le hace %d de daño!
                                %s tiene %d HP restantes.
                                %s ha muerto.
                                """, this.name, enemy.getName(),
                        this.stats.get(Stats.ATTACK) * 8 / 10,
                        enemy.getName(), enemy.getName());
            }
        }
        return message;
    }

    @Override
    public ImageIcon getSprite() {
        return ImageCache.getImageIcon("basic_slime");
    }
}
