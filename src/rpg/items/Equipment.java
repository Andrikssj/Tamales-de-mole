package rpg.items;

import rpg.entities.Player;
import rpg.enums.Stats;
import rpg.enums.WearType;
import rpg.interfaces.Equipable;

import java.io.Serializable;
import java.util.HashMap;

/**
 * The type Equipment.
 */
public abstract class Equipment extends Item implements Equipable, Serializable {

    /**
     * The Stats.
     */
    protected HashMap<Stats, Integer> stats;

    protected WearType wearType;

    @Override
    public void equip(Player player) {

    }

    @Override
    public void unequip(Player player) {

    }

    public HashMap<Stats, Integer> getStats() {
        return stats;
    }
}
