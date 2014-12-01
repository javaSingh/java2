import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.sql.*;
import java.text.*;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.*;



class bill extends JFrame implements ActionListener
{
   
    JLabel l0,l1,l2,l3,lmid, lmname, llt,llo,ltt,ld,lta,lavb,lrb,lep,lamt2,lamt3,lns,lsc1,lsc,lamt,lnp,lp1,lp,img1,ltt1,ltt2,lnb;
	JTextField tmid, tmname,tlt,tlo,ttt,td,tavb,trb,tep1,tep,tamt1,tamt2,tamt3,tns,tsc1,tsc,tamt,tnp1,tp1,tp,trb1,tta,tta1,tavb1,ttt1,ttt2,tnb,tnb1;
	JButton  cal1,cancel, search, exit,home,save;  
	Font f3,f1,f2;
	String s,ep,rb1,n,a,a1,tot1;
	int t1,ep1,aa,rb,ab,n1,n2,s2,tot,s11,aaa;
	int flag=1;
	Connection con,con2;
	ResultSet rs1,rs2,rs3,rs4,rs5,rs6;
	Statement st1,st2,st3,st4,st5,st6;
	Date date;
    GregorianCalendar cal;
    String strdate;
    String strtime;
    bill()
    {
	 	super("Member Balance Frame");
	 	try
        {
           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception ex)
        {
           System.out.println(ex);
        }
        f3=new Font("Arial",Font.BOLD,15);
		f1=new Font("Arial",Font.BOLD,12);
		f2=new Font("Arial",Font.BOLD,19);
			
		setLayout(null);
		setConnection();	
		
		date=new Date();
		cal=new GregorianCalendar();
		strdate=cal.get(Calendar.DATE)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+(cal.get(Calendar.YEAR));
		strtime=cal.get(Calendar.HOUR_OF_DAY)+":"+(cal.get(Calendar.MINUTE));
		System.out.println(""+strdate);
		System.out.println(""+strtime);
		
		
		l0 = new JLabel("  SPARTANCE CYBER CAFE  ");
    	l0.setBounds(390,70,450,35);
		l0.setFont(f2);
		add(l0);
		
		l2 = new JLabel("BHONSALA MILITARY COLLEGE,RAMBHOOMI,NASIK                    Mob NO:9595612917");
    	l2.setBounds(300,90,450,35);
		l2.setFont(f1);
		add(l2);
		
		l1= new JLabel(new ImageIcon("Bill.png"), JLabel.CENTER);
		l1.setBounds(120,30,800,600);
		
		img1 = new JLabel(new ImageIcon("logo.jpg "));
      	img1.setBounds(0,0,120,110);
       	add(img1); 
		
		lmid=new JLabel("Member ID :");
		lmid.setBounds(285,145,100,20);
		lmid.setFont(f3);
		add(lmid);
				
		tmid= new JTextField();
		tmid.setBounds(380,145,80,20);
		add(tmid);
		
		lmname=new JLabel("Member Name :");
		lmname.setBounds(265,180,120,20);
		lmname.setFont(f3);
		add(lmname);
		
		tmname = new JTextField();
	  	tmname.setBounds(380,180,200,20);
	  	tmname.setEditable(false);
	  	add(tmname);
	  	
		
        llt = new JLabel(" Login Time  : ");
        llt.setBounds(280,220,150,25);
		llt.setFont(f1);
        add(llt);
        
        tlt = new JTextField();
        tlt.setBounds(370,220,70,25);
		add(tlt);
	    tlt.setEditable(false);

        llo = new JLabel(" Logout Time : ");
        llo.setBounds(280,255,150,25);
		llo.setFont(f1);
        add(llo); 

        tlo = new JTextField();
        tlo.setBounds(370,255,70,25);
		add(tlo);
	    tlo.setEditable(false);

        ltt = new JLabel(" Total Time  : ");
        ltt.setBounds(280,300,150,25);
		ltt.setFont(f1);
        add(ltt); 
                     
             
        ttt = new JTextField();
        ttt.setBounds(370,300,70,25);
		add(ttt);  
		ttt.setEditable(false);
		
		
       
        ld = new JLabel(" Date : ");
        ld.setBounds(710,145,150,25);
		ld.setFont(f1);
        add(ld);
        
        
    	td = new JTextField();
		td.setBounds(750,145,100,25);
		td.setFont(f1);
		add(td);
		td.setEditable(false);
       
          
        lta = new JLabel(" Total Balance: ");
        lta.setBounds(280,340,150,25);
	    lta.setFont(f1);
        add(lta);
 

        tta = new JTextField();
        tta.setBounds(370,340,70,25);
         add(tta);
         tta.setEditable(false);

        tta1 = new JTextField("Rs.");
        tta1.setBounds(440,340,30,25);
        add(tta1);
        tta1.setEditable(false);

        lavb = new JLabel("Aval Balance :");
        lavb.setBounds(280,375,150,25);
        lavb.setFont(f1); 
         add(lavb);

        tavb = new JTextField();
        tavb.setBounds(370,375,70,25);
         add(tavb);
         tavb.setEditable(false);

        tavb1 = new JTextField("Rs.");
        tavb1.setBounds(440,375,30,25);
         add(tavb1);
         tavb1.setEditable(false);
         
        lnb = new JLabel("Net Amount :");
        lnb.setBounds(280,410,150,25);
        lnb.setFont(f1); 
        add(lnb);
         
        tnb = new JTextField();
        tnb.setBounds(370,410,70,25);
        add(tnb);
        tnb.setEditable(false);

        tnb1 = new JTextField("Rs.");
        tnb1.setBounds(440,410,30,25);
        add(tnb1);
        tnb1.setEditable(false);

         lrb = new JLabel("Remaining Balance :");
       	lrb.setBounds(250,450,250,25);
        lrb.setFont(f1); 
         add(lrb);

        trb = new JTextField();
        trb .setBounds(370,450,70,25);
         add(trb );
         trb .setEditable(false);

        trb1  = new JTextField("Rs.");
        trb1 .setBounds(440,450,30,25);
         add(trb1 );
         trb1 .setEditable(false);
           
        lp = new JLabel(" Add Print Outs  : ");
        lp.setBounds(550,220,220,25);
		lp.setFont(f1);
        add(lp);
        lp.setBorder(BorderFactory.createLineBorder(Color.black,1));

        lp1 = new JLabel("Printing Amount:");
        lp1.setBounds(550,255,120,15);
		add(lp1);
 

        tp = new JTextField("5");
        tp.setBounds(640,255,25,20);
        add(tp);
        tp.setEditable(false);

        tp1 = new JTextField("Rs.");
        tp1.setBounds(665,255,24,20);
         add(tp1);
         tp1.setEditable(false);

       	lnp = new JLabel("No.of Prints:");
        lnp.setBounds(550,285,120,15);
		add(lnp);
 

       	tnp1 = new JTextField();
        tnp1.setBounds(640,285,25,20);
         add(tnp1);

        lamt = new JLabel("Amount:");
        lamt.setBounds(550,310,120,15);
	 	add(lamt);
 

        tamt = new JTextField();
        tamt.setBounds(640,310,35,20);
         add(tamt);
         tamt.setEditable(false);

        tamt1 = new JTextField("Rs.");
        tamt1.setBounds(675,310,24,20);
        add(tamt1);
         tamt1.setEditable(false);

            
        lsc = new JLabel("Add Scanning's:");
       	lsc.setBounds(550,340,220,25);
		lsc.setFont(f1);
       	add(lsc);
        lsc.setBorder(BorderFactory.createLineBorder(Color.black,2));

        lsc1= new JLabel("Scanning Amount:");
        lsc1.setBounds(550,377,120,15);
	 	add(lsc1);
 

        tsc = new JTextField("5");
        tsc.setBounds(640,377,25,20);
        add(tsc);
        tsc.setEditable(false);

        tsc1 = new JTextField("Rs.");
        tsc1.setBounds(665,377,24,20);
        add(tsc1);
         tsc1.setEditable(false);

       	lns = new JLabel("No.of Scan's:");
        lns.setBounds(550,410,120,15);
	 	add(lns);
 

        tns = new JTextField();
        tns.setBounds(640,410,25,20);
        add(tns);

        lamt2 = new JLabel("Amount:");
        lamt2.setBounds(550,440,120,15);
	 	add(lamt2);
 

        tamt2= new JTextField();
        tamt2.setBounds(640,440,35,20);
        add(tamt2);
        tamt2.setEditable(false);

        tamt3 = new JTextField("Rs.");
        tamt3.setBounds(675,440,24,20);
        add(tamt3);
        tamt3.setEditable(false);
          
        lep = new JLabel("Extra Pay :");
        lep.setBounds(550,475,150,25);
        lep.setFont(f1); 
        add(lep);
         

        tep = new JTextField();
        tep.setBounds(640,475,50,25);
        add(tep);
        tep.setEditable(true);

        tep1 = new JTextField("Rs.");
        tep1.setBounds(690,475,30,25);
        add(tep1);
        tep1.setEditable(false);
         
          

    cal1 = new JButton("Calculate");
	cal1.setBounds(250,550,80,25);
	cal1.addActionListener(this); 
	add(cal1);

	cancel = new JButton("Cancel");
	cancel.setBounds(350,550,80,25);
	cancel.addActionListener(this);
	add(cancel);
	
	exit=new JButton("Exit");
    exit.setBounds(660,550,80,25);
    exit.addActionListener(this);
    add(exit);
    
	search=new JButton("Search");
    search.setBounds(510,144,80,25);
   	search.addActionListener(this); 
    add(search);
	
	home = new JButton("Home");
	home.setBounds(550,550,80,25);
	home.addActionListener(this); 
	add(home);
	add(l1);
	
	save = new JButton("Save");
	save.setBounds(450,550,80,25);
	save.addActionListener(this); 
	add(save);
	add(l1);	      
		      
	
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setSize(1100,700);
	setVisible(true);
	setResizable(false);
 }//constructor
     
     
     void clearfields()
	{
		
		tmid.setText("");
		tmname.setText("");
		tlt.setText("");
		tlo.setText("");
		ttt.setText("");
		td.setText("");
		tta.setText("");
		tavb.setText("");
		tnb.setText("");
		trb.setText("");
		tnp1.setText("");
		tamt.setText("");
		tns.setText("");
		tamt2.setText("");
		tep.setText("");
		
	}
	
		void setConnection()
		{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		    con=DriverManager.getConnection("jdbc:odbc:mydsn1");
		    st1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		    st2 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		    st3 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		    st4 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		    
		   	rs1=st1.executeQuery("select * from balance");
		    rs2=st2.executeQuery("select * from shree");
		    rs3=st3.executeQuery("select * from bill");
		    rs4=st4.executeQuery("select * from amount");
		    
		    System.out.println("Connection succesfully");
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this,"Database Connection Error!","Database Error",JOptionPane.ERROR_MESSAGE);	
		}
	}//setConnection
	void showfields(ResultSet rs1,ResultSet rs2) throws SQLException
		{
			try
			{	
			
				tmname.setText(rs2.getString(2));
				tta.setText(rs2.getString(14));
				td.setText(strdate);
				ttt.setText(rs1.getString(4));
				tlt.setText(rs1.getString(5));
				tlo.setText(rs1.getString(6));
				tavb.setText(rs1.getString(3));
			
			}
			catch(SQLException e1)
			{
			}
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
				//setVisible(true);
			}//home
			
			else if(s1.equals("Cancel"))
			{
				tmid.setText("");
				tmid.setEnabled(true);
				tmid.requestFocus();
				clearfields();
			 
			}//cancel	
     		else if(s1.equals("Search"))
     		{
     
				try
				{
					
					int id=Integer.parseInt(tmid.getText());
					rs2=st2.executeQuery("Select * from shree where Mid="+id);
					rs1=st1.executeQuery("Select * from balance where Mid1="+id);
		    		if(rs2.next()&&rs1.next())
		    		{
		    			System.out.println("Problem="+id);
		    			showfields(rs1,rs2);
		    		}
		    		else
		    		{
		    				JOptionPane.showMessageDialog(this,"Member Record Does not Found","Search",JOptionPane.ERROR_MESSAGE);	
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
					int id1=Integer.parseInt(tmid.getText());
					//st5=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					//rs5=st5.executeQuery("Select *from shree where Mid="+id1);
					String t=rs2.getString(8);				
							
					
					
				
				if(t.equals("Regular"))
				{ 
			        
			        n1=Integer.parseInt(tnp1.getText());
					n2=n1*5;
					a=String.valueOf(n2);
					
					s=tns.getText();
					s11=Integer.parseInt(s);
					s2=s11*5;
					a1=String.valueOf(s2);
					ep=tep.getText();
					ep1=Integer.parseInt(ep);
					String b1=String.valueOf(s2+n2+ep1);		
									
					tamt.setText(a);
					tamt2.setText(a1);
					tnb.setText(b1);
					aa=Integer.parseInt(tavb.getText());
					int bb=Integer.parseInt(tnb.getText());
					String cc=String.valueOf(aa-bb);
					
				
					trb.setText(cc);
		
				}
				else
				{
					System.out.println("Irregular Error");
					n=tnp1.getText();
					n1=Integer.parseInt(n);
					n2=n1*5;
					a=String.valueOf(n2);
					
					
					s=tns.getText();
					s11=Integer.parseInt(s);
					s2=s11*5;
					a1=String.valueOf(s2);
				
					
					ep=tep.getText();
					ep1=Integer.parseInt(ep);
					
					aaa=Integer.parseInt(tavb.getText());
					
					tot=n2+s2+ep1+aaa;
					tot1=String.valueOf(tot);
					
					tamt.setText(a);
					tamt2.setText(a1);
					tnb.setText(tot1);
					trb.setText("0");
					tavb.setText("0");
				}
			}
			catch(Exception e11)
			{
				System.out.println("Error:"+e11.getMessage());
			}
			}
			else if(s1.equals("Save"))
			{
				try
				{
					if(flag==1)
					{		
						rs4.moveToInsertRow();
					}
				
					int np=Integer.parseInt(tnp1.getText());
					int pamt=Integer.parseInt(tamt.getText());
					int sp=Integer.parseInt(tns.getText());
					int samt=Integer.parseInt(tamt2.getText());
					int ep11=Integer.parseInt(tep.getText());
					int rb11=Integer.parseInt(trb.getText());
				
					rs4.updateInt(2,np);
					rs4.updateInt(3,pamt);
					rs4.updateInt(4,sp);
					rs4.updateInt(5,samt);
					rs4.updateInt(6,ep11);
					rs4.updateInt(7,rb11);
				
					if(flag==1)
					{
					
						rs4.insertRow();
						JOptionPane.showMessageDialog(this,"Adding New Record Successfully!!","Add New Record",JOptionPane.INFORMATION_MESSAGE);
					}
				}	
				
				catch(Exception e2)
				{
					JOptionPane.showMessageDialog(this,"Database Storing Error","Save",JOptionPane.INFORMATION_MESSAGE);
				}
			}//save
				
				
				
	}
     
     public static void main(String args[])
     {
     	new bill();
     }  
  }        
          
	 