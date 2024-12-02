package rpg.items.misc;

public class Monedas extends Misc {
    public Monedas(){
        super("Monedas ", "Puedes comprar cosas y disponer de servicios ", "$0");
    }

    @Override
    protected void initItem() {

    }

    @Override
    public void use() {

    }

    public String toString(){
        return getNombre() + ":" + getDescripcion() + "(Costo: " + getPrecio() + ")";
    }
}
