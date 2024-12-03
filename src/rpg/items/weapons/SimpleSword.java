package rpg.items.weapons;

import rpg.enums.Stats;
import rpg.utils.cache.ImageCache;

import java.util.HashMap;

public class SimpleSword extends Weapon{

        @Override
        protected void initItem() {
            this.name = "Simple Sword";
            this.description = "A simple sword. It's not very sharp, but it's better than nothing.";
            this.price = 10;
            this.stats= new HashMap<>();
            this.stats.put(Stats.ATTACK, 1);
            ImageCache.addImage("simpleSword", "items/sword_01.png");
            this.iconName = "simpleSword";
        }

        /**
        * Attack.
        */
        public void attack() {
            System.out.println("The simple sword attacks and breaks.");
        }
}
