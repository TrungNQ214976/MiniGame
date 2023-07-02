package app;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import game.Dice;
import game.Referee;
import player.Bot;
import player.Human;
import player.Player;
import util.Sleep;

public class App {
	private ArrayList<Dice>  dices = new ArrayList<>();
	private ArrayList<Player> players = new ArrayList<>();
	private ArrayList<String> playersName = new ArrayList<>();
	private Scanner scanner = new Scanner(System.in);
	public void init() {
		for (int i = 1; i <=4; i++) {
			dices.add(new Dice(i));
		}
	}

	public void showStartMenu() {
		System.out.println("\n\nWelcome to the MiniGame");
		System.out.println("1. Create player");
		System.out.println("2. Create bot");
		System.out.println("3. Start game");
		System.out.println("4. New game with new players");
		System.out.println("5. Quit");
		System.out.println("Choose your options: ");
		
	}
	
	public void createHuman() {
		System.out.println("Enter player name:");
		String name = scanner.nextLine();
		if(playersName.contains(name)) {
			System.out.println("Duplicate name.");
			return;
		}
		
		if(players.size() < 4) {
			players.add(new Human(name));
			System.out.println("Player " + name +" created.");
		} else {
			System.out.println("Player reached maximum.");
		}
	}
	
	public void createBot() {
		if(players.size() < 4) {
			Sleep.sleep(500);
			Player newBot = new Bot();
			players.add(newBot);
			System.out.println(newBot.getName() + " created.");
		} else {
			System.out.println("Player reached maximum.");
		}
	}
	
	public void start() {
		init();
		game: while (true) {
			showStartMenu();
			int option =  scanner.nextInt();
			scanner.nextLine();
			switch (option) {
			case 1:
				createHuman();
				break;
			case 2:
				createBot();
				break;
			case 3:
				if(players.size() < 4) {
					System.out.println("Not enough player.");
					System.out.println("Creating bot...");
					int j = players.size();
					for (int i = 0; i < 4 - j; i++ ) {
						createBot();
					}
				}
				startGame();
				break;
			case 4:
				players = new ArrayList<>();
				break;
			case 5:
				scanner.close();
				break game;
			default:
				System.out.println("Invalid option.");
				break;
			}
		}
	}
	
	public void startGame() {
		int currentRound = 1;
		int currentTurn = 0;
		Random random = new Random();
		Referee referee = new Referee();
		while(referee.getWinner() == null) {
			Player currentPlayer = players.get(currentTurn++);
			Dice currentDice = dices.get(random.nextInt(4));
			
			referee.infoPlayer(currentPlayer, currentDice);
			
			System.out.println("\nPlayer "+ currentPlayer.getName()+ " playing...");
			
			currentPlayer.play(currentDice, referee);
			
			if(currentTurn == 4) {
				currentTurn = 0;
				
				referee.endRoundInfo(currentRound++, players);
				
			}
		}
		Player winner = referee.getWinner();
		System.out.println("\nGame ended");
		System.out.println("The winner is: "+ winner.getName() +".\nCongratulations!\n");
		for (Player p: players) {
			if(p instanceof Bot && !p.equals(winner)) {
				((Bot) p).showEmotion();
			}
		}
		return;
	}
	
	public static void main(String[] args) {
		App app = new App();
		app.start();
	}
	
}
