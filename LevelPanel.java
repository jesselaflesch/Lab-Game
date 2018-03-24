//*****************************************************************
/* Author = Jesse LaFlesch
 * Partner = Ian Gonzales
 * File = LevelPanel.java
 * Creation Date: 3/9/18
 * Purpose = The place where magic happens. Uses Player, Item, and Enemy.
 ******************************************************************/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class LevelPanel extends JPanel
{
	private Player myPlayer = new Player("P1", "./src/Images/MegaMan.jpg");
	private Enemy myEnemy = new Enemy("./src/Images/BadGuy.png");
	private Item myItem = new Item("./src/Images/Jewel.gif", 0, 0);
	private Item[] itemArray = new Item[10];
	private ImageIcon myImage1 = new ImageIcon(myPlayer.getImageName());
	private ImageIcon myEnemyImage = new ImageIcon(myEnemy.getImageName());
	private ImageIcon myItemImage = new ImageIcon(myItem.getImageName());
	private Movement movement = new Movement(myPlayer, myEnemy, myImage1, myEnemyImage, myItemImage, itemArray, this);
	
	private GamePanel myEastPanel = new GamePanel();
	private JPanel myCenterPanel;
	

	private Random generator = new Random();
	private int minNum = 50;
	private int maxNum = 701;
	

	
	public LevelPanel()
	{
		setPreferredSize(new Dimension(1000,800));
		setLayout(new BorderLayout());
		setFocusable(true);
		movement.startTimer();
		addKeyListener(movement);
		repaint();
		
		for(int i = 0; i < itemArray.length; i++)
		{
			myItem = new Item("./src/Images/Jewel.gif", generator.nextInt(maxNum) + minNum, generator.nextInt(maxNum) + minNum);
			itemArray[i] = myItem;
		}
	//Adding clear panels with dimensions to add score on right side.
		myCenterPanel = new JPanel(); myCenterPanel.setPreferredSize(new Dimension(800,800)); myCenterPanel.setBackground(new Color(0,0,0,0));
		
		add(myCenterPanel, BorderLayout.CENTER);
		add(myEastPanel, BorderLayout.EAST);
	}

	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);
		page.drawImage(myImage1.getImage(), myPlayer.getxLoc(), myPlayer.getyLoc(), null);
		page.drawImage(myEnemyImage.getImage(), myEnemy.getxLoc(), myEnemy.getyLoc(), null);
		
		for(int i = 0; i < itemArray.length; i++)
		{
			page.drawImage(myItemImage.getImage(), itemArray[i].getxLoc(), itemArray[i].getyLoc(), null);
		}
		
		
		
	}
	public ImageIcon getMyImage1() {
		return myImage1;
	}

	public ImageIcon getMyEnemyImage() {
		return myEnemyImage;
	}

	public ImageIcon getMyItemImage() {
		return myItemImage;
	}

	public String toString()
	{
		return "I am the LevelPanel object and I exist!";
	}
}