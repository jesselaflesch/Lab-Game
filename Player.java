

import java.awt.Image;
import javax.swing.ImageIcon;

public class Player {
	
	private String name;
	private ImageIcon image;
	private int xLoc, yLoc;
	private int score;
	
	public Player(String name, String imagePath){
		this.name = name;
		this.image = new ImageIcon(imagePath);
		this.xLoc = 0;
		this.yLoc = 0;
		this.score = 0;
	}
	
	public int getXLoc() {return xLoc;}

	public void setXLoc(int xLoc) {this.xLoc = xLoc;}

	public int getYLoc() {return yLoc;}

	public void setYLoc(int yLoc) {this.yLoc = yLoc;}

	public String getName() {return name;}
	
	public void setName(String name) {this.name = name;}

	public Image getImage() {return image.getImage();}
	
	public int getImageWidth() {return image.getIconWidth();}
	
	public int getImageHeight() {return image.getIconHeight();}
	
	public int getScore() {return score;}
	
	public void pickUpItem() {score++;}

	public void up() {yLoc -= 5; if (yLoc < 0) {yLoc = 0;}}
	
	public void down() {yLoc += 5; if (yLoc > Driver.GAME_HEIGHT - image.getIconHeight()) {yLoc = Driver.GAME_HEIGHT - image.getIconHeight();}}
	
	public void left() {xLoc -= 5; if (xLoc < 0) {xLoc = 0;}}
	
	public void right() {xLoc += 5; if (xLoc > Driver.GAME_WIDTH - image.getIconWidth()) {xLoc = Driver.GAME_WIDTH - image.getIconWidth();}}
}