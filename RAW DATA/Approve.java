import java.awt.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;

import javax.swing.Action;

class ResourceBase extends Dialog implements ActionListener {

    Label window_title;
    Image img;
    Label lname, ltype, llocation, lid, lsize, lis_approved, ldatedata;
    TextField tname, ttype, tlocation, tid, tsize, tis_approved, tdatedata;

    Button bnext, bapprove; // to submit the info

    ResourceBase(Frame prnt, String title, boolean state) {

        super(prnt, title, state);

        // title
        window_title = new Label("ALLOTED RESOURCES");
        window_title.setFont(new Font("Arial", 500, 30));

        setLayout(null); // now layout is null so setBounds method is to be used

        window_title.setBounds(80, 50, 340, 30);

        add(window_title);

        // labels
        lname = new Label("NAME :");
        ltype = new Label("TYPE :");
        llocation = new Label("LOCATION :");
        lid = new Label("ID :");
        lsize = new Label("SIZE");
        lis_approved = new Label("APPROVAL :");
        ldatedata = new Label("DATE :");

        lname.setBounds(130, 100, 70, 30);
        ltype.setBounds(130, 140, 70, 30);
        llocation.setBounds(130, 180, 70, 30);
        lid.setBounds(130, 220, 70, 30);
        lsize.setBounds(130, 260, 70, 30);
        lis_approved.setBounds(130, 300, 70, 30);
        ldatedata.setBounds(130, 340, 70, 30);

        add(lname);
        add(ltype);
        add(llocation);
        add(lid);
        add(lsize);
        add(lis_approved);
        add(ldatedata);

        // text fields
        tname = new TextField(10);
        ttype = new TextField(10);
        tlocation = new TextField(10);
        tid = new TextField(10);
        tsize = new TextField(10);
        tis_approved = new TextField(10);
        tdatedata = new TextField(10);

        tname.setBounds(210, 100, 140, 30);
        ttype.setBounds(210, 140, 140, 30);
        tlocation.setBounds(210, 180, 140, 30);
        tid.setBounds(210, 220, 140, 30);
        tsize.setBounds(210, 260, 140, 30);
        tis_approved.setBounds(210, 300, 140, 30);
        tdatedata.setBounds(210, 340, 140, 30);

        add(tname);
        add(ttype);
        add(tlocation);
        add(tid);
        add(tsize);
        add(tis_approved);
        add(tdatedata);

        bnext = new Button("NEXT");
        bapprove = new Button("APPROVE");

        bnext.addActionListener(this);
        bapprove.addActionListener(this);

        bnext.setBounds(100, 450, 100, 30);
        bapprove.setBounds(300, 450, 100, 30);

        add(bnext);
        add(bapprove);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setBackground(new Color(247, 255, 174));
        setVisible(false);
        setSize(500, 600);
        setResizable(false);
    }

    public void actionPerformed(ActionEvent e) {
    }

}

public class Approve extends Frame implements ActionListener {
    Button b1;
    ResourceBase rb;

    Approve() {

        super("Resource show window");

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
        Approve obj = new Approve();
    }
}