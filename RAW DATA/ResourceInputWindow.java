import java.awt.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;

import javax.swing.Action;

class ResourceBase extends Dialog implements ActionListener, FocusListener {
    Label window_title;
    Image img;
    Label lname, ltype, llocation, lid, lsize;
    TextField tname, ttype, tlocation, tid, tsize;

    Button bsubmit; // to submit the info

    ResourceBase(Frame prnt, String title, boolean state) {

        super(prnt, title, state);

        try {
            File fobj = new File("c:\\TEST JAVA CODE\\ResourcesImage.jfif");
            img = (Image) ImageIO.read(fobj);
        } catch (Exception e) {
        }

        // title
        window_title = new Label("NEW RESOURCE");
        window_title.setFont(new Font("Arial", 500, 30));

        setLayout(null); // now layout is null so setBounds method is to be used

        window_title.setBounds(130, 50, 250, 30);

        add(window_title);

        // labels
        lname = new Label("NAME :");
        ltype = new Label("TYPE :");
        llocation = new Label("LOCATION :");
        lid = new Label("ID :");
        lsize = new Label("SIZE");

        lname.setBounds(130, 300, 70, 30);
        ltype.setBounds(130, 340, 70, 30);
        llocation.setBounds(130, 380, 70, 30);
        lid.setBounds(130, 420, 70, 30);
        lsize.setBounds(130, 460, 70, 30);

        add(lname);
        add(ltype);
        add(llocation);
        add(lid);
        add(lsize);

        // text fields
        tname = new TextField(10);
        ttype = new TextField(10);
        tlocation = new TextField(10);
        tid = new TextField(10);
        tsize = new TextField(10);

        tname.setBounds(210, 300, 120, 30);
        ttype.setBounds(210, 340, 120, 30);
        tlocation.setBounds(210, 380, 120, 30);
        tid.setBounds(210, 420, 120, 30);
        tsize.setBounds(210, 460, 120, 30);

        tname.addFocusListener(this);
        ttype.addFocusListener(this);
        tlocation.addFocusListener(this);
        tid.addFocusListener(this);
        tsize.addFocusListener(this);

        add(tname);
        add(ttype);
        add(tlocation);
        add(tid);
        add(tsize);

        bsubmit = new Button("ADD RESOURCE");
        bsubmit.addActionListener(this);

        bsubmit.setBounds(190, 550, 120, 30);

        add(bsubmit);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setBackground(new Color(247, 255, 174));
        setVisible(false);
        setSize(500, 700);
        setResizable(false);
    }

    public void actionPerformed(ActionEvent e) {
        Button b = (Button) e.getSource();

        if (b == bsubmit) {
            // code for writing into data base
            setVisible(false);
        }
    }

    public void paint(Graphics g) {
        g.drawImage(img, 80, 120, 320, 150, this);
    }

    public void focusGained(FocusEvent f) {

    }

    public void focusLost(FocusEvent f) {

    }

}

public class ResourceInputWindow extends Frame implements ActionListener {
    Button b1;
    ResourceBase rb;

    ResourceInputWindow() {

        super("Resource add window");

        b1 = new Button("go");

        b1.addActionListener(this);

        add(b1);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        rb = new ResourceBase(this, "REOURCE WINDOW", true);

        setSize(500, 500);
        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Button b = (Button) e.getSource();
        rb.setVisible(true);
    }

    public static void main(String args[]) {
        ResourceInputWindow obj = new ResourceInputWindow();
    }
}