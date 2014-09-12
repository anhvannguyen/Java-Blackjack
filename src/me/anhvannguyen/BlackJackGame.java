package me.anhvannguyen;

//import java.io.Console;
import java.util.Scanner;


/**
 * @author Anh Nguyen
 * @version 1.0 
 * The end goal of this program is to make a simple blackjack game.
 * 
 */

public class BlackJackGame {

	public static void main(String[] args) {

		BlackJackGame game = new BlackJackGame();
		//game.debugTesting();
		game.playBlackJack();

	}

	public void playBlackJack() {
		final String PLAYER_TAG = "Player";
		final String DEALER_TAG = "Dealer";
		
		Player user = new Player();		// Create the user/player
		Player dealer = new Player();	// Create the dealer
		Deck deck = new Deck();			// Create the deck

		// Display greeting
		System.out.println("Welcome to a game of BlackJack\n");

		// Shuffle the deck
		System.out.println("Shuffling deck...");
		deck.shuffleDeck();

		// Deal out the cards in alternating order
		System.out.println("Dealing cards...");
		user.addCard(deck.dealCard());
		dealer.addCard(deck.dealCard());
		user.addCard(deck.dealCard());
		dealer.addCard(deck.dealCard());

		displayHand(user, PLAYER_TAG);

		// A game loop for the user
		while (true) {
			// Player turn will automatically end if the following happens:
			// 1. The player already has too many cards in hand
			// 2. The player card value is over 21
			if (user.getCardCount() >= Player.MAX_CARDS 
					|| user.getHandValue() > Player.MAX_CARD_VALUE) {
				break;
			}
			
			// Get the user input on what they want to do, and will 
			// keep looping until a valid input is entered
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
			} else if (userChoice == 1) {
				user.addCard(deck.dealCard());
				displayHand(user, PLAYER_TAG);
			}
		}
		displayHand(user, PLAYER_TAG);
		
		// Dealer Turn
		System.out.println("\n** Dealer Turn **");
		displayHand(dealer, DEALER_TAG);
		// TODO: Create the dealer logic to play
		// A game loop for the dealer
		while (true) {
			// Dealer turn will automatically end if the following happens:
			// 1. The player card value is over 21
			// 2. The dealer card value is over 21
			// 3. The dealer has too many cards in hand
			// 4. The dealer hand is greater than the player hand
			if (user.getHandValue() > Player.MAX_CARD_VALUE 
					|| dealer.getHandValue() > Player.MAX_CARD_VALUE 
					|| dealer.getCardCount() >= Player.MAX_CARDS 
					|| dealer.getHandValue() > user.getHandValue()) {
				break;
			}
			
			// Dealer has nothing to lose, keep drawing a card until they beat the
			// user or the hand goes over 21
			System.out.println("Dealer drawing card...");
			dealer.addCard(deck.dealCard());
			displayHand(dealer, DEALER_TAG);
		}
		checkWinner(user, dealer);
	}
	
	private void checkWinner(Player player1, Player player2) {
		
	}

	// Helper to display the current hand
	private void displayHand(Player player, String playerName) {
		System.out.println();
		System.out.println(playerName + " Hand:");
		System.out.println("============");
		player.printPlayerHand();
		System.out.println(playerName + " Total Value: " + player.getHandValue());
	}

	// Helper to test the functions of the game
	private void debugTesting() {

		// Eclipse does not have a true console and using the Console class will
		// always return null in eclipse
		// Eclipse Bug 122429:
		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=122429
		// Console console = System.console();
		// String userName = console.readLine("Enter your name: ");

		// Testing user input for future use
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your name: ");
		String userName = scanner.nextLine();
		System.out.println("Hello " + userName);

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
