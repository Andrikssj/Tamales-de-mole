package rpg.items.armors.helmet;

import rpg.enums.Stats;
import rpg.enums.WearType;
import rpg.items.armors.Armor;
import rpg.utils.cache.ImageCache;

import java.util.HashMap;

/**
 * The type Wood helmet.
 */
public class WoodHelmet extends Armor {

    @Override
    protected void initItem() {
        wearType = WearType.HEAD;
        name = "Casco de madera";
        description = "Un casco de madera. No es muy resistente, pero es mejor que nada.";
        price = 10;
        stats = new HashMap<>();
        stats.put(Stats.DEFENSE, 2);
        ImageCache.addImage("woodHelmet", "icons/items_helmet.png");
        iconName = "woodHelmet";
    }

    /**
     * Protect.
     */
    public void protect() {
        System.out.println("El casco de madera te protege de un golpe y se rompe.");
    }
}
