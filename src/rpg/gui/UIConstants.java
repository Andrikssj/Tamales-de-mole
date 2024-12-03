package rpg.gui;

import rpg.utils.cache.FontCache;

import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Constantes para las dimensiones de las ventanas.
 */
public interface UIConstants {
    Font FONT = FontCache.addFont("PIXM", "fonts/M6X.ttf");
    Font BAR_LABEL_FONT = FontCache.addFont("PAE", "fonts/PixelAE.ttf").deriveFont(16f);
    Font LABEL_FONT = FontCache.addFont("Retron", "fonts/Retron2000.ttf").deriveFont(Font.BOLD, 18f);
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
    int INTERNAL_FRAME_HEADER_HEIGHT = 77;
    int STATUS_FRAME_WIDTH = 565;
    int STATUS_FRAME_HEIGHT = 715;
    int SIMPLE_MARGIN = 18;
    int CORNER_WIDTH = 52;
    int CORNER_HEIGHT = 77;
    int CENTER_WIDTH = 350 - 2 * CORNER_WIDTH;
    Dimension BAR_ICON = new Dimension(58, 58);
    Dimension BAR_DISPLAY = new Dimension(179, 58);
    /**
     * Dimensión de la parte superior de la ventana.
     */
    Dimension TOP_DIMENSION = new Dimension(WINDOW_WIDTH, TOP_HEIGHT);
    /**
     * Dimensión de la parte media de la ventana.
     */
    Dimension MIDDLE_DIMENSION = new Dimension(WINDOW_WIDTH, MIDDLE_HEIGHT);
    /**
     * Dimensión de la parte inferior de la ventana.
     */
    Dimension BOTTOM_DIMENSION = new Dimension(WINDOW_WIDTH, BOTTOM_HEIGHT);
    Dimension START_WINDOW_DIMENSION = new Dimension(800, 600);
    Dimension FILES_PANEL_DIMENSION = new Dimension(786, 563);
    Dimension CORNER_DIMENSION = new Dimension(52, 77);
    Dimension CENTER_DIMENSION = new Dimension(CENTER_WIDTH, 77);
    /**
     *
     */
    Dimension BAR_LABEL = new Dimension(172, 51);
    Dimension MESSAGE_DIMENSION = new Dimension(1100, 287);
    Dimension NEW_PLAYER_PANEL_DIMENSION = new Dimension(786, 250);
    /**
     * Borde vacío de margen simple. Que se puede usar para dar un margen a los paneles.
     */
    EmptyBorder EMPTY_BORDER = new EmptyBorder(14, SIMPLE_MARGIN,
            SIMPLE_MARGIN, SIMPLE_MARGIN);
}
