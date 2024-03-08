import java.awt.*;
import java.awt.event.*;

public class loginFrame implements  WindowListener{
    Frame frame;
    Label l1, l2;
    TextField t1, t2;
    Button b;
    FlowLayout layout;

    loginFrame() { 
        frame = new Frame();
        frame.setSize(500, 500);
        frame.setBackground(Color.cyan);
        frame.setVisible(true);
        frame.addWindowListener(this);

        l1 = new Label("username");
        l2 = new Label("password");

        t1 = new TextField(25);
        t2 = new TextField(25);
        // t2.setEchoChar("*");

        b = new Button("Login");
        // b.addActionListener(this);

        layout = new FlowLayout(0, 0, 0);

        frame.add(l1);
        frame.add(t1);
        frame.add(l2);
        frame.add(t2);
        frame.add(b);
        frame.setLayout(layout);


    }

    public static void main(String[] args) {
        loginFrame lf = new loginFrame();
    }

    public void windowClosing(WindowEvent e) {
        frame.dispose();
    }

    public void windowOpened(WindowEvent e) {

    }

    public void windowClosed(WindowEvent e) {

    }

    public void windowIconified(WindowEvent e) {

    }

    public void windowDeiconified(WindowEvent e) {

    }

    public void windowActivated(WindowEvent e) {

    }

    public void windowDeactivated(WindowEvent e) {

    }

}
