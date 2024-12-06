package rpg.items.armors;

import rpg.enums.ItemType;
import rpg.items.Equipment;

/**
 * La clase Armor.
 */
public abstract class Armor extends Equipment {

    public Armor() {
        this.type = ItemType.ARMOR;
    }
}
