package rpg.gui.buttons;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BaseButton extends JButton {

    private Color backgroundColor = Color.LIGHT_GRAY;
    private Color hoverColor = Color.GRAY;
    private Color pressedColor = Color.DARK_GRAY;
    private Color textColor = Color.BLACK;
    private Font font = new Font("Arial", Font.BOLD, 16);

    public BaseButton(String text) {
        super(text);
        setFont(font);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setOpaque(true);

        // Añadir comportamiento para cambiar el color en función del estado del botón
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(backgroundColor);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(pressedColor);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setBackground(hoverColor);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRect(34, 35, getWidth(), getHeight());
        super.paintComponent(g);
    }

    // Métodos para personalizar colores y fuente
    public void setBackgroundColor(Color color) {
        this.backgroundColor = color;
        setBackground(color);
    }

    public void setHoverColor(Color color) {
        this.hoverColor = color;
    }

    public void setPressedColor(Color color) {
        this.pressedColor = color;
    }

    public void setTextColor(Color color) {
        this.textColor = color;
        setForeground(color);
    }

    public void setFont(Font font) {
        this.font = font;
        super.setFont(font);
    }
}
