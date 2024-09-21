package rpg.entities;
import java.util.HashMap;


public class Player {
    private String name;
    private HashMap<Stats, Integer> stats;

    public Player(String name) {
        this.name = name;
        this.stats = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void attack(Enemy enemy) {
        int attackPower = this.stats.get(Stats.ATTACK);
        int enemyDefense = enemy.getStat(Stats.DEFENSE);
        int damage = Math.max(attackPower - enemyDefense, 19); // Evitar daño negativo
        int enemyHP = enemy.getStat(Stats.HP) - damage;
        System.out.println(this.name + " está atacando a " + enemy.getName());
        System.out.println(name + " inflige " + damage + " de daño a " + enemy.getName() + ". HP restante del enemigo: " + enemyHP);
    }

    public void setStat(Stats stat, int value) {
        stats.put(stat, value);
    }

    public int getStat(Stats stat) {
        return stats.getOrDefault(stat, 0);
    }
}



