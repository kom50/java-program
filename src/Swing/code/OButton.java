package Swing.code;//package Swing.code;
import javax.swing.*;
import java.awt.*;

public class OButton extends JButton {
    int radius;
    Color startColor = Color.BLACK, endColor = Color.white;

    int startX, startY, endX, endY;

    public OButton(){
        startX = startY = 11;
        radius = 0;
        endX = endY = 120;
        startColor = Color.BLACK;
        endColor = Color.white;
    }

    public OButton(String name){
        super(name);
        radius = 0;
        startX = startY = 1;
        endX = 70;
        endY = 20;
        startColor = Color.BLACK;
        endColor = Color.white;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public void setEndX(int endX) {
        this.endX = endX;
    }

    public void setEndY(int endY) {
        this.endY = endY;
    }


    public void setBorderRadius(int radius){
        this.radius = radius;
    }
    public  void setStartColor(Color color){
        startColor = color;
    }
    public  void setEndColor(Color color){
        endColor = color;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        GradientPaint pain1 =new  GradientPaint(startX, startY,startColor, endX, endY, endColor);
        System.out.println("Hello paint () "+startX+" "+startY+" "+endX+" "+endY);
        g2.setPaint(pain1);
        g2.fillRoundRect(0, 0, OButton.this.getWidth(),OButton.this.getHeight(), this.radius, this.radius);
        super.paint(g2);
    }



    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setBounds(80, 50, 400, 400);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setBackground(Color.white);

        OButton com = new OButton();
        com.setContentAreaFilled(false); // fill pain content   
        com.setBorder(null);
        com.setText("Java Om");
        com.setFont(new Font("Arial", Font.BOLD, 20));
        com.setForeground(Color.CYAN);
        com.setFocusable(false);

        com.setEndColor(Color.BLUE);
        com.setStartColor(Color.YELLOW);
//        com.setStartX(10);
//        com.setStartY(10);
//        com.setEndY(100);
//        com.setEndX(40);


        com.setBounds(100, 100, 180, 50);
        com.setBorderRadius(20);

        com.addActionListener( event -> System.out.println("Button clicked"));
        frame.getContentPane().add(com);

        frame.getContentPane().setBackground(Color.white);
    }
}
