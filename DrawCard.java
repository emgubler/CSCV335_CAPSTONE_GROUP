/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawcard;

import java.util.ArrayList;

/**
 *
 * @author torre
 */
public final class DrawCard extends Application { 

    
    
	 private int DrawCardLevel;

	 private int getType;

	 private ArrayList<Card> hand;

	 private String DrawCards;

	 private String PlayCards;
    private int GetType;
    private String playcards;
    private String playCards;

	

	public DrawCard(ArrayList<DrawCard> startingHand) {

		

		setDrawCardLevel(1);

		setGetType(0);

		setHand(startingHand);

		setDrawCards(null);

		setPlayCards(null);

		 

	}

	

	//getters and setters



	public int getDrawCardLevel() {

		return DrawCardLevel;

	}



	public void setDrawCardLevel(int DrawCardLevel) {

		this.drawcardLevel = drawcardLevel;

	}



	public int getType() {

		return getType;

	}



	public void setGetType(int GetType ) {

		this.GetType = GetType;

	}



	public ArrayList<DrawCard> getHand() {

		return hand;

	}



	public void setHand(ArrayList<DrawCard> hand) {

		this.hand = hand;

	}



	public String getDrawCards() {

		return DrawCards;

	}



	public void setDrawCards(String DrawCards) {

		this.drawcards = drawcards;

	}



	public String getPlayCards() {

		return playcards;

	}



	public void setPlayCards(String playCards) {

		this.playCards = playCards;

	}



}


