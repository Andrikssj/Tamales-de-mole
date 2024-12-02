package rpg.items.armors.helmet;

import rpg.items.armors.Armor;

/**
 * Clase casco que herda de armadura
 */
public class casco extends Armor {
    public casco(){
        super("Casco ",  5);
    }

    public String toString(){
        return getNombre() + "Cnn defensa de " + getDefensa();
    }

    private String getNombre() {
        return null;
    }
}
