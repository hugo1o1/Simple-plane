# Simple-plane
a simple plane game
定义常量类Constant来保存一些常量如窗口大小，子弹数目等
导入图片，构造GameUtil类，获取图片直接用java.awt.Image planeImg= GameUtil.getImage("images/plane.png");
ublic class GameUtil {

           // 工具类最好将构造器私有化。

           private GameUtil() {

          

           }

 

           public static Image getImage(String path) {

                     BufferedImage bi = null;

                     try {

                                URL u = GameUtil.class.getClassLoader().getResource(path);

                                bi = ImageIO.read(u);

                     } catch (IOException e) {

                                e.printStackTrace();

                     }

                     return bi;

           }

}
//定义键盘监听内部类
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
		双缓冲技术解决缓冲，好像没用
	private java.awt.Image iBuffer=null;
	
	public void update(Graphics g){  
		if(iBuffer==null)  { 
			iBuffer=this.createImage(Constant.WINDHEI,Constant.WINDHEI); 
			Graphics gBuffer=iBuffer.getGraphics();  
			paint(gBuffer);
			g.drawImage(iBuffer, 0, 0, null);
			
			}     
	}
	//重画窗口！内部类	
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
