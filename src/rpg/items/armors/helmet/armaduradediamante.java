package rpg.items.armors.helmet;

import rpg.items.armors.Armor;

/**
 * Clase armaduradediamante que herda de armadura
 */
public class armaduradediamante extends Armor {
    @Override
    protected void initItem() {

    }

    public armaduradediamante(){
        super("Armadura de diamante ",  10);
    }

    public String toString(){
        return getNombre() + "Con defensa de " + getDefensa();
    }

    private String getNombre() {
        return null;
    }
}
