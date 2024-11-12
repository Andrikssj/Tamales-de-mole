package rpg.gui.buttons;

public class SaveButton extends BaseButton {

    public SaveButton() {
        super("Guardar");  // El texto del botón será "Guardar"
    }

    @Override
    protected void initIcons() {
        // Aquí puedes inicializar los iconos para el botón de guardar si es necesario
        setIcon(null);  // Puedes establecer el icono aquí si deseas
    }
}
