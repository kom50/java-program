package Swing.code;
import java.awt.Component;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class OnDrag extends MouseAdapter implements MouseMotionListener{
    private Component component, dragComponent;
    private int x, y;
    public OnDrag(Component onDragComponent, Component dragComponent){
        this.component = onDragComponent;
        this.dragComponent = dragComponent;
        // set Listener on component
        this.component.addMouseListener(this);
        this.component.addMouseMotionListener(this);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        int count = e.getClickCount();  // if mouse double clicked on the component then window is dispose
        if(count == 2) {
            ((Window) dragComponent).dispose();
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        dragComponent.setLocation(e.getXOnScreen() - x, e.getYOnScreen() - y);
    }
    @Override
    public void mouseMoved(MouseEvent e) {  /*	*/}

}
