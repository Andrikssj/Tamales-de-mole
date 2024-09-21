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

        public void attack(Player player) {
            System.out.println(this.name + " está atacando a " + player.getName());
        }

        public void setStat(Stats stat, int value) {
            stats.put(stat, value);
        }

        public int getStat(Stats stat) {
            return stats.getOrDefault(stat, 0);
        }
    }

