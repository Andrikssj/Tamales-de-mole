package rpg.items.misc;

public class Pocion extends Misc{
    public Pocion(){
        super("Poción ", "Recupera 30 puntos de vida ", " $80 ");
    }

    @Override
    protected void initItem() {

    }

    @Override
    public void use() {

    }

    public String toString(){
        return getNombre() + ": " + getDescripcion() + " (Costo: " + getPrecio() + ")";
    }
}
