package rpg.Inventory.items;
import rpg.enums.ItemType;

class Armas extends Item {
    private String daño;

    /**
     * Constructor de la clase armas
     */
    public Armas(String nombre, String descripcion, String precio, String daño){
        super(nombre,ItemType.WEAPON);
        this.daño = daño;
    }

    public String getDaño(){
        return daño;
    }
}

/**
 * Clase espada, que hereda de armas
 */
class espada extends Armas{
    public espada(){
        super("Espada", "Arma cuerpo a cuerpo", "125", "50");
    }
}

/**
 * Clase arco, que hereda de armas
 */
class arco extends Armas{
    public arco(){
        super("Arco", "Arma a distancia", "95", "35");
    }
}

/**
 * Clase hacha, que hereda de armas
 */
class hacha extends Armas{
    public hacha(){
        super("Hacha", "Arma cuerpo a cuerpo", "65", "50");
    }
}

/**
 * Clase machete, que hereda de armas
 */
class machete extends Armas{
    public machete(){
        super("Machete", "Arma cuerpo a cuerpo", "45", "60");
    }
}

/**
 * Clase lanza, que hereda de armas
 */
class lanza extends Armas {
    public lanza() {
        super("Lanza", "Arma cuerpo a cuerpo", "55", "30");
    }
}
