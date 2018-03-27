

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

public class Movement implements KeyListener{
	
	private Player player;
	private Enemy enemy;
	private Item[] items;
	private LevelPanel levelPanel;
	private Timer timer = new Timer(400, new TimerListener());
	
	public Movement(Player player, Enemy enemy, Item[] items, LevelPanel levelPanel){
		this.player = player;
		this.enemy = enemy;
		this.items = items;
		this.levelPanel = levelPanel;
	}
	
	public void startTimer() {timer.start();}
	
	private class TimerListener implements ActionListener{
		
		public void actionPerformed(ActionEvent arg0){
			if (player.getXLoc() < enemy.getXLoc()) {enemy.left();}
			else if (player.getXLoc() > enemy.getXLoc()) {enemy.right();}
			if (player.getYLoc() < enemy.getYLoc()) {enemy.down();}
			else if (player.getYLoc() > enemy.getYLoc()) {enemy.up();}
			
			int[] playerWithEnemy = {player.getXLoc(), player.getXLoc() + player.getImageWidth(),
					player.getYLoc(), player.getYLoc() + player.getImageWidth(),
					enemy.getXLoc(), enemy.getXLoc() + enemy.getImageWidth(),
					enemy.getYLoc(), enemy.getYLoc() + enemy.getImageWidth()};
			
			if (haveCollided(playerWithEnemy)) {
				;//Then we were hit by the enemy~~~
			}
			
			for (int i = 0; i < items.length; i++) {
				// deal with null point items[]
				int[] playerWithItem = {player.getXLoc(), player.getXLoc() + player.getImageWidth(),
												player.getYLoc(), player.getYLoc() + player.getImageWidth(),
												items[i].getXLoc(), items[i].getXLoc() + items[i].getImageWidth(),
												items[i].getYLoc(), items[i].getYLoc() + items[i].getImageWidth(),};
				if (haveCollided(playerWithItem)) {
					;//Then we get to pick up the item~~~
				}
			}
			
			levelPanel.repaint();
		}
		
		private boolean haveCollided(int[] points){
			if (points[0] < points[5] && points[1] > points[4] && points[2] < points[7] && points[3] > points[6]){
				return true;}
			else{return false;} 
		}
	}
	
	public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
				case KeyEvent.VK_A:
					player.left(); break;
				case KeyEvent.VK_S:
					player.down(); break;
				case KeyEvent.VK_D:
					player.right(); break;
				case KeyEvent.VK_W:
					player.up();	 break;
			}
			levelPanel.repaint();
	}
		
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
}