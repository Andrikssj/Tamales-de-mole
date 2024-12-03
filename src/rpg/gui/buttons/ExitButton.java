package rpg.gui.buttons;

public class ExitButton extends UserButton {

    public ExitButton() {

        super("Salir");
        addActionListener(e -> System.exit(0));
    }
}
