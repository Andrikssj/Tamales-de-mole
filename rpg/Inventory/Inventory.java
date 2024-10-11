package rpg.Inventory;
import rpg.Inventory.items.Item;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa el inventario
 */
public class Inventory {
    private List<Item> items;

    /**
     * Constructor que inicializa la lista de items
     */
    public Inventory() {
        items = new ArrayList<>();
    }

    /**
     * Metodo para añadir item al inventario
     */
    public void addItem(Item item) {
        items.add(item);
        System.out.println(item.getNombre() + "Ha sigo añadido al inventario ");
    }

    public void removeItem(Item item) {
        items.remove(item);
        System.out.println(item.getNombre() + "Se ha retirado del inventario ");

    }

    /**
     * Metodo que muestra el contendio del inventario
     */
    public void showInventory(){
        if (items.isEmpty()){
            System.out.println("El inventario esta vacio");
        } else {
            System.out.println("Inventario: ");
            for (Item item : items){
                System.out.println(" " + item.getNombre() + "(" + item.getTipo() + ")");
            }
        }
    }
}



