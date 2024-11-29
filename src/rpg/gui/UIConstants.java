package rpg.gui;

import javax.swing.border.EmptyBorder;
import java.awt.*;

public interface UIConstants {
    Font FONT = FontCache.addFont("PIXM", "fonts/CourierPrime-Bold.ttf");
    Font BAR_LABEL_FONT = FontCache.addFont("PAE", "fonts/CourierPrime-Italic.ttf").deriveFont(16f);
    Font LABEL_FONT = FontCache.addFont("Retron", "fonts/CourierPrime-Regular.ttf").deriveFont(Font.BOLD,18f);
    int WINDOW_WIDTH = 1500;
    int TOP_HEIGHT = 150;
    int MIDDLE_HEIGHT = 320;
    int BOTTOM_HEIGHT = 350;
    int SIMPLE_MARGIN = 18;
    int CORNER_WIDTH = 52;
    int CORNER_HEIGHT = 77;
    int CENTER_WIDTH = 350 - 2 * CORNER_WIDTH;
    Dimension BAR_ICON = new Dimension(58, 58);
    Dimension BAR_DISPLAY = new Dimension(179, 58);
    Dimension TOP_DIMENSION = new Dimension(69, 89);
    Dimension MIDDLE_DIMENSION = new Dimension(WINDOW_WIDTH, MIDDLE_HEIGHT);
    Dimension BOTTOM_DIMENSION = new Dimension(WINDOW_WIDTH, BOTTOM_HEIGHT);
    Dimension CORNER_DIMENSION = new Dimension(52, 77);
    Dimension CENTER_DIMENSION = new Dimension(CENTER_WIDTH, 77);
    Dimension BAR_LABEL = new Dimension(172, 51);
    EmptyBorder EMPTY_BORDER = new EmptyBorder(14, SIMPLE_MARGIN,
            SIMPLE_MARGIN, SIMPLE_MARGIN);
}