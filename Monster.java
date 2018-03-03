//Program: Monster.java
//Purpose: This class represents a monster in the game
//Developer: Carlos Portillo
import java.util.Random;
public class Monster extends Card {
	private byte strength;
	private byte vulnerability;
	//determines how much treasure cards you get if you beat this monster
	private byte treasureValue;
	private byte badStuff;
	
	public Monster() {
		setType("Monster");
		Random monsterRNG = new Random();
		strength = (byte)(1+monsterRNG.nextInt(20));
		vulnerability = (byte)(1+ monsterRNG.nextInt(10));
		treasureValue = (byte)(1+ monsterRNG.nextInt(5));
		badStuff = (byte)(1 + monsterRNG.nextInt(5));
		
	}
	
	public byte getStrength() {
		return strength;
	}
	public void setStrength(byte strength) {
		this.strength = strength;
	}
	public byte getVulnerability() {
		return vulnerability;
	}
	public void setVulnerability(byte vulnerability) {
		this.vulnerability = vulnerability;
	}
	public byte getTreasureValue() {
		return treasureValue;
	}
	public void setTreasureValue(byte treasureValue) {
		this.treasureValue = treasureValue;
	}

	public byte getBadStuff() {
		return badStuff;
	}

	public void setBadStuff(byte badStuff) {
		this.badStuff = badStuff;
	}
	
	

}
