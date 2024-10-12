package rpg.Inventory.items;

/**
 * Clase hacha, que hereda de armas
 */
public class hacha extends Armas{
    public hacha(){
        super("Hacha ", "Arma cuerpo a cuerpo ", "65");
    }

    public String toString(){
        return getNombre() + "Con daño de " + getDaño();
    }
}
