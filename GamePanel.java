

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel extends JPanel{
	
	private JLabel score, moveButtons;
	private Font font1 = new Font("New Times Roman", Font.BOLD, 20);
	
	public GamePanel(){
		setPreferredSize(new Dimension(200,800)); 
		setBackground(new Color(0,0,0,0));
		
		moveButtons = new JLabel("<HTML>Movement:<BR>"
								+ "A to move Right<BR>"
								+ "S to move Down<BR>"
								+ "D to move Left<BR>"
								+ "W to move Up</HTML>");
		moveButtons.setForeground(Color.BLUE); moveButtons.setFont(font1);
		
		score = new JLabel("Score: 0"); score.setForeground(Color.BLUE); score.setFont(font1);
		
		add(moveButtons);
		add(score);
	}
	
	public void updateScore(String score) {this.score.setText("Score: " + score);}

}