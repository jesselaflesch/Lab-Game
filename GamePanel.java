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
	private JLabel myLabel1, myLabel2;
	private JButton myButton1, myButton2;
	private Font font1 = new Font("New Times Roman", Font.BOLD, 20);
	
	
	public GamePanel()
	{
		setPreferredSize(new Dimension(200,800)); 
		setBackground(new Color(0,0,0,0));
		
		myLabel1 = new JLabel("Omg, I work!"); myLabel1.setForeground(Color.BLUE); myLabel1.setFont(font1);
		add(myLabel1);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		
	}

}
