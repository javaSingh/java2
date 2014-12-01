import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.text.*;
import javax.swing.border.*;

class login1 extends JFrame implements ActionListener
 {
    JLabel luserid,luserpass,img1,l1;
    JTextField uid;          
    TextField upass;
    JButton blog,bexit;
    Connection cn1;
    Statement st1;
   
    Font f = new Font("Times New Roman",Font.BOLD,18);
    Font f0 = new Font("Monotype Corsiva",Font.BOLD,30);
    Font f1 = new Font("Areal",Font.BOLD,18);
    Font f2= new Font("Monotype Corsiva",4,50);
    login1()
    {
    
	super("Login");
	   try
        {
           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception ex)
        {
           System.out.println(ex);
        }
	
	    
	l1= new JLabel(new ImageIcon("login.png"), JLabel.CENTER);
	l1.setBounds(70,70,800,400);	
	    
	img1 = new JLabel(new ImageIcon("logo.jpg "));
    img1.setBounds(0,0,170,170);
    add(img1);
	
	luserid=new JLabel("User Name :");
	luserid.setBounds(380,280,100,20);
	luserid.setFont(f);
	add(luserid);
	
	luserpass=new JLabel("Password   :");
	luserpass.setBounds(380,350,100,20);
	luserpass.setFont(f);
	add(luserpass);
	
	uid=new JTextField();
	uid.setBounds(480,280,125,29);
	uid.setFont(f1);
	add(uid);
	
	upass=new TextField();
    upass.setEchoChar('*');
    upass.setFont(f1);
	upass.setBounds(480,350,125,29);
	add(upass);
	
	blog=new JButton("Login");
	blog.setBounds(400,420,80,25);
	blog.setFont(f);
	blog.addActionListener(this);
	blog.setMnemonic('o');
	blog.setToolTipText("Used for Log into the System");
	add(blog);	
	
	bexit=new JButton("Exit");
	bexit.setBounds(540,420,80,25);
	bexit.setFont(f);
	bexit.addActionListener(this);
	bexit.setMnemonic('e');
	bexit.setToolTipText("Used to Exit From System");
	add(bexit);
	
	
	JLabel l3=new JLabel("Administration of Spartance Cyber Cafe ");
	l3.setBounds(250,25,750,90);
	l3.setFont(f2);
	l3.setForeground(Color.black);
	add(l3);
	add(l1);
	
	
	 setSize(1100,700);
     setVisible(true);
     setResizable(false);
}
	
	public void actionPerformed(ActionEvent e1)
   { 
      String s1=e1.getActionCommand();
      if(s1.equals("Exit"))			//exit button ic clicked
      {
          System.exit(0);
      }
      else								//login button is clicked
      {
          try
	  {
	     int flag = 0;
	     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	     cn1 = DriverManager.getConnection("jdbc:odbc:mydsn1");
	     System.out.println("Connection Successfully!!!");
         Statement st1 = cn1.createStatement();
	     //Statement st2 = cn1.createStatement();
         st1 = cn1.createStatement(); 
         ResultSet rs1 = st1.executeQuery("SELECT* FROM Admin");
         String s2 = uid.getText();
         String s3 = upass.getText();
	     while(rs1.next())
             {
		        String s4 = rs1.getString("A_lname");
                System.out.println("Login name : "+s4);
                String s5 = rs1.getString("A_pwd");
                System.out.println("Password : "+s5);
                if((s2.equals(s4)) && (s3.equals(s5)))
                {
		   			flag = 1;
		   			break;                
                }
             }
             if(flag==1)
             {
             	JOptionPane.showMessageDialog((Component)null,"LOGIN,Successful...!","Login screen",-1);

  		         setVisible(false);
                //mainframe f1 = new mainframe();
                 
             }
             else
             {
               int dt1 = JOptionPane.PLAIN_MESSAGE;
	           JOptionPane.showMessageDialog((Component)null,"WRONG LOGIN,Plese Retry...!","Login screen",dt1);
	           uid.setText("");		 
	           upass.setText("");	
               uid.requestFocus();
            }
             cn1.close();
          }
          catch(Exception e)
          {
             System.out.println("SQL Error!"+e.getMessage());
          }
       }
    }
       
  

public static void main(String args[])
{
	new login1();
}
}