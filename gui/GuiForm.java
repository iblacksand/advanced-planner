package gui;

import javax.swing.*;

/**
 * Created by John Elizarraras on 3/7/2016.
 */
public class GuiForm extends JFrame{
    private JButton testButton;
    private JPanel rootPanel;
    private JTextField insertTextHereTextField;
    private JProgressBar progressBar1;

    public GuiForm(){
        super("Hello");
        setContentPane(rootPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
