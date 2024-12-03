package rpg.entities.enemies.goblins;

import rpg.enums.EnemyType;
import rpg.utils.cache.ImageCache;

import javax.swing.*;

public class GoblinGeneral extends RookieGoblin {

    public GoblinGeneral() {

        super();
        setName("Goblin General");
        type = EnemyType.BOSS;
        ImageCache.addImage("goblin_general", "enemies/Zodiac Virgo.png");
    }

    @Override
    public ImageIcon getSprite() {
        return new ImageIcon(ImageCache.getImage("goblin_general"));
    }
}
