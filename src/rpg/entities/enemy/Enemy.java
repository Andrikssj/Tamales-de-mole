package rpg.entities.enemy;
import rpg.entities.GameCharacter;
import rpg.entities.Player;
import rpg.enums.Stats;

import java.util.HashMap;

public class Enemy extends GameCharacter{
    protected String name;
    protected HashMap<Stats, Integer> stats;

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


    public void attack(GameCharacter enemy) {
        int attackPower = this.stats.get(Stats.ATTACK);
        int targetDefense = enemy.getStat(Stats.DEFENSE);
        int damage = Math.max(attackPower - targetDefense, attackPower); // Evitar daño negativo
        int enemyHP =enemy.getStat(Stats.HP) - damage;
        enemy.setStat(Stats.HP, enemyHP);
        System.out.println(name + " inflige " + damage + " de daño a " + enemy.getName() + ". HP restante del objetivo: " + enemyHP);
    }

    public boolean isAlive() {
            Integer hp = this.stats.get(Stats.HP);
            return hp != null && hp > 0;

    }



}


