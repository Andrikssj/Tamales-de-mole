package rpg.items.armors.helmet;

import rpg.enums.Stats;
import rpg.enums.WearType;

/**
 * La clase IronHelmet.
 */
public class IronHelmet extends WoodHelmet {

    /**
     * Instancia un nuevo casco de hierro.
     */
    public IronHelmet() {

        super();
        this.wearType = WearType.HEAD;
        this.name = "Iron Helmet";
        this.description = "Un casco de hierro. No es muy resistente, pero tiene una dureza superior a la madera.";
        this.stats.put(Stats.DEFENSE, 5);
    }

    @Override
    public void protect() {
        System.out.println("El casco de hierro te protege de un golpe y resiste.");
    }
}
