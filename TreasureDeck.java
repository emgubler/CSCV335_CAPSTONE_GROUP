
//Program: TreasureDeck.java
//Purpose: This class is responsible for creating the treasure deck
//Developer Carlos Portillo
import java.util.Stack;

public class TreasureDeck {
	private int amountOfCards = 100;
	private Stack<Card> treasureDeck = new Stack<Card>();

	// creates deck
	public void createDeck() {
		for (int i = 0; i < amountOfCards; i++) {
			Card newCard = new Item();
			treasureDeck.push(newCard);
		}
	}

	public Stack<Card> getTreasureDeck() {
		return this.treasureDeck;
	}
}
