package lesson4.L4;

import javax.swing.*;

public class MainFrame extends JFrame {

    public MainFrame(){
        setTitle("Frame");
        setBounds(100,100,400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);


        JTextField jTextF = new JTextField();
        jTextF.addActionListener(actionEvent -> {
            System.out.println("Enter pressed");
        });
        jTextF.setVisible(true);
        jTextF.setBounds(100,100,100,50);
        add(jTextF);
    }
}
