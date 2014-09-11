package me.anhvannguyen;

import java.util.ArrayList;

/**
 * @author Anh
 * A class to represent the dealer and player(s)
 */
public class Player {
	private final int MAX_CARDS = 5;		// Maximum number of cards the player can have in their hand
	private final int MAX_CARD_VALUE = 21;	// Maximum total value of card in hand, going over this amount and player loses
	
	private ArrayList<Card> hand;			// List of cards in hand
	
	// Initialize the player with an empty hand
	public Player() {
		hand = new ArrayList<Card>();
		hand.clear();
	}
	
	// Initialize the player with 2 cards in hand
	public Player(Card card1, Card card2) {
		hand = new ArrayList<Card>();
		hand.clear();
		hand.add(card1);
		hand.add(card2);
	}

	// Check if there is any ace cards in hand
	public boolean hasAce() {
		for (Card c : hand) {
			if (c.getFaceOfCard() == Card.Face.ACE)
				return true;
		}
		return false;
	}
	
	// Add the card to the hand
	public void addCard(Card card) {
		// Check to see if 
		if (hand.size() >= MAX_CARDS) {
			System.out.println("Hand is full");
			return;
		}
		hand.add(card);
	}
	
	// Remove a card from the player's hand
	public void removeCard(Card card) {
		// If the card exist in the deck we remove it
		hand.remove(card);
	}
	
	// Remove a card from the player's hand by index
	public void removeCard(int index) {
		// Check if the index is in-bounds and remove it if it is
		if (index >= 0 || index < MAX_CARDS)
			hand.remove(index);
	}
	
	// Get the sum of the value of the cards in a players hand
	public int getHandValue() {
		// Go through each cards in hand and add the values
		int sumOfCards = 0;
		for (Card c : hand) {
			sumOfCards += c.getCardValue();
		}
		
		// Ace can have a value of 1 or 11.  
		// Ace is set to have a default value of 1.
		// At most only one Ace card in the deck can have an Ace card of value 11.
		// Because having two Ace in the deck will bring the total value of the hand
		// to 22, if both have a value of 11.
		// Here we add the difference of the Ace value (11 - 1) = 10 since the value of 1 of the Ace card
		// has been added to the total
		if (hasAce() && sumOfCards + 10 <= MAX_CARD_VALUE)
			sumOfCards += 10;
		
		return sumOfCards;
	}
	
	// Print out all the cards that are currently in the players hand
	public void printPlayerHand() {
		for (Card c : hand) {
			System.out.println(c);
		}
	}
	
	// Reset the players hand by removing all the cards
	public void resetHand() {
		hand.clear();
	}

}
