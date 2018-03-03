//Program: Class.java
//Purpose: This class represents various classes and their abilities
//Developer: Carlos Portilo
import java.util.Random;
public class Class extends Card{
	
	byte raceValue;
	String classString;
	//abilities/skills of the classes
	Boolean fightingUndead = false;
	Boolean runningAway = false;
	Boolean charmSpell = false;
	Boolean beserking = false;
	Boolean tie = false;
	
	public Class() {
		setType("Class");
		Random classRNG = new Random();
		raceValue = (byte)classRNG.nextInt(3);
		if(raceValue == 0) {
			classString = "Cleric";
			//set object instance to have this ability 
			fightingUndead = true;
		}
		else if(raceValue == 1) {
			classString = "Wizard";
			runningAway = true;
			charmSpell = true;
		}
		else if(raceValue == 2) {
			classString = "Warrior";
			beserking = true;
			tie = true;
		}
	}
	

}
