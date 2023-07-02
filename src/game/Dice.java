package game;

import java.util.ArrayList;
import java.util.Random;

public class Dice {
	private int majorFace;
	private ArrayList<Double> probList = new ArrayList<>();
	
	public int getMajorFace() {
		return majorFace;
	}

	
	public Dice(int majorFace) {
		this.majorFace = majorFace;
		getProbList();
	}
	
	public int roll() {
		Random random = new Random();
		double res = random.nextDouble(); 
		double w = 0;
		for (int i = 0; i < 6; i++) {
			w += probList.get(i);
			if(w > res) {
				return i+1;
			}
		}
		return -1;
	}
	
	private void getProbList() {
		for (int i = 1; i <= 6; i++ ) {
			if(i == majorFace) {
				probList.add(0.2);
			} else {
				probList.add(0.16);
			}
		}
	}
	
}
