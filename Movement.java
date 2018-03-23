
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

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Movement implements KeyListener
{
	
	private Player myPlayer;
	private Enemy myEnemy;
	private Item myItem;
	private Timer myTimer = new Timer(500, new timerListener());
	private JPanel myPanel;
	private ImageIcon myImage1 = new ImageIcon(myPlayer.getImageName());
	private ImageIcon myEnemyImage = new ImageIcon(myEnemy.getImageName());
	private ImageIcon myItemImage = new ImageIcon(myItem.getImageName());
	
	public Movement(Player myPlayer, Enemy myEnemy, JPanel myPanel) 
	{
		this.myPlayer = myPlayer;
		this.myEnemy = myEnemy;
		this.myPanel = myPanel;

	}

	public void startTimer()
	{
		myTimer.start();
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
	

	
	public String toString() {
		return "I am a Movement object, and I exist.";
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		if(e.getKeyCode() == KeyEvent.VK_A)
		{
			myPlayer.setxLoc(myPlayer.getxLoc() - 5);
		}
		else if(e.getKeyCode() == KeyEvent.VK_S)
		{
			myPlayer.setyLoc(myPlayer.getyLoc() + 5);
		}
		else if(e.getKeyCode() == KeyEvent.VK_W)
		{
			myPlayer.setyLoc(myPlayer.getyLoc() - 5);
		}
		else if(e.getKeyCode() == KeyEvent.VK_D)
		{
			myPlayer.setxLoc(myPlayer.getxLoc() + 5);
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
}