package me.anhvannguyen;

/**
 * Card class to hold and display our card object
 * @author Anh Nguyen 
 * 
 */
public class Card {
	// Defining the suit of the cards
	public enum Suit {
		SPADES, CLUBS, HEARTS, DIAMONDS
	};

	// Defining the face of the cards and setting their value
	public enum Face {
		ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), 
		NINE(9), TEN(10), JACK(10), QUEEN(10), KING(10);
		private final int value;	// The value of the card, we don't want this changed

		private Face(int value) {
			this.value = value;
		}

		// Get the value of the card
		public int getValue() {
			return value;
		}
	};

	private Face face; // represents the face of the card
	private Suit suit; // represents the suit of the card

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


	// String representation of what our card looks like.
	// Output should look something like "Ace of Clubs" or "Ten of Diamonds"
	@Override
	public String toString() {
		return getFaceAsString() + " of " + getSuitAsString();
	}

}
