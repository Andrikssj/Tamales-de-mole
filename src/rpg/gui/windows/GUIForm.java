package rpg.gui.windows;

import rpg.enums.BarType;
import rpg.gui.labels.BarLabel;
import rpg.gui.panels.BottomPanel;
import rpg.gui.panels.MiddlePanel;
import rpg.gui.panels.TopPanel;

import javax.swing.*;
import java.awt.*;

public class GUIForm extends JFrame implements WindowConstants {
    private JPanel topPanel;
    private JPanel middlePanel;
    private JPanel bottomPanel;
    private JButton button1;
    private BarLabel magicLabel;
    private BarLabel lifeLabel;
    private BarLabel expLabel;


    private JPanel mainPanel;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JPanel statusBar;
    private JPanel gamePanel;
    private JPanel actionBar;

    public GUIForm() {
        // Configurar la ventana
        setTitle("RPG Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Crear y configurar las secciones
        createSections();

        createUIComponents();

        // Establecer el panel principal como contenido de la ventana
        setContentPane(mainPanel);
        pack();

        // Hacer visible la ventana
        setVisible(true);
    }

    private void createSections() {
        // Barra de Estado (150 px de altura)
        statusBar = new JPanel();
        statusBar.setBackground(Color.BLUE); // Color de fondo para distinguir la sección
        statusBar.setPreferredSize(new Dimension(WINDOW_SIZE.width, 150));

        // Cargar y redimensionar imagen para la barra de estado
; // Ajusta la ruta a tu imagen

// Agregar imagen al panel de la barra de estado

        // Panel de Juego (370 px de altura)
        gamePanel = new JPanel();
        gamePanel.setBackground(Color.GREEN); // Color de fondo para distinguir la sección
        gamePanel.setPreferredSize(new Dimension(WINDOW_SIZE.width, 370));

        // Cargar y redimensionar image para el panel de juego
        ImageIcon imgGamePanel = new ImageIcon("Background 2.jpg"); // Ajusta la ruta a tu imagen
        Image scaledGamePanelImage = imgGamePanel.getImage().getScaledInstance(WINDOW_SIZE.width, 370, Image.SCALE_SMOOTH);
        JLabel labelGamePanel = new JLabel(new ImageIcon(scaledGamePanelImage));
        gamePanel.add(labelGamePanel); // Agregar imagen al panel de juego

        // Barra de Acción (340 px de altura)
        actionBar = new JPanel();
        actionBar.setBackground(Color.RED); // Color de fondo para distinguir la sección
        actionBar.setPreferredSize(new Dimension(WINDOW_SIZE.width, 340));

        // Cargar y redimensionar imagen para la barra de acción
        ImageIcon imgActionBar = new ImageIcon("Background 3.jpg"); // Ajusta la ruta a tu imagen
        Image scaledActionBarImage = imgActionBar.getImage().getScaledInstance(WINDOW_SIZE.width, 340, Image.SCALE_SMOOTH);
        JLabel labelActionBar = new JLabel(new ImageIcon(scaledActionBarImage));
        actionBar.add(labelActionBar); // Agregar imagen al panel de la barra de acción
    }

    private void createUIComponents() {
            topPanel = new TopPanel();
            middlePanel = new MiddlePanel();
            bottomPanel = new BottomPanel();

            // Otros componentes de la interfaz
            lifeLabel = new BarLabel(100, 100, BarType.LIFE);
            magicLabel = new BarLabel(30, 100, BarType.MAGIC);
            expLabel = new BarLabel(0, 350, BarType.EXPERIENCE);
            button1=new JButton("Play");
        }
          ;// TODO: place custom component creation code here
    }
