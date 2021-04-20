package Swing.code;

import javax.swing.*;
import java.awt.*;

public class App1 {

    private JButton button1;
    private JPanel panel1;

    public App1() {

        button1.addActionListener(e -> {
            System.out.println("Hello bro");
            button1.setBackground(Color.red);
        });

    }

    public static void main(String[] args) {
        JFrame f1 = new JFrame("Hello");
//        f1.setPreferredSize(new Dimension(400, 300));
        f1.setBounds(30, 30, 400, 300);
        f1.add(new App1().panel1);
        f1.setVisible(true);
        f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        f1.pack();
        f1.validate();

    }
}
