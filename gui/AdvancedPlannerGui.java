package gui;

import compile.Compiler;
import main.AdvancedPlanner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;

/**
 * Created by John Elizarraras on 3/15/2016.
 */
public class AdvancedPlannerGui extends JFrame{
    public static void main(String[] args){
        AdvancedPlannerGui gui = new AdvancedPlannerGui();
    }

    public AdvancedPlannerGui(){
        setTitle("Advanced Planner");
        JTextField textField = new JTextField("Put File Name Here");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JButton button = new JButton("Run");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] file = {textField.getText()};
                AdvancedPlanner.main(file);
            }
        });
        JButton compile = new JButton("Compile");
        compile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isFile(textField.getText())) {
                    Compiler compiler = new Compiler(textField.getText());
                    if (compiler.errors() > 0) {
                        add(new JLabel("Error in code!"));
                    }
                    else {
                        add(button);
                    }
                }
                else add(new JLabel("Not a File!"));
            }
        });
        JButton exit = new JButton("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dialog = JOptionPane.YES_NO_OPTION;
                int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to close?", "Advanced Planner", dialog);
                if(result == 0) System.exit(0);
            }
        });
        add(exit);
        setLayout(new FlowLayout());
        add(textField);
        add(compile);
        pack();
        setVisible(true);
    }

    private boolean isFile(String name){
        boolean res = true;
        try {
            FileReader f = new FileReader(name);
        }
        catch(Exception e){
            res = false;
        }
        return res;
    }
}
