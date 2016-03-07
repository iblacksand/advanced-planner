package tester;
import gui.GuiPopup;
import javax.swing.*;

/**
 * Created by John Elizarraras on 3/6/2016.
 */
public class GuiPopupTester {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                final GuiPopup window = new GuiPopup("hello world", "Good Bye World");
                window.setVisible(true);
            }
        });
    }
}
