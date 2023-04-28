import java.awt.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;

class LoginWindow extends Dialog implements ActionListener {

    // fields
    Label luname, lpass; // username and password
    TextField tuname, tpass;// for username and password
    Button blogin;
    Image img;

    LoginWindow(Frame prnt, String title, boolean state) {

        super(prnt, title, state);
        try {
            File fobj = new File("c:\\Resource Allocator\\loginImageFinal.png");
            img = (Image) ImageIO.read(fobj);
        } catch (Exception e) {
        }

        luname = new Label("USERNAME");
        lpass = new Label("PASSWORD");

        tuname = new TextField(10);
        tpass = new TextField(10);

        blogin = new Button("Login");

        blogin.addActionListener(this);

        setLayout(null);

        luname.setBounds(200, 150, 80, 30);
        lpass.setBounds(200, 210, 80, 30);

        tuname.setBounds(300, 150, 100, 30);
        tpass.setBounds(300, 210, 100, 30);

        blogin.setBounds(300, 270, 50, 30);

        add(luname);
        add(lpass);
        add(tuname);
        add(tpass);
        add(blogin);

        setBackground(new Color(183, 19, 117));

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setSize(500, 400);
    }

    public void paint(Graphics g) {
        g.drawImage(img, 40, 140, 150, 150, this);
    }

    public void actionPerformed(ActionEvent e) {
        Button b = (Button) e.getSource();
        setVisible(false);
    }
}

public class Window3 extends Frame implements ActionListener {
    Button b1;
    LoginWindow lw;

    Window3() {
        super("Window3");

        b1 = new Button("go");

        b1.addActionListener(this);

        add(b1);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        lw = new LoginWindow(this, "LOGIN", true);
        setSize(500, 500);
        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Button b = (Button) e.getSource();
        lw.setVisible(true);
    }

    public static void main(String args[]) {
        Window3 obj = new Window3();
    }
}
