//*****************************************************************
/* Author = Jesse LaFlesch
 * Partner = Ian Gonzales
 * File = Game.java
 * Creation Date: 3/9/18
 * Purpose = Holds top scores and an array of Player objects and array of ints.
 ******************************************************************/
import java.util.ArrayList;

public class Game 
{
	private int topScore, secondScore, thirdScore;
	private ArrayList<Player> players;
	private ArrayList<Integer> scores;
	
	public Game()
	{
		this.topScore = topScore; 
		this.secondScore = secondScore; 
		this.thirdScore = thirdScore;
		this.players = new ArrayList<Player>();
		this.scores = new ArrayList<Integer>();
	}
	
	public void addPlayer(Player player)
	{
		players.add(player);
	}
	
	public void addScore(int score)
	{
		scores.add(score);
	}

	public int getTopScore() 
	{
		return topScore;
	}

	public void setTopScore(int topScore) 
	{
		this.topScore = topScore;
	}

	public int getSecondScore() 
	{
		return secondScore;
	}

	public void setSecondScore(int secondScore) 
	{
		this.secondScore = secondScore;
	}

	public int getThirdScore() 
	{
		return thirdScore;
	}

	public void setThirdScore(int thirdScore) 
	{
		this.thirdScore = thirdScore;
	}

}
