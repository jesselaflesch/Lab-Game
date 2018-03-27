

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JPanel;

public class LevelPanel extends JPanel{
	
	private Player player;
	private Enemy enemy;
	private Item[] items = new Item[10];
	private Movement movement;
	private Scanner fileScanner, lineScanner;
	private JPanel centerPanel;
	private GamePanel eastPanel = new GamePanel();
	
	public LevelPanel(File characterFile, int level) throws FileNotFoundException {
		fileScanner = new Scanner(characterFile);
		lineScanner = new Scanner(fileScanner.nextLine());
		lineScanner.useDelimiter(",");
		this.player = new Player(lineScanner.next(), lineScanner.next());
		
		lineScanner = new Scanner(fileScanner.nextLine());
		lineScanner.useDelimiter(",");
		this.enemy = new Enemy(lineScanner.next(), lineScanner.next(), level);
		
		lineScanner = new Scanner(fileScanner.nextLine());
		lineScanner.useDelimiter(",");
		String itemName = lineScanner.next();
		String itemImagePath = lineScanner.next();
		for (int i=0; i<10; i++) {this.items[i] = new Item(itemName, itemImagePath);}
		
		this.movement = new Movement(player, enemy, items, this);
		addKeyListener(movement);
		
		setPreferredSize(new Dimension(1000,800));
		setLayout(new BorderLayout());
		setFocusable(true);
		
		centerPanel = new JPanel(); centerPanel.setPreferredSize(new Dimension(800,800)); centerPanel.setBackground(new Color(0,0,0,0));
		add(centerPanel, BorderLayout.CENTER);
		add(eastPanel, BorderLayout.EAST);
		movement.startTimer();
		repaint();
	}
	
	public void paintComponent(Graphics page){
		super.paintComponent(page);
		page.drawImage(player.getImage(), player.getXLoc(), player.getYLoc(), null);
		page.drawImage(enemy.getImage(), enemy.getXLoc(), enemy.getYLoc(), null);
		
		for(int i = 0; i < items.length; i++){
			if (items[i] == null) {continue;}
			else {page.drawImage(items[i].getImage(), items[i].getXLoc(), items[i].getYLoc(), null);}
		}
	}
}