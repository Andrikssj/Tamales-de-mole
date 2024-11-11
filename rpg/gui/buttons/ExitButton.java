package rpg.gui.buttons;

public class ExitButton extends BaseButton {

    public ExitButton() {
        super("Salir");  // El texto del botón será "Salir"
    }

    @Override
    protected void initIcons() {
        setIcon(null);  // Puedes establecer el icono aquí si deseas
    }
}
