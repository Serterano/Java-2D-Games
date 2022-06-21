package main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;

public class GamePanel extends JPanel implements Runnable{
	
	final int originalTileSize=16;//16x16 tile
	final int scale=3; //tile x scale(çarpan) = pixel 
	
	public final int tileSize = originalTileSize * scale;//48 x 48 tile
	final int maxScreenCol = 16;//ekran enine
	final int maxScreenRow=12;//ekran yükseklik
	
	final int screenWidth = tileSize * maxScreenCol; //48 x 16 =768 pixel
	final int screenHeight = tileSize * maxScreenRow;//48 x 12 = 576 pixel
	
	KeyHandler keyH = new KeyHandler();
	Thread gameThread;
	Player player = new Player(this,keyH);
	
	int FPS =60;
	//set players default position
	int playerX=100;
	int playerY=100;
	int playerSpeed = 4;
	
	public GamePanel(){
		
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);//game render araştır
		
		this.addKeyListener(keyH);
		this.setFocusable(true);
		
		startGameThread();
		
	}

	public void startGameThread() {
		
		gameThread=new Thread(this);//GamePanel is Runnable
		gameThread.start();
	
	}
//	@Override
//	public void run() {
////			long currentTime = System.nanoTime();//1,000,000,000 nanoseconds = 1 second
////			long currentTime2 = System.currentTimeMillis();//1,000 milliseconds = 1second
//		double drawInterval =1000000000/FPS;
//		double nextDrawTime = System.nanoTime() + drawInterval;
//		
//		while(gameThread!=null) {
//			
//			
//			//1-) update info such as character position
//			update();
//			
//			//2-) draw the screen
//			repaint();
//			
//			
//
//			try {			
//				double remainingTime = nextDrawTime - System.nanoTime();
//				remainingTime = remainingTime/1000000;
//				
//				if(remainingTime<0) {
//					remainingTime =0;
//				}
//				
//				Thread.sleep((long)remainingTime);
//				
//				nextDrawTime+=drawInterval;
//			}catch(InterruptedException e) {
//				e.printStackTrace();
//			}
//			
//		}
//	}
	@Override
	public void run() {
		
		double drawInterval =1000000000/FPS;
		
		double delta =0;
		long lastTime = System.nanoTime();
		long currentTime;
		
		long timer =0;
		int drawCount =0;
		
		
		while(gameThread!=null) {
			
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			timer+=(currentTime - lastTime);
			lastTime = currentTime;
			
			if(delta >=1) {
				update();
				
				repaint();
				delta--;
				drawCount++;
			}
			if(timer >=1000000000) {
				System.out.println("FPS: "+drawCount);
				drawCount=0;
				timer=0;
			}
			
			
		}
		
	}
	
	public void update() {
		player.update();
		
	}
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		Graphics2D g2 =(Graphics2D)g;
		player.draw(g2);
		g2.dispose();
	
	}
}
