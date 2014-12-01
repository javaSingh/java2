import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.sql.*;
import java.text.*;
import java.util.Date.*;


class balance extends JFrame  implements ActionListener
{
   
    JLabel l0,l1, lmid, lmname, lbt,lba,lvd,img1;
	JTextField tmid, tmname,lba1,lvd1,lbt1;
	JButton  search, exit,home,cancel;  
	Font f3;
	String s;
	
	Connection con;
	ResultSet rs1,rs3;
	Statement st1, st2,st3;
  
    balance()
    {
	 super("  Member Balance Frame ");
	 	try
        {
           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception ex)
        {
           System.out.println(ex);
        }
        	f3=new Font("Arial",Font.BOLD,15);

	
		setLayout(null);
		l1= new JLabel(new ImageIcon("Balance.png"), JLabel.CENTER);
		l1.setBounds(70,70,800,400);
		
		img1 = new JLabel(new ImageIcon("logo.jpg "));
      	img1.setBounds(0,0,120,110);
       	add(img1);
		
		lmid=new JLabel("Member ID :");
		lmid.setBounds(280,175,100,20);
		lmid.setFont(f3);
		add(lmid);
				
		tmid= new JTextField();
		tmid.setBounds(380,175,80,20);
		add(tmid);
		
		search = new JButton("Search");
		search.setBounds(470,175,80,25);
		add(search);
		
		lmname=new JLabel("Member Name :");
		lmname.setBounds(250,220,120,20);
		lmname.setFont(f3);
		add(lmname);
		
		tmname = new JTextField();
	  	tmname.setBounds(380,220,200,20);
	  	tmname.setEditable(false);
	   	add(tmname);
	  	
	 
   		lbt = new JLabel(" Balance Date  : ");
    	lbt.setBounds(280,255,80,25);
		add(lbt);
        
        lbt1 = new JTextField();
        lbt1.setBounds(380,255,80,20);
        lbt1.setEditable(false);
	    add(lbt1);

        lba = new JLabel(" Balance Amount  : ");
        lba.setBounds(265,285,150,25);
       	add(lba); 

        lba1 = new JTextField();
        lba1.setBounds(380,285,80,20);
        lba1.setEditable(false);
        add(lba1);

        lvd = new JLabel(" Validity Date  : ");
        lvd.setBounds(280,320,150,25);
	    add(lvd);              
             
        lvd1 = new JTextField();
        lvd1.setBounds(380,320,80,20);
       	lvd1.setEditable(false);
	    add(lvd1);  
              
		home = new JButton("Home");
		home.setBounds(420,370,80,25);
		add(home);
    	
    	exit = new JButton("Exit");
		exit.setBounds(530,370,80,25);
		add(exit);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(310,370,80,25);
		add(cancel);
    	
    	
    	home.addActionListener(this);
    	search.addActionListener(this);
    	exit.addActionListener(this);
    	cancel.addActionListener(this);	
    	
    	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1100,700);
		setVisible(true);
		add(l1);
}

		void showbalancefields(ResultSet rs3) throws SQLException
		{
		try
		{	
				tmname.setText(rs3.getString(2));
				lba1.setText(rs3.getString(14));
				String st=rs3.getString(11)+"/"+rs3.getString(12)+"/"+rs3.getString(13);
				lbt1.setText(st);
				String st1=rs3.getString(15)+"/"+rs3.getString(16)+"/"+rs3.getString(17);
				lvd1.setText(st1);
		}
		catch(Exception e)
		{
		}	
		}
		void clearfields()
		{
			
			tmname.setText("");
			lbt1.setText("");
			lba1.setText("");
			lvd1.setText("");
		}	
    	
       
	public void actionPerformed(ActionEvent e1)
	{
		String s1=e1.getActionCommand();
					
			if(s1.equals("Exit"))
			{
				
				System.exit(0);
				
			}//Exit
			
		else if(s1.equals("Home"))
			{
				
				mainframe m1=new mainframe();
				dispose();
			}//home
			
			
			
			else if(s1.equals("Search"))
			{
				try
				{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		    		Connection con=DriverManager.getConnection("jdbc:odbc:mydsn1");
		    		st3 = con.createStatement();
		    		System.out.println("Connection succesfully");
					
           		
        			
				 	int id=Integer.parseInt(tmid.getText());
				 
		    	
		    		ResultSet rs3=st3.executeQuery("Select * from shree where Mid="+id);
		    		if(rs3.next())
		    		{
		    			System.out.println("Problem="+id);
		    			showbalancefields(rs3);
		    		}
		    		else
		    		{
		    			JOptionPane.showMessageDialog(this,"Member does not Found","Search",JOptionPane.INFORMATION_MESSAGE);
		    			tmid.setText("");
		    			tmid.requestFocus();
		    		}
		    			
		    			
		   		}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(this,"Database Storing Error","Save",JOptionPane.INFORMATION_MESSAGE);	
				}
			}
			else if(s1.equals("Cancel"))
			{
				tmid.setText("");
				tmid.setEnabled(true);
				tmid.requestFocus();
				clearfields();
			}
	}     
     
     public static void main(String args[])
     {
     	new balance();
     }
 }
     