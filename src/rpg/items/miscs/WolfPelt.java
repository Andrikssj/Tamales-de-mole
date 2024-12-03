package rpg.items.miscs;

import rpg.enums.ItemType;
import rpg.utils.cache.ImageCache;

import java.io.Serializable;

/**
 * The type Wolf pelt.
 */
public class WolfPelt extends Misc implements Serializable {

    @Override
    protected void initItem() {
        this.type = ItemType.MISC;
        this.name = "Piel de lobo";
        this.description = "Una piel de lobo. Se puede vender por un buen precio.";
        this.price = 50;
        this.consumable = false;
        this.stackable = true;
        this.quantity = 1;
        ImageCache.addImage("wolfPelt", "icons/items_misc.png");
        this.iconName = "wolfPelt";
    }

    @Override
    public void use() {
        System.out.println("No puedes usar una piel de lobo.");
    }
}
