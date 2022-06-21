package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{
	
	GamePanel gp;
	KeyHandler keyH;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		this.gp=gp;
		this.keyH=keyH;
		setDefaultValues();
	}
	public void setDefaultValues() {
		x=100;
		y=100;
		speed =4;
		
		direction ="up";
	}
	public void getPlayerImage() {
		try {
			up1= ImageIO.read(getClass().getResourceAsStream("/player/1.png"));
			up2= ImageIO.read(getClass().getResourceAsStream("/player/2.png"));
			
			right1= ImageIO.read(getClass().getResourceAsStream("/player/1.png"));
			right2= ImageIO.read(getClass().getResourceAsStream("/player/2.png"));
			
			left1= ImageIO.read(getClass().getResourceAsStream("/player/2.png"));
			left2= ImageIO.read(getClass().getResourceAsStream("/player/1.png"));
			
			down1= ImageIO.read(getClass().getResourceAsStream("/player/3.png"));
			down2= ImageIO.read(getClass().getResourceAsStream("/player/3.png"));
		
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void update() {
		if(keyH.upPressed==true) {
			direction ="up";
			y -=speed;
		}
		if(keyH.downPressed==true) {
			direction ="down";
			y +=speed;
		}
		if(keyH.leftPressed==true) {
			direction="left";
			x -= speed;
		}
		if(keyH.rightPressed==true) {
			direction="right";
			x += speed;
		}
	}
	public void draw(Graphics2D g2) {
//		g2.setColor(Color.white);
//		//g2.fillRect(maxScreenRow, maxScreenCol, screenWidth, screenHeight);
//		g2.fillRect(x,y,gp.tileSize,gp.tileSize);
		
		BufferedImage image =null;
		
		switch(direction) {
		case "up":
			image=up1;
			break;
		case "down":
			image=down1;
			break;
		case "right":
			image=right1;
			break;
		case "left":
			image=left1;
			break;
		default:
			image=up1;
			break;
		}
		
		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
