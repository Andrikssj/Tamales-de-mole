package rpg.gui.buttons;

import rpg.gui.windows.MainWindow;

public class FleeButton extends UserButton {

    public FleeButton(MainWindow game) {

        super("Huir");
        addActionListener(e -> game.tryToFlee());
    }
}