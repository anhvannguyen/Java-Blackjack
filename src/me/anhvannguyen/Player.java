package me.anhvannguyen;

import java.util.ArrayList;

/**
 * @author Anh
 * A class to represent the dealer and player(s)
 */
public class Player {
	private final int MAX_CARDS = 5;		// Maximum number of cards the player can have in their hand
	
	private int cardTotalValue;				// The current value of cards in hand
	private boolean aceCard;				// Check to see if at least one Ace card is in hand
	private ArrayList<Card> hand;			// List of cards in hand
	
	// Initialize the player
	public Player() {
		hand.clear();
		aceCard = false;
	}
	
	// Initialize the player with 2 cards in hand
	public Player(Card card1, Card card2) {
		hand.clear();
		hand.add(card1);
		hand.add(card2);
		checkAce();
	}
	
	// Helper to check if there is any ace cards in hand
	private void checkAce() {
		for (Card c : hand) {
			if (c.getFaceOfCard() == Card.Face.ACE)
				aceCard = true;
		}
	}
	
	// Add the card to the hand if it doesn't exceed the card limit
	public void addCard(Card card) {
		if (hand.size() >= MAX_CARDS) {
			System.out.println("Hand is full");
			return;
		}
		hand.add(card);
	}
	
	// Remove a card from the player's hand
	public void removeCard(Card card) {
		hand.remove(card);
	}
	
	// Remove a card from the player's hand by index
		public void removeCard(int index) {
			hand.remove(index);
		}

}
