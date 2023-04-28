import java.awt.*;
import java.awt.event.*;
class AuthorityDialog extends Dialog implements ActionListener,FocusListener,ItemListener
{
    Label lunm,lpass1,lpass2,lnm,lid,lbnm,lpos;
    TextField tunm,tpass1,tpass2,tnm,tid,tpos;
    Choice cbnm;
    Button bb;

    String username,password,name,pos,branch;
    int id;

    AuthorityDialog(Frame parent,String title,boolean state)
    {
        super(parent,title,state);

        lunm=new Label("Username");
        lpass1=new Label("Password");
        lpass2=new Label("Confirm PAssword");
        lnm=new Label("Name");
        lid=new Label("ID");
        lbnm=new Label("Branch");
        lpos=new Label("Position");

        tunm=new TextField(20);
        tpass1=new TextField(10);
        tpass2=new TextField(10);
        tnm=new TextField(20);
        tid=new TextField(10);
        tpos=new TextField(20);

        cbnm=new Choice();
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

        bb=new Button("Sign Up");
        bb.addActionListener(this);
        
        setLayout(null);

        lunm.setBounds(50,40,150,30);
        tunm.setBounds(300,40,350,50);
        lpass1.setBounds(50,130,150,30);
        tpass1.setBounds(300,130,350,50);
        lpass2.setBounds(50,220,150,30);
        tpass2.setBounds(300,220,350,50);
        lnm.setBounds(50,310,150,30);
        tnm.setBounds(300,310,350,50);
        lid.setBounds(50,400,150,30);
        tid.setBounds(300,400,350,50);
        lpos.setBounds(50,490,150,30);
        tpos.setBounds(300,490,350,50);
        lbnm.setBounds(50,580,150,30);
        cbnm.setBounds(300,580,350,50);
        bb.setBounds(300,670,100,50);
       

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

        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });

        setBackground(new Color(247,255,174));
        setSize(700,760);
        setVisible(true);
        setResizable(false);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        setVisible(false);
    }
    public void focusLost(FocusEvent e)
    {
        TextField t=(TextField)e.getSource();
        String str="";
        if(t==tpass1)
            str=tpass1.getText();
        if(t==tpass2)
        {
            if(str.equals(tpass1.getText())==false)
            {
                tpass2.requestFocus();
                return;
            }
            else
                password=tpass2.getText();
        }

        if(t==tpos)
        {
            bb.setEnabled(true);
        }
        name=tnm.getText();
        id=Integer.parseInt(tid.getText());
        pos=tpos.getText();
    }
    public void focusGained(FocusEvent e)
    {
        TextField t=(TextField)e.getSource();
        if(t==tunm)
             bb.setEnabled(false);
    }
    public void itemStateChanged(ItemEvent e)
    {
        branch=cbnm.getSelectedItem();
    }   
}