package rpg;

import rpg.Inventory.Inventory;
import rpg.Inventory.items.*;
import rpg.entities.Player;
import rpg.entities.enemy.Enemy;
import rpg.entities.enemy.goblins.RookieGoblin;
import rpg.entities.enemy.slimes.BasicSlime;


import java.util.Random;


public class Game {

    private Player player;
    private Enemy enemy;
    private Inventory inventory;

    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }

    public Game() {
        this.player = new Player("Odin");
        int enemyType = new Random().nextInt(3) + 1;
        this.enemy = switch (enemyType) {
            case 1 -> new RookieGoblin();
            case 2 -> new BasicSlime("Basic Slime");
            default -> new Enemy("Otro enemigo");
        };
        this.inventory = new Inventory();
    }

    public void startGame() {
        manageGame();
        while (player.isAlive() && enemy.isAlive()) {
            player.attack(enemy);
            if (enemy.isAlive()) {
                enemy.attack(player);
            }
        }

        if (player.isAlive()) {
            System.out.println(player.getName() + " GANO el mas perro");
        } else {
            System.out.println(enemy.getName() + " Ganooooo ");
        }
    }

    public void manageGame(){
        Espada espada = new Espada(" Acero ",58);
        arco arco = new arco();
        hacha hacha = new hacha();
        Antidoto antidoto = new Antidoto();
        Armadura armadura = new Armadura(" Armadura de cuero ",35);
        armaduradediamante armaduraDiamante = new armaduradediamante();
        blindaje blindaje = new blindaje();
        casco casco = new casco();
        escudo escudo = new escudo();
        lanza lanza = new lanza();
        Llave llave = new Llave();
        machete machete = new machete();
        Mapa mapa = new Mapa();
        Monedas monedas = new Monedas();
        Pocion pocion = new Pocion();


        // Agregar ítems al inventario
        inventory.addItem(espada);
        inventory.addItem(arco);
        inventory.addItem(hacha);
        inventory.addItem(antidoto);
        inventory.addItem(armadura);
        inventory.addItem(armaduraDiamante);
        inventory.addItem(blindaje);
        inventory.addItem(casco);
        inventory.addItem(escudo);
        inventory.addItem(lanza);
        inventory.addItem(llave);
        inventory.addItem(machete);
        inventory.addItem(mapa);
        inventory.addItem(monedas);
        inventory.addItem(pocion);


        /**
         *      Imprimir el inventario
         */
        System.out.println("Items en el inventario:");
        inventory.printItems();
    }
}