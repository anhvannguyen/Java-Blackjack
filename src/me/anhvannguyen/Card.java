package me.anhvannguyen;

/**
 * @author Anh Nguyen 
 * Card class to hold and display our card object
 */
public class Card {
	// Defining the suit of the cards
	public enum Suit {
		SPADES, CLUBS, HEARTS, DIAMONDS
	};

	// Defining the face of the cards
	public enum Face {
		ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
	};

	private Face face;		// represents the face of the card
	private Suit suit;		// represents the suit of the card

	public Card(Face face, Suit suit) {
		this.face = face;
		this.suit = suit;
	}

	// Convert the Face value to a string representation
	public String getFaceAsString() {
		switch (face) {
		case ACE:
			return "Ace";
		case TWO:
			return "Two";
		case THREE:
			return "Three";
		case FOUR:
			return "Four";
		case FIVE:
			return "Five";
		case SIX:
			return "Six";
		case SEVEN:
			return "Seven";
		case EIGHT:
			return "Eight";
		case NINE:
			return "Nine";
		case TEN:
			return "Ten";
		case JACK:
			return "Jack";
		case QUEEN:
			return "Queen";
		case KING:
			return "King";
		default:
			return "?";
		}
	}

	// Convert the Suit value to a string representation
	public String getSuitAsString() {
		switch (suit) {
		case SPADES:
			return "Spades";
		case CLUBS:
			return "Clubs";
		case HEARTS:
			return "Hearts";
		case DIAMONDS:
			return "Diamonds";
		default:
			return "?";
		}
	}
	
	// Return what type of face the card has
	public Face getFaceOfCard() {
		return face;
	}
	
	// Return what type of suit the card has
	public Suit getSuitOfCard() {
		return suit;
	}
	
	// Get the numerical value of the card
	public int getCardValue() {
		switch (face) {
		case ACE:
			return 1;
		case TWO:
			return 2;
		case THREE:
			return 3;
		case FOUR:
			return 4;
		case FIVE:
			return 5;
		case SIX:
			return 6;
		case SEVEN:
			return 7;
		case EIGHT:
			return 8;
		case NINE:
			return 9;
		case TEN:
			return 10;
		case JACK:
			return 10;
		case QUEEN:
			return 10;
		case KING:
			return 10;
		default:
			return 0;
		}
	}
	

	// String representation of what our card looks like.
	// Output should look something like "Ace of Clubs" or "Ten of Diamonds"
	@Override
	public String toString() {
		return getFaceAsString() + " of " + getSuitAsString();
	}

}
