

import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;

public class Item{

	private ImageIcon image;
	private String name;
	private int xLoc;
	private int yLoc;
	private Random randomLocation = new Random();
	
	public Item(String name, String imagePath) {
		this.name = name;
		this.image = new ImageIcon(imagePath);
		this.xLoc = randomLocation.nextInt(701) + 50;
		this.yLoc = randomLocation.nextInt(701) + 50;
	}

	public int getXLoc() {return xLoc;}

	public void setXLoc(int xLoc) {this.xLoc = xLoc;}

	public int getYLoc() {return yLoc;}

	public void setYLoc(int yLoc) {this.yLoc = yLoc;}
	
	public Image getImage() {return image.getImage();}

	public int getImageWidth() {return image.getIconWidth();}
	
	public int getImageHeight() {return image.getIconHeight();}
}


