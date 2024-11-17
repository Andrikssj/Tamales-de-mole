package rpg.utils.cache;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class FontLoader {

    public static Font loadFont(String path) {

        try {

            return Font.createFont(Font.TRUETYPE_FONT, new File(path)).deriveFont(12f);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar la fuente: " + path,
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        return Font.getFont("Arial").deriveFont(12f);
    }
}