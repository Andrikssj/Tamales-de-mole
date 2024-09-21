package rpg.entities;

public class game {
        private Player player;
        private Enemy enemy;

        public game(Player player, Enemy enemy) {
            this.player = player;
            this.enemy = enemy;
        }

        public void startGame() {
            System.out.println("El juego ha comenzado!");
            player.attack(enemy);
            enemy.attack(player);
        }
    }

