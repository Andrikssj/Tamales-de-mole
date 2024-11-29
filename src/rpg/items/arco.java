package rpg.items;

import rpg.items.weapons.Armas;

/**
 * Clase arco, que hereda de armas
 */
public class arco extends Armas {
    public arco(){
        super("Arco ", " Reforzado", " 95");
    }

    public String toString(){
        return getNombre() + " Arma a distancia con daño de "+ getDaño();
    }
}
