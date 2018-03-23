import javax.swing.JFrame;

//**********************************************************************
/* Authors = Jesse LaFlesch & Ian Gonzales
 * File = Driver.java
 * Creation Date: 3/9/18
 * Purpose = Currently only to test our class instantiations
 ***********************************************************************/
public class Driver {

	public static void main(String[] args) {
		
/*		Player myPlayer = new Player("Ian", "./src/Images/MegaMan.jpg");
		Movement myMovement = new Movement();
		Item myItem = new Item("./src/jewel.jpg", 0, 0);
		Game myGame = new Game();
		GamePanel myGamePanel = new GamePanel();
		LevelPanel myLevelPanel = new LevelPanel();
		Enemy myEnemy = new Enemy("./src/Images/BadGuy.png");*/
		
		JFrame myFrame = new JFrame("Level Panel.");
		
	// Making the frame
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	// Making a panel using LevelPanel class that we made
		LevelPanel levelPanel = new LevelPanel(); 
		
	// Putting that panel on the frame and making it visible
		myFrame.getContentPane().add(levelPanel);
		myFrame.add(levelPanel);
		myFrame.pack();
		myFrame.setVisible(true);
		
/*		System.out.println("Instantiating a \"Player\":");
		System.out.println(myPlayer);
		System.out.println("Instantiating a \"Movement\":");
		System.out.println(myMovement);
		System.out.println();
		System.out.println("Instantiating an \"Item\":");
		System.out.println(myItem);
		
		System.out.println("Instantiating a \"Game\":");
		System.out.println(myGame); System.out.println();
		System.out.println("Instantiating a \"GamePanel\":");
		System.out.println(myGamePanel); System.out.println();
		System.out.println("Instantiating a \"LevelPanel\":");
		System.out.println(myLevelPanel); System.out.println();
		System.out.println("Instantiating an \"Enemy\":");
		System.out.println(myEnemy);
		*/
	}

}