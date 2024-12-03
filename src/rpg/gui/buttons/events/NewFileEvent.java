package rpg.gui.buttons.events;

import rpg.entities.Player;
import rpg.gui.windows.MainWindow;
import rpg.gui.windows.NewFileWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewFileEvent implements ActionListener {

    int slot;
    NewFileWindow window;

    public NewFileEvent(int slot, NewFileWindow window) {
        this.slot = slot;
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        window.dispose();
        Player player = new Player(window.getName());
        player.save(slot);
        new MainWindow(player, slot);
    }
}
