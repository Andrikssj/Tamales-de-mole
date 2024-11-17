package rpg.items;

public class Llave extends MisceItem{
    public Llave(){
        super("Llave ", "Permite abrir cualquier puerta y cualquier caja ", "$75");
    }

    public String toString(){
        return  getNombre() + ":" + getDescripcion()+ "Costo: " + getPrecio()+ ")";
    }
}
