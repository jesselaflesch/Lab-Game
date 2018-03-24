import java.io.FileNotFoundException;
import javax.swing.JFrame;

//**********************************************************************
/* Authors = Jesse LaFlesch & Ian Gonzales
 * File = Driver.java
 * Creation Date: 3/9/18
 * Purpose = Currently only to test our class instantiations
 ***********************************************************************/
public class Driver {

	static Game myGame = new Game();
	static JFrame myFrame;
	
	public static void main(String[] args) throws FileNotFoundException  {
		
		play();

		}
	
	public static void play() throws FileNotFoundException {
	// Making the frame
		myFrame = new JFrame("Level Panel.");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	// Making a panel using LevelPanel class that we made
		LevelPanel levelPanel = new LevelPanel(myGame); 
		
	// Putting that panel on the frame and making it visible
		myFrame.getContentPane().add(levelPanel);
		myFrame.add(levelPanel);
		myFrame.pack();
		myFrame.setVisible(true);
		
		
	}

}