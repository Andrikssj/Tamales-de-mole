    package rpg.gui.ui;

    import rpg.utils.cache.ImageCache;

    import javax.swing.*;
    import java.awt.*;

    public class UserHoverUI extends HoverButtonUI {

        private final int staticWidth = 180;

        protected void installDefaults(AbstractButton b) {
            super.installDefaults(b);
            // Establecemos el borde del botón.
            b.setForeground(Color.WHITE);
        }

        @Override
        public Dimension getPreferredSize(JComponent c) {

            return new Dimension(staticWidth, 48);
        }

        protected void initParts() {
            //Inicializamos los arreglos de imágenes.
            parts = new ImageIcon[3];
            partsHover = new ImageIcon[3];
            // Agregamos las imágenes a la caché.
            ImageCache.addImage("actionLeftSide", "buttons/idle/ui/leftSide.png");
            ImageCache.addImage("actionCenterSide", "buttons/idle/ui/centerSide.png");
            ImageCache.addImage("actionRightSide", "buttons/idle/ui/rightSide.png");
            ImageCache.addImage("actionHoverLeftSide", "buttons/hover/ui/leftSide.png");
            ImageCache.addImage("actionHoverCenterSide", "buttons/hover/ui/centerSide.png");
            ImageCache.addImage("actionHoverRightSide", "buttons/hover/ui/rightSide.png");
            // Obtenemos las imágenes de la caché y las almacenamos en los arreglos correspondientes.
            parts[0] = ImageCache.getImageIcon("actionLeftSide");
            parts[1] = ImageCache.getImageIcon("actionCenterSide");
            parts[2] = ImageCache.getImageIcon("actionRightSide");
            partsHover[0] = ImageCache.getImageIcon("actionHoverLeftSide");
            partsHover[1] = ImageCache.getImageIcon("actionHoverCenterSide");
            partsHover[2] = ImageCache.getImageIcon("actionHoverRightSide");
        }

        protected void drawButtonParts(Graphics2D g2d, ImageIcon[] parts) {

            g2d.drawImage(parts[0].getImage(), 0, 0, null);
            g2d.translate(27, 0);
            g2d.drawImage(parts[1].getImage(), 0, 0,
                    staticWidth - 54, height, null);
            g2d.translate(staticWidth - 54, 0);
            g2d.drawImage(parts[2].getImage(), 0, 0, null);
            g2d.translate(-staticWidth + width + 54, 0);
        }
    }
