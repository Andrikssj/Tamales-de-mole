package rpg.gui;

import javax.swing.*;
import java.awt.*;

public class GUIForm extends JFrame implements WindowConstants {

    private JPanel mainPanel;
    private JPanel statusBar;
    private JPanel gamePanel;
    private JPanel actionBar;

    public GUIForm() {
        // Configurar la ventana
        setTitle("RPG Game");
        setSize(WINDOW_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Crear panel principal con BorderLayout
        mainPanel = new JPanel(new BorderLayout());

        // Crear y configurar las secciones
        createSections();

        // Establecer el panel principal como contenido de la ventana
        setContentPane(mainPanel);

        // Hacer visible la ventana
        setVisible(true);
    }

    private void createSections() {
        // Barra de Estado (150 px de altura)
        statusBar = new JPanel();
        statusBar.setBackground(Color.BLUE); // Color de fondo para distinguir la sección
        statusBar.setPreferredSize(new Dimension(WINDOW_SIZE.width, 150));

        // Cargar y redimensionar imagen para la barra de estado
        ImageIcon imgStatusBar = new ImageIcon("rpg/gui/images/Background 1.jpg"); // Ajusta la ruta a tu imagen
        Image scaledStatusBarImage = imgStatusBar.getImage().getScaledInstance(WINDOW_SIZE.width, 150, Image.SCALE_SMOOTH);
        JLabel labelStatusBar = new JLabel(new ImageIcon(scaledStatusBarImage));
        statusBar.add(labelStatusBar); // Agregar imagen al panel de la barra de estado

        // Panel de Juego (370 px de altura)
        gamePanel = new JPanel();
        gamePanel.setBackground(Color.GREEN); // Color de fondo para distinguir la sección
        gamePanel.setPreferredSize(new Dimension(WINDOW_SIZE.width, 370));

        // Cargar y redimensionar imagen para el panel de juego
        ImageIcon imgGamePanel = new ImageIcon("rpg/gui/images/Background 2.jpg"); // Ajusta la ruta a tu imagen
        Image scaledGamePanelImage = imgGamePanel.getImage().getScaledInstance(WINDOW_SIZE.width, 370, Image.SCALE_SMOOTH);
        JLabel labelGamePanel = new JLabel(new ImageIcon(scaledGamePanelImage));
        gamePanel.add(labelGamePanel); // Agregar imagen al panel de juego

        // Barra de Acción (340 px de altura)
        actionBar = new JPanel();
        actionBar.setBackground(Color.RED); // Color de fondo para distinguir la sección
        actionBar.setPreferredSize(new Dimension(WINDOW_SIZE.width, 340));

        // Cargar y redimensionar imagen para la barra de acción
        ImageIcon imgActionBar = new ImageIcon("rpg/gui/images/Background 3.jpg"); // Ajusta la ruta a tu imagen
        Image scaledActionBarImage = imgActionBar.getImage().getScaledInstance(WINDOW_SIZE.width, 340, Image.SCALE_SMOOTH);
        JLabel labelActionBar = new JLabel(new ImageIcon(scaledActionBarImage));
        actionBar.add(labelActionBar); // Agregar imagen al panel de la barra de acción

        // Añadir las secciones al panel principal
        mainPanel.add(statusBar, BorderLayout.NORTH);
        mainPanel.add(gamePanel, BorderLayout.CENTER);
        mainPanel.add(actionBar, BorderLayout.SOUTH);
    }

}
