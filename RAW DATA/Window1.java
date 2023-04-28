import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
class Window1 extends Dialog implements ActionListener
{
    Button auth,user,adm,exit;
    Image img;
    Window1 parent;
    Window1(Frame prnt , String title , boolean state)
    {
        super(prnt , title , state);
        
        try
        {
            img=ImageIO.read(new File("C:\\resource allocator\\window.jpg"));
        }
        catch(Exception e){}

      

        parent=this;
        auth=new Button("AUTHORITY");
        user=new Button("USER");
        adm=new Button("ADMIN");
        exit=new Button("EXIT");

        auth.addActionListener(this);
        user.addActionListener(this);
        adm.addActionListener(this);
        exit.addActionListener(this);

        setLayout(null);

        auth.setBounds(100,200,100,30);
        user.setBounds(300,200,100,30);
        adm.setBounds(100,300,100,30);
        exit.setBounds(300,300,100,30);

        add(auth);
        add(user);
        add(adm);
        add(exit);

        addWindowListener(new WindowAdapter()
        {
            public void windowOpened(WindowEvent e)
            {
                //use Database
            }
            public void windowClosing(WindowEvent e)
            {
                //commit
                System.exit(0);
            }
        });

        setSize(500,500);
        setResizable(false);
        setVisible(true);
    }

    public void paint(Graphics g)
    {
      g.drawImage(img,0,0,500,500,this);
    }
    public void actionPerformed(ActionEvent e)
    {
        // Button b=(Button)e.getSource();
        // if(b==auth)
        //     d2=new Dialog2(parent,"AUTHORITY",true);
        // if(b==user)
        //     d2=new Dialog2(parent,"USER",true);
        // if(b==user)
        //     d2=new Dialog2(parent,"ADMIN",true);
        // if(b==exit)
        // {
        //     System.exit(0);         
        // }
    }

   
    public static void main(String []args)
    {
        Window1 a=new Window1();
    }

}
