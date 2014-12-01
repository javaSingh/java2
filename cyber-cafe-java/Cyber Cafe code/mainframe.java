import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;


class mainframe extends JFrame implements ActionListener
 {
   JButton b1,b2,b3,b4,b5,b6;
   
   JLabel wel,img1,img;
   Font f0 = new Font("Monotype Corsiva",Font.BOLD+Font.ITALIC,30);
   Font f1 = new Font("Monotype Corsiva",Font.BOLD,20); 
   Font f2 = new Font("Monotype Corsiva",Font.BOLD+Font.ITALIC,55);
    
    mainframe()
    {
      super(" MainFrame  ");
      
      try
        {
           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception ex)
        {
           System.out.println(ex);
        }
      	setLayout(null);
    
      	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      	wel = new JLabel(" ");
      	wel.setBounds(210,30,370,60);
     	wel.setForeground(Color.RED);
      	wel.setFont(f2);
      	add(wel); 
      
      	img1 = new JLabel(new ImageIcon("logo.jpg "));
      	img1.setBounds(0,0,120,110);
      	add(img1);
       	
       	
    	ImageIcon i3=new ImageIcon("dip.jpg");
		img=new JLabel("",i3,JLabel.RIGHT);
		img.setBorder(BorderFactory.createEtchedBorder(Color.RED,Color.RED));
		img.setBounds(400,130,574,400);
		add(img);
	

      	b1 = new JButton("Add Member");
      	b1.setBounds(50,140,250,50);
      	b1.setMnemonic('A');
      	b1.setFont(f0);  
      	add(b1);
      	b1.setBorder(BorderFactory.createEtchedBorder(Color.RED,Color.orange));
      	b1.setToolTipText("Add New Member");
  
      	b2 = new JButton("Add Time");
      	b2.setBounds(50,210,250,50);
      	b2.setMnemonic('T');
      	b2.setFont(f0);  
      	add(b2);
      	b2.setBorder(BorderFactory.createEtchedBorder(Color.RED,Color.orange));
      	b2.setToolTipText("Assign Time To Member");
     
     
      	b3 = new JButton("Balance");
      	b3.setBounds(50,280,250,50);
      	b3.setMnemonic('B');
      	b3.setFont(f0); 
      	add(b3);
      	b3.setBorder(BorderFactory.createEtchedBorder(Color.RED,Color.orange));
      	b3.setToolTipText("Check Member Balance");
    

      	b4 = new JButton("Bill");
      	b4.setBounds(50,350,250,50);
      	b4.setMnemonic('I');
      	b4.setFont(f0);
      	add(b4);
      	b4.setBorder(BorderFactory.createEtchedBorder(Color.RED,Color.orange));
      	b4.setToolTipText("Calculate Bill");

      	b5= new JButton("Exit");
      	b5.setBounds(50,490,250,50);
      	b5.setMnemonic('Q');
      	b5.setFont(f0); 
      	add(b5);
      	b5.setBorder(BorderFactory.createEtchedBorder(Color.RED,Color.orange));
      	b5.setToolTipText("Close The Window");
	

		b6= new JButton("Reports");
     	b6.setBounds(50,420,250,50);
      	b6.setMnemonic('R');
      	b6.setFont(f0); 
      	add(b6);
      	b6.setBorder(BorderFactory.createEtchedBorder(Color.RED,Color.orange));
      	b6.setToolTipText("show the Reports");
      	
      	
      	b1.addActionListener(this);
      	b2.addActionListener(this);
      	b3.addActionListener(this);
      	b4.addActionListener(this);
      	b5.addActionListener(this);
      	b6.addActionListener(this);     
     
      
      	setSize(1100,700);
      	setVisible(true);
      
    }


  public void actionPerformed(ActionEvent ae)
    {
	 if(ae.getSource() == b1)//add member
	 {
	    
	    member m1=new member();
	    dispose();      
         }

         if(ae.getSource() == b2)//add time
	  {
	    
	    addtime p2 = new addtime();
	    dispose();
	    
           }

         if(ae.getSource() == b3)//Balance
	 {
	    balance p3=new balance();
	     dispose();     
	 }	
         if(ae.getSource() == b4)//Bill
	 {
	  	bill f1=new bill();
	   	dispose();
         }
     
         if(ae.getSource() == b5)//Exit
	{
	     System.exit(0);
        }
         if(ae.getSource() == b6)//report
	{
	   Report r1=new Report();
	    dispose();
        }

     
    }
         
    public static void main(String args[])
   {
    mainframe f1 = new mainframe();
    
   }     
 }
 