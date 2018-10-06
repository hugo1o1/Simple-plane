package game;

import java.awt.Color;
import java.awt.Graphics;



public class Shell extends GameObject {
	double degree;
	public Shell() {
		x=200;
		y=200;
		width=10;
		height=10;
		speed=3;
		degree = Math.random()*Math.PI*2;
	}
	public void draw(Graphics g) {
		Color c= g.getColor();
		g.setColor(Color.yellow);
		g.fillOval((int)x, (int)y, width, height);
		//�ڵ���������Ƕȷ���
		x+=speed*Math.cos(degree);
		y+=speed*Math.sin(degree);
		if(x<0||x>Constant.WINDWId-width) {degree=Math.PI-degree;}
			
		if(y<30||y>Constant.WINDHEI-height) {degree=-degree;}
			
		g.setColor(c);
	}
	
}
