import java.util.ArrayList;

public class Character {
	
	 private int characterLevel;
	 private int goldAmount;
	 private ArrayList<Card> hand;
	 private String playerClass;
	 private String playerRace;
	
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

	public String getPlayerClass() {
		return playerClass;
	}

	public void setPlayerClass(String playerClass) {
		this.playerClass = playerClass;
	}

	public String getPlayerRace() {
		return playerRace;
	}

	public void setPlayerRace(String playerRace) {
		this.playerRace = playerRace;
	}

}
