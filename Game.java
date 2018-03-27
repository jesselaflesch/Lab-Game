

import java.util.ArrayList;

public class Game{
	
	private ArrayList<Integer> topScores;
	private ArrayList<String> topPlayers;
	private String playerName;
	
	public Game(String playerName){
		this.topScores = new ArrayList<Integer>();
		this.topPlayers = new ArrayList<String>();
		this.playerName = playerName;
	}
	
	public void addScore(int score){
		for (int i = 0; i < topScores.size(); i++) {
			while (score <= topScores.get(i)) {continue;}
			topScores.add(i, score);
			topPlayers.add(i, playerName);
		}
	}
	
	public String toString(){
		String highScores = "<HTML>High Scores:<BR>";
		for (int i = 0; i < this.topScores.size(); i++) {
			highScores += ((i+1) + ". " + topPlayers.get(i) + ": " + topScores.get(i) + "<br>");
		}
		highScores += "</HTML>";
		return highScores;
	}
}