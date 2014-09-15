package me.anhvannguyen;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Deck class to manage all of our cards
 * @author Anh
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
	
	
	
	// Reset our deck list by removing everything and 
	// repopulate with an unshuffled deck
	public void resetDeck() {
		deck.clear();
		for (Card.Suit suit : Card.Suit.values())
			for (Card.Face face : Card.Face.values())
				deck.add(new Card(face, suit));
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
