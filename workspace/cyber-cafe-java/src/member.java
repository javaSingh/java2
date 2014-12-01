import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.event.*;
import java.text.*;

class member extends JFrame implements ActionListener
{
	
	JLabel l1, lmid, lmname, ldob, lgender, laddr, lmno, leid, ldoj,lamnt, ltype,ldov;
	JTextField mid, mname,mno,eid,amnt;
	JTextArea addr;
	JComboBox day, month, year,day1, month1, year1, gender, type,day2,month2,year2;
	JButton next, prev, last, first,modify, anew, delete, save, cancel, exit,home;  
	Font f3;
	int n1;
	String s;
	String glist[]={"None","Male","Female"};
	String dlist[]={"None","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18",
					"19","20","21","22","23","24","25","26","27","28","29","30","31"};
	String mlist[]={"None","1","2","3","4","5","6","7","8","9","10","11","12"};
	String ylist[]={"None","1970","1971","1972","1973","1974","1975","1976","1977","1978","1979","1980",
					"1981","1982","1983","1984","1985","1986","1987","1988","1989","1990","1991","1992",
					"1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004",
					"2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016",
					"2017","2018","2019","2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030"};
	String ylist1[]={"None","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021",
					"2022","2023","2024","2025","2026","2027","2028","2029","2030","2031","2032","2033","2034",
					"2035","2036","2037","2038","2039","2040","2041","2042","2043","2044","2045","2046","2047","2048",
					"2049","2050","2051","2052","2053","2054","2055","2056","2057","2058","2059","2060"};
					
	String tlist[]={"None","Regular","Irregular"};
	
	int flag=1,c=0;
	
	Connection con;
	ResultSet rs1,rs2;
	Statement st1, st2,st3;
	

	member()
	{
		super("Cyber Cafe Management System");
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
		
		l1= new JLabel(new ImageIcon("Member.png"), JLabel.CENTER);
		l1.setBounds(70,50,900,600);
		
		
		lmid=new JLabel("Member ID :");
		lmid.setBounds(285,145,100,20);
		lmid.setFont(f3);
		add(lmid);
				
		mid= new JTextField();
		mid.setBounds(380,145,100,20);
		mid.setEditable(false);
		add(mid);
		
		lmname=new JLabel("Member Name :");
		lmname.setBounds(250,180,120,20);
		lmname.setFont(f3);
		add(lmname);
		
		mname = new JTextField();
	  	mname.setBounds(380,180,350,20);
	  	mname.setEditable(true);
	  	add(mname);
	  	
		mname.addKeyListener(new KeyAdapter() 
		{
        	public void keyPressed(KeyEvent EVT) 
        	{
                                
        		String value = mname.getText();
                int l = value.length();
                if (EVT.getKeyChar() >= 'a' && EVT.getKeyChar() <= 'z' ||EVT.getKeyChar() >= 'A' && EVT.getKeyChar() <= 'Z'|| EVT.getKeyChar()=='\b'|| EVT.getKeyChar()==' '|| EVT.isShiftDown()==true)               
                {
                	mname.setEditable(true);
                    //System.out.println("Error");
                }
                else 
                {
                    mname.setEditable(true);
                    JOptionPane.showMessageDialog((Component)null,"Enter Only Characters","Cyber Cafe",JOptionPane.INFORMATION_MESSAGE);
             
             	}
             }
          });
	
		ldob=new JLabel("Date of Birth :");
		ldob.setBounds(270,215,120,20);
		ldob.setFont(f3);
		add(ldob);
		
		day=new JComboBox(dlist);
		day.setBounds(380,215,50,20);
		add(day);
		
		month=new JComboBox(mlist);
		month.setBounds(435,215,75,20);
		add(month);
		
		year=new JComboBox(ylist);
		year.setBounds(515,215,60,20);
		add(year);
		
		lgender=new JLabel("Gender :");
		lgender.setBounds(580,215,120,20);
		lgender.setFont(f3);
		add(lgender);
		
		gender= new JComboBox(glist);
		gender.setBounds(650,215,80,20);
		add(gender);
		
		laddr=new JLabel("Address :");
		laddr.setBounds(300,250,120,20);
		laddr.setFont(f3);
		add(laddr);
		
		addr= new JTextArea();
		addr.setBounds(380,250,200,50);
		addr.setBorder(BorderFactory.createLineBorder(Color.black,1));
		add(addr);
		
		ltype=new JLabel("Type :");
		ltype.setBounds(600,250,120,20);
		ltype.setFont(f3);
		add(ltype);
		
		type= new JComboBox(tlist);
		type.setBounds(650,250,80,20);
		add(type);
		
		
		lmno=new JLabel("Mobile No :");
		lmno.setBounds(285,315,100,20);
		lmno.setFont(f3);
		add(lmno);
		
		mno= new JTextField();
		mno.setBounds(380,315,100,20);
		add(mno);
			mno.addKeyListener(new KeyAdapter() 
			{
        		public void keyPressed(KeyEvent EVT) 
        		{
                
        	               
        		String value = mno.getText();
                int l = value.length();
                if(l<10)
                {            	
                if (EVT.getKeyChar() >= '0' && EVT.getKeyChar() <= '9' ||EVT.getKeyChar()=='\b')               
                {
                	//mno.setEditable(true);
                }
                else 
                {
                    mno.setEditable(true);
                    JOptionPane.showMessageDialog((Component)null,"Enter Only Numbers","Cyber Cafe",JOptionPane.INFORMATION_MESSAGE);
             	}
          		}
             	else
             		JOptionPane.showMessageDialog((Component)null,"Enter Only 10 Numbers","Cyber Cafe",JOptionPane.INFORMATION_MESSAGE);
          }

         	});
      
      
		
		leid=new JLabel("Email ID :");
		leid.setBounds(485,315,100,20);
		leid.setFont(f3);
		add(leid);
		
		eid= new JTextField();
		eid.setBounds(560,315,170,20);
		add(eid);
		
		ldoj=new JLabel("Date of Joining :");
		ldoj.setBounds(250,350,140,20);
		ldoj.setFont(f3);
		add(ldoj);
		
		day1=new JComboBox(dlist);
		day1.setBounds(380,350,50,20);
		add(day1);
		
		month1=new JComboBox(mlist);
		month1.setBounds(435,350,75,20);
		add(month1);
		
		year1=new JComboBox(ylist1);
		year1.setBounds(515,350,60,20);
		add(year1);
		
		lamnt=new JLabel("Amount :");
		lamnt.setBounds(580,350,80,20);
		lamnt.setFont(f3);
		add(lamnt);
		
		amnt= new JTextField();
		amnt.setBounds(650,350,80,20);
		add(amnt);
		
		amnt.addKeyListener(new KeyAdapter() 
			{
        		public void keyPressed(KeyEvent EVT) 
        		{
                
        	               
        		String value = mno.getText();
                int l = value.length();
                   	
                if (EVT.getKeyChar() >= '0' && EVT.getKeyChar() <= '9' ||EVT.getKeyChar()=='\b')               
                {
                	amnt.setEditable(true);
                }
                else 
                {
                   amnt.setEditable(true);
                    JOptionPane.showMessageDialog((Component)null,"Enter Only Numbers","Cyber Cafe",JOptionPane.INFORMATION_MESSAGE);
             	}
          		}
             
          

         	});
         	
         	
        ldov=new JLabel("Date of Validity :");
		ldov.setBounds(250,380,140,20);
		ldov.setFont(f3);
		add(ldov);
		
		day2=new JComboBox(dlist);
		day2.setBounds(380,380,50,20);
		add(day2);
		
		month2=new JComboBox(mlist);
		month2.setBounds(435,380,75,20);
		add(month2);
		
		year2=new JComboBox(ylist1);
		year2.setBounds(515,380,60,20);
		add(year2);
		
		
		next = new JButton("Next");
		next.setBounds(280,425,80,25);
		add(next);
		
		prev = new JButton("Previous");
		prev.setBounds(380,425,80,25);
		add(prev);
		
		first = new JButton("First");
		first.setBounds(480,425,80,25);
		add(first);
		
		last = new JButton("Last");
		last.setBounds(580,425,80,25);
		add(last);
		
		anew = new JButton("New");
		anew.setBounds(680,425,80,25);
		add(anew);
		
		modify = new JButton("Modify");
		modify.setBounds(280,465,80,25);
		add(modify);
		
		delete = new JButton("Delete");
		delete.setBounds(380,465,80,25);
		add(delete);
		
		save = new JButton("Save");
		save.setBounds(480,465,80,25);
		add(save);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(580,465,80,25);
		add(cancel);
		
		exit = new JButton("Exit");
		exit.setBounds(680,465,80,25);
		add(exit);
		
		home = new JButton("Home");
		home.setBounds(480,505,80,25);
		add(home);
		
		next.addActionListener(this);
		prev.addActionListener(this);
		first.addActionListener(this);
		last.addActionListener(this);
		anew.addActionListener(this);
		modify.addActionListener(this);
		delete.addActionListener(this);
		save.addActionListener(this);
		cancel.addActionListener(this);
		exit.addActionListener(this);
		home.addActionListener(this);
		add(l1);
		
		try
		{
			setConnection();
			enablefields(false);
			
			if(rs1.next())
			{
				enabledbuttons(true);
				showfields();
			}
						
		}
		catch(Exception e) 
		{
			JOptionPane.showMessageDialog(this,"Database Missing Error!","Database Show Error",JOptionPane.ERROR_MESSAGE);
		}
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1100,700);
		setVisible(true);
		setResizable(false);
	}
	
	
	void setConnection()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		    con=DriverManager.getConnection("jdbc:odbc:mydsn1");
		    System.out.println("Connection succesfully");
		    st1=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE); 
		    rs1=st1.executeQuery("Select * from shree");
		    st2=con.createStatement(); 
		    
		    
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this,"Database Connection Error!","Database Error",JOptionPane.ERROR_MESSAGE);	
		}
	}//setConnection
	
	void enabledbuttons(boolean flag)
	{
		next.setEnabled(flag);
		prev.setEnabled(flag);
		first.setEnabled(flag);
		last.setEnabled(flag);
		anew.setEnabled(flag);
		modify.setEnabled(flag);
		delete.setEnabled(flag);
		save.setEnabled(flag);
		cancel.setEnabled(flag);
		exit.setEnabled(flag);
		
	}//enableButton 
	
	void showfields()
	{
		try
		{
			
			mid.setText(rs1.getString(1));
			mname.setText(rs1.getString(2));
			day.setSelectedItem(rs1.getString(3));
			month.setSelectedItem(rs1.getString(4));
			year.setSelectedItem(rs1.getString(5));
			gender.setSelectedItem(rs1.getString(6));
			addr.setText(rs1.getString(7));
			type.setSelectedItem(rs1.getString(8));
			mno.setText(rs1.getString(9));
			eid.setText(rs1.getString(10));
			day1.setSelectedItem(rs1.getString(11));
			month1.setSelectedItem(rs1.getString(12));
			year1.setSelectedItem(rs1.getString(13));
			amnt.setText(rs1.getString(14));
			day2.setSelectedItem(rs1.getString(15));
			month2.setSelectedItem(rs1.getString(16));
			year2.setSelectedItem(rs1.getString(17));
											
		}
		catch(Exception e1)
		{
			JOptionPane.showMessageDialog(this,"Data Show Error!","Show Error",JOptionPane.INFORMATION_MESSAGE);
		}
		
	}//showfield
	
	void clearfields()
	{
				
				mid.setText("");
				mname.setText("");
				day.setSelectedItem("None");
				month.setSelectedItem("None");
				year.setSelectedItem("None");
				gender.setSelectedItem("None");
				addr.setText("");
				type.setSelectedItem("None");
				mno.setText("");
				eid.setText("");
				day1.setSelectedItem("None");
				month1.setSelectedItem("None");
				year1.setSelectedItem("None");
				amnt.setText("");
				day2.setSelectedItem("None");
				month2.setSelectedItem("None");
				year2.setSelectedItem("None");							
			
		
	}//clearfields	
	
	void enablefields(boolean flag)
	{
		
		mid.setEnabled(flag);
		mname.setEnabled(flag);
		day.setEnabled(flag);
		month.setEnabled(flag);
		year.setEnabled(flag);
		gender.setEnabled(flag);
		addr.setEnabled(flag);
		type.setEnabled(flag);
		mno.setEnabled(flag);
		eid.setEnabled(flag);
		day1.setEnabled(flag);
		month1.setEnabled(flag);
		year1.setEnabled(flag);
		amnt.setEnabled(flag);
		day2.setEnabled(flag);
		month2.setEnabled(flag);
		year2.setEnabled(flag);	
		
	}//enablefields
	
	public void actionPerformed(ActionEvent e1)
	{
		String s1=e1.getActionCommand();
		try
		{
			
			if(s1.equals("Exit"))
			{
				
				System.exit(0);
				
			}//Exit
			
			else if(s1.equals("Next"))
			{
				if(rs1.next())
					showfields();
				else
				{
					rs1.last();
					showfields();
				}
					
			}//Next
					
			else if(s1.equals("Previous"))
			{
				if(rs1.previous())
					showfields();
				else
				{
					rs1.first();
					showfields();
				}
					
			}//Previous
			
			else if(s1.equals("First"))
			{
				rs1.first();
				showfields();
			}//First
			
			else if(s1.equals("Last"))
			{
				rs1.last();
				showfields();
			}//Last
					
			else if(s1.equals("New"))
			{
				next.setEnabled(false);
				prev.setEnabled(false);
				first.setEnabled(false);
				last.setEnabled(false);
				modify.setEnabled(false);
				delete.setEnabled(false);
				
				clearfields();
				enablefields(true);
				
				day.setSelectedItem("None");
				month.setSelectedItem("None");
				year.setSelectedItem("None");
				
				gender.setSelectedItem("None");
				type.setSelectedItem("None");
				
				day1.setSelectedItem("None");
				month1.setSelectedItem("None");
				year1.setSelectedItem("None");
				
				day2.setSelectedItem("None");
				month2.setSelectedItem("None");
				year2.setSelectedItem("None");
				
				mname.requestFocus();
				flag=1;
				
			}//Add New
					
			else if(s1.equals("Cancel"))
			{
				enabledbuttons(true);
				enablefields(false);
				
			}//Cancel
				else if(s1.equals("Home"))
			{
				mainframe m1=new mainframe();
				dispose();
				
			}//Cancel
			
			else if(s1.equals("Modify"))
			{
				enabledbuttons(true);
				anew.setEnabled(false);
				enablefields(true);
				mname.requestFocus();
				flag=2;
				
			}//Modify
			
			else if(s1.equals("Delete"))
			{
				try
				{
					
				    int id=Integer.parseInt(mid.getText());
				    st3=con.createStatement();
					String qry="delete * from shree where Mid="+id;
					st3.executeUpdate(qry);
					JOptionPane.showMessageDialog(this,"RECORD IS DELETE SUCCESSFULLY","Record Deleted",JOptionPane.INFORMATION_MESSAGE);
					clearfields();
					
				}
					
				catch(Exception et)
				{
					JOptionPane.showMessageDialog(this,"Record does not delete","Record Delete Error",JOptionPane.ERROR_MESSAGE);
				}
			}//Delete
					
			else if(s1.equals("Save"))
			{
				
				try
				{
					if(flag==1)
					{
						try
	            		{
	            
			        			rs2=st2.executeQuery("select max(Mid) from shree");
								System.out.println("Number found-----");
								if(rs2.next())
								{
									n1=Integer.parseInt(rs2.getString(1));
									n1=n1+1;
									System.out.println("Number increment to-----" + n1);
									String m11=String.valueOf(n1);
									mid.setText(m11);
								}
								else
									mid.setText("1");
							
	   		  			}
	   		  			catch(SQLException e2)
	   		  			{
	   		  				JOptionPane.showMessageDialog(this,"Member id Storing Error!!!","mid Error",JOptionPane.INFORMATION_MESSAGE);	
	   		  			}
	   		  		}
					
					if(flag==1)
					{
						rs1.moveToInsertRow();
					}
					//int rno=Integer.parseInt(mid.getText());
					String name=mname.getText();
					
					int d=Integer.parseInt(day.getSelectedItem().toString());
					int m=Integer.parseInt(month.getSelectedItem().toString());
					int y=Integer.parseInt(year.getSelectedItem().toString());
					
					String g=gender.getSelectedItem().toString();
					
					String adr=addr.getText();
					String t=type.getSelectedItem().toString();
					String mn=mno.getText();
					
					String e=eid.getText();
					
					int d1=Integer.parseInt(day1.getSelectedItem().toString());
					int m1=Integer.parseInt(month1.getSelectedItem().toString());
					int y1=Integer.parseInt(year1.getSelectedItem().toString());
					
					int am=Integer.parseInt(amnt.getText());
					int d2=Integer.parseInt(day2.getSelectedItem().toString());
					int m2=Integer.parseInt(month2.getSelectedItem().toString());
					int y2=Integer.parseInt(year2.getSelectedItem().toString());
					
					if(mname.getText().equals("")) 
                 	{
                    	JOptionPane.showMessageDialog((Component)null,"Please,Enter Member Name","Message",-1);
                 	}
                 
			
                     
					
					rs1.updateInt(1,n1);
					rs1.updateString(2,name);
					rs1.updateInt(3,d);
					
					rs1.updateInt(4,m);
					rs1.updateInt(5,y);
					rs1.updateString(6,g);
					rs1.updateString(7,adr);
					rs1.updateString(8,t);
					rs1.updateString(9,mn);
					rs1.updateString(10,e);
					rs1.updateInt(11,d1);
					rs1.updateInt(12,m1);
					rs1.updateInt(13,y1);
					rs1.updateInt(14,am);
					rs1.updateInt(15,d2);
					rs1.updateInt(16,m2);
					rs1.updateInt(17,y2);
					
					
					if(flag==1)
					{
						
						rs1.insertRow();
						System.out.println("Error");
						JOptionPane.showMessageDialog(this,"Adding New Record Successfully!!","Add New Record",JOptionPane.INFORMATION_MESSAGE);
						clearfields();
						
					}
					else
					{
						rs1.updateRow();
						rs1.refreshRow();
						JOptionPane.showMessageDialog(this,"Record Update Successfully!!","Record Update",JOptionPane.INFORMATION_MESSAGE);
					}
					enabledbuttons(true);
					enablefields(false);
					
					
					
				}
				
				catch(NumberFormatException e)
				{
					JOptionPane.showMessageDialog(this,"DataBase Storing Error !","Saving Error",JOptionPane.INFORMATION_MESSAGE);
				}
			}//Save
					
		}
		catch(Exception e2)
		{
			JOptionPane.showMessageDialog(this,"Form Number ERROR!","Form Number Missing",JOptionPane.WARNING_MESSAGE);	
	
		}
		
	}

	public static void main(String args[])
	{
		new member();
	}
}
		
				 
		
		
		