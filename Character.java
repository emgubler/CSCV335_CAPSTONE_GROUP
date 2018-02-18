import java.util.ArrayList;

public class Character {
	
	 private int characterLevel;
	 private int goldAmount;
	 private ArrayList<Card> hand;
	 private Class playerClass;
	 private Race playerRace;
	
	public Character(ArrayList<Card> startingHand) {
		
		setCharacterLevel(1);
		setGoldAmount(0);
		setHand(startingHand);
		setPlayerClass(null);
		setPlayerRace(null);
		 
	}
	
	//getters and setters

	public int getCharacterLevel() {
		return characterLevel;
	}

	public void setCharacterLevel(int characterLevel) {
		this.characterLevel = characterLevel;
	}

	public int getGoldAmount() {
		return goldAmount;
	}

	public void setGoldAmount(int goldAmount) {
		this.goldAmount = goldAmount;
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}

	public Class getPlayerClass() {
		return playerClass;
	}

	public void setPlayerClass(Class playerClass) {
		this.playerClass = playerClass;
	}

	public Race getPlayerRace() {
		return playerRace;
	}

	public void setPlayerRace(Race playerRace) {
		this.playerRace = playerRace;
	}

}
