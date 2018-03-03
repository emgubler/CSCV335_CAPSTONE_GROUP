//Program Item.java
//Purpose: This class represents items in the game, which are in the treasure deck
//Developer: Carlos Portillo
import java.util.Random;
public class Item extends Card {
		private short monetaryValue;
		private byte combatValue;
		//constructor item, assigning random monetary value and combat value
		public Item() {
			Random ItemRNG = new Random();
			setType("Item");
			monetaryValue = (short)(100+ ItemRNG.nextInt(300));
			combatValue = (byte)(1 + ItemRNG.nextInt(5));
		}
		public short getMonetaryValue() {
			return monetaryValue;
		}
		public void setMonetaryValue(short monetaryValue) {
			this.monetaryValue = monetaryValue;
		}
		public byte getCombatValue() {
			return combatValue;
		}
		public void setCombatValue(byte combatValue) {
			this.combatValue = combatValue;
		}
}
