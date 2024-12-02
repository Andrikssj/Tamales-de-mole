package rpg.items.misc;

import rpg.items.armors.Armor;

/**
 * Clase blindaje que herda de armadura
 */
public class blindaje extends Armor {
    public blindaje(){
        super("Blindaje ",  9);
    }

    public String toString(){
        return getNombre() + "Con defensa de " + getDefensa();
    }
}

