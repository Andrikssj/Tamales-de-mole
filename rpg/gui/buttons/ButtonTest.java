package rpg.gui.buttons;

import javax.swing.JFrame;
import rpg.gui.buttons.BaseButton;
import java.awt.Color;

public class ButtonTest extends JFrame {
    public ButtonTest() {
        // Crear una instancia de BaseButton
        BaseButton myButton = new BaseButton("Click Me");
        myButton.setBackgroundColor(Color.BLUE); // Personalizar el botón
        myButton.setHoverColor(Color.CYAN);
        myButton.setPressedColor(Color.DARK_GRAY);
        myButton.setTextColor(Color.WHITE);

        // Configurar la ventana
        add(myButton);
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        // Ejecutar la ventana de prueba
        new ButtonTest();
    }
}
