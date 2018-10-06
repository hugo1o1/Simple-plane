package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;

import javax.swing.JFrame;







public class MyGameFrame extends JFrame {
	java.awt.Image planeImg= GameUtil.getImage("images/plane.png");
	java.awt.Image starbg= GameUtil.getImage("images/starbg.png");
	
	Plane plane = new Plane(planeImg,250,250);
	Shell[] shells  = new Shell[Constant.ShellsNum];	
	Explode explode;
	Date startTime = new Date();
	Date endTime;
	int period;//��Ϸ����ʱ��
	//������̼����ڲ���
	class KeyMonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			super.keyPressed(e);
			plane.addDirection(e);
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			super.keyReleased(e);
			plane.SubDirection(e);
		}
		
		
		
	}
	//����
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(starbg, 0,0,null);
		plane.drawSelf(g);//���ɻ�
		//���ڵ�
		for (int i = 0; i < shells.length; i++) {
			shells[i].draw(g);
			 boolean Peng = shells[i].getRect().intersects(plane.getRect());
			 if(Peng) {
				 plane.alive=false;
				 if(explode==null) { 
					
					 explode =new Explode(plane.x, plane.y);
					 endTime = new Date();
					 period=(int)((endTime.getTime()-startTime.getTime())/1000);}
				  explode.draw(g);
			 }
				
		}
				 if(!plane.alive) { 
					 g.setColor(Color.YELLOW);
					 Font font = new Font("����", Font.BOLD, 30);
					 g.setFont(font);
					 g.drawString("Time:"+period+"Seconds",100,100);
					 if(period<10) {
						 g.setColor(Color.white);
					
					 g.setFont(font);
					 g.drawString("crazy stupid��",100,200);}
					 }
				 
			 }

		
		
		
		
	
//	˫���弼��������壬����û��
	private java.awt.Image iBuffer=null;
	
	public void update(Graphics g){  
		if(iBuffer==null)  { 
			iBuffer=this.createImage(Constant.WINDHEI,Constant.WINDHEI); 
			Graphics gBuffer=iBuffer.getGraphics();  
			paint(gBuffer);
			g.drawImage(iBuffer, 0, 0, null);
			
			}     
	}
	//�ػ����ڣ��ڲ���	
	class PaintThread extends Thread{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			while(true)
			{
				repaint();
				try {
					Thread.sleep(41);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

//���ڳ�ʼ��
	
	public void launchFrame() {
	this.setTitle("plane0.2");
	this.setVisible(true);
	this.setSize(Constant.WINDHEI,Constant.WINDHEI);
	this.setLocation(200, 200);
	//��ʼ���ڵ�
	for (int i = 0; i < shells.length; i++) {
		shells[i]= new Shell();
	}
	//���ڿɹر�
	this.addWindowListener(new WindowAdapter() {
		public void windowClosed(WindowEvent e) {
			System.exit(0);
		}
	});
 new PaintThread().start();	
 addKeyListener(new KeyMonitor());//���������Ӵ��ڼ���

}

	public static void main(String[] args) {
	MyGameFrame f = new MyGameFrame();
	f.launchFrame();
}
}
