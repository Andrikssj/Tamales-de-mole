package rpg.items;

import rpg.enums.ItemType;
import rpg.utils.cache.ImageCache;

import javax.swing.*;
import java.io.Serializable;

/**
 * La clase Item.
 */
public abstract class Item implements Serializable {

    /**
     * El nombre del ítem.
     */
    protected String name;
    protected String iconName;
    /**
     * La descripción del ítem.
     */
    protected String description;
    /**
     * El precio del ítem.
     */
    protected int price;
    /**
     *El tipo del ítem.
     */
    protected ItemType type;

    /**
     * Constructor de la clase Item. Inicializa los atributos de la clase mediante
     * la función initItem().
     */
    public Item() {

        initItem();
    }

    /**
     * Función que inicializa los atributos de la clase actual.
     * Deberá ser implementada y sobreescrita por las clases hijas.
     */
    protected abstract void initItem();

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public ItemType getType() {
        return type;
    }

    public ImageIcon getIcon() {
        return new ImageIcon(ImageCache
                .getImage(iconName)
                .getScaledInstance(32, 32, 0));
    }
}
