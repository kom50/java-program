package Swing.code;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

;
public class PButton extends JButton {
    int radius, radius1;
    Color startColor = Color.BLACK, endColor = Color.white;
    int startX, startY, endX, endY;
    boolean isFill = true;
    Color pressColor = Color.lightGray,
            hoverColor = Color.lightGray, foregroundColor = Color.WHITE,
            HoverForegroundColor = Color.RED;

    boolean isGradient   = true;
    public PButton(){
        this.setContentAreaFilled(false); // fill pain content
        this.setBorder(new EmptyBorder(0, 0, 1, 0));
        this.setFocusable(false);
        this.setForeground(foregroundColor);
        startX = startY = 11;
        radius1 = radius = 0;
        endX = endY = 120;
        startColor = Color.BLACK;
        endColor = Color.white;
    }

    public PButton(String name){
        super(name);
        this.setContentAreaFilled(false); // fill pain content
        this.setBorder(new EmptyBorder(0, 0, 1, 0));
        this.setFocusable(false);
        this.setForeground(foregroundColor);
        radius = radius1 = 0;
        startX = startY = 1;
        endX = 130;
        endY = 90;
        startColor = Color.BLACK;
        endColor = Color.white;
    }

    public void setFillButton(boolean b){  this.isFill = b; }
    public void setGradient(boolean b){ this.isGradient = b;  }
    public void setPressedColor(Color color) { this.pressColor = color; }
    public void setHoverColor(Color color) { this.hoverColor = color; }
    public void setHoverForegroundColor(Color color){ this.HoverForegroundColor = color; }
    public void setForegroundColor(Color color){
        this.foregroundColor = color;
        this.setForeground(foregroundColor);
    }
    public void setStartX(int startX) {   this.startX = startX; }
    public void setStartY(int startY) {   this.startY = startY;    }
    public void setEndX(int endX) {   this.endX = endX;    }
    public void setEndY(int endY) {   this.endY = endY;    }

    public  void setStartColor(Color color){ this. startColor = color;   }
    public  void setEndColor(Color color){ this.endColor = color;   }


    public void setBorderRadius(int radius){
        this.radius = radius;
        this.radius1 = radius;
    }
    public void setBorderRadius(int radius, int radius1){
        this.radius = radius;
        this.radius1 = radius1;
    }
    Graphics2D graphics2D;
    GradientPaint pain1;
    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics2D = (Graphics2D) graphics;
        ButtonModel model = this.getModel();
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if(!isGradient){ // if isGradient is false then button is filled with one color startColor
            graphics.setColor(startColor);
            if (model.isPressed()) {
                System.out.println("Mouse pressed");
                graphics.setColor(pressColor);
            }else if (model.isRollover()) {
                System.out.println("Mouse over");
                this.setForeground(HoverForegroundColor);
                graphics.setColor(hoverColor);
            }
            else {
                System.out.println("Mouse released");
                graphics.setColor(startColor);
                this.setForeground(foregroundColor);
            }
            if (model.isArmed()){
                System.out.println("Is armed");
            }
//            System.out.println("Hello paint () " + startX + " " + startY + " " + endX + " " + endY);
            if (isFill)
                graphics.fillRoundRect(0, 0, PButton.this.getWidth(), PButton.this.getHeight(), this.radius, this.radius1);
            else{
//                graphics.drawRoundRect(2, 2, PButton.this.getWidth() - 4, PButton.this.getHeight() - 4, this.radius, this.radius1);
                graphics.fillRoundRect(0, 0, PButton.this.getWidth() - 1, PButton.this.getHeight() - 1, this.radius, this.radius1);
            }
            super.paint(graphics);
        }else {
            System.out.println("Gradient Button color ");
            pain1 = new GradientPaint(startX, startY, startColor, endX, endY, endColor);
            if (model.isPressed()) {
                System.out.println("Mouse pressed");
                pain1 = new GradientPaint(startX, startY, pressColor, endX, endY, pressColor);
            }else if (model.isRollover()) {
                System.out.println("Mouse over");
                this.setForeground(HoverForegroundColor);
                pain1 = new GradientPaint(startX, startY, hoverColor, endX, endY, hoverColor);
            }
            else {
                pain1 = new GradientPaint(startX, startY, startColor, endX, endY, endColor);
                System.out.println("Mouse released");
                setForeground(foregroundColor);
            }
//            System.out.println("Hello paint () " + startX + " " + startY + " " + endX + " " + endY);
            graphics2D.setPaint(pain1);
            if (isFill)
                graphics2D.fillRoundRect(0, 0, PButton.this.getWidth(), PButton.this.getHeight(), this.radius, this.radius1);
            else
                graphics2D.drawRoundRect(0, 0, PButton.this.getWidth() - 1, PButton.this.getHeight() - 1, this.radius, this.radius1);
            super.paint(graphics2D);
        }
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setBounds(80, 50, 400, 400);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setBackground(Color.white);

        PButton com = new PButton();
        com.setText("Java Om");
        com.setFont(new Font("Arial", Font.BOLD, 20));
        com.setForeground(Color.CYAN);
        com.setBorderRadius(10);
        com.setEndColor(Color.green);
        com.setStartColor(Color.blue);
        com.setBorderRadius(10, 50);

//        com.setStartX(10);
//        com.setStartY(10);
        com.setEndY(100);
        com.setEndX(40);


        com.setBounds(100, 100, 180, 50);
        com.setBorderRadius(90);
        com.setHoverColor(Color.BLUE);
        com.setForegroundColor(Color.BLACK);
        com.setGradient(false);
        com.setStartColor(Color.orange);
        com.setHoverColor(Color.green);
        com.setHoverForegroundColor(Color.GRAY);
        com.setForegroundColor(Color.red);
//        com.addActionListener( event -> System.out.println("Button clicked"));
        frame.getContentPane().add(com);
        PButton btn = new PButton("JAVA");
        btn.setBounds(140, 190, 100, 60);
        frame.getContentPane().add(btn);
        btn.setForeground(Color.BLUE);
        btn.setFillButton(true);
        btn.setFont(new Font("Arail", Font.BOLD, 18));
        btn.setBorderRadius(50, 110);
//        btn.setHoverColor(Color.red);
//        btn.setGradient(false);
        btn.setStartColor(Color.BLUE);

        btn.setForeground(Color.getHSBColor(10, 30, 40));
        btn.setHoverForegroundColor(Color.YELLOW);
        btn.setHoverColor(Color.CYAN);

        frame.getContentPane().setBackground(Color.BLUE);


        PButton b1 = new PButton("JAVA");
        b1.setBounds(100, 300, 60, 40);
        frame.getContentPane().add(b1);

    }
}
