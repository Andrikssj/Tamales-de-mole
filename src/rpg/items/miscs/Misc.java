package rpg.items.miscs;

import rpg.items.Item;

import java.io.Serializable;

/**
 * La clase Misc.
 */
public abstract class Misc extends Item implements Serializable  {

    /**
     * Indica si es consumible.
     */
    protected boolean consumable;
    /**
     * Indica si es apilable.
     */
    protected boolean stackable;
    protected int quantity;
    protected int maxQuantity;

    public Misc() {
        super();
        maxQuantity = 99;
    }

    /**
     * Usar.
     */
    public abstract void use();

    public boolean isConsumable() {
        return consumable;
    }

    public boolean isStackable() {
        return stackable;
    }

    public int getQuantity() {
        return quantity;
    }

    public void increaseQuantity(int amount) {
        quantity += amount;
        if (quantity > maxQuantity) {
            quantity = maxQuantity;
        }
    }

    public void decreaseQuantity(int amount) {
        quantity -= amount;
        if (quantity < 0) {
            quantity = 0;
        }
    }
}
