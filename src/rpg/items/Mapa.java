package rpg.items;

public class Mapa extends MisceItem {
    public Mapa(){
        super("Mapa ", "Muestra todas las ubicaciones "," $50");
    }

    public String toString(){
        return getNombre() + ":" + getDescripcion() + "(Costo: " + getPrecio()+ ")";
    }
}
