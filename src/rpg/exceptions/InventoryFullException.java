package rpg.exceptions;

/**
 * Excepción que se lanza cuando el inventario está lleno.
 */
public class InventoryFullException extends Exception {

    /**
     * Constructor de la excepción de inventario lleno.
     */
    public InventoryFullException() {

        super("Inventory is full");
    }
}
