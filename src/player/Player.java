package player;

import game.Dice;
import game.Referee;
import util.Sleep;

public abstract class Player {
	private int score = 0;
	private final String name;
	
	public Player(String name) {
		this.name = name;
		
	}
	
	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public void play(Dice d, Referee r) {
		Sleep.sleep(1000);
		int score = d.roll();
		System.out.println("Player "+ name + " rolls a "+score);
		r.updateScore(this, score);
		System.out.println(getName()+ " now has " + getScore()+ " points");
	}
	
}
