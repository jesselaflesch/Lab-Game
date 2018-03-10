//**********************************************************************
/* Author = Ian Gonzales
 * Partner = Jesse LaFlesch
 * File = Item.java
 * Creation Date: 3/9/18
 * Purpose = Appears on the screen and is collected by the player.
 ***********************************************************************/

public class Item {

	private String imageName;
	private int xLoc, yLoc;
	
	
	public Item(String imageName, int xLoc, int yLoc) {
		this.imageName = imageName;
		this.xLoc = xLoc;
		this.yLoc = yLoc;
	}
	
	public void dissappear() {
	}
	
	public String toString() {
		return "ImageName: \t" + imageName + "\n"
				+ "xLoc: \t" + xLoc + "\n"
				+ "yLoc: \t" + yLoc + "\n";
	}
	
}
