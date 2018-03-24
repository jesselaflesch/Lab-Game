//**********************************************************************
/* Author = Ian Gonzales
 * Partner = Jesse LaFlesch
 * File = Movement.java
 * Creation Date: 3/9/18
 * Purpose = Used by the Player or Enemy to move about the screen
 ***********************************************************************/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Movement implements KeyListener
{
	
	private Player myPlayer;
	private Enemy myEnemy;
	private Item[] itemArray = new Item[10];
	private Game myGame;
	private Timer myTimer = new Timer(400, new timerListener());
	private LevelPanel myPanel;
	private int enemyHeight, enemyWidth, playerHeight, playerWidth, itemHeight, itemWidth;
	private Integer[] itemLeftx = new Integer[10];
	private Integer[] itemRightx = new Integer[10];
	private Integer[] itemTopy = new Integer[10];
	private Integer[] itemBottomy = new Integer[10];
	private ImageIcon myEnemyImage, myPlayerImage, myItemImage;
	
	public Movement(Player myPlayer, Enemy myEnemy, ImageIcon myPlayerImage, ImageIcon myEnemyImage,
			ImageIcon myItemImage, Item[] itemArray, LevelPanel myPanel, Game myGame) 
	{
		this.myPlayer = myPlayer;
		this.myEnemy = myEnemy;
		this.myPanel = myPanel;
		this.myPlayerImage = myPlayerImage;
		this.myEnemyImage = myEnemyImage;
		this.myItemImage = myItemImage;
		this.itemArray = itemArray;
		this.myGame = myGame;
		
		this.playerHeight = myPlayerImage.getIconHeight();
		this.playerWidth = myPlayerImage.getIconWidth();
		this.enemyHeight = myEnemyImage.getIconHeight();
		this.enemyWidth = myEnemyImage.getIconWidth();
		this.itemHeight = myItemImage.getIconHeight();
		this.itemWidth = myItemImage.getIconWidth();
		
		for (int i = 0; i < this.itemArray.length; i++)
		{
			itemLeftx[i] = this.itemArray[i].getxLoc();
		}
		for (int i = 0; i < this.itemArray.length; i++)
		{
			itemRightx[i] = this.itemArray[i].getxLoc() + myItemImage.getIconWidth();
		}
		for (int i = 0; i < this.itemArray.length; i++)
		{
			itemTopy[i] = this.itemArray[i].getyLoc();
		}
		for (int i = 0; i < this.itemArray.length; i++)
		{
			itemBottomy[i] = this.itemArray[i].getyLoc() + myItemImage.getIconHeight();
		}
	}
	

	public void startTimer()
	{
		myTimer.start();
	}
//Methods for x and y points for myPlayer's Image	
	private int playerLeftx()
	{
		return myPlayer.getxLoc();
	}
	
	private int playerRightx()
	{
		return myPlayer.getxLoc() + playerWidth;
	}
	
	private int playerTopy()
	{
		return myPlayer.getyLoc();
	}
	
	private int playerBottomy()
	{
		return myPlayer.getyLoc() + playerHeight;
	}
//Methods for x and y points for myEnemy's Image	
	private int enemyLeftx()
	{
		return myEnemy.getxLoc();
	}
	
	private int enemyRightx()
	{
		return myEnemy.getxLoc() + enemyWidth;
	}
	
	private int enemyTopy()
	{
		return myEnemy.getyLoc();
	}
	
	private int enemyBottomy()
	{
		return myEnemy.getyLoc() + enemyHeight;
	}
	
	
	private boolean areRectsColliding(int r1TopLeftX, int r1BottomRightX,int r1TopLeftY, int r1BottomRightY, int r2TopLeftX, 
			int r2BottomRightX, int r2TopLeftY, int r2BottomRightY) 
	{
		if (r1TopLeftX < r2BottomRightX && r1BottomRightX >
		r2TopLeftX && r1TopLeftY < r2BottomRightY && r1BottomRightY > r2TopLeftY) 
		{
		return true;
		}
		else 
		{
		return false; 
		} 
	}
	
	private class timerListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			if (myPlayer.getxLoc() < myEnemy.getxLoc())
			{
				myEnemy.setxLoc(myEnemy.getxLoc() - 5);
			}
			else if (myPlayer.getxLoc() > myEnemy.getxLoc())
			{
				myEnemy.setxLoc(myEnemy.getxLoc() + 5);
			}
			if (myPlayer.getyLoc() < myEnemy.getyLoc())
			{
				myEnemy.setyLoc(myEnemy.getyLoc() - 5);
			}
			else if (myPlayer.getyLoc() > myEnemy.getyLoc())
			{
				myEnemy.setyLoc(myEnemy.getyLoc() + 5);
			}
			myPanel.repaint();
		}
	}
	

	@Override
	public void keyPressed(KeyEvent e) 
	{
		if(e.getKeyCode() == KeyEvent.VK_A)
		{
			myPlayer.setxLoc(myPlayer.getxLoc() - 5);
		//Border control.
			if (playerLeftx() < 0)
			{
				myPlayer.setxLoc(0);
			}
		//Collision with myEnemy
			if (areRectsColliding(playerLeftx(), playerRightx(), playerTopy(), playerBottomy(), enemyLeftx(), 
			enemyRightx(), enemyTopy(), enemyBottomy()))
			{
				myTimer.stop();
				myGame.addScore(myPlayer.getItemsCollected());
				JOptionPane.showMessageDialog(null, myGame.toString());
				Driver.myFrame.dispose();
				try {
					Driver.play();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		//Collision with myItem
			for (int i=0; i < itemArray.length; i++) {
				if (itemArray[i] != null) {
					if (areRectsColliding(playerLeftx(), playerRightx(), playerTopy(), playerBottomy(), itemLeftx[i], 
						itemRightx[i], itemTopy[i], itemBottomy[i]))
					{
						myPlayer.pickUpItem();
						itemArray[i] = null;
						myPanel.updateScore(Integer.toString(myPlayer.getItemsCollected()));
					}
				
				}
			}
		}
		else if(e.getKeyCode() == KeyEvent.VK_S)
		{
			myPlayer.setyLoc(myPlayer.getyLoc() + 5);
		//Border control.
			if (playerBottomy() > 800)
			{
				myPlayer.setyLoc(800 - playerHeight);
			}
		//Collision with myEnemy
			if (areRectsColliding(playerLeftx(), playerRightx(), playerTopy(), playerBottomy(), enemyLeftx(), 
			enemyRightx(), enemyTopy(), enemyBottomy()))
			{
				myTimer.stop();
				myGame.addScore(myPlayer.getItemsCollected());
				JOptionPane.showMessageDialog(null, myGame.toString());
				Driver.myFrame.dispose();
				try {
					Driver.play();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		//Collision with myItem
			for (int i=0; i < itemArray.length; i++) {
				if (itemArray[i] != null) {
					if (areRectsColliding(playerLeftx(), playerRightx(), playerTopy(), playerBottomy(), itemLeftx[i], 
						itemRightx[i], itemTopy[i], itemBottomy[i]))
					{
						myPlayer.pickUpItem();
						itemArray[i] = null;
						myPanel.updateScore(Integer.toString(myPlayer.getItemsCollected()));
					}
				
				}
			}
		}
		else if(e.getKeyCode() == KeyEvent.VK_W)
		{
			myPlayer.setyLoc(myPlayer.getyLoc() - 5);
		//Border control.
			if (playerTopy() < 0)
			{
				myPlayer.setyLoc(0);
			}
		//Collision with myEnemy
			if (areRectsColliding(playerLeftx(), playerRightx(), playerTopy(), playerBottomy(), enemyLeftx(), 
			enemyRightx(), enemyTopy(), enemyBottomy()))
			{
				myTimer.stop();
				myGame.addScore(myPlayer.getItemsCollected());
				JOptionPane.showMessageDialog(null, myGame.toString());
				Driver.myFrame.dispose();
				try {
					Driver.play();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		//Collision with myItem
			for (int i=0; i < itemArray.length; i++) {
				if (itemArray[i] != null) {
					if (areRectsColliding(playerLeftx(), playerRightx(), playerTopy(), playerBottomy(), itemLeftx[i], 
						itemRightx[i], itemTopy[i], itemBottomy[i]))
					{
						myPlayer.pickUpItem();
						itemArray[i] = null;
						myPanel.updateScore(Integer.toString(myPlayer.getItemsCollected()));
					}
				
				}
			}
		}
		else if(e.getKeyCode() == KeyEvent.VK_D)
		{
			myPlayer.setxLoc(myPlayer.getxLoc() + 5);
			
		//Border control.
			if (playerRightx() > 800)
			{
				myPlayer.setxLoc(800 - playerWidth);
			}
			
		//Collision with myEnemy
			if (areRectsColliding(playerLeftx(), playerRightx(), playerTopy(), playerBottomy(), enemyLeftx(), 
			enemyRightx(), enemyTopy(), enemyBottomy()))
			{
				myTimer.stop();
				myGame.addScore(myPlayer.getItemsCollected());
				JOptionPane.showMessageDialog(null, myGame.toString());
				Driver.myFrame.dispose();
				try {
					Driver.play();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		//Collision with myItem
			for (int i=0; i < itemArray.length; i++) {
				if (itemArray[i] != null) {
					if (areRectsColliding(playerLeftx(), playerRightx(), playerTopy(), playerBottomy(), itemLeftx[i], 
						itemRightx[i], itemTopy[i], itemBottomy[i]))
					{
						myPlayer.pickUpItem();
						itemArray[i] = null;
						myPanel.updateScore(Integer.toString(myPlayer.getItemsCollected()));
					}
				
				}
			}
		}
		myPanel.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}