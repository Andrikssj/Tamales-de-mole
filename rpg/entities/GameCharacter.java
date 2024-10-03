package rpg.entities;
import rpg.enums.Stats;
import java.util.HashMap;

public class GameCharacter {

    protected String name;
    private HashMap<Stats, Integer> stats;

    public GameCharacter() {
        this.name = name;
        stats = new HashMap<>();
        stats.put(Stats.HP, 100);
        stats.put(Stats.ATTACK, 56);
        stats.put(Stats.DEFENSE, 89);
        stats.put(Stats.MAX_HP, 400);
    }


// Método para obtener una estadística específica
public int getStat(Stats stat) {
    return stats.get(stat);
}

// Método para modificar una estadística específica
public void setStat(Stats stat, int value) {
    stats.put(stat, value);
}

public boolean isAlive() {
    return stats.get(Stats.HP) != null && stats.get(Stats.HP) > 0;
}

public void attack(GameCharacter enemy) {
    String message = "";
    String enemyName = enemy.getName();
    int damage = this.getStat(Stats.ATTACK) - enemy.getStat(Stats.DEFENSE);
    int newHP = enemy.getStat(Stats.HP);

    if (damage > 0) {
        newHP = enemy.getStat(Stats.HP) - damage;
        enemy.setStat(Stats.HP, newHP);
        message += String.format("""
                    %s ataques %s por %d daño!
                    %s has %d HP left.
                    """, this.name, enemyName, damage, enemyName, newHP);
    } else {
        message += String.format("""
                    %s ataca a %s pero no hace daño!
                    %s tiene %d HP left.
                    """, this.name, enemyName, enemyName, newHP);
    }
    System.out.println(message);
}

public String getName() {
    return String.format("%s el Intrépido", name);
}

public HashMap<Stats, Integer> getStats() {
    return stats;
}
}


