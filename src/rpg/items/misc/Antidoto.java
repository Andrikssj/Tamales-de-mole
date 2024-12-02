package rpg.items.misc;

import rpg.items.MisceItem;

public class Antidoto extends MisceItem {

    public Antidoto() {

    super("Antidoto ", ": Elimina cualquier tipo de veneno ", " $5");
    }

    public String toString(){
        return getNombre() + "Elimina cualquier tipo de veneno ";
    }

}
