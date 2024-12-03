package rpg.gui.labels.events;

import rpg.gui.windows.MainWindow;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ShowStatusEvent extends MouseAdapter {

    private MainWindow mainWindow;

    public ShowStatusEvent(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        mainWindow.getStatusFrame().setVisible(true);
    }
}
