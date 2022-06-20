import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
	
	final int originalTileSize=16;//16x16 tile
	final int scale=3; //tile x scale(çarpan) = pixel 
	
	final int tileSize = originalTileSize * scale;//48 x 48 tile
	final int maxScreenCol = 16;//ekran enine
	final int maxScreenRow=12;//ekran yükseklik
	
	final int screenWidth = tileSize * maxScreenCol; //48 x 16 =768 pixel
	final int screenHeight = tileSize * maxScreenRow;//48 x 12 = 576 pixel
	
	Thread gameThread;
	
	public GamePanel(){
		
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);//game render araştır
		
	}

	public void strartGameThread() {
		
		gameThread=new Thread(this);//GamePanel is Runnable
		gameThread.start();
	
	}
	@Override
	public void run() {
		
		while(gameThread!=null) {}
	}
	
}
