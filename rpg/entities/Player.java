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
            System.out.println(this.name + " está atacando a " + enemy.getName());
        }

        public void setStat(Stats stat, int value) {
            stats.put(stat, value);
        }

        public int getStat(Stats stat) {
            return stats.getOrDefault(stat, 0);
        }
    }


