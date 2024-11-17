package rpg.Inventory.items;

/**
 * Clase espada, que hereda de armas
 */
public class Espada extends Armas {
    private String material;
    private String daño;
    public Espada(String material, int daño) {
        super("Espada ", "Una poderosa espada de " + material, String.valueOf(daño));
        this.material = material;
        this.daño = String.valueOf(daño);
    }

    // Sobrescribir el método toString para personalizar la salida
    @Override
    public String toString() {
        return "Espada de " +material + "con daño de " + daño;
    }

    public String getDaño(){
        return daño;
    }
}
