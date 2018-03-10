//*****************************************************************
/* Author = Jesse LaFlesch
 * Partner = Ian Gonzales
 * File = Enemy.java
 * Creation Date: 3/9/18
 * Purpose = Controls the enemy that steadily creeps up to the player
 ******************************************************************/

public class Enemy 
{
	private int speed, xLoc, yLoc;
	private String imageName;
	private Movement enemyMovement;
	
	public Enemy(String imageName)
	{
		this.speed = speed; 
		this.xLoc = xLoc; 
		this.yLoc = yLoc;
		this.imageName = imageName; 
		this.enemyMovement = new Movement();
		
	}
	
	public void approachPlayer()
	{
		
	}

	public void appear()
	{
		
	}
	public String toString()
	{
		return "ImageName: \t" + imageName + "\n"
				+ "xLoc: \t\t" + xLoc + "\n"
				+ "yLoc: \t\t" + yLoc + "\n"
				+ "Movement Object: " + enemyMovement.toString() + "\n";
	}
	
}
