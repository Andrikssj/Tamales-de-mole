package rpg.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public interface WindowConstants {
    Dimension MIDDLE_DIMENSION = new Dimension(800, 600);
    Dimension WINDOW_SIZE = new Dimension(1280, 720);
    Insets WINDOW_INSETS = new Insets(10, 10, 10, 10);
    Dimension TOP_DIMENSION = new Dimension(800, 600); // Ajusta el tamaño según tus necesidades
        /**
         * Ancho de la ventana.
         */
        int WINDOW_WIDTH = 1500;
        /**
         * Alto de la parte superior de la ventana.
         */
        int TOP_HEIGHT = 150;
        /**
         * Alto de la parte media de la ventana.
         */
        int MIDDLE_HEIGHT = 320;
        /**
         * Alto de la parte inferior de la ventana.
         */
        int BOTTOM_HEIGHT = 350;
        /**
         * Margen simple.
         */
        int SIMPLE_MARGIN = 18;
        /**
         * Dimensión de la parte superior de la ventana.
         */
        /**
         * Dimensión de la parte inferior de la ventana.
         */
        Dimension BOTTOM_DIMENSION = new Dimension(WINDOW_WIDTH, BOTTOM_HEIGHT);
        /**
         * Borde vacío de margen simple. Que se puede usar para dar un margen a los paneles.
         */
        EmptyBorder EMPTY_BORDER = new EmptyBorder(SIMPLE_MARGIN, SIMPLE_MARGIN,
                SIMPLE_MARGIN, SIMPLE_MARGIN);
    }


