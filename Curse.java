//Program: Curse.Java
//Purpose: This class represents curse cards
//Developer: Carlos Portillo
import java.util.Random;
public class Curse extends Card {
	private byte curseValue = 0;
	//string that represents what the curse effect is can be used to give player 
	//information about what curse they have been hit with
	private String curseEffect;
	
	//create random curse 
	Curse(){
		setType("Curse");
		Random curseRNG = new Random();
		curseValue = (byte)(1+ curseRNG.nextInt(10));
		if(curseValue == 1 || curseValue == 2) {
			setCurseEffect("Loose" + curseValue + " items");
		}
		if(curseValue == 3) {
			setCurseEffect("Loose race and become human");
		}
		if(curseValue == 4 || curseValue == 5) {
			setCurseEffect("Lose race and draw random new race card");
		}
		if(curseValue == 6 || curseValue == 7) {
			setCurseEffect("Lose class");
		}
		if(curseValue >= 8) {
			setCurseEffect("Lose Level");
		}
	}

	public String getCurseEffect() {
		return curseEffect;
	}

	public void setCurseEffect(String curseEffect) {
		this.curseEffect = curseEffect;
	}
}
