package me.anhvannguyen;

//import java.io.Console;
import java.util.Scanner;

/**
 * @author Anh Nguyen
 * @version 1.0 
 * The end goal of this program is to make a simple blackjack game.
 * The current goal is to make a quick and dirty list of cards and add
 * it to a deck, then we shuffle the deck
 */

public class BlackJackGame {

	public static void main(String[] args) {
		Deck deck;

		// Display greeting
		System.out.println("Welcome to a game of BlackJack\n");

		// Eclipse does not have a true console and using the Console class will
		// always return null in eclipse
		// Eclipse Bug 122429:
		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=122429
		// Console console = System.console();
		// String userName = console.readLine("Enter your name: ");

		// Testing user input for future use
//		Scanner scanner = new Scanner(System.in);
//		System.out.print("Enter your name: ");
//		String userName = scanner.nextLine();
//		System.out.println("Hello " + userName);

		deck = new Deck();
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
