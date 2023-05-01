import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import java.sql.Ref;
import java.sql.*;
import java.util.jar.Attributes.Name;

/*
 * Resources are visible now
*/

class Book extends Dialog implements ActionListener {
    Label ldate;
    TextField td, tm, ty;
    Button book;
    Button back;
    String tmp;

    Book(Dialog parent, String title, boolean state) {
        super(parent, title, state);

        tmp = title;

        ldate = new Label("Date");

        td = new TextField(2);
        tm = new TextField(2);
        ty = new TextField(4);

        book = new Button("BOOK");
        back = new Button("BACK");

        setLayout(null);

        ldate.setBounds(50, 390, 100, 30);

        td.setBounds(400, 400, 30, 30);
        tm.setBounds(450, 400, 30, 30);
        ty.setBounds(500, 400, 50, 30);

        back.setBounds(350, 550, 100, 50);
        book.setBounds(550, 550, 100, 50);

        back.addActionListener(this);
        book.addActionListener(this);

        add(td);
        add(tm);
        add(ty);

        add(book);
        add(back);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        setBackground(new Color(247, 255, 174));
        setSize(1000, 700);
        setLocation(250, 50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Button b = (Button) e.getSource();
        Connection con = null;
        Statement st = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "saur");

            st = con.createStatement();
        } catch (Exception e1) {
        }

        if (b == book) {

            try {
                st.executeQuery("UPDATE RESOURCES SET year =" + Integer.parseInt(ty.getText()) + ", month = "
                        + Integer.parseInt(tm.getText()) + ",date = " + Integer.parseInt(td.getText())
                        + "WHERE NAME = \'" + tmp + "\'");
            } catch (Exception e3) {
            }
        } else {
            this.setVisible(false);
        }

        try {
            st.close();
            con.close();
        } catch (Exception e2) {
        }

    }
}

class Approve extends Dialog implements ActionListener {

    Label window_title;
    Image img;
    Label lname, ltype, llocation, lid, lsize, lis_approved, ldatedata;
    TextField tname, ttype, tlocation, tid, tsize, tis_approved, tdatedata;

    Button bnext, bapprove; // to submit the info

    Approve(Dialog prnt, String title, boolean state) {

        super(prnt, title, state);

        // title
        window_title = new Label("ALLOTED RESOURCES");
        window_title.setFont(new Font("Arial", 500, 30));

        setLayout(null); // now layout is null so setBounds method is to be used

        window_title.setBounds(300, 50, 340, 30);

        add(window_title);

        // labels
        lname = new Label("NAME :");
        ltype = new Label("TYPE :");
        llocation = new Label("LOCATION :");
        lid = new Label("ID :");
        lsize = new Label("SIZE");
        lis_approved = new Label("APPROVAL :");
        ldatedata = new Label("DATE :");

        lname.setBounds(230, 100, 120, 30);
        ltype.setBounds(230, 140, 120, 30);
        llocation.setBounds(230, 180, 120, 30);
        lid.setBounds(230, 220, 120, 30);
        lsize.setBounds(230, 260, 120, 30);
        lis_approved.setBounds(230, 300, 120, 30);
        ldatedata.setBounds(230, 340, 120, 30);

        lname.setFont(new Font("Arial", 30, 20));
        ltype.setFont(new Font("Arial", 30, 20));
        llocation.setFont(new Font("Arial", 30, 20));
        lid.setFont(new Font("Arial", 30, 20));
        lsize.setFont(new Font("Arial", 30, 20));
        lis_approved.setFont(new Font("Arial", 30, 20));
        ldatedata.setFont(new Font("Arial", 30, 20));

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

        tname.setBounds(380, 100, 140, 30);
        ttype.setBounds(380, 140, 140, 30);
        tlocation.setBounds(380, 180, 140, 30);
        tid.setBounds(380, 220, 140, 30);
        tsize.setBounds(380, 260, 140, 30);
        tis_approved.setBounds(380, 300, 140, 30);
        tdatedata.setBounds(380, 340, 140, 30);

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

        bnext.setBounds(200, 450, 100, 30);
        bapprove.setBounds(400, 450, 100, 30);

        add(bnext);
        add(bapprove);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setBackground(new Color(247, 255, 174));
        setVisible(false);
        setLocation(250, 50);
        setSize(1000, 700);
        setResizable(false);
    }

    public void actionPerformed(ActionEvent e) {
        Button b = (Button) e.getSource();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String name, type, location, is_approved, is_available;
        int id, size, y, m, d;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "saur");

            st = con.createStatement();

            rs = st.executeQuery("SELECT * FROM RESOURCES");
            if (rs != null) {
                rs.next();
                name = rs.getString("name");
                type = rs.getString("type");
                location = rs.getString("location");
                id = rs.getInt("id");
                size = rs.getInt("size");
                y = rs.getInt("year");
                m = rs.getInt("month");
                d = rs.getInt("date");
                is_approved = rs.getString("is_approved");

                tname.setText(name);
                ttype.setText(type);
                tlocation.setText(location);
                tid.setText("" + id);
                tsize.setText("" + size);
                tdatedata.setText("" + y + "-" + m + "-" + d);
                tis_approved.setText(is_approved);
            }

        } catch (Exception e1) {
        }

        if (b == bnext) {
            try {
                rs.next();
                name = rs.getString("name");
                type = rs.getString("type");
                location = rs.getString("location");
                id = rs.getInt("id");
                size = rs.getInt("size");
                y = rs.getInt("year");
                m = rs.getInt("month");
                d = rs.getInt("date");
                is_approved = rs.getString("is_approved");

                tname.setText(name);
                ttype.setText(type);
                tlocation.setText(location);
                tid.setText("" + id);
                tsize.setText("" + size);
                tdatedata.setText("" + y + "-" + m + "-" + d);
                tis_approved.setText(is_approved);

            } catch (Exception e5) {
            }

        }

        if (b == bapprove) {
            this.setVisible(false);
            try {

                st.executeQuery("UPDATE RESOURCES SET is_approved = \'Y\' WHERE NAME = \'" + tname.getText() + "\'");
            } catch (Exception e6) {
            }
        }

        try {
            st.close();
            con.close();
        } catch (Exception e2) {
        }

    }

}

class ShowResources extends Dialog implements ActionListener {

    Label window_title;
    Image img;
    Label lname, ltype, llocation, lid, lsize, lis_approved, ldatedata;
    TextField tname, ttype, tlocation, tid, tsize, tis_approved, tdatedata;
    Button bnext, bbook; // to submit the info
    Book bk;
    boolean flag;
    int cnt;

    ShowResources(Dialog prnt, String title, boolean state) {

        super(prnt, title, state);

        flag = false;
        cnt = 0;

        // title
        window_title = new Label("ALLOTED RESOURCES");
        window_title.setFont(new Font("Arial", 500, 30));

        setLayout(null); // now layout is null so setBounds method is to be used

        window_title.setBounds(280, 50, 340, 30);

        add(window_title);

        // labels
        lname = new Label("NAME :");
        ltype = new Label("TYPE :");
        llocation = new Label("LOCATION :");
        lid = new Label("ID :");
        lsize = new Label("SIZE");
        lis_approved = new Label("APPROVAL :");
        ldatedata = new Label("DATE :");

        lname.setBounds(230, 150, 120, 30);
        ltype.setBounds(230, 190, 120, 30);
        llocation.setBounds(230, 230, 120, 30);
        lid.setBounds(230, 270, 120, 30);
        lsize.setBounds(230, 310, 120, 30);
        lis_approved.setBounds(230, 350, 120, 30);
        ldatedata.setBounds(230, 390, 120, 30);

        lname.setFont(new Font("Arial", 30, 20));
        ltype.setFont(new Font("Arial", 30, 20));
        llocation.setFont(new Font("Arial", 30, 20));
        lid.setFont(new Font("Arial", 30, 20));
        lsize.setFont(new Font("Arial", 30, 20));
        lis_approved.setFont(new Font("Arial", 30, 20));
        ldatedata.setFont(new Font("Arial", 30, 20));

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

        tname.setBounds(400, 150, 170, 30);
        ttype.setBounds(400, 190, 170, 30);
        tlocation.setBounds(400, 230, 170, 30);
        tid.setBounds(400, 270, 170, 30);
        tsize.setBounds(400, 310, 170, 30);
        tis_approved.setBounds(400, 350, 170, 30);
        tdatedata.setBounds(400, 390, 170, 30);

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

        bnext.setBounds(300, 550, 120, 50);
        bbook.setBounds(500, 550, 120, 50);

        add(bnext);
        add(bbook);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setBackground(new Color(247, 255, 174));
        setLocation(250, 50);
        setVisible(false);
        setSize(1000, 700);
        setResizable(false);
    }

    public void actionPerformed(ActionEvent e) {
        Button b = (Button) e.getSource();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String name, type, location, is_approved;
        int id, size, y, m, d;

        System.out.println("Entered in the action mode...");

        if (b == bnext) {
            cnt++;
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");

                con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "saur");

                st = con.createStatement();

                rs = st.executeQuery("SELECT * FROM RESOURCES");

                int var = cnt;
                while (var != 0) {

                    rs.next();
                    var--;
                }

                name = rs.getString("name");
                type = rs.getString("type");
                location = rs.getString("location");
                id = rs.getInt("id");
                size = rs.getInt("size_new");
                y = rs.getInt("year");
                m = rs.getInt("month");
                d = rs.getInt("day");
                is_approved = rs.getString("is_approved");

                System.out.println(name + "\t" + id);

                tname.setText(name);
                ttype.setText(type);
                tlocation.setText(location);
                tid.setText("" + id);
                tsize.setText("" + size);
                tdatedata.setText("" + y + "-" + m + "-" + d);
                tis_approved.setText(is_approved);

            }

            catch (Exception e5) {
            }

        }

        if (b == bbook) {
            this.setVisible(false);
            bk = new Book(this, "RESOURCE BOOKING", true);
            bk.setVisible(true);
        }

        try {
            st.close();
            con.close();
        } catch (Exception e2) {
        }
    }

}

class ResourceBase extends Dialog implements ActionListener, FocusListener {
    Label window_title;
    Image img;
    Label lname, ltype, llocation, lid, lsize;
    TextField tname, ttype, tlocation, tid, tsize;

    Button bsubmit; // to submit the info

    ResourceBase(Dialog prnt, String title, boolean state) {

        super(prnt, title, state);

        try {
            File fobj = new File("c:\\RESOURCE ALLOCATOR\\ResourcesImage.jfif");
            img = (Image) ImageIO.read(fobj);
        } catch (Exception e) {
        }

        // title
        window_title = new Label("NEW RESOURCE");
        window_title.setFont(new Font("Arial", 500, 30));

        setLayout(null); // now layout is null so setBounds method is to be used

        window_title.setBounds(370, 50, 250, 30);

        add(window_title);

        // labels
        lname = new Label("NAME :");
        ltype = new Label("TYPE :");
        llocation = new Label("LOCATION :");
        lid = new Label("ID :");
        lsize = new Label("SIZE");

        lname.setBounds(300, 350, 100, 30);
        ltype.setBounds(300, 400, 100, 30);
        llocation.setBounds(300, 450, 100, 30);
        lid.setBounds(300, 500, 100, 30);
        lsize.setBounds(300, 550, 100, 30);

        lname.setFont(new Font("Serief", 30, 20));
        ltype.setFont(new Font("Serief", 30, 20));
        llocation.setFont(new Font("Serief", 30, 20));
        lid.setFont(new Font("Serief", 30, 20));
        lsize.setFont(new Font("Serief", 30, 20));

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

        tname.setBounds(450, 350, 150, 30);
        ttype.setBounds(450, 400, 150, 30);
        tlocation.setBounds(450, 450, 150, 30);
        tid.setBounds(450, 500, 150, 30);
        tsize.setBounds(450, 550, 150, 30);

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

        bsubmit.setBounds(700, 600, 150, 50);

        add(bsubmit);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setBackground(new Color(247, 255, 174));
        setVisible(false);
        setLocation(250, 50);
        setSize(1000, 700);
        setResizable(false);
    }

    public void actionPerformed(ActionEvent e) {
        Button b = (Button) e.getSource();
        this.setVisible(false);
        Connection con = null;
        Statement st = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "saur");

            st = con.createStatement();
        } catch (Exception e1) {
        }

        if (b == bsubmit) {
            try {
                st.executeQuery("INSERT INTO RESOURCES VALUES(\'" + tname.getText() + "\' , \'" + ttype.getText()
                        + "\',\'" + tlocation.getText() + "\' , " + tid.getText() + "," + tsize.getText()
                        + " , \'N\',\'Y\',null , null, null)");
            } catch (Exception e3) {
            }
        }
        try {
            st.close();
            con.close();
        } catch (Exception e2) {
        }

    }

    public void paint(Graphics g) {
        g.drawImage(img, 250, 100, 500, 220, this);
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

    AuthorityDialog(Dialog parent, String title, boolean state) {
        super(parent, title, state);

        lunm = new Label("Username");
        lpass1 = new Label("Password");
        lpass2 = new Label("Confirm Password");
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

        lunm.setBounds(50, 40, 200, 30);
        tunm.setBounds(300, 40, 350, 50);
        lpass1.setBounds(50, 130, 200, 30);
        tpass1.setBounds(300, 130, 350, 50);
        lpass2.setBounds(50, 220, 200, 30);
        tpass2.setBounds(300, 220, 350, 50);
        lnm.setBounds(50, 310, 200, 30);
        tnm.setBounds(300, 310, 350, 50);
        lid.setBounds(50, 400, 200, 30);
        tid.setBounds(300, 400, 350, 50);
        lpos.setBounds(50, 490, 200, 30);
        tpos.setBounds(300, 490, 350, 50);
        lbnm.setBounds(50, 580, 200, 30);
        cbnm.setBounds(300, 580, 350, 50);
        bb.setBounds(400, 630, 150, 50);

        lunm.setFont(new Font("ROMAN", 40, 20));
        lpass1.setFont(new Font("ROMAN", 40, 20));
        lpass2.setFont(new Font("ROMAN", 40, 20));
        lnm.setFont(new Font("ROMAN", 40, 20));
        lid.setFont(new Font("ROMAN", 40, 20));
        lpos.setFont(new Font("ROMAN", 40, 20));
        lbnm.setFont(new Font("ROMAN", 40, 20));

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
                System.exit(0);
            }
        });

        setBackground(new Color(247, 255, 174));
        setLocation(250, 50);
        setSize(1000, 700);
        setVisible(true);
        setResizable(false);
    }

    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        Button b = (Button) e.getSource();
        Connection con = null;
        Statement st = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "saur");

            st = con.createStatement();
        } catch (Exception e1) {
        }

        if (b == bb) {
            try {
                st.executeQuery("INSERT INTO AUTHORITY VALUES(\'" + tunm.getText() + "\' , \'" + tpass2.getText()
                        + "\',\'" + tnm.getText() + "\' , \'" + tid.getText() + "\' , \'" + tpos.getText() + "\' , \'"
                        + branch + "\')");
            } catch (Exception e3) {
            }
        }
        try {
            st.close();
            con.close();
        } catch (Exception e2) {
        }

    }

    public void focusLost(FocusEvent e) {
        // TextField t = (TextField) e.getSource();
        // String str = "";
        // if (t == tpass1)
        // str = tpass1.getText();
        // if (t == tpass2) {
        // if (str.equals(tpass1.getText()) == false) {
        // tpass2.requestFocus();
        // return;
        // } else
        // password = tpass2.getText();
        // }

        // if (t == tpos) {
        // bb.setEnabled(true);
        // }
        // name = tnm.getText();
        // id = Integer.parseInt(tid.getText());
        // pos = tpos.getText();
    }

    public void focusGained(FocusEvent e) {
        // TextField t = (TextField) e.getSource();
        // if (t == tunm)
        // bb.setEnabled(false);
    }

    public void itemStateChanged(ItemEvent e) {
        branch = cbnm.getSelectedItem();
    }
}

class Users extends Dialog implements ActionListener, FocusListener, WindowListener, ItemListener {
    Label lname, lclub, lbranch, lprn, lreq, lrea, ldate, lresp;
    TextField tnm, tclub, tbranch, tprn, treq, treas, tdate, tresp, tuname, tpass;
    Button bok, bclr;
    Panel p1, p2;
    Image img1;

    Users(Dialog prnt, String title, boolean state) {

        super(prnt, title, state);

        lname = new Label("Name");
        lclub = new Label("Club");
        lbranch = new Label("Branch");
        lprn = new Label("PRN");
        lreq = new Label("Requirements");
        lrea = new Label("Reason");
        ldate = new Label("Date");
        lresp = new Label("Responsible Person");

        // For coloring the labels
        lname.setForeground(Color.red);
        lclub.setForeground(Color.red);
        lbranch.setForeground(Color.red);
        lprn.setForeground(Color.red);
        lreq.setForeground(Color.red);
        lrea.setForeground(Color.red);
        ldate.setForeground(Color.red);
        lresp.setForeground(Color.red);

        lname.setFont(new Font("Arial", 30, 30));
        lclub.setFont(new Font("Arial", 30, 30));
        lbranch.setFont(new Font("Arial", 30, 30));
        lprn.setFont(new Font("Arial", 30, 30));
        lreq.setFont(new Font("Arial", 30, 30));
        lrea.setFont(new Font("Arial", 30, 30));
        ldate.setFont(new Font("Arial", 30, 30));
        lresp.setFont(new Font("Arial", 30, 30));

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
        lname.setBounds(50, 60, 190, 30);
        tnm.setBounds(340, 40, 350, 50);
        lclub.setBounds(50, 150, 190, 30);
        tclub.setBounds(340, 130, 350, 50);
        lbranch.setBounds(50, 240, 190, 30);
        tbranch.setBounds(340, 220, 350, 50);
        lrea.setBounds(50, 330, 190, 30);
        treas.setBounds(340, 310, 350, 50);
        ldate.setBounds(50, 420, 190, 30);
        tdate.setBounds(340, 400, 350, 50);
        lreq.setBounds(50, 510, 190, 30);
        treq.setBounds(340, 490, 350, 50);
        lprn.setBounds(50, 600, 190, 30);
        tprn.setBounds(340, 580, 350, 50);

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
        setSize(1000, 700);
        setLocation(250, 50);
        setVisible(true);
        setResizable(false);
        setBackground(new Color(249, 226, 175));
        p1.setBackground(Color.GRAY);

    }

    public void actionPerformed(ActionEvent e) {
        Button b = (Button) e.getSource();
        Connection con = null;
        Statement st = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "saur");

            st = con.createStatement();
        } catch (Exception e1) {
        }

        if (b == bok) {
            try {
                st.executeQuery("INSERT INTO USERS VALUES(\'" + tuname.getText() + "\' , \'" + tpass.getText() + "\',\'"
                        + tnm.getText() + "\' , \'" + tclub.getText() + "\' , \'" + tbranch.getText() + "\' , \'"
                        + tprn.getText() + "\' , \'" + treq.getText() + "\' , \'" + treas.getText() + "\' , \'"
                        + tdate.getText() + "\' , \'" + tresp.getText() + "\')");
            } catch (Exception e3) {
            }
        }
        try {
            st.close();
            con.close();
        } catch (Exception e2) {
        }

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
        System.exit(0);
    }

    public void windowActivated(WindowEvent e) {
        System.out.println("Activated");
    }

    public void windowDeactivated(WindowEvent e) {
        System.out.println("Deactivated");
    }

    public void windowIconified(WindowEvent e) {
        System.out.println("Iconified");
    }

    public void windowDeiconified(WindowEvent e) {
        System.out.println("Deiconified");
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
    String uname = "raadmin";
    String pass = "raadmin@123";

    LoginWindow(Dialog prnt, String title, boolean state) {

        super(prnt, title, state);

        tmp = title;

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

        luname.setBounds(330, 220, 180, 35);
        lpass.setBounds(330, 360, 180, 35);

        tuname.setBounds(530, 220, 120, 35);
        tpass.setBounds(530, 360, 120, 35);

        blogin.setBounds(450, 450, 120, 40);

        add(luname);
        add(lpass);
        add(tuname);
        add(tpass);
        add(blogin);

        luname.setFont(new Font("Arial", 50, 30));
        lpass.setFont(new Font("Arial", 50, 30));

        setBackground(new Color(183, 19, 117));

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setLocation(250, 50);
        setSize(1000, 700);
        setVisible(true);
    }

    public void paint(Graphics g) {
        g.drawImage(img, 80, 200, 200, 200, this);
    }

    public void actionPerformed(ActionEvent e) {
        Button b = (Button) e.getSource();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        this.setVisible(false);

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "saur");

            st = con.createStatement();
        } catch (Exception e1) {
        }

        if (b == blogin) {
            if (tmp.equals("ADMIN")) {

                if (uname.equals(tuname.getText()) && pass.equals(tpass.getText())) {
                    rb = new ResourceBase(this, "ADD NEW RESOURCE", true);
                    rb.setVisible(true);
                }
            }

            if (tmp.equals("USER LOGIN")) {

                // try {

                // rs = st.executeQuery("SELECT USERNAME , PASSWORD FROM USERS WHERE USERNAME =
                // \'" + tuname.getText()
                // + "\' AND PASSWORD = \'" + tpass.getText() + "\')");
                // System.out.println("this is user login");
                // rs.next();
                // } catch (Exception e4) {
                // }
                // if (rs != null) {
                sr = new ShowResources(this, "RESOURCES", true);
                sr.setVisible(true);
                // }

            }

            if (tmp.equals("AUTHORITY LOGIN")) {

                try {

                    rs = st.executeQuery("SELECT USERNAME , PASSWORD FROM AUTHORITY WHERE USERNAME = \'"
                            + tuname.getText() + "\' AND PASSWORD = \'" + tpass.getText() + "\')");
                } catch (Exception e5) {
                }
                // if (rs != null) {
                ap = new Approve(this, "APPROVAL", true);
                ap.setVisible(true);
                // }

            }
        }

        try {
            st.close();
            con.close();
        } catch (Exception e2) {
        }

    }
}

class LoginPage2 extends Dialog implements ActionListener {
    Button Login, Signup;
    // Image img;
    LoginPage2 parent;
    LoginWindow lw;
    String t;
    Users u;
    AuthorityDialog ad;

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

        parent = this;
        Login = new Button("Login");
        Signup = new Button("Signup");

        Login.addActionListener(this);
        Signup.addActionListener(this);

        setLayout(null);

        Login.setBounds(400, 300, 120, 50);
        Signup.setBounds(400, 400, 120, 50);

        add(Login);
        add(Signup);

        addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e) {
                // use Database
            }

            public void windowClosing(WindowEvent e) {
            }
        });

        setLocation(250, 50);
        setSize(1000, 700);
        setResizable(false);
        setVisible(true);
    }

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
    Window1 parent;
    LoginPage2 lp2;
    LoginWindow lw;

    Window1(Frame prnt, String title, boolean state) {
        super(prnt, title, state);

        parent = this;
        auth = new Button("AUTHORITY");
        user = new Button("USER");
        adm = new Button("ADMIN");
        exit = new Button("EXIT");

        auth.addActionListener(this);
        user.addActionListener(this);
        adm.addActionListener(this);
        exit.addActionListener(this);

        setLayout(null);

        auth.setBounds(275, 200, 150, 50);
        user.setBounds(575, 200, 150, 50);
        adm.setBounds(275, 400, 150, 50);
        exit.setBounds(575, 400, 150, 50);

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
            }
        });

        setLocation(250, 50);
        setBackground(new Color(255, 225, 148));
        setSize(1000, 700);
        setResizable(false);
        setVisible(false);
    }

    public void actionPerformed(ActionEvent e) {
        Button b = (Button) e.getSource();

        this.setVisible(false);

        if (b == auth) {
            lp2 = new LoginPage2(this, "AUTHORITY", true);
            lp2.setVisible(true);
        }
        if (b == user) {
            lp2 = new LoginPage2(this, "USER", true);
            lp2.setVisible(true);
        }

        if (b == adm) {
            lw = new LoginWindow(this, "ADMIN", true);
        }

        if (b == exit) {

            System.exit(0);
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
        w1.setLocation(250, 50);
        w1.setVisible(true);
    }

    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, 1000, 700, this);
    }

    public static void main(String args[]) {
        WelcomePage wp = new WelcomePage();
        wp.setLocation(250, 50);
    }
}