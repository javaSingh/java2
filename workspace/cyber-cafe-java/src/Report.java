import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

class Report extends JFrame implements ActionListener
{
    
     
     JTabbedPane tb=new JTabbedPane();
     JPanel Datewise;
     JPanel Type;
     String t1;
     JScrollPane jsp,jsp1;
     JTable table,tab,tab1;
     JTextField td,td1;
     JLabel ld,ld1,l3,l2,l1;
     JButton b1,bs,bs1,b2;
     
     Font f1=new Font("Cambria",1,16);
     Font f=new Font("Cambria",4,35); 
       
     String[] colhead={"Mid","Member Name","login time","logout time","Date of Join","date od Validity"};
     String[] colhead1={"Mid","MemberName","DOB","Address","Mobile","Type","DateofJoin","DateofVal"};
	 //String[] colhead2={"Staff ID","Staff Name","DOB","Address","Mob.No","Subject","Working Time"};	

     Object[][] data=new Object[60][6];
     Object[][] data1=new Object[65][8];
     //Object[][] data2=new Object[25][7];
     
     Connection con;
     Statement st1,st2,st3;
     ResultSet rs1,rs2,rs3;
     int cnt1=0,cnt2=0,cnt3=0;
     
     
     int[] count1=new int[60];
     
     public Report()
     {
     	super("REPORT....!");
     	try
    	{
    		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
     	
	     	Container c=getContentPane();
	     	c.setLayout(null);
	     	setconnection();
	     	
	     	Datewise=new JPanel();
	     	Datewise.setBounds(100,100,768,100);
	     	Datewise.setLayout(null);
	     	
	     	Type=new JPanel();
			Type.setLayout(null);
			
		//	staff=new JPanel();
		//	staff.setLayout(null);
	
	     	
	     	tb.addTab("Date Report",Datewise);
	     	tb.addTab("RTYPE REPORT",Type);
	     	//tb.addTab("STAFF REPORT",staff);
			tb.setBounds(120,80,600,550);
	     	tb.setBorder(new LineBorder(Color.RED,2));
	     	c.add(tb);
	     	
	     
	     	 
	     	
	     	l2=new JLabel("REPORTS");
	     	l2.setFont(f);
	     	l2.setBounds(350,20,500,60);
	     	c.add(l2);
	     	//PANEL Admission
	     	
	     	  tab=new JTable(data,colhead);
	     	  jsp=new JScrollPane(tab);
	          jsp.setBounds(10,80,565,545);
	          Datewise.add(jsp);
	          
	          tab1=new JTable(data1,colhead1);
	          jsp1=new JScrollPane(tab1);
	          jsp1.setBounds(10,80,565,545);
	          Type.add(jsp1);
	          
	         /* JTable tab2=new JTable(data2,colhead2);
	          JScrollPane jsp2=new JScrollPane(tab2);
	          jsp2.setBounds(10,30,565,545);
	          staff.add(jsp2);*/
	     	  
	     	   
	    	  l1=new JLabel("Total Member="+cnt1);          	;
	          l1.setBounds(25,33,300,30);
	          l1.setFont(f1);
	          Datewise.add(l1);
	          
	          ld=new JLabel("Enter the date: ");
	          ld.setBounds(25,2,150,30);
	          ld.setFont(f1);
	          Datewise.add(ld);
	          
	          td=new JTextField();
	          td.setBounds(145,9,100,20);
	          td.setFont(f1);
	          Datewise.add(td);
	          
	          
	          
	          ld1=new JLabel("Enter the type: ");
	          ld1.setBounds(25,2,150,30);
	          ld1.setFont(f1);
	          Type.add(ld1);
	          
	          td1=new JTextField();
	          td1.setBounds(145,9,100,20);
	          //td1.setFont(f1);
	          Type.add(td1);
	          
	          bs1=new JButton("Search1");
	          bs1.setBounds(248,9,80,20);
	          Type.add(bs1);
	          bs1.addActionListener(this);
	          
	          bs=new JButton("Search");
	          bs.setBounds(248,9,80,20);
	          Datewise.add(bs);
	          bs.addActionListener(this);
          	
	        b1=new JButton("HOME");
	     	b1.setBounds(295,640,100,50);
	     	b1.setMnemonic('H');
	     	b1.setBorder(new LineBorder(Color.BLUE,2));
	     	b1.addActionListener(this);
	     	c.add(b1);
		  
		  	b2=new JButton("EXIT");
	     	b2.setBounds(400,640,100,50);
	     	b2.setMnemonic('Q');
	     	b2.setBorder(new LineBorder(Color.BLUE,2));
	     	b2.addActionListener(this);
	     	c.add(b2);
		  
		 /* l3=new JLabel("Total Member=");
	      l3.setBounds(25,43,300,30);
	      //l3.setFont(f1);
	      Type.add(l3);*/
	      
	     /* JLabel l4=new JLabel("Total Staff Member="+cnt3);
	      l4.setBounds(25,3,300,30);
	      l4.setFont(f1);
	      staff.add(l4);*/
	
	
	setSize(1024,768);
	setVisible(true);
}

void setconnection()
	{
		try
		{
			
		    	
		    	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		    	con=DriverManager.getConnection("jdbc:odbc:mydsn1");
		    	System.out.println("Connection succesfully");
		    	
		}
		catch(Exception e1)
		{
			System.out.println("Connection error");
		}
	}
public void actionPerformed(ActionEvent ae)
{
	String s1=ae.getActionCommand();
	
	if(s1.equals("Search1"))
	{
		String t1=td1.getText();
		System.out.println(""+t1);
     	try
       	   {
       	   	
       	   		
       	   	 	st1=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	       		rs1=st1.executeQuery("select * from shree where Type='"+t1+"'");
	      		while(rs1.next())
	       	    {
	       	    	int j=0;
	       	    	for(int k=0;k<61;k++)
	       	    	{
	       	    		for(int m=0;m<8;m++)
	       	    		{
	       	    			data1[k][m]="";
	       	    		}
	       	    	}
	       	    	for(int i=0;i<61;i++)
	       	    	{
	       	    		data1[i][j]=rs1.getString(1);
	       	    		j++;
	       	    		data1[i][j]=rs1.getString(2);
	       	    		j++;
	       	    		data1[i][j]=rs1.getString(6);
	       	    		j++;
	       	    		data1[i][j]=rs1.getString(7);
	       	    		j++;
	       	    		data1[i][j]=rs1.getString(8);
	       	    		j++;
	       	    		data1[i][j]=rs1.getString(9);
	       	    		j++;
	       	    		data1[i][j]=rs1.getString(11)+"/"+rs1.getString(12)+"/"+rs1.getString(13);
	       	    		j++;
	       	    		data1[i][j]=rs1.getString(15)+"/"+rs1.getString(16)+"/"+rs1.getString(17);
	       	    		j-=7;
	       	    		
	       	    		rs1.next();
	       	    		cnt2++;
	       	    	}
	       	    }
	     
	       	   	rs1.close();
       	   	  
       	   }
       	   catch(SQLException kl)
       	   {
       	   	    System.out.println(kl);
       	   }
       	   catch(ArrayIndexOutOfBoundsException out)
       	   {
       	   		System.out.println(out);
       	   }
       	   
  	}
  	
  	if(s1.equals("HOME"))
  	{
  		mainframe m1=new mainframe();
  		dispose();
	}
	if(s1.equals("EXIT"))
  	{
  		System.exit(0);
	}
	
}
       	   /*---------------------------Staff---------------------------------------*/
       	   
       	   /*try
       	   {
       	   		st2=cn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); 
	       		rs3=st2.executeQuery("select * from staff");
	       	   
	       	    while(rs3.next())
	       	    {
	       	    	int j=0;
	       	    	for(int i=0;i<25;i++)
	       	    	{
	       	    		data2[i][j]=rs3.getString(1);
	       	    		j++;
	       	    		data2[i][j]=rs3.getString(2);
	       	    		j++;
	       	    		data2[i][j]=rs3.getString(3);
	       	    		j++;
	       	    		data2[i][j]=rs3.getString(5);
	       	    		j++;
	       	    		data2[i][j]=rs3.getString(6);
	       	    		j++;
	       	    		data2[i][j]=rs3.getString(9);
	       	    		j++;
	       	    		data2[i][j]=rs3.getString(10);
	       	    		j-=6;
	       	    		
	       	    		rs3.next();
	       	    		cnt2++;
	       	    	}
	       	    }
	       	   rs3.close();
       	   	  
       	   	  
       	   	    
       	   }
       	   catch(SQLException kl)
       	   {
       	   	    System.out.println(kl);
       	   }
       	   catch(ArrayIndexOutOfBoundsException out)
       	   {
       	   		System.out.println(out);
       	   }*/
       	   
       	   
       	   
       	   
       	   
     	
         
     	   
     	 
   
     
     /*public void actionPerformed(ActionEvent ae)
     {
     	  String s1=ae.getActionCommand();
     	  
     	else if(s1.equals("Search"))
     	{
     	/*-----------------------Datewise--------------------------------
     	
    	try
     	{
     	    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	       	cn1=DriverManager.getConnection("jdbc:odbc:mydsn1");
	       	stmt=cn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	       	rs1=stmt.executeQuery("select * from shree");
	       //	int id=Integer.parseInt(rs1.getString(1));
	       	 
	       	st1=cn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); 
	       	String s2=td.getText();
	       	rs2=st1.executeQuery("select * from balance where shree.Mid=balance.Mid1 and bdate= "+s2) ;
	       	
	       	
	       	    while(rs1.next() && rs2.next())
	       	    {
	       	    	int j=0;
	       	    	for(int i=0;i<61;i++)
	       	    	{
	       	    		data[i][j]=rs1.getString(1);
	       	    		j++;
	       	    		data[i][j]=rs1.getString(2);
	       	    		j++;
	       	    		data[i][j]=rs2.getString(6);
	       	    		j++;
	       	    		data[i][j]=rs2.getString(7);
	       	    		j++;
	       	    		data[i][j]=rs1.getString(11)+"/"+rs1.getString(12)+"/"+rs1.getString(13);
	       	    		j++;
	       	    		data[i][j]=rs1.getString(15)+"/"+rs1.getString(16)+"/"+rs1.getString(17);
	       	    		j++;
	       	    		
	       	    		j-=5;
	       	    		
	       	    		rs1.next();
	       	    		rs2.next();
	       	    		cnt1++;
	       	    	}
	       	    }
	       	   rs1.close();
	       	   rs2.close();
     	   }//try
       	    catch(SQLException kl)
       	   {
       	   	    System.out.println(kl);
       	   }
       	   catch(ClassNotFoundException nm)
       	   {
       	   		System.out.println(nm);
       	   }
       	   catch(ArrayIndexOutOfBoundsException out)
       	   {
       	   		System.out.println(out);
       	   }
       	   	
     	}//Search
	}
}  */ 
 		public static void main(String m[])
     	{
     		Report r=new Report();
     	}
 }  