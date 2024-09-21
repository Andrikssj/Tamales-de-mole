package rpg;

import rpg.entities.Stats;

public static void main(String[] args) {
        // Crear un jugador y un enemigo
        Player player = new Player("Heroe");
        Enemy enemy = new Enemy("Dragon");

        // Establecer algunas estadísticas
        player.setStat(Stats.ATTACK, 50);
        player.setStat(Stats.HP, 100);

        enemy.setStat(Stats.ATTACK, 40);
        enemy.setStat(Stats.HP, 120);

        // Crear el juego
        Game game = new Game(player, enemy);

        // Iniciar el juego
        game.startGame();
    }

