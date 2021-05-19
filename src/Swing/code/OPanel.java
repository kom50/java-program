package Swing.code;
import javax.swing.*;
import java.awt.*;
public class OPanel extends JPanel {
    Color startColor = Color.BLACK, endColor = Color.white;
    int width = 100, height = 100, radius;
    public int getRadius() {   return radius;    }
    public void setRadius(int radius) {  this.radius = radius;    }
    public void setStartColor(Color startColor) {
        this.startColor = startColor;
    }
    public void setEndColor(Color endColor) {
        this.endColor = endColor;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        height = getHeight();
        width  = getWidth();
        Paint paint = new GradientPaint(0.0f, 0.0f, startColor, width, height, endColor, true);
        graphics2D.setPaint(paint);
        graphics2D.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
    }
}

