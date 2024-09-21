package rpg.entities;
import java.util.HashMap;

public class Enemy {
    private String name;
    private HashMap<Stats, Integer> stats;

    public Enemy(String name) {
        this.name = name;
        this.stats = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    // Método para asignar estadísticas
    public void setStat(Stats stat, int value) {
        this.stats.put(stat, value);
    }

    // Método para obtener una estadística
    public int getStat(Stats stat) {
        Integer statValue = this.stats.get(stat);
        if (statValue == null) {
            // Puedes lanzar una excepción o devolver un valor predeterminado
            throw new IllegalArgumentException("Estadística no encontrada para: " + stat);
        }
        return statValue; // Regresar el valor directamente, ya es un int.
    }


    public void attack(Player player) {
        int attackPower = this.stats.get(Stats.ATTACK);
        int playerDefense = player.getStat(Stats.DEFENSE);
        int damage = Math.max(attackPower - playerDefense, 40); // Evitar daño negativo
        int playerHP = player.getStat(Stats.HP) - damage;
        player.setStat(Stats.HP, playerHP);
        System.out.println(name + " inflige " + damage + " de daño a " + player.getName() + ". HP restante del jugador: " + playerHP);
    }
}


