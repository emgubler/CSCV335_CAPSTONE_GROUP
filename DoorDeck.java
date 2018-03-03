//Program: DoorDeck.java
//Purpose: this class is reponsible for creating the door deck
//Developer: Carlos Portillo
import java.util.*;
public class DoorDeck {
	
	
	private Stack<Card> doorDeck = new Stack<Card>();
	private int amountOfCards = 100;
	//limits of cards we can have in 
	private int raceCards = 15;
	private int classCards = 15;
	private int monsterCards = 30;
	private int curseCards = 30;
	private int helpfulCards = 10;
	//this method creates the door deck
	public void createDeck() {
		//this will determine which card gets created
		Random cardRNG = new Random();
		int chosenValue;
		int i = 0;
		//loop until you filled deck
		while(i < amountOfCards) {
			chosenValue = cardRNG.nextInt(5);
			switch(chosenValue) {
				case 0:
					//checks if we don't exceed the limit of race cards we can put 
					//into deck
					if(raceCards > 0) {
						Card newCard = new Race();
						doorDeck.push(newCard);
						raceCards--;
					}
					else {
						continue; //try loop again, don't increment
					}
					break;
				case 1: 
					if(classCards > 0) {
						Card newCard = new Class();
						doorDeck.push(newCard);
						classCards--;
					}
					else {
						continue; //try loop again, dont increment
					}
					break;
				case 2:
					if(monsterCards > 0) {
						Card newCard = new Monster();
						doorDeck.push(newCard);
						monsterCards--;
					}
					else {
						continue; //try loop again, don't increment
					}
					break;
				case 3:
					if(curseCards > 0) {
						Card newCard = new Curse();
						doorDeck.push(newCard);
						curseCards--;
						
					}
					else {
						continue; //try loop again, don't increment
					}
					break;
				case 4:
					if(helpfulCards > 0) {
						Card newCard = new Helpful();
						doorDeck.push(newCard);
						helpfulCards--;
					}
					else {
						continue; //try loop again, don't increment
					}
					break;					
			} //end switch
		    i++;
		} //end while
	} //end createDeck method
	public Stack<Card> getDoorDeck(){
		return this.doorDeck;
	}
}

