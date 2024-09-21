import rpg.entities.Player;
import rpg.entities.Enemy;
import rpg.entities.game;
import rpg.entities.Stats;


        public static void main(String[] args) {
                // Crear un jugador y un enemigo
                Player player = new Player("Julian");
                Enemy enemy = new Enemy("Ares");

                // Establecer algunas estadísticas
                player.setStat(Stats.ATTACK, 100);
                player.setStat(Stats.HP, 200);
                player.setStat(Stats.DEFENSE, 250);

                enemy.setStat(Stats.ATTACK, 20);
                enemy.setStat(Stats.HP, 1200);
                enemy.setStat(Stats.DEFENSE, 600);

                // Crear el juego
                game game = new game(player, enemy);

                // Iniciar el juego
                game.startGame();
        }


