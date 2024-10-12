package rpg.Inventory.items;

/**
 * Clase escudo que herda de armadura
 */
public class escudo extends Armadura{
    public escudo(){
        super("Escudo ",  15);
    }

    public String toString(){
        return getNombre() + "Con defensa de "+ getDefensa();
    }
}
