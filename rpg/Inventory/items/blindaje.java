package rpg.Inventory.items;

/**
 * Clase blindaje que herda de armadura
 */
public class blindaje extends Armadura{
    public blindaje(){
        super("Blindaje ",  9);
    }

    public String toString(){
        return getNombre() + "Con defensa de " + getDefensa();
    }
}

