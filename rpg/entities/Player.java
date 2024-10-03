package rpg.entities;
import rpg.entities.enemy.Enemy;
import rpg.enums.Stats;

import java.util.HashMap;


public class Player {
    private String name;
    private HashMap<Stats, Integer> stats;

    public Player(String Odin) {
        this.name = Odin;
        this.stats = new HashMap<>();
        this.stats.put(Stats.HP, 100);
        this.stats.put(Stats.MAX_HP, 100);
        this.stats.put(Stats.MAX_MP, 50);
        this.stats.put(Stats.MP, 50);
        this.stats.put(Stats.ATTACK, 10);
        this.stats.put(Stats.DEFENSE, 5);
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
    public boolean isAlive() {
        Integer hp = this.stats.get(Stats.HP);
        return hp != null && hp > 0;
    }
}



