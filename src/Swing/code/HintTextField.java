package Swing.code;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JTextField;
//This class is use to create placeholder textField in java Swing
public class HintTextField extends JTextField implements FocusListener{

    private static final long serialVersionUID = 1L;
    boolean showHint = true;
    String hint;
    // if set Field as a password field then below field are useful
    boolean isPasswordField = false;
    char echoChar;
    StringBuilder password;
    String text = "";

    public HintTextField(String hint) {
        super(hint);
        this.hint = hint;
        this.showHint = true;
        this.echoChar ='#';
        super.addFocusListener(this);
        super.setForeground(Color.LIGHT_GRAY);
    }

    public void setPasswordField(boolean b) {
        this.isPasswordField = b;
        if (isPasswordField) {
            ArrayList<Character> pass = new ArrayList<>();
            this.addKeyListener(new KeyAdapter() {
                public void keyReleased(KeyEvent event) {
                    event.setKeyChar(echoChar); // set key char
                    text += event.getKeyChar();  // then get character and add in text string

                    String str = HintTextField.this.getText();
                    pass.add(str.charAt(str.length() - 1));  // add last input character in password arrayList

                    password = new StringBuilder();
                    for(Character pp : pass)
                        password.append(pp);

                    System.out.println(text+"  "+str+" : "+pass+" Password :- "+password);
                    HintTextField.this.setText(text);
                }
            });
        }
    }
    public void setEchoChar(char ch) {  this.echoChar = ch;  }
    public char getEchoChar() { return this.echoChar; }
    public boolean isPasswordField() {  return isPasswordField;   }
    public String getPassword(){ return password.toString();  }

    @Override
    public void focusGained(FocusEvent e) {
        if(this.getText().isEmpty()) {
            super.setText("");
            showHint = false;
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if(this.getText().isEmpty()) {
            this.setText(hint);
            showHint = true;
        }
        if(!showHint) {
            super.setForeground(Color.black);
        }else {
            super.setForeground(Color.lightGray);
        }
    }
    @Override
    public String getText() {
        return showHint ? "" : super.getText();
    }
}
