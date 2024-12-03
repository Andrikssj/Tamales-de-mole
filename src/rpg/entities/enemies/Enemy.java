package rpg.entities.enemies;

import rpg.entities.GameCharacter;
import rpg.enums.EnemyType;

import javax.swing.*;

/**
 * The type Enemy.
 */
public abstract class Enemy extends GameCharacter {

    /**
     * The Type.
     */
    protected EnemyType type;

    /**
     * Instantiates a new Enemy.
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
     * Gets type.
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