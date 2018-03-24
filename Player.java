//**********************************************************************
/* Author = Ian Gonzales
 * Partner = Jesse LaFlesch
 * File = Player.java
 * Creation Date: 3/9/18
 * Purpose = Controls the player that collects items and avoids enemies
 ***********************************************************************/

import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Player 
{

	private String name, imageName;	
	private int xLoc, yLoc, itemsCollected, score, width, height;
	private Movement playerMovement;
	private Font font1 = new Font("New Times Roman", Font.BOLD, 20);

	public Player() throws FileNotFoundException
	{
		do
		{
			UIManager.put("OptionPane.minimumSize",new Dimension(500,200));
			JLabel myLabel = new JLabel("Who do you want to play as? Type \"Link\" or \"MegaMan\"");
			myLabel.setFont(font1);
			this.name = JOptionPane.showInputDialog(myLabel);
		}
		while (this.name.equalsIgnoreCase("link") == false && this.name.equalsIgnoreCase("megaman") == false);
		
		if (this.name.equalsIgnoreCase("link"))
		{
			File myLinkFile = new File("./src/CSVs/Link.csv");
			Scanner myScanner = new Scanner(myLinkFile);
		//Catches first line of CSV
			myScanner.nextLine(); 
			
			while(myScanner.hasNextLine()) 
			{
				String line = myScanner.nextLine(); 
				Scanner myLineScanner = new Scanner(line); 
				myLineScanner.useDelimiter(","); 
				
				while(myLineScanner.hasNext()) 
				{
				//Catches Image Path
					this.imageName = myLineScanner.next();
				}	
			}
		}
		else if (this.name.equalsIgnoreCase("megaman"))
		{
			File myMegaManFile = new File("./src/CSVs/MegaMan.csv");
			Scanner myScanner = new Scanner(myMegaManFile);
		//Catches first line of CSV
			myScanner.nextLine(); 
			
			while(myScanner.hasNextLine()) 
			{
				String line = myScanner.nextLine(); 
				Scanner myLineScanner = new Scanner(line); 
				myLineScanner.useDelimiter(","); 
				
				while(myLineScanner.hasNext()) 
				{
				//Catches Image Path
					this.imageName = myLineScanner.next();
				}	
			}
		}
		this.xLoc = 0;
		this.yLoc = 0;
		this.itemsCollected = 0;
		this.score = 0;
		
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

	public void setItemsCollected(int itemsCollected) {
		this.itemsCollected = itemsCollected;
	}
	
	public void pickUpItem() {
		itemsCollected++;
		score++;
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