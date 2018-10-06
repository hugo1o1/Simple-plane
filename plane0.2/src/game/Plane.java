package game;

import java.awt.Graphics;

import java.awt.event.*;





public class Plane extends GameObject {
	boolean right,left,up, down;
	boolean alive=true;
		@Override
		public void drawSelf(Graphics g) {
			// TODO Auto-generated method stub
			if(alive) {
			super.drawSelf(g);
			if(left)
				x-=speed;
			if(right)
				x+=speed;
			if(up)
				y-=speed;
			if(down)
				y+=speed;
				
			}else {}
			
		}
		public Plane(java.awt.Image img,double x,double y) {
			this.img=img;
			this.x=x;
			this.y=y;
			this.width= img.getWidth(null);
			this.height= img.getHeight(null);
		}
		//按下某个键增加相应的方向
		public void addDirection(KeyEvent e) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				left= true;
				break;
			case KeyEvent.VK_RIGHT:
				right= true;
				break;
			case KeyEvent.VK_UP:
				up= true;
				break;
			case KeyEvent.VK_DOWN:
				down= true;
				break;
				}
			
			}
			//抬起某个键减方向
			public void SubDirection(KeyEvent e) {
				switch(e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					left= false;
					break;
				case KeyEvent.VK_RIGHT:
					right= false;
					break;
				case KeyEvent.VK_UP:
					up= false;
					break;
				case KeyEvent.VK_DOWN:
					down= false;
					break;
				
				}
		}
			
}
