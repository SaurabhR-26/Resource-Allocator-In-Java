import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;


public class WelcomePage extends Frame implements ActionListener {

    Image img;
    Button btitle;
    WelcomePage() {
        super("WELCOME TO THE RESOURCE ALLOCATOR");

        btitle = new Button("RESOURCE ALLOCATOR");
        btitle.setFont(new Font("Arial", 500, 30));

        try {
            File fobj = new File("c:\\TEST JAVA CODE\\WelcomeImageFinal.jfif");
            img = (Image) ImageIO.read(fobj);
        } catch (Exception e) {
        }

        setLayout(null);

        btitle.setBounds(300, 300, 400, 100);
        add(btitle);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setSize(1000, 700);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Button b = (Button) e.getSource();
    }

    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, 1000, 700,this);
    }

    public static void main(String args[]) {
        WelcomePage wp = new WelcomePage();
    }
}