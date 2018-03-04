/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawcard;

import java.util.ArrayList;
import javafx.application.Application;
import javax.smartcardio.Card;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

/**
 *
 * @author torre
 */
public final class DrawCard extends Application { 

	 private int DrawCardLevel;
	 private int getDoorDeck;

	 private ArrayList<DrawCard> Characterhand;

	 private String DrawCards;
	 private String PlayCardsMunchkinGame;
         private int GetDoorDeck;
         private String PopCard;
         private String playCards;
         private String playcards;
         private ArrayList<DrawCard> CharacterHand;
         private String PopCards;

	public DrawCard(ArrayList<MunchkinGame> CharacterHand) {

		setDrawCardLevel(1);
                setActionMethod(1);
		setGetDoorDeck(1);
		setCharacterHand(startingCharacterHand);
		setPopCards(null);
		setPlayCards(null);

	}

	//getters and setters

	public int getDoorDeck() {
		return DrawCardLevel;
	}

	public void setDrawCardLevel(int DrawCardLevel) {
		this.drawcardLevel = drawcardLevel;
	}

	public int getDoorDeck() {
		return getDoorDeck;
	}

	public void drawCard(DoorDeck doorDeck, Character character) {
            Card cardDrawn = doorDeck.getDoorDeck().pop();
            character.getHand().add(cardDrawn);
	}

	public ArrayList<DrawCard> CharacterHand() {
		return CharacterHand;
	}
        
        public void setDoorDeck(int GetDoorDeck ) {
		this.GetDoorDeck = GetDoorDeck;
	}

	public String getPopCards() {
		return PopCards;
	}

	public void setPopCards(String PopCards) {
		this.PopCards = PopCards;
	}

	public String getPlayCards() {
             String PlayCards = null;
		return PlayCards;
	}
        
	public void setPlayCards(String playCards) {
		this.playCards = playCards;
	}
}

