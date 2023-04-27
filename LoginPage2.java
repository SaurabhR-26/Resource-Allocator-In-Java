import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.imageio.*;

class LoginPage2 extends Frame implements ActionListener {
    Button Login, Signup;
    Image img;
    LoginPage2 parent;

    LoginPage2() {
        super("Window1");
        try {
            img = ImageIO.read(new File("C:\\Resource Allocator\\LOGIN PAGE.jpeg")); // D:\\javaLAb\\resource
                                                                                     // allocator\\window.jpg
        } catch (Exception e) {
        }

        parent = this;
        Login = new Button("Login");
        Signup = new Button("Signup");

        Login.addActionListener(this);
        Signup.addActionListener(this);

        setLayout(null);

        Login.setBounds(210, 200, 100, 30);
        Signup.setBounds(210, 250, 100, 30);

        add(Login);
        add(Signup);

        addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e) {
                // use Database
            }

            public void windowClosing(WindowEvent e) {
                // commit
                System.exit(0);
            }
        });

        setSize(500, 500);
        setResizable(false);
        setVisible(true);
    }

    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, 500, 500, this);
    }

    public void actionPerformed(ActionEvent e) {
        // Button b=(Button)e.getSource();
        // if(b==auth)
        // d2=new Dialog2(parent,"AUTHORITY",true);
        // if(b==user)
        // d2=new Dialog2(parent,"USER",true);
        // if(b==user)
        // d2=new Dialog2(parent,"ADMIN",true);
        // if(b==exit)
        // {
        // System.exit(0);
        // }
    }

    public static void main(String[] args) {
        LoginPage2 a = new LoginPage2();

    }

}
