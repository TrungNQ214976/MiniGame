package player;

import java.util.Random;

public class Bot extends Player{
	private static String[] NAME_LIST = {"Alice", "Bob", "Eve", "Cathy"};
	private static String[] LOSE_EMOTIONS = {"So close...", "I'll win next time!", "GG well played", "Unlucky...", ":((((", "No way...", "You guys are good!", "Congrats!"};
	private static Random RANDOM = new Random();
	
	public Bot() {
		super("Bot " + NAME_LIST[RANDOM.nextInt(0,4)] + RANDOM.nextInt(1000));
	} 
	
	public void showEmotion() {
		System.out.println(this.getName()+": " + LOSE_EMOTIONS[RANDOM.nextInt(LOSE_EMOTIONS.length)]);
	}
	
	public void sayABC() {
		System.out.println("ABC");
	}

}
