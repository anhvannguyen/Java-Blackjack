package me.anhvannguyen;

//import java.io.Console;
import java.util.Scanner;


/**
 * @author Anh Nguyen
 * @version 1.0
 * The current goal of this program is to make a quick and dirty list of cards
 * and add it to a deck, then we shuffle the deck
 */
public class BlackJackGame {

	private String[] deck = new String[52];

	public String[] getDeck() {
		return deck;
	}

	public static void main(String[] args){
		
		// Display greeting
		System.out.println("Welcome to a game of BlackJack\n");

		// Eclipse does not have a true console and using the Console class will
		// always return null in eclipse
		// Eclipse Bug 122429: https://bugs.eclipse.org/bugs/show_bug.cgi?id=122429
		//Console console = System.console();
		//String userName = console.readLine("Enter your name: ");
		
		// Testing user input for future use using the the scanner class
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter your name: ");
		String userName = scanner.nextLine();
		
		System.out.println("Hello " + userName);
		
		System.out.println("Here are the current list of cards:");
		BlackJackGame blackJackGame = new BlackJackGame();
		blackJackGame.createDeck();
		for (String card : blackJackGame.getDeck()) {
			System.out.println(card);
		}
	}
	
	/**
	 * Generates 
	 */
	private void createDeck() {
		// TODO: Create a card deck
		int count = 0;
		String face = "";
		String suit = "";
		// There are 13 face and 4 suit for each face in a deck of cards
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				switch(i) {
				case 0:
					suit = "Spades";
					break;
				case 1:
					suit = "Clubs";
					break;
				case 2:
					suit = "Hearts";
					break;
				case 3:
					suit = "Diamonds";
					break;
				}
				switch(j) {
				case 0:
					face = "Ace";
					break;
				case 1:
					face = "Two";
					break;
				case 2:
					face = "Three";
					break;
				case 3:
					face = "Four";
					break;
				case 4:
					face = "Five";
					break;
				case 5:
					face = "Six";
					break;
				case 6:
					face = "Seven";
					break;
				case 7:
					face = "Eight";
					break;
				case 8:
					face = "Nine";
					break;
				case 9:
					face = "Ten";
					break;
				case 10:
					face = "Jack";
					break;
				case 11:
					face = "Queen";
					break;
				case 12:
					face = "King";
					break;
				}
				deck[count] = face + " of " + suit;
				count++;
			}
		}
	}
	
	private void shuffleDeck() {
		// TODO: Shuffle deck
	}

}