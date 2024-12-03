package rpg.items.weapons;

import rpg.enums.WearType;
import rpg.items.Equipment;

public abstract class Weapon extends Equipment {

    public Weapon() {
        this.wearType = WearType.WEAPON;
    }
}
