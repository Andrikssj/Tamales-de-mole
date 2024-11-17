package rpg.Inventory.items;

/**
 * Clase lanza, que hereda de armas
 */
public class lanza extends Armas {
    public lanza() {
        super("Lanza ", "Arma cuerpo a cuerpo ", "55 ");
    }

    public String toString(){
        return "Lanza con daño de " + getDaño();
    }
}
