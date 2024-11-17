package rpg.Inventory.items;
import  rpg.enums.ItemType;

/**
 * Clase MisceItem heredada de la clase Item
 */
class MisceItem extends Item{
    private String descripcion;
    private String precio;

    /**
     * Constructor de la clase MisceItem
     */
    public MisceItem(String nombre, String descripcion, String precio){
        super(nombre, ItemType.MISC);
        this.descripcion = descripcion;
        this.precio = precio;
    }
 public String toString(){
        return "Item: " + getNombre() + "Descripcion: "+ descripcion + "Precio: " + precio;
 }

 public String getDescripcion(){
        return descripcion;
 }

 public String getPrecio(){
        return precio;
 }

}
