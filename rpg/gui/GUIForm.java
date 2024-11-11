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
    private JPanel gamePanel;
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
        statusBar.setBackground(Color.BLUE);
        statusBar.setPreferredSize(new Dimension(WINDOW_SIZE.width, 150)); // Dimensión ajustada
        ImageIcon imgStatusBar = new ImageIcon("rpg/gui/images/Background 1.jpg");
        Image scaledStatusBarImage = imgStatusBar.getImage().getScaledInstance(WINDOW_SIZE.width,150, Image .SCALE_SMOOTH);
        JLabel labelStatusBar = new JLabel(new ImageIcon(scaledStatusBarImage));
        statusBar.add(labelStatusBar);
        mainPanel.add(statusBar);


        // Panel de juego
        gamePanel = new JPanel();
        gamePanel.setBackground(Color.GREEN);
        gamePanel.setPreferredSize(new Dimension(WINDOW_SIZE.width, 370)); // Dimensión ajustada
        ImageIcon imgGamePanel = new ImageIcon("rpg/gui/images/Background 2.jpg");
        Image scaledGamePanelImage = imgGamePanel.getImage().getScaledInstance(WINDOW_SIZE.width,370, Image .SCALE_SMOOTH);
        JLabel labelGamePanel = new JLabel(new ImageIcon(scaledGamePanelImage));
        gamePanel.add(labelGamePanel);
        mainPanel.add(gamePanel);

        // Barra de acción con dimensiones exactas (800x340)
        actionBar = new JPanel();
        actionBar.setBackground(Color.RED);
        actionBar.setPreferredSize(new Dimension(WINDOW_SIZE.width, 340)); // Mantener dimensiones originales
        ImageIcon imgActionBar = new ImageIcon("rpg/gui/images/Background 3.jpg");
        Image scaledActionBarImage = imgActionBar.getImage().getScaledInstance(WINDOW_SIZE.width,340, Image .SCALE_SMOOTH);
        JLabel labelActionBar = new JLabel(new ImageIcon(scaledActionBarImage)); // Usar imagen sin redimensionar
        actionBar.add(labelActionBar);
        mainPanel.add(actionBar);
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

        // Añadir los botones al panel
        buttonPanel.add(saveButton);
        buttonPanel.add(inventoryButton);
        buttonPanel.add(statsButton);
        buttonPanel.add(exitButton);

        // Agregar el panel de botones en la parte superior
        mainPanel.add(buttonPanel);
    }
}


