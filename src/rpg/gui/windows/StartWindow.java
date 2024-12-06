package rpg.gui.windows;

import rpg.entities.Player;
import rpg.enums.Stats;
import rpg.gui.UIConstants;
import rpg.gui.buttons.LoadFileButton;
import rpg.gui.buttons.NewFileButton;
import rpg.gui.labels.NameLabel;
import rpg.gui.panels.FilesPanel;
import rpg.gui.ui.NameLabelUI;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class StartWindow extends JFrame {
    private JPanel mainPanel;
    private JButton newFile1;
    private JButton loadFile1;
    private JLabel titleLabel;
    private JLabel file1Name;
    private JLabel file2Name;
    private JLabel file3Name;
    private JLabel file4Name;
    private JLabel file5Name;
    private JButton newFile2;
    private JButton newFile3;
    private JButton newFile4;
    private JButton newFile5;
    private JButton loadFile2;
    private JButton loadFile3;
    private JButton loadFile4;
    private JButton loadFile5;

    public static void main(String[] args) {
        new StartWindow();
    }

    public StartWindow() {
        this.setContentPane(mainPanel);
        this.setTitle("Java RPG");
        this.setSize(UIConstants.START_WINDOW_DIMENSION);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        update();
    }

    public void update() {

        for (int i = 1; i <= 5; i++) {
            /**
             * Carga el nombre de la partida en el slot correspondiente.
             */
            JLabel slotLabel = null;
            String slotName;
            Player player;
            JButton newFileButton;
            JButton loadFileButton;
            try {

                slotLabel = (JLabel) getClass()
                        .getDeclaredField("file" + i + "Name").get(this);
                newFileButton = (JButton) getClass()
                        .getDeclaredField("newFile" + i).get(this);
                loadFileButton = (JButton) getClass()
                        .getDeclaredField("loadFile" + i).get(this);
                if (isFileEmpty(i)) {

                    slotLabel.setText("-- Vació --");
                    slotLabel.setUI(new NameLabelUI());
                    newFileButton.setVisible(true);
                    loadFileButton.setVisible(false);
                    continue;
                } else {
                    newFileButton.setVisible(false);
                    loadFileButton.setVisible(true);
                    player = Player.load(i);
                }
                if (player != null) {
                    slotName = String.format("%s - NIVEL: %d",
                            player.getName().toUpperCase(),
                            player.getStats().get(Stats.LEVEL));
                    slotLabel.setText(slotName);
                    slotLabel.setUI(new NameLabelUI());
                }
            } catch (IllegalAccessException | NoSuchFieldException e) {

                JOptionPane.showMessageDialog(null, "Error al cargar la partida " + i,
                        "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {

                slotLabel.setText("-- Vació --");
                slotLabel.setUI(new NameLabelUI());
                try {
                    loadFileButton = (JButton) getClass()
                            .getDeclaredField("loadFile" + i).get(this);
                    loadFileButton.setVisible(false);
                } catch (IllegalAccessException | NoSuchFieldException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private void createUIComponents() {

        mainPanel = new FilesPanel();
        titleLabel = new JLabel("Java RPG");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        file1Name = new NameLabel("");
        newFile1 = new NewFileButton(1, this);
        loadFile1 = new LoadFileButton(1, this);
        file2Name = new NameLabel("");
        newFile2 = new NewFileButton(2, this);
        loadFile2 = new LoadFileButton(2, this);
        file3Name = new NameLabel("");
        newFile3 = new NewFileButton(3, this);
        loadFile3 = new LoadFileButton(3, this);
        file4Name = new NameLabel("");
        newFile4 = new NewFileButton(4, this);
        loadFile4 = new LoadFileButton(4, this);
        file5Name = new NameLabel("");
        newFile5 = new NewFileButton(5, this);
        loadFile5 = new LoadFileButton(5, this);
    }

    private boolean isFileEmpty(int slot) {

        return !new File("files/save" + slot + ".dat").exists();
    }
}
