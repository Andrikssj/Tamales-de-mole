package rpg.entities.enemy.goblins;

import rpg.entities.GameCharacter;
import rpg.entities.Player;
import rpg.entities.enemy.Enemy;
import rpg.enums.Stats;

import java.util.HashMap;
import java.util.Random;

public class RookieGoblin extends Enemy {
    private HashMap<String, Integer> stats;
    public RookieGoblin() {
        super("Basic Slime");
        stats = new HashMap<>();
        this.name = "Rookie Goblin";
        stats.put(Stats.MAX_HP.name(), 35);
        this.stats.put(String.valueOf(Stats.HP), 35);
        this.stats.put(String.valueOf(Stats.ATTACK), 6);
        stats.put(Stats.DEFENSE.name(), 2);
    }
    private void throwRock(GameCharacter enemy) {
        int damage = (int) (this.stats.get(Stats.ATTACK) * 0.8);
        enemy.getStats().put(Stats.HP, enemy.getStats().get(Stats.HP) - damage);
        System.out.println(this.name + " lanza una roca a " + enemy.getName() + " por " + damage + " de daño!");
        System.out.println(enemy.getName() + " tiene " + enemy.getStats().get(Stats.HP) + " HP restantes.");
    }

    private void savageBite(GameCharacter enemy) {
        int damage = (int) (this.stats.get(Stats.ATTACK) * 1.2);
        enemy.getStats().put(Stats.HP, enemy.getStats().get(Stats.HP) - damage);
        System.out.println(this.name + " muerde salvajemente a " + enemy.getName() + " por " + damage + " de daño!");
        System.out.println(enemy.getName() + " tiene " + enemy.getStats().get(Stats.HP) + " HP restantes.");
    }
    @Override
    public void attack(GameCharacter Enemy) {
        int attack = new Random().nextInt(3) + 1;
        switch (attack) {
            case 1: // Use int literals for cases
                throwRock(Enemy);
                break;
            case 2: // Use int literals for cases
                savageBite(Enemy);
                break;
            default:
                super.attack(Enemy);
                break;
        }
    }
}