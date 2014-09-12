package me.anhvannguyen;

//import java.io.Console;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

/**
 * @author Anh Nguyen
 * @version 1.0 
 * The end goal of this program is to make a simple blackjack game.
 * 
 */

public class BlackJackGame {

	public static void main(String[] args) {

		BlackJackGame game = new BlackJackGame();
		// game.debugTesting();
		game.playBlackJack();

	}

	public void playBlackJack() {
		Player user = new Player();
		Player dealer = new Player();
		Deck deck = new Deck();

		// Display greeting
		System.out.println("Welcome to a game of BlackJack\n");

		System.out.println("Shuffling deck...");
		deck.shuffleDeck();

		System.out.println("Dealing cards...");
		user.addCard(deck.dealCard());
		dealer.addCard(deck.dealCard());
		user.addCard(deck.dealCard());
		dealer.addCard(deck.dealCard());

		displayHand(user);

		// Create a simple game loop
		while (true) {
			// Break out of the loop if the player hand is full or if
			if (user.getCardCount() >= Player.MAX_CARDS) {
				break;
			}
			
			int userChoice;
			do {
				Scanner scanner = new Scanner(System.in);
				System.out.println("[1] - Hit");
				System.out.println("[2] - Stand");
				System.out.print("What do you want to do: ");
				userChoice = scanner.nextInt();
			} while (userChoice != 1 && userChoice != 2);

			if (userChoice == 2) {
				break;
			} else {
				user.addCard(deck.dealCard());
			}
		}
		displayHand(user);
		
		// TODO: Create the dealer logic to play
	}

	public void displayHand(Player player) {
		System.out.println();
		System.out.println("Player Hand:");
		System.out.println("============");
		player.printPlayerHand();
		System.out.println("Total Value: " + player.getHandValue());
	}

	// Helper to test the functions of the game
	public void debugTesting() {

		// Eclipse does not have a true console and using the Console class will
		// always return null in eclipse
		// Eclipse Bug 122429:
		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=122429
		// Console console = System.console();
		// String userName = console.readLine("Enter your name: ");

		// Testing user input for future use
		// Scanner scanner = new Scanner(System.in);
		// System.out.print("Enter your name: ");
		// String userName = scanner.nextLine();
		// System.out.println("Hello " + userName);

		Deck deck = new Deck();
		// Print out a list of cards in the deck
		System.out.println();
		System.out.println("Cards before shuffle:");
		System.out.println("=====================");
		deck.printDeckList();
		System.out.println("Current deck size: " + deck.deckSize());

		// Shuffle the cards and print out the new deck
		System.out.println();
		System.out.println("Cards after shuffle:");
		System.out.println("====================");
		deck.shuffleDeck();
		deck.printDeckList();
		System.out.println("Current deck size: " + deck.deckSize());

		// Deal a card and print it
		System.out.println();
		System.out.println("Dealing out card");
		System.out.println("================");
		System.out.println("Dealing Card: " + deck.dealCard().toString());
		System.out.println("Current deck size: " + deck.deckSize());

		System.out.println();
		System.out.println("Deck after card delt:");
		System.out.println("=====================");
		deck.printDeckList();
	}

}
