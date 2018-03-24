//*****************************************************************
/* Author = Jesse LaFlesch
 * Partner = Ian Gonzales
 * File = Game.java
 * Creation Date: 3/9/18
 * Purpose = Holds top scores and an array of Player objects and array of ints.
 ******************************************************************/
import java.util.ArrayList;
import java.util.Collections;

public class Game 
{
	private ArrayList<Integer> scores;
	
	public Game()
	{
		this.scores = new ArrayList<Integer>();
	}
	
	public void addScore(int score)
	{
		scores.add(score);
		Collections.sort(scores);
		Collections.reverse(scores);
	}
	
	public String toString() {
		String highScores = "<HTML>";
		
		for (int i = 0; i < this.scores.size(); i++) {
			highScores = highScores + (i+1) + ". " + scores.get(i) + "<br>";
		}
		highScores += "</HTML>";
		return highScores;
		
	}

}
