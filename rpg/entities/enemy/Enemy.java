package rpg.entities.enemy;
import rpg.entities.GameCharacter;
import rpg.entities.Player;
import rpg.enums.Stats;

import java.util.HashMap;

public class Enemy {
    protected String name;
    protected HashMap<Stats, Integer> stats;

    public Enemy(String name) {
        this.name = name;
        this.stats = new HashMap<>();
        this.stats.put(Stats.MAX_HP, 100);
        this.stats.put(Stats.HP, 100);
        this.stats.put(Stats.MAX_MP, 50);
        this.stats.put(Stats.MP, 50);
        this.stats.put(Stats.ATTACK, 10);
        this.stats.put(Stats.DEFENSE, 5);
    }

    public Enemy() {

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
    public boolean isAlive() {
        return this.stats.get(Stats.HP) > 0;
    }

    public void attack(GameCharacter enemy) {
    }
}


