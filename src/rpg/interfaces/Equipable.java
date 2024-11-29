package rpg.interfaces;

import rpg.entities.Player;

/**
 * The interface Equipable.
 */
public interface Equipable {

    /**
     * Equip.
     *
     * @param player the player
     */
    public void equip(Player player);

    /**
     * Unequip.
     *
     * @param player the player
     */
    public void unequip(Player player);
}
