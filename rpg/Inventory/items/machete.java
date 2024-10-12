package rpg.Inventory.items;

/**
 * Clase machete, que hereda de armas
 */
public class machete extends Armas{
    public machete(){
        super("Machete ", "Arma cuerpo a cuerpo ", " 45");
    }

    public String toString(){
        return "Machete con daño de " + getDaño();
    }
}
