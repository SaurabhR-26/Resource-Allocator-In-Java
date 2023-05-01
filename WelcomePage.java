import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import java.sql.Ref;


class Book extends Dialog implements ActionListener {
    Label lnm, ltype, lloc, lia, lib, ldate;
    TextField tnm, ttype, tloc, tia, tib, td, tm, ty;
    Button book;
    Button back;

    Dialog parent;

    Book(Dialog prnt, String title, boolean state) {
        super(prnt, title, state);

        parent =prnt;

        lnm = new Label("Name");
        ltype = new Label("Type");
        lloc = new Label("Location");
        lia = new Label("Is Available?");
        lib = new Label("Is Approved?");
        ldate = new Label("Date");

        tnm = new TextField(20);
        ttype = new TextField(20);
        tloc = new TextField(20);
        tia = new TextField(5);
        tib = new TextField(5);
        td = new TextField(2);
        tm = new TextField(2);
        ty = new TextField(4);

        tnm.setEnabled(false);
        ttype.setEnabled(false);
        tloc.setEnabled(false);
        tia.setEnabled(false);
        tib.setEnabled(false);

        book = new Button("BOOK");
        back = new Button("BACK");

        setLayout(null);

        lnm.setBounds(50, 40, 100, 30);
        tnm.setBounds(250, 40, 250, 30);
        ltype.setBounds(50, 110, 100, 30);
        ttype.setBounds(250, 110, 250, 30);
        lloc.setBounds(50, 180, 100, 30);
        tloc.setBounds(250, 180, 250, 30);
        lia.setBounds(50, 250, 100, 30);
        tia.setBounds(250, 250, 250, 30);
        lib.setBounds(50, 320, 100, 30);
        tib.setBounds(250, 320, 250, 30);
        ldate.setBounds(50, 390, 100, 30);

        td.setBounds(250, 390, 20, 30);
        tm.setBounds(270, 390, 20, 30);
        ty.setBounds(290, 390, 40, 30);

        back.setBounds(150, 460, 100, 50);
        book.setBounds(350, 460, 100, 50);

        back.addActionListener(this);
        book.addActionListener(this);

        add(lnm);
        add(tnm);
        add(ltype);
        add(ttype);
        add(lloc);
        add(tloc);
        add(lia);
        add(tia);
        add(lib);
        add(tib);
        add(ldate);
        add(td);
        add(tm);
        add(ty);

        add(book);
        add(back);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                parent.setVisible(true);
            }
        });
        setBackground(new Color(247, 255, 174));
        setSize(600, 550);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
    }
}

class Approve extends Dialog implements ActionListener {

    Label window_title;
    Image img;
    Label lname, ltype, llocation, lid, lsize, lis_approved, ldatedata;
    TextField tname, ttype, tlocation, tid, tsize, tis_approved, tdatedata;

    Button bnext, bapprove; // to submit the info

    Dialog parent;

    Approve(Dialog prnt, String title, boolean state) {

        super(prnt, title, state);

        parent = prnt;

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
                setVisible(false);
                parent.setVisible(true);
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

class ShowResources extends Dialog implements ActionListener {

    Label window_title;
    Image img;
    Label lname, ltype, llocation, lid, lsize, lis_approved, ldatedata;
    TextField tname, ttype, tlocation, tid, tsize, tis_approved, tdatedata;
    Button bnext, bbook; // to submit the info
    Book b;
    Dialog parent;

    ShowResources(Dialog prnt, String title, boolean state) {

        super(prnt, title, state);

        // title
        parent = prnt;
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
        bbook = new Button("BOOK");

        bnext.addActionListener(this);
        bbook.addActionListener(this);

        bnext.setBounds(100, 450, 100, 30);
        bbook.setBounds(300, 450, 100, 30);

        add(bnext);
        add(bbook);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                parent.setVisible(true);
            }
        });

        setBackground(new Color(247, 255, 174));
        setVisible(false);
        setSize(500, 600);
        setResizable(false);
    }

    public void actionPerformed(ActionEvent e) {
        Button btn = (Button) e.getSource();

        if (btn == bnext) {

        }

        if (btn == bbook) {
            this.setVisible(false);
            b = new Book(this, "RESOURCE BOOKING", true);
            b.setVisible(true);
        }
    }

}

class ResourceBase extends Dialog implements ActionListener, FocusListener {
    Label window_title;
    Image img;
    Label lname, ltype, llocation, lid, lsize;
    TextField tname, ttype, tlocation, tid, tsize;

    Button bsubmit; // to submit the info

    Dialog parent;

    ResourceBase(Dialog prnt, String title, boolean state) {

        super(prnt, title, state);

        parent = prnt;

        try {
            File fobj = new File("c:\\RESOURCE ALLOCATOR\\ResourcesImage.jfif");
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
                setVisible(false);
                parent.setVisible(true);
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
            parent.setVisible(true);
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

class AuthorityDialog extends Dialog implements ActionListener, FocusListener, ItemListener {
    Label lunm, lpass1, lpass2, lnm, lid, lbnm, lpos;
    TextField tunm, tpass1, tpass2, tnm, tid, tpos;
    Choice cbnm;
    Button bb;

    String username, password, name, pos, branch;
    int id;

    Dialog parent;

    AuthorityDialog(Dialog prnt, String title, boolean state) {
        super(prnt, title, state);

        parent = prnt;

        lunm = new Label("Username");
        lpass1 = new Label("Password");
        lpass2 = new Label("Confirm PAssword");
        lnm = new Label("Name");
        lid = new Label("ID");
        lbnm = new Label("Branch");
        lpos = new Label("Position");

        tunm = new TextField(20);
        tpass1 = new TextField(10);
        tpass2 = new TextField(10);
        tnm = new TextField(20);
        tid = new TextField(10);
        tpos = new TextField(20);

        cbnm = new Choice();
        cbnm.add("IT");
        cbnm.add("Mechanical");
        cbnm.add("Electrical");
        cbnm.add("Civil");
        cbnm.add("Electronics");
        cbnm.add("CSE");

        cbnm.addItemListener(this);

        tunm.addFocusListener(this);
        tpass1.addFocusListener(this);
        tpass2.addFocusListener(this);
        tnm.addFocusListener(this);
        tid.addFocusListener(this);
        tpos.addFocusListener(this);

        bb = new Button("Sign Up");
        bb.addActionListener(this);

        setLayout(null);

        lunm.setBounds(50, 40, 150, 30);
        tunm.setBounds(300, 40, 350, 50);
        lpass1.setBounds(50, 130, 150, 30);
        tpass1.setBounds(300, 130, 350, 50);
        lpass2.setBounds(50, 220, 150, 30);
        tpass2.setBounds(300, 220, 350, 50);
        lnm.setBounds(50, 310, 150, 30);
        tnm.setBounds(300, 310, 350, 50);
        lid.setBounds(50, 400, 150, 30);
        tid.setBounds(300, 400, 350, 50);
        lpos.setBounds(50, 490, 150, 30);
        tpos.setBounds(300, 490, 350, 50);
        lbnm.setBounds(50, 580, 150, 30);
        cbnm.setBounds(300, 580, 350, 50);
        bb.setBounds(300, 670, 100, 50);

        add(lunm);
        add(tunm);
        add(lpass1);
        add(tpass1);
        add(lpass2);
        add(tpass2);
        add(lnm);
        add(tnm);
        add(lid);
        add(tid);
        add(lpos);
        add(tpos);
        add(lbnm);
        add(cbnm);
        add(bb);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                parent.setVisible(true);
            }
        });

        setBackground(new Color(247, 255, 174));
        setSize(700, 760);
        setVisible(true);
        setResizable(false);
    }

    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }

    public void focusLost(FocusEvent e) {
        TextField t = (TextField) e.getSource();
        String str = "";
        if (t == tpass1)
            str = tpass1.getText();
        if (t == tpass2) {
            if (str.equals(tpass1.getText()) == false) {
                tpass2.requestFocus();
                return;
            } else
                password = tpass2.getText();
        }

        if (t == tpos) {
            bb.setEnabled(true);
        }
        name = tnm.getText();
        id = Integer.parseInt(tid.getText());
        pos = tpos.getText();
    }

    public void focusGained(FocusEvent e) {
        TextField t = (TextField) e.getSource();
        if (t == tunm)
            bb.setEnabled(false);
    }

    public void itemStateChanged(ItemEvent e) {
        branch = cbnm.getSelectedItem();
    }
}

class Users extends Dialog implements ActionListener, FocusListener, WindowListener, ItemListener {
    Label lname, lclub, lbranch, lprn, lreq, lrea, ldate, lresp;
    TextField tnm, tclub, tbranch, tprn, treq, treas, tdate, tresp;
    Button bok, bclr;
    Panel p1, p2;
    Image img1;

    Dialog parent;

    Users(Dialog prnt, String title, boolean state) {

        super(prnt, title, state);

        parent=prnt;

        lname = new Label("Name");
        lclub = new Label("Club");
        lbranch = new Label("branch");
        lprn = new Label("PRN");
        lreq = new Label("Requirments");
        lrea = new Label("Reason");
        ldate = new Label("Date");
        lresp = new Label("Responsible person");

        // For coloring the labels
        lname.setForeground(Color.red);
        lclub.setForeground(Color.red);
        lbranch.setForeground(Color.red);
        lprn.setForeground(Color.red);
        lreq.setForeground(Color.red);
        lrea.setForeground(Color.red);
        ldate.setForeground(Color.red);
        lresp.setForeground(Color.red);

        tnm = new TextField(20);
        tclub = new TextField(20);
        tbranch = new TextField(20);
        tprn = new TextField(20);
        treq = new TextField(20);
        treas = new TextField(20);
        tdate = new TextField(20);
        tresp = new TextField(20);

        tnm.addActionListener(this);
        tclub.addActionListener(this);
        tbranch.addActionListener(this);
        tprn.addActionListener(this);
        treq.addActionListener(this);
        treas.addActionListener(this);
        tdate.addActionListener(this);
        tresp.addActionListener(this);

        p1 = new Panel();
        p1.setLayout(null);
        lname.setBounds(50, 60, 150, 30);
        tnm.setBounds(300, 40, 350, 50);
        lclub.setBounds(50, 150, 150, 30);
        tclub.setBounds(300, 130, 350, 50);
        lbranch.setBounds(50, 240, 150, 30);
        tbranch.setBounds(300, 220, 350, 50);
        lrea.setBounds(50, 330, 150, 30);
        treas.setBounds(300, 310, 350, 50);
        ldate.setBounds(50, 420, 150, 30);
        tdate.setBounds(300, 400, 350, 50);
        lreq.setBounds(50, 510, 150, 30);
        treq.setBounds(300, 490, 350, 50);
        lprn.setBounds(50, 600, 150, 30);
        tprn.setBounds(300, 580, 350, 50);

        add(lname);
        add(tnm);
        add(lclub);
        add(tclub);
        add(lbranch);
        add(tbranch);
        add(lprn);
        add(tprn);
        add(lreq);
        add(treq);
        add(lrea);
        add(treas);
        add(ldate);
        add(tdate);
        add(lresp);
        add(tresp);

        bok = new Button("OK");
        bclr = new Button("Clear");

        bok.addActionListener(this);
        bclr.addActionListener(this);

        bok.setBounds(1, 500, 25, 30);
        bclr.setBounds(250, 500, 40, 30);

        p2 = new Panel();
        p2.setLayout(new GridLayout(1, 2, 5, 5));
        p2.add(bok);
        p2.add(bclr);

        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);

        addWindowListener(this);
        setSize(700, 700);
        setVisible(true);
        setResizable(false);
        p1.setBackground(Color.GRAY);

    }

    public void actionPerformed(ActionEvent e) {

    }

    public void focusGained(FocusEvent e) {

    }

    public void itemStateChanged(ItemEvent e) {
        //
    }

    public void windowOpened(WindowEvent e) {
        // System.out.println("Opened");
        // open();
    }

    public void windowClosed(WindowEvent e) {
    }

    public void windowClosing(WindowEvent e) {
        // close();
        setVisible(false);
        parent.setVisible(true);
    }

    public void windowActivated(WindowEvent e) {
        
    }

    public void windowDeactivated(WindowEvent e) {
        
    }

    public void windowIconified(WindowEvent e) {
    
    }

    public void windowDeiconified(WindowEvent e) {
        
    }

    public void focusLost(FocusEvent e) {

    }

}

class LoginWindow extends Dialog implements ActionListener {

    // fields
    Label luname, lpass; // username and password
    TextField tuname, tpass;// for username and password
    Button blogin;
    Image img;
    String tmp;
    ResourceBase rb;

    ShowResources sr;
    Approve ap;

    Dialog parent;

    LoginWindow(Dialog prnt, String title, boolean state) {

        super(prnt, title, state);

        tmp = title;

        parent =prnt;

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
                setVisible(false);
                parent.setVisible(true);
            }
        });

        setSize(500, 400);
        setVisible(true);
    }

    public void paint(Graphics g) {
        g.drawImage(img, 40, 140, 150, 150, this);
    }

    public void actionPerformed(ActionEvent e) {
        Button b = (Button) e.getSource();
        setVisible(false);

        if (b == blogin) {
            if (tmp.equals("ADMIN")) {
                // ADD RESOURCE WINDOW CODE
                rb = new ResourceBase(this, "ADD NEW RESOURCE", true);
                rb.setVisible(true);
            }

            if (tmp.equals("USER LOGIN")) {
                sr = new ShowResources(this, "RESOURCES", true);
                sr.setVisible(true);
            }

            if (tmp.equals("AUTHORITY LOGIN")) {
                ap = new Approve(this, "APPROVAL", true);
                ap.setVisible(true);
            }
        }

    }
}

class LoginPage2 extends Dialog implements ActionListener {
    Button Login, Signup;
    // Image img;
    LoginWindow lw;
    String t;
    Users u;
    AuthorityDialog ad;

    Dialog parent;

    LoginPage2(Dialog prnt, String title, boolean state) {

        super(prnt, title, state);
        setBackground(new Color(164, 208, 164));
        // try {
        // img = ImageIO.read(new File("C:\\Resource Allocator\\LOGIN PAGE.jpeg")); //
        // D:\\javaLAb\\resource
        // // allocator\\window.jpg
        // } catch (Exception e) {
        // }

        t = title;

        parent = prnt;
        Login = new Button("Login");
        Signup = new Button("Signup");

        Login.addActionListener(this);
        Signup.addActionListener(this);

        setLayout(null);

        Login.setBounds(180, 150, 120, 30);
        Signup.setBounds(180, 200, 120, 30);

        add(Login);
        add(Signup);

        addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e) {
                // use Database
            }

            public void windowClosing(WindowEvent e) {
                // commit
                setVisible(false);
                parent.setVisible(true);
            }
        });

        setSize(500, 400);
        setResizable(false);
        setVisible(true);
    }

    // public void paint(Graphics g) {
    // g.drawImage(img, 0, 0, 500, 500, this);
    // }

    public void actionPerformed(ActionEvent e) {
        Button b = (Button) e.getSource();
        if (b == Login) {

            if (t.equals("AUTHORITY")) {
                this.setVisible(false);
                lw = new LoginWindow(this, "AUTHORITY LOGIN", true);
            }

            if (t.equals("USER")) {
                this.setVisible(false);
                lw = new LoginWindow(this, "USER LOGIN", true);
            }
        }

        if (b == Signup) {
            if (t.equals("USER")) {
                this.setVisible(false);
                u = new Users(this, "USER SIGN UP", true);
            } else {
                this.setVisible(false);
                ad = new AuthorityDialog(this, "AUTHORITY SIGN UP", true);
            }
        }
    }
}

class Window1 extends Dialog implements ActionListener {
    Button auth, user, adm, exit;
    Image img;
    LoginPage2 lp2;
    LoginWindow lw;

    Frame parent;

    Window1(Frame prnt, String title, boolean state) {
        super(prnt, title, state);

        try {
            img = ImageIO.read(new File("C:\\resource allocator\\window.jpg"));
        } catch (Exception e) {
        }

       
        parent =prnt;
        auth = new Button("AUTHORITY");
        user = new Button("USER");
        adm = new Button("ADMIN");
        exit = new Button("EXIT");

        auth.addActionListener(this);
        user.addActionListener(this);
        adm.addActionListener(this);
        exit.addActionListener(this);

        setLayout(null);

        auth.setBounds(100, 200, 100, 30);
        user.setBounds(300, 200, 100, 30);
        adm.setBounds(100, 300, 100, 30);
        exit.setBounds(300, 300, 100, 30);

        add(auth);
        add(user);
        add(adm);
        add(exit);

        addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e) {
                // use Database
            }

            public void windowClosing(WindowEvent e) {
                setVisible(false);
                parent.setVisible(true);
            }
        });

        setSize(500, 500);
        setResizable(false);
        setVisible(false);
    }

    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, 500, 500, this);
    }

    public void actionPerformed(ActionEvent e) {
        Button b = (Button) e.getSource();
        this.setVisible(false);
        if (b == auth)
            lp2 = new LoginPage2(this, "AUTHORITY", true);
        if (b == user)
            lp2 = new LoginPage2(this, "USER", true);
        if (b == adm)
            lw = new LoginWindow(this, "ADMIN", true);

        if (b == exit) {
            setVisible(false);
            parent.setVisible(true);
        }

    }

}

public class WelcomePage extends Frame implements ActionListener {

    Image img;
    Button btitle;
    Window1 w1;
    WelcomePage ref;

    WelcomePage() {
        super("WELCOME TO THE RESOURCE ALLOCATOR");
        ref = this;
        btitle = new Button("RESOURCE ALLOCATOR");
        btitle.setFont(new Font("Arial", 500, 30));

        try {
            File fobj = new File("c:\\TEST JAVA CODE\\WelcomeImageFinal.jfif");
            img = (Image) ImageIO.read(fobj);
        } catch (Exception e) {
        }

        setLayout(null);
        btitle.addActionListener(this);
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
        w1 = new Window1(ref, "WHO YOU ARE", true); // creating first dialog object
        this.setVisible(false);
        w1.setVisible(true);
    }

    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, 1000, 700, this);
    }

    public static void main(String args[]) {
        WelcomePage wp = new WelcomePage();
    }
}