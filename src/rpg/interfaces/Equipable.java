package rpg.interfaces;

import rpg.entities.Player;

/**
 * La interfaz Equipable.
 */
public interface Equipable {

    /**
     * Equipar.
     *
     * @param player the player
     */
    public void equip(Player player);

    /**
     * Desequipar.
     *
     * @param player the player
     */
    public void unequip(Player player);
}
