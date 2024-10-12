package rpg.Inventory.items;

/**
 * Clase armaduradediamante que herda de armadura
 */
public class armaduradediamante extends Armadura{
    public armaduradediamante(){
        super("Armadura de diamante ",  10);
    }

    public String toString(){
        return getNombre() + "Con defensa de " + getDefensa();
    }
}
