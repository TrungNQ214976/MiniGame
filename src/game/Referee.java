package game;

import java.util.ArrayList;

import player.Player;
import util.Sleep;

public class Referee {
	private Player winner;
	public void infoPlayer(Player p, Dice d) {
		Sleep.sleep(1000);
		System.out.println("\nReferee:\nThis is " + p.getName() + " turn");
		System.out.println("Your score is: " + p.getScore());
		System.out.println("You will use dice with face "+ d.getMajorFace()+" has 20% probability");;
	}
	
	public void endRoundInfo(int i, ArrayList<Player> players) {
		System.out.println("\nReferee: Round "+i+ " ended");
		for (Player p: players) {
			System.out.println(p.getName()+ " got " + p.getScore()+ " points");
		}
		Sleep.sleep(1000);
	}
	
	public void updateScore(Player p, int score) {
		int newScore = p.getScore() + score;
		if(newScore == 21) {
			winner = p;
		} else if(newScore > 21) {
			newScore = 0;
		}
		p.setScore(newScore);
	}

	public Player getWinner() {
		return winner;
	}

	
}
