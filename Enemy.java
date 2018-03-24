import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

//*****************************************************************
/* Author = Jesse LaFlesch
 * Partner = Ian Gonzales
 * File = Enemy.java
 * Creation Date: 3/9/18
 * Purpose = Controls the enemy that steadily creeps up to the player
 ******************************************************************/

public class Enemy 
{
	private int speed, xLoc, yLoc, width, height;
	private String imageName;
	private Movement enemyMovement;
	private Random generator = new Random();

	
	public Enemy(String imageName)
	{
		this.speed = speed; 
		this.xLoc = 600; 
		this.yLoc = 600;
		this.imageName = imageName; 
		
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

	public String getImageName()
	{
		return imageName;
	}
	
	
	public String toString()
	{
		return "ImageName: \t" + imageName + "\n"
				+ "xLoc: \t\t" + xLoc + "\n"
				+ "yLoc: \t\t" + yLoc + "\n"
				+ "Movement Object: " + enemyMovement.toString() + "\n";
	}
	
}