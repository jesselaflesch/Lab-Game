//**********************************************************************
/* Author = Ian Gonzales
 * Partner = Jesse LaFlesch
 * File = Player.java
 * Creation Date: 3/9/18
 * Purpose = Controls the player that collects items and avoids enemies
 ***********************************************************************/

import java.util.ArrayList;

public class Player {

	private String name, imageName;
	private int xLoc, yLoc, itemsCollected, score;
	private Movement playerMovement;
	
	public Player(String name, String imageName) {
		this.name = name;
		this.imageName = imageName;
		this.xLoc = 0;
		this.yLoc = 0;
		this.itemsCollected = 0;
		this.score = 0;
		this.playerMovement = new Movement();
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


	public String getName() {
		return name;
	}


	public String getImageName() {
		return imageName;
	}


	public int getItemsCollected() {
		return itemsCollected;
	}
	
	public String toString() {
		return "Name: \t\t" + name + "\n"
				+ "ImageName: \t" + imageName + "\n"
				+ "xLoc: \t\t" + xLoc + "\n"
				+ "yLoc: \t\t" + yLoc + "\n"
				+ "Items: \t\t" + itemsCollected + "\n"
				+ "Score: \t\t" + score + "\n"
				+ "Movement Object: " + playerMovement.toString() + "\n";
	}
	
}
