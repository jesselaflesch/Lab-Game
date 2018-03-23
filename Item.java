//**********************************************************************
/* Author = Ian Gonzales
 * Partner = Jesse LaFlesch
 * File = Item.java
 * Creation Date: 3/9/18
 * Purpose = Appears on the screen and is collected by the player.
 ***********************************************************************/

public class Item {

	private String imageName;
	private int xLoc;
	private int yLoc;
	private int width, height;
	
	
	public Item(String imageName, int xLoc, int yLoc) {
		this.imageName = imageName;
		this.xLoc = xLoc;
		this.yLoc = yLoc;
	}
	
	public void dissappear() {
	}
	
	public String getImageName() {
		return imageName;
	}
	

	public int getxLoc() {
		return xLoc;
	}

	public void setxLoc(int xLoc) {
		this.xLoc = xLoc;
	}

	public int getyLoc() {
		return yLoc;
	}

	public void setyLoc(int yLoc) {
		this.yLoc = yLoc;
	}

	public String toString() {
		return "ImageName: \t" + imageName + "\n"
				+ "xLoc: \t" + xLoc + "\n"
				+ "yLoc: \t" + yLoc + "\n";
	}
	
}