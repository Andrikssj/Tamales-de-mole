package rpg.gui.buttons;

import rpg.gui.ui.HoverButtonUI;

public abstract class UserButton extends BaseButton {

    public UserButton(String text) {
        super(text);
        // Agregamos los iconos a la caché de imágenes.
        setIcon(null);
        setRolloverIcon(null);
        setUI(new HoverButtonUI());
    }

    @Override
    protected void initIcons() {
        // No se inicializan iconos.
    }
}