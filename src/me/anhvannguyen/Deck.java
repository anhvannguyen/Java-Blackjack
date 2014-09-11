package me.anhvannguyen;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Anh
 * Deck class to manage all of our cards
 */
public class Deck {
	// The container holding all our cards
	private ArrayList<Card> deck = new ArrayList<Card>();


	// Constructor to create a new deck and populate with cards
	public Deck() {
		resetDeck();
	}
	

	// Shuffle the entire deck around
	public void shuffleDeck() {
		Collections.shuffle(deck);
	}
	
	

	// Reset our deck list by removing everything and repopulate with an unshuffled deck
	public void resetDeck() {
		deck.clear();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				Card.Suit suit = null;
				Card.Face face = null;
				switch (i) {
				case 0:
					suit = Card.Suit.SPADES;
					break;
				case 1:
					suit = Card.Suit.CLUBS;
					break;
				case 2:
					suit = Card.Suit.HEARTS;
					break;
				case 3:
					suit = Card.Suit.DIAMONDS;
					break;
				}
				switch (j) {
				case 0:
					face = Card.Face.ACE;
					break;
				case 1:
					face = Card.Face.TWO;
					break;
				case 2:
					face = Card.Face.THREE;
					break;
				case 3:
					face = Card.Face.FOUR;
					break;
				case 4:
					face = Card.Face.FIVE;
					break;
				case 5:
					face = Card.Face.SIX;
					break;
				case 6:
					face = Card.Face.SEVEN;
					break;
				case 7:
					face = Card.Face.EIGHT;
					break;
				case 8:
					face = Card.Face.NINE;
					break;
				case 9:
					face = Card.Face.TEN;
					break;
				case 10:
					face = Card.Face.JACK;
					break;
				case 11:
					face = Card.Face.QUEEN;
					break;
				case 12:
					face = Card.Face.KING;
					break;
				}
				deck.add(new Card(face, suit));
			}
		}
	}
	
	// Deal a card, then remove it from the deck
	public Card dealCard() {
		if (deck.isEmpty())
			return null;
		
		// Get the top card in the deck
		Card card = deck.get(deck.size() - 1);
		
		// Remove the card from the deck list
		deck.remove(card);
		
		// Return the card that was at the top of the deck
		return card;
	}
	
	// Return the size how many cards remain in the deck
	public int deckSize() {
		return deck.size();
	}

	 // Helper to print the current deck list
	public void printDeckList() {
		for (Card c : deck)
			System.out.println(c.toString());
	}
}
