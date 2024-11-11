package rpg.gui.buttons;

public class InventoryButton extends BaseButton {

    public InventoryButton() {
        super("Inventario");  // El texto del botón será "Inventario"
    }

    @Override
    protected void initIcons() {
        setIcon(null);  // Puedes establecer el icono aquí si deseas
    }
}
