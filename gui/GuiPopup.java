package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by John Elizarraras on 3/5/2016.
 */
public class GuiPopup extends JFrame {
    public GuiPopup(String title, String input) {
        super(title);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                GuiPopup.this.setVisible(false);
                GuiPopup.this.dispose();
            }
        });
        final JLabel test = new JLabel();
        test.setText(input);
        add(test);
        setLayout(new FlowLayout());
        pack();
    }
}
