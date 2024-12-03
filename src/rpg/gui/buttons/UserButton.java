package rpg.gui.buttons;

import rpg.gui.ui.UserHoverUI;

public abstract class UserButton extends BaseButton {

    public UserButton(String text) {
        super(text);
        // Agregamos los iconos a la caché de imágenes.
        setIcon(null);
        setRolloverIcon(null);
        setUI(new UserHoverUI());
    }

    @Override
    protected void initIcons() {
        // No se inicializan iconos.
    }
}
