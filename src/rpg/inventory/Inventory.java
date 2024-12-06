package rpg.inventory;

import rpg.exceptions.InventoryFullException;
import rpg.exceptions.ItemNotFoundException;
import rpg.items.Item;
import rpg.items.armors.Armor;
import rpg.items.miscs.Misc;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * La clase Inventory.
 */
public class Inventory implements Serializable {

    /**
     * Los artículos.
     */
    private final ArrayList<Item> items;
    /**
     * La capacidad.
     */
    private int capacity;

    /**
     * Instancia un nuevo Inventario.
     */
    public Inventory() {
        this.capacity = 15;
        items = new ArrayList<>();
    }

    /**
     * Añadir artículo.
     *
     * @param item the item
     */
    public void addItem(Item item) {

        try {

            if (!isFull())
                items.add(item);
            else
                throw new InventoryFullException();
        } catch (InventoryFullException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Quitar artículo.
     *
     * @param item the item
     */
    public void removeItem(Item item) {
        try {
            items.remove(item);
        } catch (Exception e) {
            System.out.println("Item not found");
        }
    }

    /**
     * Obtener artículo.
     *
     * @param index the index
     */
    public Item getItem(int index) {
        return items.get(index);
    }

    public Item getItem(Item item) throws ItemNotFoundException {

        Item found = null;
        for (Item i : items) {
            if (i.getName().equals(item.getName())) {
                found = i;
                break;
            }
        }
        if (found == null) {
            throw new ItemNotFoundException();
        }
        return found;
    }

    /**
     * Obtener item count.
     */
    public int getItemCount() {
        return items.size();
    }

    /**
     * Indica si esta lleno.
     *
     * @return the boolean
     */
    public boolean isFull() {

        return items.size() == capacity;
    }

    /**
     * Indica si esta vacío.
     *
     * @return the boolean
     */
    public boolean isEmpty() {
        return items.isEmpty();
    }

    /**
     * Limpia el contenido.
     */
    public void clear() {
        items.clear();
    }

    /**
     * Aumenta la capacidad.
     *
     * @param amount the amount
     */
    public void increaseCapacity(int amount) {
        capacity += amount;
        items.ensureCapacity(capacity);
    }

    /**
     * Obtener armaduras.
     *
     * @return the armors
     */
    public ArrayList<Armor> getArmors() {

        ArrayList<Armor> armors = new ArrayList<>();
        for (Item item : items) {
            if (item instanceof Armor) {
                armors.add((Armor) item);
            }
        }
        return armors;
    }

    /**
     * Obtener miscs.
     *
     * @return the miscs
     */
    public ArrayList<Misc> getMiscs() {

        ArrayList<Misc> miscs = new ArrayList<>();
        for (Item item : items) {
            if (item instanceof Misc) {
                miscs.add((Misc) item);
            }
        }
        return miscs;
    }

    /**
     * Obtener artículos.
     *
     * @return the items
     */
    public ArrayList<Item> getItems() {
        return items;
    }
}
