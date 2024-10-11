package rpg.Inventory.items;
import rpg.enums.ItemType;

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
}

/**
 * Clase armaduradecuero que herda de armadura
 */
class armaduradecuero extends Armadura{
    public armaduradecuero(){
        super("Armadura de cuero", 5);
    }
}

/**
 * Clase armaduradediamante que herda de armadura
 */
class armaduradediamante extends Armadura{
    public armaduradediamante(){
        super("Armadura de diamante", 10);
    }
}

/**
 * Clase escudo que herda de armadura
 */
class escudo extends Armadura{
    public escudo(){
        super("Escudo", 15);
    }
}

/**
 * Clase blindaje que herda de armadura
 */
class blindaje extends Armadura{
    public blindaje(){
        super("Blindaje", 9);
    }
}

/**
 * Clase casco que herda de armadura
 */
class casco extends Armadura{
    public casco(){
        super("Casco", 5);
    }
}

