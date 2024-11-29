package rpg.items;

import rpg.items.armors.Armadura;

/**
 * Clase escudo que herda de armadura
 */
public class escudo extends Armadura {
    public escudo(){
        super("Escudo ",  15);
    }

    public String toString(){
        return getNombre() + "Con defensa de "+ getDefensa();
    }
}
