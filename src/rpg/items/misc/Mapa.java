package rpg.items.misc;

public class Mapa extends Misc {
    public Mapa(){
        super("Mapa ", "Muestra todas las ubicaciones "," $50");
    }

    public String toString(){
        return getNombre() + ":" + getDescripcion() + "(Costo: " + getPrecio()+ ")";
    }

    private String getNombre() {
        return null;
    }
}
