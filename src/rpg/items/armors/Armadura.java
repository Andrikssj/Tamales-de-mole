package rpg.items.armors;
import rpg.enums.ItemType;
import rpg.items.Item;

/**
 * Clase armadura  que hereda de la clase Item
 */
public class Armadura extends Item {
    private int defensa;

    /**
     * Constructor de la clase armadura
     */
    public Armadura(String nombre, int defensa){
        super(nombre, ItemType.ARMOR);
        this.defensa = defensa;
    }
    public int getDefensa(){
        return defensa;
    }

    public String toString(){
        return getNombre() + "Con defensa de " + defensa;
    }
}

