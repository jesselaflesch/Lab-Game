

import java.awt.Image;
import javax.swing.ImageIcon;

public class Enemy {

	private String name;
	private int speed, xLoc, yLoc;
	private ImageIcon image;

	public Enemy(String name, String imagePath, int speed) {
		this.name = name;
		this.image = new ImageIcon(imagePath);
		this.speed = speed;
		this.xLoc = 600; 
		this.yLoc = 600;
	}

	public int getSpeed() {return speed;}

	public void setSpeed(int speed) {this.speed = speed;}
	
	public int getXLoc() {return xLoc;}

	public int getYLoc() {return yLoc;}

	public String getName() {return name;}
	
	public void setName(String name) {this.name = name;}

	public Image getImage() {return image.getImage();}

	public int getImageWidth() {return image.getIconWidth();}
	
	public int getImageHeight() {return image.getIconHeight();}
	
	public void up() {this.yLoc += (4 * speed);}
	
	public void down() {this.yLoc -= (4 * speed);}
	
	public void left() {this.xLoc -= (4 * speed);}
	
	public void right() {this.xLoc += (4 * speed);}
}