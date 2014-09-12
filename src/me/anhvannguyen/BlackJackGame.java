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
		//displayHand(user, PLAYER_TAG);
		
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
			// user or the hand goes over 21.
			// Added the 17 rule because the dealer will win too much.
			// The dealer must draw when the hand is 16 or under and must stand when
			// the hand is 17 and over.
			if (dealer.getHandValue() < 17) {
				System.out.println("Dealer drawing card...");
				dealer.addCard(deck.dealCard());
				displayHand(dealer, DEALER_TAG); 
			} else {
				// exit the loop when the dealer hand is 17 or over
				break;
			}
		}
		checkWinner(user, dealer);
	}
	
	// Check the player and dealer hand to see who win/lose or if it's a tie
	// Blackjack will beat out all
	private void checkWinner(Player player1, Player player2) {
		System.out.println();
		System.out.println("** Checking Winner **");
		// Checking some special case
		if (player1.hasBlackJack() && player2.hasBlackJack()) {
			System.out.println("Both user and dealer has blackjack!");
			System.out.println("Game is a Draw!");
		} else if (player1.hasBlackJack() && !player2.hasBlackJack()) {
			System.out.println("You have blackjack!");
			System.out.println("You Win!");
		} else if (!player1.hasBlackJack() && player2.hasBlackJack()) {
			System.out.println("Dealer have blackjack!");
			System.out.println("You Lose!");
		} else if (player1.getHandValue() > Player.MAX_CARD_VALUE) {
			System.out.println("You went over!");
			System.out.println("You Lose!");
		} else if (player2.getHandValue() > Player.MAX_CARD_VALUE) {
			System.out.println("Dealer went over!");
			System.out.println("You Win!");
		} else {
			// Compare the hand of the dealer and player
			if (player1.getHandValue() <= Player.MAX_CARD_VALUE && player2.getHandValue() <= Player.MAX_CARD_VALUE) {
				if (player2.getHandValue() == player1.getHandValue()) {
					System.out.println("Game is a draw!");
				} else if (player2.getHandValue() > player1.getHandValue()) {
					System.out.println("You Lose!");
				} else if (player1.getHandValue() > player2.getHandValue()) {
					System.out.println("You Win!");
				}
			}
		}
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
