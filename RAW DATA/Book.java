import java.awt.*;
import java.awt.event.*;


class Book extends Dialog implements ActionListener
{
    Label lnm,ltype,lloc,lia,lib,ldate;
    TextField tnm,ttype,tloc,tia,tib,td,tm,ty;
    Button book;
    Button back;
    Book(Frame parent,String title,boolean state)
    {
        super(parent,title,state);
        
        lnm=new Label("Name");
        ltype=new Label("Type");
        lloc=new Label("Location");
        lia=new Label("Is Available?");
        lib=new Label("Is Approved?");
        ldate=new Label("Date");

        tnm=new TextField(20);
        ttype=new TextField(20);
        tloc=new TextField(20);
        tia=new TextField(5);
        tib=new TextField(5);
        td=new TextField(2);
        tm=new TextField(2);
        ty=new TextField(4);


        tnm.setEnabled(false);
        ttype.setEnabled(false);
        tloc.setEnabled(false);
        tia.setEnabled(false);
        tib.setEnabled(false);

        book=new Button("BOOK");
        back=new Button("BACK");

        setLayout(null);

        lnm.setBounds(50,40,100,30);
        tnm.setBounds(250,40,250,30);
        ltype.setBounds(50,110,100,30);
        ttype.setBounds(250,110,250,30);
        lloc.setBounds(50,180,100,30);
        tloc.setBounds(250,180,250,30);
        lia.setBounds(50,250,100,30);
        tia.setBounds(250,250,250,30);
        lib.setBounds(50,320,100,30);
        tib.setBounds(250,320,250,30);
        ldate.setBounds(50,390,100,30);

        td.setBounds(250,390,20,30);
        tm.setBounds(270,390,20,30);
        ty.setBounds(290,390,40,30);

        back.setBounds(150,460,100,50);
        book.setBounds(350,460,100,50);

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

        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
        setBackground(new Color(247,255,174));
        setSize(600,550);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {}
}