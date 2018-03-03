//Program: Race.java
//Purpose: This class represents all the different races and their various abilities
//Developer: Carlos Portillo
import java.util.Random;
public class Race extends Card {
		//value determines which race this card
		private byte raceValue;
		private String raceString;
		//determines how many cards race can hold in hand
		private byte cardHandSize = 5;
		//determines if you can sell an item for double its price
		private boolean sellDoublePrice =false;
		//determines if you can roll twice to run away
		private boolean doubleChanceToRunAway = false;
		//determines if you can run with a roll of 4 or higher
		private boolean runWith4Or_Higher = false;
		
		//creates race and assigns a random race to instance 
		public Race() {
			
			Random raceRNG = new Random();
			raceValue = (byte)raceRNG.nextInt(3);
			if(raceValue == 0) {
				setRaceString("Elf");
				//elves can run with 4 or higher 
				setRunWith4Or_Higher(true);
			}
			else if(raceValue == 1) {
				setRaceString("Halfling");
				//halflings can sell for double price
				setSellDoublePrice(true);
				setDoubleChanceToRunAway(true);
			}
			else if(raceValue == 2) {
				setRaceString("Dwarf");
				//dwards can hold 6 cards
				cardHandSize = 6;
			}
			
		}
		
		public byte getCardHandSize() {
			return cardHandSize;
		}
		public void setCardHandSize(byte cardHandSize) {
			this.cardHandSize = cardHandSize;
		}

		public String getRaceString() {
			return raceString;
		}

		public void setRaceString(String raceString) {
			this.raceString = raceString;
		}

		public boolean isSellDoublePrice() {
			return sellDoublePrice;
		}

		public void setSellDoublePrice(boolean sellDoublePrice) {
			this.sellDoublePrice = sellDoublePrice;
		}

		public boolean isDoubleChanceToRunAway() {
			return doubleChanceToRunAway;
		}

		public void setDoubleChanceToRunAway(boolean doubleChanceToRunAway) {
			this.doubleChanceToRunAway = doubleChanceToRunAway;
		}

		public boolean isRunWith4Or_Higher() {
			return runWith4Or_Higher;
		}

		public void setRunWith4Or_Higher(boolean runWith4Or_Higher) {
			this.runWith4Or_Higher = runWith4Or_Higher;
		}
		
		
}
