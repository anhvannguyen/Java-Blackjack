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

	private Face mFace;		// represents the face of the card
	private Suit mSuit;		// represents the suit of the card

	public Card(Face face, Suit suit) {
		mFace = face;
		mSuit = suit;
	}

	// Convert the Face value to a string representation
	public String getFaceAsString() {
		switch (mFace) {
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
		switch (mSuit) {
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

	@Override
	public String toString() {
		return getFaceAsString() + " of " + getSuitAsString();
	}

}
