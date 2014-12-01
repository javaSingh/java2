import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.event.*;
import java.text.*;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.*;
import java.lang.*;

class addtime extends JFrame implements ActionListener
{
	JLabel l1, lmid, lmname, ldate,lamt,labal,ltt,ltt1,ltt3,ldv,ltb,img1,llt,llt1,llt2,lot,lot1,lot2;
	JTextField tmid, tmname,tdate,tamt,tabal,ttt,ttt2,tdv,ttb,tlt,tlt1,tlt2,tot,tot1;
	JButton add1, cancel, exit,search,home,endtime,cal1;  
	Font f3;
	String s;
	int flag=1,t1,id,amt;
	Connection con;
	ResultSet rs1,rs2,rs3;
	Statement st1, st2,st3;
	 Date date;
     GregorianCalendar cal;
     String strdate;
     int strtime,strtime1,totbal,totbal1,totbal2;
		
		addtime()
	   {
		super("# VALIDITY FRAME #");
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
		date=new Date();
		cal=new GregorianCalendar();
		strdate=cal.get(Calendar.DATE)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+(cal.get(Calendar.YEAR));
		strtime=cal.get(Calendar.HOUR_OF_DAY);
		strtime1=cal.get(Calendar.MINUTE);
		System.out.println(""+strdate);
		System.out.println(""+strtime+":"+strtime1);
		setconnection();
		
		l1= new JLabel(new ImageIcon("Time.png"), JLabel.CENTER);
		l1.setBounds(70,50,900,600);
		
		
		img1 = new JLabel(new ImageIcon("logo.jpg "));
      	img1.setBounds(0,0,120,110);
       	add(img1);
		
		lmid=new JLabel("Member ID :");
		lmid.setBounds(285,155,100,20);
		lmid.setFont(f3);
		add(lmid);
				
		tmid= new JTextField();
		tmid.setBounds(380,155,100,20);
		add(tmid);
		
		lmname=new JLabel("Member Name :");
		lmname.setBounds(250,190,120,25);
		lmname.setFont(f3);
		add(lmname);
		
		tmname = new JTextField();
	  	tmname.setBounds(380,190,250,20);
	  	tmname.setEditable(false);
	  	add(tmname);
	  	
		ldate=new JLabel("Date :");
        ldate.setBounds(320,240,110,25);
        add(ldate); 

      	tdate=new JTextField();
      	tdate.setBounds(380,240,70,25);
       	tdate.setEditable(false);
        add(tdate);
        
        ldv=new JLabel("Date Validity :");
     	ldv.setBounds(550,240,170,25);
     	add(ldv);

     	tdv=new JTextField();
     	tdv.setBounds(620,240,70,25); 
     	tdv.setEditable(false);
     	add(tdv);
     	
     	llt=new JLabel("Login Time:");
        llt.setBounds(295,290,150,20);
        add(llt);
         
       tlt=new JTextField();
       tlt.setBounds(380,290,30,20);
       add(tlt);
       tlt.addKeyListener(new KeyAdapter() 
		{
        public void keyPressed(KeyEvent EVT) 
        {
                String value = tlt.getText();
                int l = value.length();
             	            	
                if (EVT.getKeyChar() >= '0' && EVT.getKeyChar() <= '9' ||EVT.getKeyChar()=='\b')               
                {
                	 tlt.setEditable(true);
                }
                else 
                {
                     tlt.setEditable(true);
                    JOptionPane.showMessageDialog((Component)null,"Enter Valid Time","Cyber Cafe",JOptionPane.INFORMATION_MESSAGE);
             	}
         }
             	

        });
        
       
       llt1=new JLabel("hr");
       llt1.setBounds(412,290,30,20);
       add(llt1);
       
       tlt1=new JTextField();
       tlt1.setBounds(427,290,30,20);
       add(tlt1);
       
       llt2=new JLabel("mm");
       llt2.setBounds(459,290,30,20);
       add(llt2);
       
        ltb=new JLabel("Total Balance :");
    	ltb.setBounds(540,290,150,25);
   		add(ltb);
         
    	ttb=new JTextField();
    	ttb.setBounds(620,290,70,25);
    	ttb.setEditable(false);
    	add(ttb);
    	
    	lot=new JLabel("Logout Time:");
       lot.setBounds(295,340,150,20);
       add(lot);
         
       tot=new JTextField();
       tot.setBounds(380,340,30,20);
       tot.setEditable(false);
       add(tot);
         	
       lot1=new JLabel("hr");
       lot1.setBounds(412,340,20,20);
       add(lot1);
       
       tot1=new JTextField();
       tot1.setBounds(427,340,30,20);
       tot1.setEditable(false);
       add(tot1);
       
      	lot2=new JLabel("mm");
       lot2.setBounds(459,340,30,20);
       add(lot2);
       
       	lamt=new JLabel("Net Amount :");
        lamt.setBounds(550,340,100,25);
        add(lamt);
     
    
       tamt=new JTextField();
       tamt.setBounds(620,340,70,25);
       tamt.setEditable(false);
       add(tamt);
       
       ltt=new JLabel("Total Time :");
       ltt.setBounds(295,390,100,25);
       add(ltt);

      ttt=new JTextField();
      ttt.setBounds(380,390,30,25);
      ttt.setEditable(false);
      add(ttt);

     ltt1=new JLabel("hr ");
     ltt1.setBounds(412,390,15,25);
     add(ltt1);

     ttt2=new JTextField();
     ttt2.setBounds(427,390,30,25);
     ttt2.setEditable(false);
     add(ttt2);

     ltt3=new JLabel("mm ");
     ltt3.setBounds(459,390,50,25);
     add(ltt3);

     labal=new JLabel("Aval Balance :");
     labal.setBounds(550,390,150,25);
     add(labal);
         
     tabal=new JTextField();
     tabal.setBounds(620,390,70,25);
     tabal.setEditable(false);
     add(tabal);
         	
      search=new JButton("Search");
      search.setBounds(490,155,80,25);
      add(search);
      search.addActionListener(this); 
         	
      add1=new JButton("Save");
      add1.setBounds(530,460,80,25);
      add(add1);  
      add1.addActionListener(this);
         
      endtime=new JButton("EndTime");
      endtime.setBounds(330,460,80,25);
      add(endtime);
      endtime.addActionListener(this);  
       
      cal1=new JButton("Calculate");
      cal1.setBounds(430,460,80,25);
      add(cal1);
      cal1.addActionListener(this);
      
      home=new JButton("Home");
      home.setBounds(630,460,80,25);
      add(home);
      home.addActionListener(this); 

	  
     cancel=new JButton("Cancel");
     cancel.setBounds(430,500,80,25);
     add( cancel);
     cancel.addActionListener(this);
       
     exit=new JButton("Exit");
     exit.setBounds(530,500,80,25);
     add(exit);
     exit.addActionListener(this);
     add(l1);
      
      	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);              
   		setSize(1100,700);
		setVisible(true);
		setResizable(false);
  }
 
	  		void enablefields(boolean flag)
			{
		
			tmid.setEnabled(flag);
			tmname.setEnabled(flag);
			ttb.setEnabled(flag);
			tdv.setEnabled(flag);
			ttt2.setEnabled(flag);
			ttt.setEnabled(flag);
			tabal.setEnabled(flag);
			tamt.setEnabled(flag);
			tdate.setEnabled(flag);
			tlt.setEnabled(flag);
			tot.setEnabled(flag);
			tlt1.setEnabled(flag);
			tot1.setEnabled(flag);
		
		
		}//enablefields
	 	void enabledbuttons(boolean flag)
	 	{
	 		cancel.setEnabled(flag);
			exit.setEnabled(flag);
			endtime.setEnabled(flag);
			cal1.setEnabled(flag);
		}
		void clearfields()
		{
			tmid.setText("");
			tmname.setText("");
			ttb.setText("");
			tdv.setText("");
			ttt.setText("");
			ttt2.setText("");
			tabal.setText("");
			tdate.setText("");
			tlt.setText("");
			tlt1.setText("");
			tot.setText("");
			tot1.setText("");
			tamt.setText("");
		}	
	
	
  		void showfields(ResultSet rs3) throws SQLException
		{
		try
		{	
			//tmid.setText("");
			tmname.setText(rs3.getString(2));
			ttb.setText(rs3.getString(14));
			String st1=rs3.getString(15)+"/"+rs3.getString(16)+"/"+rs3.getString(17);
			tdv.setText(st1);
			tdate.setText(strdate);
			
		}
		catch(SQLException e1)
		{
		}
	}
	void setconnection()
	{
		try
		{
			
		    	
		    	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		    	con=DriverManager.getConnection("jdbc:odbc:mydsn1");
		    	st1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		    	st2=con.createStatement();
		    	st3=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		    	rs1=st1.executeQuery("select * from balance");
		    	rs2=st2.executeQuery("select * from shree");
		    	rs3=st3.executeQuery("select max(bid) from balance");
		    	System.out.println("Connection succesfully");
		}
		catch(Exception e1)
		{
			System.out.println("Connection error");
		}
	}
				
			
			
    
    		
	public void actionPerformed(ActionEvent e1)
	{
		String s1=e1.getActionCommand();
		if(s1.equals("Exit"))
		{
			System.exit(0);
		}//exit
			
		else if(s1.equals("Home"))
		{
			mainframe me=new mainframe();
		}//home 
		else if(s1.equals("Cancel"))
		{
			tmid.setEnabled(true);
			tlt.setEnabled(true);
			tlt1.setEnabled(true);
			clearfields();
			enabledbuttons(true);
			tmid.requestFocus();	 
		}//home 
		else if(s1.equals("EndTime"))
		{
			enablefields(false);
			enabledbuttons(true);
			String t3=String.valueOf(strtime);
			tot.setText(t3);
			String t4=String.valueOf(strtime1);
			tot1.setText(t4);
		}//EndTime
		else if(s1.equals("Save"))
		{
			try
			{
				if(flag==1)
				{		
					rs1.moveToInsertRow();
				}
				int id1=Integer.parseInt(tmid.getText());
								
				String d=tdate.getText();
				
				String ab=tabal.getText();
				int amt=Integer.parseInt(tamt.getText());
				String t1=ttt.getText()+":"+ttt2.getText();
				String l=tlt.getText()+":"+tlt1.getText();
				String o=tot.getText()+":"+tot1.getText();
				
				
				rs1.updateString(2,d);
				rs1.updateString(3,ab);
				rs1.updateString(4,t1);
				rs1.updateString(5,l);
				rs1.updateString(6,o);
				rs1.updateInt(7,amt);
				rs1.updateInt(8,id1);
				
				//System.out.println(rs3.getString(1));
				System.out.println("JAYASHRI");
					 
				if(flag==1)
				{
					
					rs1.insertRow();
					JOptionPane.showMessageDialog(this,"Adding New Record Successfully!!","Add New Record",JOptionPane.INFORMATION_MESSAGE);
					
					
				}
				
				//clearfields();
				enabledbuttons(true);
				endtime.setEnabled(true);
			 	cal1.setEnabled(true);
				enablefields(false);
			}
			catch(Exception e2)
			{
				JOptionPane.showMessageDialog(this,"Database Storing Error","Save",JOptionPane.INFORMATION_MESSAGE);
			}
		}//save
			
			else if(s1.equals("Search"))
			{
				
				try
				{
					int id=Integer.parseInt(tmid.getText());
					rs2=st2.executeQuery("Select * from shree where Mid="+id);
		    		if(rs2.next())
		    		{
		    			//System.out.println("Problem="+id);
		    			showfields(rs2);
		    		}
		    		else
		    		{
		    			JOptionPane.showMessageDialog(this,"Member Does not Found","Search",JOptionPane.INFORMATION_MESSAGE);
		    			tmid.setText("");
		    			tmid.requestFocus();
		    		} 
		    		
		    			
		   		}
		   		
				catch(Exception e)
				{
					
				}
			}
			else if(s1.equals("Calculate"))
			{
				
				try
				{    
					t1=Integer.parseInt(tlt.getText());
					int t2=Integer.parseInt(tlt1.getText());//login mm
					int t3=strtime;//logout hr
					int t4=strtime1;//logout mm
				
					int tothr=t3-t1;//tot hr
					int totmm=t4-t2;//tot mm
				
					if(totmm<0)
					{
						totmm=-totmm;
					}
				
				 String tothr1=String.valueOf(tothr);
				 ttt.setText(tothr1);//show tot hr
				 String totmm1=String.valueOf(totmm);
				 ttt2.setText(totmm1);
				 
				 int rate=tothr*20;
				 if(totmm>=15)
				 {
				 	rate=rate+5;
				 }
				 else if(totmm>=30)
				 {
				 	rate=rate+10;
				 }
				 else if(totmm>=45)
				 {
				 	rate=rate+15;
				 }
				
				 
				 String rate1=String.valueOf(rate);
				 tamt.setText(rate1);
				 
				 String t=rs2.getString(8);	
				 if(t.equals("Regular"))
				 {
				  	//ttb.setText(rs3.getString(14));
					int totbal=Integer.parseInt(ttb.getText());
					// System.out.println(""+totbal);
				 	int totbal1=totbal-rate;
					String totbal2=String.valueOf(totbal1);
				 	tabal.setText(totbal2);
				 }
				 else
				 {
				 	tamt.setText(rate1);
				 	tabal.setText(rate1);
				 }
				 
				 }
				 catch(Exception e)
				 {
				 	System.out.println("Error: "+e);
				 }
		}
	}
		
   public static void main(String args[])
   {
    addtime f1=new addtime();
    
   }
  
 }

       
       