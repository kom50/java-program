package Swing.code;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
public class Calculator extends JFrame implements ActionListener {
    JButton[] jb;
    JTextField text;
    String[] icon;
    char[] op;
    ScriptEngine engine = new  ScriptEngineManager().getEngineByName("JavaScript");
    public Calculator() {
        super("Calculator");
        setVisible(true);
        setBounds(200, 50, 300, 480);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 2, 2, 2);
        op = new char[] { '%', '/', '*', '+', '-', '.' };
        icon = new String[] { "pw", "C", "<-", "/", "7", "8", "9", "*", "4", "5", "6", "-", "1", "2", "3", "+", "%",
                "0", ".", "=" };
        jb = new JButton[20];
        for (int i = 0; i < jb.length; i++) {
            jb[i] = new JButton();
            jb[i].setBackground(Color.white);
            jb[i].setForeground(Color.blue);
            jb[i].setPreferredSize(new Dimension(60, 60));
            jb[i].setFont(new Font("Arial", Font.BOLD, 18));
            jb[i].addActionListener(this);
        }
        int l = 0;
        for (int i = 1; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                jb[l].setText(icon[l]);
                gbc.fill = GridBagConstraints.HORIZONTAL;
                gbc.gridx = j;
                gbc.gridy = i;
                add(jb[l], gbc);
                jb[l].setBorder(BorderFactory.createLineBorder(Color.darkGray, 1, true));
                l++;
            }
        }


        text = new JTextField();
        text.setEditable(false);
        text.setBorder(BorderFactory.createLineBorder(Color.blue, 2, true));
        jb[1].setDefaultCapable(false);
        text.setHorizontalAlignment(JTextField.RIGHT);
        text.setBackground(Color.white);
        text.setPreferredSize(new Dimension(200, 40));
        text.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        add(text, gbc);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        validate();
        this.pack();
        this.setResizable(false);
    }
    //
    Object ans = null;
    public void actionPerformed(ActionEvent e) {
        String s;
        if (text.getText().indexOf('=') != -1){
            text.setText(ans.toString());
        }

        Object obj = e.getSource();
        for (int i = 3; i < jb.length - 1; i++) {
            if (obj == jb[i]) {
                if (i != 3 && i != 7 && i != 11 && i != 15 && i != 16 && i != 18)
                    text.setText(text.getText() + jb[i].getText());
            }
        }
        if (obj == jb[0]) {
            if (!text.getText().isEmpty()) {
                double d = Double.parseDouble(text.getText());
                text.setText(String.valueOf(d * d));
            }
        }
        if (obj == jb[2]) {
            s = text.getText();
            if (!s.isEmpty()) {
                text.setText(s.substring(0, s.length() - 1));
            }
        }
        if (obj == jb[1]) {
            text.setText("");
        }
        if (obj == jb[18]) {
            s = text.getText();
            if(s.isEmpty() || isDigit(s.charAt(s.length() - 1))){
                text.setText(s + "0.");
            }else {
                int f = 0, i;
                for (i = s.length() - 1; i >= 0; i--) {
                    for (char c : op) {
                        if (s.charAt(i) == c) {
                            f = 1;
                            break;
                        }
                    }
                    if (f == 1)
                        break;
                }
                if(s.indexOf('.', i) == -1)
                    text.setText(s + ".");
            }
        }
        if (obj == jb[3]) {
            s = text.getText();
            if (!s.isEmpty() && s.charAt(0) != '-') {
                if (isDigit(s.charAt(s.length() - 1))) {
                    s = s.substring(0, s.length() - 1);
                }
                text.setText(s + "/");
            }
        }
        if (obj == jb[7]) {
            s = text.getText();
            if (!s.isEmpty() && s.charAt(0) != '-') {
                if (isDigit(s.charAt(s.length() - 1))) {
                    s = s.substring(0, s.length() - 1);
                }
                text.setText(s + "*");
            }
        }
        if (obj == jb[11]) {
            s = text.getText();
            if (!s.isEmpty()) {
                if (isDigit(s.charAt(s.length() - 1))) {
                    s = s.substring(0, s.length() - 1);
                }
                text.setText(s + "-");
            }
            if (s.isEmpty())
                text.setText(s + "-");
        }
        if (obj == jb[15]) {
            s = text.getText();
            if (!s.isEmpty() && s.charAt(0) != '-') {
                if (isDigit(s.charAt(s.length() - 1))) {
                    s = s.substring(0, s.length() - 1);
                }
                text.setText(s + "+");
            }
        }
        if (obj == jb[16]) {
            boolean f = false;
            s = text.getText();
            if (!s.isEmpty() && s.charAt(0) != '-') {
                for (char c : op) {
                    if (s.charAt(s.length() - 1) == c) {
                        f = true;
                    }
                }
                if (!f)
                    text.setText(s + "%");
            }
        }
        // equal button code
        if (obj == jb[icon.length - 1]) {
            if (!text.getText().isEmpty()) {
                try {
                    String exp = text.getText();
                    ans = engine.eval(text.getText());  //  call JavaScript eval()  function
                    text.setText(exp +" = "+ans.toString());   // Convert object to String and then pass in method
                } catch (ScriptException scriptException) {
                    scriptException.printStackTrace();
                }
            }
        }
    }
    // If character is digit then this method return False and otherwise return True
    boolean isDigit(char ch) {
        return (ch < 48 || ch > 57) && ch != '.';
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Calculator::new); // Method reference
    }
}