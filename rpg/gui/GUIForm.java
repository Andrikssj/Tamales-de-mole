package rpg.gui;

import rpg.gui.buttons.SaveButton;
import rpg.gui.buttons.ExitButton;
import rpg.gui.buttons.InventoryButton;
import rpg.gui.buttons.StatsButton;
import rpg.Game;

import javax.swing.*;
import java.awt.*;

import static rpg.gui.WindowConstants.WINDOW_SIZE;

public class GUIForm extends JFrame {
    private Game game;
    private JPanel mainPanel;
    private JPanel statusBar;
    private JLayeredPane gamePanel; // Cambiado a JLayeredPane para permitir la superposición
    private JPanel actionBar;
    private SaveButton saveButton;
    private ExitButton exitButton;
    private InventoryButton inventoryButton;
    private StatsButton statsButton;

    public GUIForm(Game game) {
        this.game = game;
        setTitle("RPG Game");
        setSize(new Dimension(800, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Crear panel principal con BoxLayout en dirección vertical
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Crear y configurar las secciones
        createButtons(); // Primero agregamos los botones en la parte superior
        createSections();

        // Establecer el panel principal como contenido de la ventana
        setContentPane(mainPanel);

        // Ajustar todos los componentes al tamaño preferido
        pack();
        setVisible(true);
    }

    private void createSections() {
        // Crear y configurar la barra de estado
        statusBar = new JPanel(new BorderLayout());
        statusBar.setPreferredSize(new Dimension(WINDOW_SIZE.width, 150)); // Dimensión ajustada
        addBackgroundImage(statusBar, "rpg/gui/images/Background 1.jpg", WINDOW_SIZE.width, 150);
        mainPanel.add(statusBar);

        // Panel de juego
        gamePanel = new JLayeredPane();
        gamePanel.setPreferredSize(new Dimension(WINDOW_SIZE.width, 370)); // Dimensión ajustada
        addBackgroundImage(gamePanel, "rpg/gui/images/Background 2.jpg", WINDOW_SIZE.width, 370);

        // Imagen del jugador (en capa superior)
        ImageIcon playerIcon = new ImageIcon("rpg/gui/images/Player.png");
        Image scaledPlayerImage = playerIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH); // Ajusta el tamaño según sea necesario
        JLabel playerLabel = new JLabel(new ImageIcon(scaledPlayerImage));
        playerLabel.setBounds(100, 155, 150, 150); // Posición y tamaño del jugador en el panel
        gamePanel.add(playerLabel, Integer.valueOf(1)); // Agregar en una capa superior

        mainPanel.add(gamePanel);

        // Barra de acción con dimensiones exactas (800x340)
        actionBar = new JPanel();
        actionBar.setPreferredSize(new Dimension(WINDOW_SIZE.width, 340)); // Mantener dimensiones originales
        addBackgroundImage(actionBar, "rpg/gui/images/Background 3.jpg", WINDOW_SIZE.width, 340);
        mainPanel.add(actionBar);
    }

    private void addBackgroundImage(JComponent panel, String imagePath, int width, int height) {
        // Cargar la imagen y escalarla
        ImageIcon icon = new ImageIcon(imagePath);
        Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        JLabel backgroundLabel = new JLabel(new ImageIcon(scaledImage));
        backgroundLabel.setBounds(0, 0, width, height);

        // Añadir la imagen como fondo al panel
        if (panel instanceof JLayeredPane) {
            ((JLayeredPane) panel).add(backgroundLabel, Integer.valueOf(0)); // Añadir en la capa inferior si es un JLayeredPane
        } else {
            panel.setLayout(new BorderLayout());
            panel.add(backgroundLabel, BorderLayout.CENTER);
        }
    }

    private void createButtons() {
        // Crear los botones
        saveButton = new SaveButton();
        exitButton = new ExitButton();
        inventoryButton = new InventoryButton();
        statsButton = new StatsButton();

        // Establecer los oyentes de eventos para los botones
        saveButton.addActionListener(e -> game.saveGame());
        exitButton.addActionListener(e -> game.exitGame());
        inventoryButton.addActionListener(e -> game.openInventory());
        statsButton.addActionListener(e -> game.showStats());

        // Crear el panel de botones y configurarlo
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setBackground(Color.LIGHT_GRAY);
        buttonPanel.setPreferredSize(new Dimension(800, 50)); // Tamaño ajustado para el panel de botones
        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Añadir borde para visualizar el panel

        // Ajustar y agregar iconos a los botones
        addButtonIcon(saveButton, "rpg/gui/images/save_icon.jpg", 40, 40);
        addButtonIcon(exitButton, "rpg/gui/images/exit_icon.jpg", 40, 40);
        addButtonIcon(inventoryButton, "rpg/gui/images/inventory_icon.jpg", 40, 40);
        addButtonIcon(statsButton, "rpg/gui/images/stats_icon.jpg", 40, 40);

        // Añadir los botones al panel
        buttonPanel.add(saveButton);
        buttonPanel.add(inventoryButton);
        buttonPanel.add(statsButton);
        buttonPanel.add(exitButton);

        // Agregar el panel de botones en la parte superior
        mainPanel.add(buttonPanel);
    }

    private void addButtonIcon(JButton button, String iconPath, int width, int height) {
        ImageIcon icon = new ImageIcon(iconPath);
        Image scaledIcon = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        button.setIcon(new ImageIcon(scaledIcon));
    }
}


