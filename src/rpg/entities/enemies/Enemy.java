package rpg.entities.enemies;

import rpg.entities.GameCharacter;
import rpg.enums.EnemyType;

import javax.swing.*;

/**
 * La clase Enemy.
 */
public abstract class Enemy extends GameCharacter {

    /**
     * El tipo de enemigo.
     */
    protected EnemyType type;

    /**
     * Instancia un nuevo enemigo.
     *
     * @param name the name
     */
    public Enemy(String name) {
        super(name);
    }

    /**
     * Función que permite recuperar el botín del enemigo.
     */
    public abstract void getLoot();

    public abstract String attack(GameCharacter enemy);

    /**
     * Obtiene el tipo.
     *
     * @return the type
     */
    public EnemyType getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract ImageIcon getSprite();
}