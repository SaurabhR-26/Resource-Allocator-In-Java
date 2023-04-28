import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.*;



class Users extends Frame implements ActionListener, FocusListener, WindowListener , ItemListener{

    
    Label lname,lclub,lbranch,lprn,lreq,lrea,ldate,lresp;
    TextField tnm,tclub,tbranch,tprn,treq,treas,tdate,tresp;
    Button bok,bclr;
    Panel p1,p2;
    Image img1;

    Users()
    {
        
        
        // super(prnt,title,state);
        super("Login_page");

        // try{
        //     img1=ImageIO.read(new File("d:\java23\AWT Window programming\image0.jpg"))
        // }

        
        // public void paint(Graphics g)
        // {
        //     g.drawImage(img1, 20,20,360,360,this);
        // }

        lname=new Label("Name");
        lclub=new Label("Club");
        lbranch=new Label("branch");
        lprn=new Label("PRN");
        lreq=new Label("Requirments");
        lrea=new Label("Reason");
        ldate=new Label("Date");
        lresp=new Label("Responsible person");
        


        // For coloring the labels 
        lname.setForeground(Color.red);
        lclub.setForeground(Color.red);
        lbranch.setForeground(Color.red);
        lprn.setForeground(Color.red);
        lreq.setForeground(Color.red);
        lrea.setForeground(Color.red);
        ldate.setForeground(Color.red);
        lresp.setForeground(Color.red);



        

        tnm=new TextField(20);
        tclub=new TextField(20);
        tbranch=new TextField(20);
        tprn=new TextField(20);
        treq=new TextField(20);
        treas=new TextField(20);
        tdate=new TextField(20);
        tresp=new TextField(20);


        tnm.addActionListener(this);
        tclub.addActionListener(this);
        tbranch.addActionListener(this);
        tprn.addActionListener(this);
        treq.addActionListener(this);
        treas.addActionListener(this);
        tdate.addActionListener(this);
        tresp.addActionListener(this);
        
        p1=new Panel();
        p1.setLayout(null);
        lname.setBounds(50,60,150,30);
        tnm.setBounds(300,40,350,50);
        lclub.setBounds(50,150,150,30);
        tclub.setBounds(300,130,350,50);
        lbranch.setBounds(50,240,150,30);
        tbranch.setBounds(300,220,350,50);
        lrea.setBounds(50,330,150,30);
        treas.setBounds(300,310,350,50);
        ldate.setBounds(50,420,150,30);
        tdate.setBounds(300,400,350,50);
        lreq.setBounds(50,510,150,30);
        treq.setBounds(300,490,350,50);
        lprn.setBounds(50,600,150,30);
        tprn.setBounds(300,580,350,50);


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

        bok=new Button("OK");
        bclr=new Button("Clear");

        bok.addActionListener(this);
        bclr.addActionListener(this);

        bok.setBounds(1,500,25,30);
        bclr.setBounds(250,500,40,30);

        p2=new Panel();
        p2.setLayout(new GridLayout(1,2,5,5));
        p2.add(bok);
        p2.add(bclr);

        add(p1,BorderLayout.CENTER);
        add(p2,BorderLayout.SOUTH);

        addWindowListener(this);
        setSize(700,700);
        setVisible(true);
        setResizable(false);
        p1.setBackground(Color.GRAY);

        

    }

    public void actionPerformed(ActionEvent e)
    {

    }

    public void focusGained(FocusEvent e)
    {

    }


    public void itemStateChanged(ItemEvent e){
       //
    }
	

    public void windowOpened(WindowEvent e)
	{
		// System.out.println("Opened");
        // open();
	}
	
	public void windowClosed(WindowEvent e)
	{
	}
	
	public void windowClosing(WindowEvent e)
	{
        // close();
		System.exit(0);
	}
	
	public void windowActivated(WindowEvent e)
	{
		System.out.println("Activated");
	}
	
	public void windowDeactivated(WindowEvent e)
	{
		System.out.println("Deactivated");
	}
	
	public void windowIconified(WindowEvent e)
	{
		System.out.println("Iconified");
	}
	
	public void windowDeiconified(WindowEvent e)
	{
		System.out.println("Deiconified");
	}
	
    public void focusLost(FocusEvent e)
    {
        
    }

    public static void main(String [] args)
    {
        Users a=new Users();
    }


}