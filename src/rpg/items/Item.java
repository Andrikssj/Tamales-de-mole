package rpg.items;
import rpg.enums.ItemType;

/**
 * CLase abstracta Itemm
 */
public abstract class Item{
    private String nombre;
    private ItemType tipo;

    /**
     * Constructor que inicializa los atributos
     */
    public Item(String nombre, ItemType tipo){
        this.nombre = nombre;
        this.tipo = tipo;
    }

    /**
     * Metodo que devuelve el nombre del item
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Metodo que devuelve el tipo del item
     */
    public ItemType getTipo(){
        return tipo;
    }

    public String toString(){
        return nombre + "(" + tipo + ")";
    }
}

