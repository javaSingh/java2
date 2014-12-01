import java.awt.*;
import javax.swing.*;

class mysplash extends JWindow implements Runnable
{
	Thread t;
	Image i;
	ImageIcon ii;
	int x=10;
	int r=225,g=90,b=50;
	Color c,c1;
	Font f1;
	mysplash()
	{
		t=new Thread(this,"MyThread");
		ii=new ImageIcon("jayu.jpg");
		i=ii.getImage();
		setBounds(400,150,653,419);
		f1=new Font("Tahoma",Font.BOLD,15);	
		setVisible(true);
		t.start();
	}
	public void run()
	{
		try
		{
			c=new Color(r%255,g%255,b%255);	
			while(x<530)
			{
				r+=20;g+=15;b+=9;
				x+=5;t.sleep(100);repaint();
			}
			
		}
		
		catch(Exception e){}
		 
		 login1 l1=new login1();
		 l1.setBounds(275,35,850,700);
			this.setVisible(false);
	}
	public void paint(Graphics g)
	{
		g.drawImage(i,0,0,this);
		g.setColor(Color.white);
		g.setFont(f1);
		g.drawString("Wait until process completes . . .",100,405);
		g.setColor(c);
		g.drawString((x*100/530)+"% completed",100,370);
		//g.setColor(Color.white);
		g.drawRect(25,372,530,14);
		g.fillRect(25,372,x,13);
		
	}
	public static void main(String args[])
	{
		new mysplash();
	}
}		