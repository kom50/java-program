package Swing.code;//package Swing.code;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class OButton extends JButton implements MouseListener{
    int radius, radius1;
    Color startColor = Color.BLACK, endColor = Color.white;

    int startX, startY, endX, endY;
    boolean isFill = true;
    void setFillButton(boolean b){
        isFill = b;
    }
    Color pressColor = Color.lightGray,
            enterColor = Color.lightGray, foregroundColor = Color.WHITE,
            HoverForegroundColor = Color.WHITE;
    boolean isGradient   = true;
    public OButton(){
        this.setContentAreaFilled(false); // fill pain content
        this.setBorder(new EmptyBorder(0, 0, 1, 0));
        this.setFocusable(false);
        startX = startY = 11;
        radius1 = radius = 0;
        endX = endY = 120;
        startColor = Color.BLACK;
        endColor = Color.white;
        this.addMouseListener(this);
    }

    public OButton(String name){
        super(name);
        this.setContentAreaFilled(false); // fill pain content
        this.setBorder(new EmptyBorder(0, 0, 1, 0));
        this.setFocusable(false);
        radius = radius1 = 0;
        startX = startY = 1;
        endX = 130;
        endY = 90;
        startColor = Color.BLACK;
        endColor = Color.white;
        this.addMouseListener(this);
    }

    public void setGradient(boolean b){ this.isGradient = b;  }
    public void setPressedColor(Color color) { this.pressColor = color; }
    public void setHoverColor(Color color) { this.enterColor = color; }
    public void setHoverForegroundColor(Color color){ this.HoverForegroundColor = color; }
    public void setForegroundColor(Color color){
        this.foregroundColor = color;
        this.setForeground(foregroundColor);
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
        this.radius1 = radius;
    }
    public void setBorderRadius(int radius, int radius1){
        this.radius = radius;
        this.radius1 = radius1;
    }
    public  void setStartColor(Color color){
        startColor = color;
    }
    public  void setEndColor(Color color){
        endColor = color;
    }

    Graphics2D graphics2D;
    GradientPaint pain1;
    boolean mouseClick = false, mouseOut = false, mouseEnter = false, mouseExit = false;

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics2D = (Graphics2D) graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if(!isGradient){ // if isGradient is false then button is filled with one color startColor
            graphics.setColor(startColor);
            if (mouseClick) {
                mouseClick = false;
                graphics.setColor(pressColor);
            }
            if (mouseOut) {
                mouseOut = false;
                graphics.setColor(startColor);
            }
            if (mouseEnter) {
                mouseEnter = false;
                this.setForeground(HoverForegroundColor);
                graphics.setColor(enterColor);
            }
            if (mouseExit) {
                mouseExit = false;
                this.setForeground(foregroundColor);
                graphics.setColor(startColor);
            }
            System.out.println("Hello paint () " + startX + " " + startY + " " + endX + " " + endY);
            System.out.println("Gradient option " + isGradient);
            if (isFill)
                graphics.fillRoundRect(0, 0, OButton.this.getWidth(), OButton.this.getHeight(), this.radius, this.radius1);
            else
                graphics.drawRoundRect(0, 0, OButton.this.getWidth() - 1, OButton.this.getHeight() - 1, this.radius, this.radius1);
            super.paint(graphics);
        }else {
            pain1 = new GradientPaint(startX, startY, startColor, endX, endY, endColor);
            if (mouseClick) {
                mouseClick = false;
                pain1 = new GradientPaint(startX, startY, pressColor, endX, endY, pressColor);
            }
            if (mouseOut) {
                mouseOut = false;
                pain1 = new GradientPaint(startX, startY, startColor, endX, endY, endColor);
            }
            if (mouseEnter) {
                mouseEnter = false;
                this.setForeground(HoverForegroundColor);
                pain1 = new GradientPaint(startX, startY, enterColor, endX, endY, enterColor);
            }
            if (mouseExit) {
                this.setForeground(foregroundColor);
                mouseExit = false;
                pain1 = new GradientPaint(startX, startY, startColor, endX, endY, endColor);
            }
            System.out.println("Hello paint () " + startX + " " + startY + " " + endX + " " + endY);
            graphics2D.setPaint(pain1);
            System.out.println("Gradient option " + isGradient);

            if (isFill)
                graphics2D.fillRoundRect(0, 0, OButton.this.getWidth(), OButton.this.getHeight(), this.radius, this.radius1);
            else
                graphics2D.drawRoundRect(0, 0, OButton.this.getWidth() - 1, OButton.this.getHeight() - 1, this.radius, this.radius1);
            super.paint(graphics2D);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Mouse pressed");
        mouseClick = true;
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Mouse Released");
        mouseOut = true;
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Mouse Entered");
        mouseEnter = true;
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Mouse Exited");
        mouseExit = true;
        repaint();
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setBounds(80, 50, 400, 400);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setBackground(Color.white);

        OButton com = new OButton();
        com.setText("Java Om");
        com.setFont(new Font("Arial", Font.BOLD, 20));
        com.setForeground(Color.CYAN);
        com.setBorderRadius(10);
        com.setEndColor(Color.green);
        com.setStartColor(Color.blue);
//        com.setStartX(10);
//        com.setStartY(10);
        com.setEndY(100);
        com.setEndX(40);


        com.setBounds(100, 100, 180, 50);
        com.setBorderRadius(20);
        com.setHoverColor(Color.BLUE);
        com.setForegroundColor(Color.BLACK);
        com.setFillButton(false);

        com.addActionListener( event -> System.out.println("Button clicked"));
        frame.getContentPane().add(com);
        OButton btn = new OButton("JAVA");
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

        frame.getContentPane().setBackground(Color.white);
    }
}
