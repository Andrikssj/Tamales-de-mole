package rpg.items;

import rpg.items.armors.Armadura;

/**
 * Clase casco que herda de armadura
 */
public class casco extends Armadura {
    public casco(){
        super("Casco ",  5);
    }

    public String toString(){
        return getNombre() + "Cnn defensa de " + getDefensa();
    }
}
