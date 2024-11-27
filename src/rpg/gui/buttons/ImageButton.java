package rpg.gui.buttons;

import rpg.gui.buttons.BaseButton;

import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class ImageButton extends BaseButton {
    private ImageIcon[] parts;
    private ImageIcon[] partsHover;

    public ImageButton(String text, ImageIcon[] parts, ImageIcon[] partsHover) {
        super(text);
        this.parts = parts;
        this.partsHover = partsHover;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        ImageIcon[] images = isHover() ? partsHover : parts; // Determina si usar imágenes de hover o normales

        if (images != null) {
            g2d.drawImage(images[0].getImage(), 0, 0, null);
            g2d.translate(27, 0); // Mueve la posición
            g2d.drawImage(images[1].getImage(), 27, 0, null);
            g2d.translate(54, 0);
            g2d.drawImage(images[2].getImage(), 54, 0, null);
            g2d.translate(-81, 0); // Restablece la posición
        } else {
            super.paintComponent(g); // Usa la pintura estándar si no hay imágenes
        }
    }

    @Override
    protected void initIcons() {

    }

    private boolean isHover() {
        // Puedes añadir lógica aquí para detectar el estado hover, o usar un MouseAdapter
        return getModel().isRollover();
    }
}

