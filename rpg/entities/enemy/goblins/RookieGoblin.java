package rpg.entities.enemy.goblins;

import rpg.entities.GameCharacter;
import rpg.entities.enemy.Enemy;
import rpg.enums.Stats;


import java.util.Random;

public class RookieGoblin extends Enemy {
    public RookieGoblin() {
        super("Rookie Goblin");
        this.name = "Rookie Goblin";
        this.stats.put(Stats.MAX_HP, 90);
        this.stats.put(Stats.HP, 500);
        this.stats.put(Stats.ATTACK, 30);
        this.stats.put(Stats.DEFENSE, 10);

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