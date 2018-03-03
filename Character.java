import java.util.ArrayList;

public class Character {

	private int characterLevel;
	private int goldAmount;
	private ArrayList<Card> hand;
	private ArrayList<Item> items;
	private String playerClass;
	private String playerRace;

	public Character(ArrayList<Card> startingHand) {

		setCharacterLevel(1);
		setGoldAmount(0);
		setHand(startingHand);
		setPlayerClass(null);
		setPlayerRace(null);

	}

	// getters and setters

	public int getCombatValue() {
		int sum = characterLevel;
		for (int i = 0; i < items.size(); i++) {
			sum += items.get(i).getCombatValue();
		}
		return sum;
	}

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

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	public ArrayList<Item> getItemsInHand() {
		ArrayList<Item> itemsInHand = new ArrayList<Item>();
		for (int i = 0; i < hand.size(); i++) {
			if (hand.get(i).getType().equals("Item")) {
				itemsInHand.add((Item) (hand.get(i)));
			}
		}
		return itemsInHand;
	}

	public Item getHighestValueItemInHand() {
		Item max = null;
		for (int i = 0; i < hand.size(); i++) {
			if (hand.get(i).getType().equals("Item")) {
				if (max.getMonetaryValue() < ((Item) hand.get(i)).getMonetaryValue()) {
					max = ((Item) hand.get(i));
				}
			}
		}
		return max;
	}
}
