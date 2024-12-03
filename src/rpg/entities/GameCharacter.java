package rpg.entities;

import rpg.enums.Stats;
import rpg.exceptions.EnemyDeathException;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Clase que representa a un personaje del juego.
 */
public abstract class GameCharacter implements Serializable {
    /**
     * Nombre del personaje.
     */
    protected String name;
    /**
     * Características del personaje.
     */
    protected HashMap<Stats, Integer> stats;

    /**
     * Instantiates a new Game character.
     *
     * @param name the name
     */
    public GameCharacter(String name) {

        this.name = name;
        this.stats = new HashMap<>();
        initCharacter();
    }

    /**
     * Función que inicializa las características del personaje.
     * Implementada por las clases hijas.
     * Deberá de incluir el nombre del personaje y las características mínimas para su funcionamiento.
     */
    protected abstract void initCharacter();

    /**
     * Is alive boolean.
     *
     * @return the boolean
     */
    public boolean isAlive() {
        return stats.get(Stats.HP) > 0;
    }

    /**
     * Función que simula un ataque del personaje al enemigo e imprime un mensaje
     * en consola con el resultado del ataque. Si el daño es mayor a 0, se resta
     * la cantidad de daño a la vida del enemigo. Si el daño es menor o igual a 0,
     * se imprime un mensaje indicando que no se hizo daño.
     *
     * @param enemy el enemigo a atacar.
     */
    public String attack(GameCharacter enemy) {

        String message = "";
        String enemyName = enemy.getName();
        int damage = this.stats.get(Stats.ATTACK) - enemy.getStats().get(Stats.DEFENSE);
        int newHP = enemy.getStats().get(Stats.HP);
        if (damage > 0) {

            try {
                newHP = reduceHP(enemy, damage);
                message += String.format("""
                        ¡%s ataca a %s por %d de daño!
                        %s tiene %d HP restantes.
                        """, this.name, enemyName, damage, enemyName, newHP);
            } catch (EnemyDeathException e) {
                enemy.getStats().put(Stats.HP, 0);
                message += String.format("""
                        %s attacks %s for %d damage!
                        %s has 0 HP left.
                        %s has died.
                        """, this.name, enemyName, damage, enemyName, enemyName);
            }
        } else {
            message += String.format("""
                    ¡%s ataca a %s pero no hace daño!
                    %s tiene %d HP restantes.
                    """, this.name, enemyName, enemyName, newHP);
        }
        return message;
    }

    /**
     * Función que reduce la vida del enemigo y actualiza sus características.
     *
     * @param enemy  el enemigo a atacar.
     * @param damage el daño a realizar.
     * @return la nueva vida del enemigo.
     */
    protected final int reduceHP(GameCharacter enemy, int damage) throws EnemyDeathException {

        int newHP = enemy.getStats().get(Stats.HP) - damage;
        enemy.getStats().put(Stats.HP, newHP);
        if (!enemy.isAlive())
            throw new EnemyDeathException();
        return newHP;
    }

    /**
     * Devuelve el nombre del personaje con un epíteto.
     *
     * @return el nombre del personaje con el epíteto.
     */
    public final String getName() {

        return String.format("%s", name);
    }

    /**
     * Gets stats.
     *
     * @return the stats
     */
    public final HashMap<Stats, Integer> getStats() {

        return stats;
    }
}
