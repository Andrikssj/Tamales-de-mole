package rpg.gui.windows;

import rpg.entities.Player;
import rpg.entities.enemies.Enemy;
import rpg.enums.BarType;
import rpg.enums.Stats;
import rpg.factory.EnemyFactory;
import rpg.gui.UIConstants;
import rpg.gui.buttons.*;
import rpg.gui.internalFrames.InventoryFrame;
import rpg.gui.internalFrames.StatusFrame;
import rpg.gui.labels.*;
import rpg.gui.panels.BottomPanel;
import rpg.gui.panels.MessagePanel;
import rpg.gui.panels.MiddlePanel;
import rpg.gui.panels.TopPanel;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel middlePanel;
    private JPanel bottomPanel;
    private JButton blacksmithButton;
    private JButton shopButton;
    private JButton inventoryButton;
    private JLabel exampleLabel;
    private JButton atacarButton;
    private JButton habilidadesButton;
    private JButton huirButton;
    private JTextArea textDisplay;
    private JScrollPane textScroll;
    private JLabel lifeLabel;
    private JLabel magicLabel;
    private JLabel expLabel;
    private JLabel nameLabel;
    private JLabel goldLabel;
    private JButton exitButton;
    private JButton saveButton;
    private JLabel playerSprite;
    private JLabel enemySprite;
    private JLabel enemyLifeLabel;
    private JLabel enemyNameLabel;
    private JPanel messagePanel;
    private JPanel enemyPanel;
    private JDesktopPane desktopPane;
    private final JInternalFrame statusFrame;
    private final JInternalFrame inventoryFrame;
    Player player;
    Enemy enemy;
    int slot;

    public MainWindow(Player player, int slot) {

        this.player = player;
        this.slot = slot;
        initComponents();
        ((BarLabel) lifeLabel).updateBar(player.getStats().get(Stats.HP), player.getStats().get(Stats.MAX_HP));
        ((BarLabel) magicLabel).updateBar(player.getStats().get(Stats.MP), player.getStats().get(Stats.MAX_MP));
        ((BarLabel) expLabel).updateBar(player.getStats().get(Stats.EXPERIENCE), player.getStats().get(Stats.NEEDED_EXPERIENCE));
        statusFrame = new StatusFrame(this);
        inventoryFrame = new InventoryFrame(this);
        desktopPane.add(statusFrame, JLayeredPane.PALETTE_LAYER);
        desktopPane.add(inventoryFrame, JLayeredPane.PALETTE_LAYER);
        // Colocamos los InternalFrames en la posición deseada
        statusFrame.setLocation((desktopPane.getWidth() - statusFrame.getWidth()) / 2,
                (desktopPane.getHeight() - statusFrame.getHeight()) / 2);
        inventoryFrame.setLocation((desktopPane.getWidth() - inventoryFrame.getWidth()) / 2,
                (desktopPane.getHeight() - inventoryFrame.getHeight()) / 2);
        // Añadimos un mensaje al textDisplay de bienvenida
        appendText("¡Te damos la Bienvenida, Juega y gana con nosotros!\n");
        appendText("¡Vamos a la acción!\n");
        appendText("Enemigo: " + enemy.getName() + "\n");
    }

    private void initComponents() {
        // Creamos un DesktopPane para poder agregar los componentes
        desktopPane = new JDesktopPane();
        // Hacemos que el tamaño del DesktopPane sea igual al
        // tamaño del panel principal
        desktopPane.setPreferredSize(mainPanel != null ?
                mainPanel.getPreferredSize() : null);
        // Definimos los Bounds del panel principal
        mainPanel.setBounds(0, 0, mainPanel.getPreferredSize().width,
                mainPanel.getPreferredSize().height);
        // Agregamos el panel principal al DesktopPane
        desktopPane.add(mainPanel, JLayeredPane.DEFAULT_LAYER);
        // Agregamos el panel principal a la ventana
        setContentPane(desktopPane);
        // Definimos el título de la ventana
        setTitle("RPG Game");
        // Definimos la operación por defecto al cerrar la ventana
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        // Tomamos el tamaño de los componentes
        pack();
        // Centramos la ventana
        setLocationRelativeTo(null);
        // Hacemos visible la ventana
        setVisible(true);
        // Definimos que la ventana no se pueda redimensionar
        setResizable(false);
        // Definimos la forma de trabajo del ScrollPane
        // Hacemos que el ScrollPane no tenga bordes y sea transparente
        textScroll.getViewport().setOpaque(false);
        textScroll.setBorder(null);
        // Hacemos que el ScrollPane tenga solo la barra vertical
        textScroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        textScroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        // Definimos el color de fondo del display en Blanco y su fuente en 28px
        textDisplay.setFont(UIConstants.FONT.deriveFont(28f));
        textDisplay.setForeground(Color.WHITE);
        // Configuramos el scrool del textDisplay
        textDisplay.setColumns(1);
        textDisplay.setEditable(false);
        textDisplay.setLineWrap(true);
        textDisplay.setWrapStyleWord(true);
        goldLabel.setText(player.getStats().get(Stats.GOLD) + "G");
    }

    /**
     * Permite añadir texto al textDisplay.
     */
    public void appendText(String text) {

        // Añadimos el texto al textDisplay
        textDisplay.append(text);
        // Hacemos que el textDisplay se posicione en la última línea
        textDisplay.setCaretPosition(textDisplay.getDocument().getLength());
    }

    /**
     * Permite intentar huir de un combate.
     */
    public void tryToFlee() {

        // Si el jugador logra huir
        if (player.tryToFlee()) {
            // Añadimos un mensaje al textDisplay de que se logró huir
            appendText("Has huido con éxito.\n");
            // Creamos un nuevo enemigo
            createEnemy();
        } else {
            // Añadimos un mensaje al textDisplay de que no se pudo huir
            appendText("No has podido huir.\n");
            // El enemigo ataca al jugador
            appendText(enemy.attack(player));
        }
        // Actualizamos las barras status del jugador y del enemigo
        updateBars();
    }

    /**
     * Permite verificar el estado del juego y actualizar las barras de estado.
     */
    public void checkGameStatus() {

        // Verificamos si el jugador o el enemigo han muerto
        if (!player.isAlive()) {
            // En caso de que el jugador haya muerto
            // Añadimos un mensaje al textDisplay de que el jugador ha muerto
            appendText("Has muerto.\n");
            appendText("GAME OVER\n");
        } else if (!enemy.isAlive()) {
            // En caso de que el enemigo haya muerto
            // Recuperamos la experiencia y el oro del jugador y del enemigo
            int playerExp = player.getStats().get(Stats.EXPERIENCE);
            int enemyExp = enemy.getStats().get(Stats.EXPERIENCE);
            int promotionExp = player.getStats().get(Stats.NEEDED_EXPERIENCE);
            int playerGold = player.getStats().get(Stats.GOLD);
            int enemyGold = enemy.getStats().get(Stats.GOLD);
            // Calculamos el total de experiencia y oro
            int totalExp = playerExp + enemyExp;
            int totalGold = playerGold + enemyGold;
            // Añadimos un mensaje al textDisplay de que se ha derrotado al enemigo
            // y se ha ganado experiencia y oro.
            appendText("""
                    Has derrotado a %s
                    Has ganado %d puntos de experiencia.
                    Has ganado %d monedas de oro.
                    """.formatted(enemy.getName(), enemyExp, enemyGold));
            // Asignamos la nueva experiencia y oro al jugador
            player.getStats().put(Stats.EXPERIENCE, totalExp);
            player.getStats().put(Stats.GOLD, totalGold);
            goldLabel.setText(totalGold + "G");
            goldLabel.repaint();
            // Evaluamos si el jugador ha subido de nivel
            if (totalExp >= promotionExp)
                updatePlayer();
            // Creamos un nuevo enemigo en cualquier caso
            createEnemy();
        }
        updateBars();
    }

    private void createEnemy() {

        enemy = EnemyFactory.getEnemy();
        if (enemy != null) {

            enemyNameLabel.setText(enemy.getName());
            appendText("Aparece un nuevo enemigo: " + enemy.getName() + "\n");
            ((EnemySpriteLabel) enemySprite).setEnemy(enemy);
            ((NameLabel) enemyNameLabel).updateLabel(enemy.getName());
            ((BarLabel) enemyLifeLabel).updateBar(enemy.getStats().get(Stats.HP),
                    enemy.getStats().get(Stats.MAX_HP));
        }
    }

    private void updateBars() {

        ((BarLabel) lifeLabel).setBarValue(player.getStats().get(Stats.HP));
        ((BarLabel) expLabel).setBarValue(player.getStats().get(Stats.EXPERIENCE));
        ((BarLabel) enemyLifeLabel).setBarValue(enemy.getStats().get(Stats.HP));
    }

    /**
     * Permite actualizar al jugador cuando sube de nivel.
     */
    private void updatePlayer() {

        // Actualizamos al jugador
        player.levelUp();
        // Obtenemos el nivel, vida, magia y experiencia del jugador
        int level = player.getStats().get(Stats.LEVEL);
        int hp = player.getStats().get(Stats.HP);
        int mp = player.getStats().get(Stats.MP);
        int neededExp = player.getStats().get(Stats.NEEDED_EXPERIENCE);
        // Añadimos un mensaje al textDisplay de que el jugador ha subido de nivel
        appendText("Has subido de nivel.\n");
        // Actualizamos las barras de estado del jugador
        ((BarLabel) lifeLabel).updateBar(hp, hp);
        ((BarLabel) magicLabel).updateBar(mp, mp);
        ((BarLabel) expLabel).updateBar(0, neededExp);
        // Actualizamos el nombre del jugador
        ((NameLabel) nameLabel).updateLabel(
                "%s LVL. %d".formatted(player.getName(), level));
    }

    /**
     * Permite personalizar los componentes de la ventana.
     */
    private void createUIComponents() {

        enemy = EnemyFactory.getEnemy();
        messagePanel = new MessagePanel();
        topPanel = new TopPanel();
        middlePanel = new MiddlePanel();
        bottomPanel = new BottomPanel();
        blacksmithButton = new BlacksmithButton();
        shopButton = new ShopButton();
        inventoryButton = new InventoryButton(this);
        exitButton = new ExitButton();
        saveButton = new SaveButton(this, player, slot);
        atacarButton = new AttackButton(this);
        habilidadesButton = new SkillPanelButton();
        huirButton = new FleeButton(this);
        exampleLabel = new PortraitLabel(this);
        lifeLabel = new BarLabel(0, 0, BarType.LIFE);
        magicLabel = new BarLabel(0, 0, BarType.MAGIC);
        expLabel = new BarLabel(0, 0, BarType.EXPERIENCE);
        goldLabel = new GoldLabel(player.getStats().get(Stats.GOLD));
        nameLabel = new NameLabel(String.format("%s LVL. %d", player.getName(),
                player.getStats().get(Stats.LEVEL)));
        playerSprite = new PlayerSpriteLabel();
        enemyNameLabel = new NameLabel(enemy.getName());
        enemyLifeLabel = new BarLabel(enemy.getStats().get(Stats.HP),
                enemy.getStats().get(Stats.MAX_HP), BarType.LIFE);
        enemySprite = new EnemySpriteLabel(enemy);
    }

    public Player getPlayer() {
        return player;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public JInternalFrame getInventoryFrame() {
        return inventoryFrame;
    }

    public JInternalFrame getStatusFrame() {
        return statusFrame;
    }
}
