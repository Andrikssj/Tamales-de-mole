package rpg.entities.enemy.slimes;

import rpg.entities.GameCharacter;
import rpg.entities.enemy.Enemy;
import rpg.enums.Stats;




public class BasicSlime extends Enemy {

    public BasicSlime(String BasicSlime) {
        super("Basic Slime");
        this.name = BasicSlime;
        this.stats.put(Stats.MAX_HP, 400);
        this.stats.put(Stats.HP, 305);
        this.stats.put(Stats.ATTACK, 120);
        this.stats.put(Stats.DEFENSE, 40);
    }


    protected void splash(GameCharacter enemy) {

        System.out.println(this.name + " salpicadura " + enemy.getName() + " y no hace nada ");
        System.out.println(enemy.getName() + " tiene " + enemy.getStats().get(Stats.HP) + " HP left.");
    }

    protected void trhowSlime(GameCharacter enemy) {

        int damage = (int) (this.stats.get(Stats.ATTACK) * 0.8);
        enemy.getStats().put(Stats.HP, enemy.getStats().get(Stats.HP) - damage);
        System.out.println(this.name + " lanza baba a " + enemy.getName() + " para " + damage + " daño!");
        System.out.println(enemy.getName() + " tiene " + enemy.getStats().get(Stats.HP) + " HP perdio.");
    }

    @Override
    public void attack(GameCharacter enemy) {
        if (Math.random() < 0.5) {
            splash(enemy);
        } else {
            trhowSlime(enemy);
        }
    }
}