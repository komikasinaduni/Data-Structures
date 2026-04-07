import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

public class PanelFile_SPS extends JPanel implements MouseListener, MouseMotionListener {

    private int xOfLeft = 50;
    private int yOfLeft = 50;
    private int xOfRight = 100;
    private int yOfRight = 100;

    private int xOfMouse = -10;
    private int yOfMouse = -10;

    public PanelFile_SPS(int panelWidth, int panelHeight){
        super();
        setSize(panelWidth, panelHeight);
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void paint(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0,0, getWidth(), getHeight());
        g.setColor(Color.RED);
        g.fillRect(xOfLeft, yOfLeft, 10, 10);
        g.setColor(Color.GREEN);
        g.fillRect(xOfRight, yOfRight, 10, 10);
        g.setColor(Color.BLUE);
        g.fillOval(xOfMouse, yOfMouse, 30, 30);
    }

    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if(e.getButton()==MouseEvent.BUTTON1){
            xOfLeft = x;
            yOfLeft = y;
        }
        if(e.getButton()==MouseEvent.BUTTON3){
            xOfLeft = x;
            yOfLeft = y;
        }
        repaint();
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseDragged(MouseEvent e) {

    }

    public void mouseMoved(MouseEvent e) {
        xOfMouse = e.getX();
        yOfMouse = e.getY();

        repaint();
    }
}
