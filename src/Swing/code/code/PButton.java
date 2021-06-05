package Swing.code.code;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
public class PButton extends JButton {
    /* Variable 	 */
	private static final long serialVersionUID = 1L;
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
        this.setPreferredSize(new Dimension(60, 30));
        
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
        this.setPreferredSize(new Dimension(60, 30));
        
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
    public void setStartPoint(int startX, int startY) {this.startX = startX; this.startY = startY;   }
    public void setEndPoint(int endX, int endY) {this.endX = endX; this.endY = endY;   }

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
    @Override
    public void paint(Graphics graphics) {
    	Graphics2D graphics2D;
    	GradientPaint pain1; 
    	super.paint(graphics);
        graphics2D = (Graphics2D) graphics;
        ButtonModel model = this.getModel(); // Button Model
        
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHints(rh);
        
        //graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if(!isGradient){ // if isGradient is false then button is filled with one color startColor
        	graphics2D.setColor(startColor);
            if (model.isPressed()) {
//                System.out.println("Mouse pressed");
            	graphics2D.setColor(pressColor);
            }else if (model.isRollover()) {
//                System.out.println("Mouse over");
                this.setForeground(HoverForegroundColor);
                graphics2D.setColor(hoverColor);
            }
            else {
//                System.out.println("Mouse released");
            	graphics2D.setColor(startColor);
                this.setForeground(foregroundColor);
            }
			
            if (isFill)
            	graphics2D.fillRoundRect(0, 0, PButton.this.getWidth(), PButton.this.getHeight(), this.radius, this.radius1);
            else{
            	graphics2D.drawRoundRect(0, 0, PButton.this.getWidth() -1, PButton.this.getHeight() - 1, this.radius, this.radius1);
//                graphics.fillRoundRect(0, 0, PButton.this.getWidth() - 1, PButton.this.getHeight() - 1, this.radius, this.radius1);
            }
            
            super.paint(graphics2D);
        }else {
//            System.out.println("Gradient Button color ");
            pain1 = new GradientPaint(startX, startY, startColor, endX, endY, endColor);
            if (model.isPressed()) {
//                System.out.println("Mouse pressed");
                pain1 = new GradientPaint(startX, startY, pressColor, endX, endY, pressColor);
            }else if (model.isRollover()) {
//                System.out.println("Mouse over");
                this.setForeground(HoverForegroundColor);
                pain1 = new GradientPaint(startX, startY, hoverColor, endX, endY, hoverColor);
            }
            else {
                pain1 = new GradientPaint(startX, startY, startColor, endX, endY, endColor);
//                System.out.println("Mouse released");
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

        frame.getContentPane().setBackground(Color.white);


        PButton b1 = new PButton("JAVA");
        b1.setBounds(100, 300, 80, 50);
//        b1.setFillButton(false);?
        b1.setBorderRadius(40);
        b1.setHoverColor(Color.lightGray);
        
        frame.getContentPane().add(b1);
        

    }
}
