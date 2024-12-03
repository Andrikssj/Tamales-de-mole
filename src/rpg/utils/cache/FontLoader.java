package rpg.utils.cache;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Clase que se encarga de cargar las fuentes.
 */
public class FontLoader {

    /**
     * Método que se encarga de cargar una fuente.
     *
     * @param path Ruta de la fuente.
     * @return La fuente ya cargada en formato simple y tamaño 12px. En caso de error se regresará la fuente Arial 12.
     */
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
