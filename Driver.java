

import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JFrame;

public class Driver {

	static JFrame myFrame;
	static File characterFile = new File("./src/CSVs/Link.txt"); // This will be chosen by the user
	static String playerName = "Ian"; 							// Also entered by the player
	static Game myGame = new Game(playerName);
	static int level = 0, GAME_WIDTH = 800, GAME_HEIGHT = 800;

	public static void main(String[] args) throws FileNotFoundException{
		myFrame = new JFrame("Lab Game");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//newPlayer();
		play();
	}
	
	public static void play() throws FileNotFoundException{
		level++;
		LevelPanel levelPanel = new LevelPanel(characterFile, level); 
		myFrame.getContentPane().add(levelPanel);
		myFrame.add(levelPanel);
		myFrame.pack();
		myFrame.setVisible(true);
	}
	
	public static void newPlayer() {
		//~~~ Get the players name
		//~~~ Let them choose their character
		//~~~ Set playerName to their name
		//~~~ Set playerFile to their file
		;
	}
}