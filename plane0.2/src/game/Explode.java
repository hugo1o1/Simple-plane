package game;

import java.awt.Graphics;
import java.awt.Image;



public class Explode {
	double x,y;//±¬Õ¨µÄÎ»ÖÃ
	//static Image[] imgs= new Image[Constant.ExplodeImgNum+1];
	//
	static Image img = GameUtil.getImage("images/3.png");
	

//	static {
//		for (int i = 0; i <12; i++) {
//			imgs[i]=GameUtil.getImage("images/"+(i)+".gif");
//			imgs[i].getWidth(null);
//				
//		}
	
//	}
//int count=0;
public void draw(Graphics g) {
//	if(count<=12)
//	{
//		System.out.println("count");
	   g.drawImage(img,(int)x,(int)y, null);
//		count++;
//	}
}
public Explode(double x, double y) {
	super();
	this.x = x;
	this.y = y;
	
}

}
