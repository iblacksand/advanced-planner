package tester;

import gui.GuiWindow;

import javax.swing.*;

/**
 * Created by John Elizarraras on 3/5/2016.
 */
public class GuiWindowTester {
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                final GuiWindow window = new GuiWindow("hello world");
                window.setVisible(true);
            }
        });
    }
}
