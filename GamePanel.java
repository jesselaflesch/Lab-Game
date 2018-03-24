//*****************************************************************
/* Author = Jesse LaFlesch
 * Partner = Ian Gonzales
 * File = GamePanel.java
 * Creation Date: 3/9/18
 * Purpose = Game panel uses Player Class to set up.
 ******************************************************************/

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener
{
	private JLabel myLabel1, myLabel2, moveButtons;
	private JButton myButton1, myButton2;
	private Font font1 = new Font("New Times Roman", Font.BOLD, 20);
	
	
	public GamePanel()
	{
		setPreferredSize(new Dimension(200,800)); 
		setBackground(new Color(0,0,0,0));
		
		moveButtons = new JLabel("<HTML>Movement:<BR>"
								+ "A to move Right<BR>"
								+ "S to move Down<BR>"
								+ "D to move Left<BR>"
								+ "W to move Up</HTML>");
		moveButtons.setForeground(Color.BLUE); moveButtons.setFont(font1);
		myLabel1 = new JLabel("Score:"); myLabel1.setForeground(Color.BLUE); myLabel1.setFont(font1);
		myLabel2 = new JLabel("0"); myLabel2.setForeground(Color.BLUE); myLabel2.setFont(font1);
		add(moveButtons);
		add(myLabel1);
		add(myLabel2);
	
	}
	
	
	public void updateScore(String score) {
		myLabel2.setText(score);
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		
	}

}
