import java.awt.*;
import java.awt.event.*;

public class firstFrame implements WindowListener, MouseListener, KeyListener {

    Frame f;

    firstFrame() {
        f = new Frame();
        f.setSize(400, 400);
        f.setBackground(Color.blue);
        f.setVisible(true);
        f.addWindowListener(this);
        f.addMouseListener(this);
        f.addKeyListener(this);
    }

    public void windowClosing(WindowEvent e) {
        f.dispose();
        System.out.println("closing");
    }

    public void windowOpened(WindowEvent e) {
        System.out.println("opened");
    }

    public void windowClosed(WindowEvent e) {
        System.out.println("closed");
    }

    public void windowIconified(WindowEvent e) {
        System.out.println("iconified");
    }

    public void windowDeiconified(WindowEvent e) {
        System.out.println("de-iconified");
    }

    public void windowActivated(WindowEvent e) {
        System.out.println("activated");
    }

    public void windowDeactivated(WindowEvent e) {
        System.out.println("de-activated");
    }

    public void mousePressed(MouseEvent e) { 
        System.out.println("Mouse Pressed");
    }

    public void mouseClicked(MouseEvent e) { 
        System.out.println("Mouse Clicked");
    }

    public void mouseReleased(MouseEvent e) { 
        System.out.println("Mouse released");
    }

    public void mouseEntered(MouseEvent e) { 
        System.out.println("Mouse entered");
    }

    public void mouseExited(MouseEvent e) { 
        System.out.println("Mouse exited");
    }

    public void keyPressed(KeyEvent e) { 
        System.out.println("Key Pressed" + e.getKeyChar());
    }

    public void keyReleased(KeyEvent e) { 
        System.out.println("Key released" + e.getKeyChar());
    }

    public void keyTyped(KeyEvent e) { 
        System.out.println("Key typed" + e.getKeyChar());
    }

    public static void main(String[] args) {
        firstFrame ob = new firstFrame();
    }

}
