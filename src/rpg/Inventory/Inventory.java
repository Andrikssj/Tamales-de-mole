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
        this.items = new ArrayList<>();
    }

    /**
     * Metodo para añadir item al inventario
     */
    public void addItem(Item item) {
        items.add(item);
        System.out.println(item.getNombre() + "ha sido añadido al inventario ");
    }

    /**
     * Método para retirar item del inventario
     */
    public void removeItem(Item item) {
        if (items.remove(item)){
            System.out.println(item.getNombre() + "se ha retirado del inventario ");
        } else {
            System.out.println(item.getNombre() + "no se encontro el inventario ");

        }
    }

    /**
     * Metodo que muestra el contendio del inventario
     */
    public void showInventory(){
        if (items.isEmpty()){
            System.out.println("El inventario esta vacio ");
        } else {
            System.out.println("Inventario: ");
            for (Item item : items){
                System.out.println(" " + item.toString());
            }
        }
    }

    public void printItems() {
        if (items.isEmpty()){
            System.out.println("El inventario esta vacio ");
        } else {
            System.out.println("Items en el inventario: ");
            for (Item item : items){
                System.out.println(item.toString());
            }
        }

    }
}



