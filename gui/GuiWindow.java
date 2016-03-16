package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by John Elizarraras on 3/5/2016.
 */
public class GuiWindow extends JFrame{

    public GuiWindow(String input){
        super("Advanced Planner");
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                GuiWindow.this.setVisible(false);
                GuiWindow.this.dispose();
            }
        });
        JTextField textField = new JTextField("Write Code Here");
        add(textField);
        final JLabel test  =new JLabel();
        test.setText("Hello");
        add(test);
        final JButton btn = new JButton("Exit");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               JLabel temp = new JLabel(textField.getText());
                add(temp);
                pack();
            }
        });
        setLayout(new FlowLayout());
        add(btn);
        pack();
    }
}
