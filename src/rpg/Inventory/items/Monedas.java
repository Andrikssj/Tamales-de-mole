package rpg.Inventory.items;

public class Monedas extends MisceItem {
    public Monedas(){
        super("Monedas ", "Puedes comprar cosas y disponer de servicios ", "$0");
    }

    public String toString(){
        return getNombre() + ":" + getDescripcion() + "(Costo: " + getPrecio() + ")";
    }
}
