package rpg.gui.buttons;

import rpg.gui.ui.HoverButtonUI;

import javax.swing.*;

public abstract class BaseButton extends JButton {

    public BaseButton(String text) {

        setText(text);
        initIcons();
        setUI(new HoverButtonUI());
    }

    protected abstract void initIcons();
}
