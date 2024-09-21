package rpg.entities;


public class game {
    private Player player;
    private Enemy enemy;

    public game(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public void startGame() {
        System.out.println("¡El juego ha comenzado!");

        // Mientras el jugador y el enemigo tengan vida (HP mayor a 0)
        while (player.getStat(Stats.HP) > 0 && enemy.getStat(Stats.HP) > 0) {
            // Turno del jugador
            System.out.println(player.getName() + " ataca a " + enemy.getName());
            player.attack(enemy);

            // Si el enemigo muere, salir del bucle
            if (enemy.getStat(Stats.HP) <= 0) {
                System.out.println(enemy.getName() + " ha sido derrotado!");
                break;
            }

            // Turno del enemigo
            System.out.println(enemy.getName() + " ataca a " + player.getName());
            enemy.attack(player);

            // Si el jugador muere, salir del bucle
            if (player.getStat(Stats.HP) <= 0) {
                System.out.println(player.getName() + " ha sido derrotado!");
                break;
            }
        }

        // Mostrar el resultado final
        if (player.getStat(Stats.HP) > 0) {
            System.out.println(player.getName() + " ha ganado el combate!");
        } else {
            System.out.println(enemy.getName() + " ha ganado el combate!");
        }
    }
}


