package rpg.Inventory.items;

public class Pocion extends MisceItem {
    public Pocion(){
        super("Poción ", "Recupera 30 puntos de vida ", " $80 ");
    }

    public String toString(){
        return getNombre() + ": " + getDescripcion() + " (Costo: " + getPrecio() + ")";
    }
}
