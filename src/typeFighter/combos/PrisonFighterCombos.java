package typeFighter.combos;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;

public class PrisonFighterCombos extends ComboList  {
	
	public PrisonFighterCombos() {
		comboList = new ArrayList<String>();
		
		generateCombos();
	}
	
	public void executeCombo(ComboLetter comboLetter){
		switch (Character.toLowerCase(comboLetter.getChar())) {
		case 'a':
			if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
				comboLetter.setChecked(true);
			}
			break;

		default:
			break;
		}
	}
	
	private void generateCombos(){
		comboList.add("Ass Fisting Killer Punch");
		comboList.add("Bone Breaking Death Blossom");
		comboList.add("Combo From The Dark Side");
		comboList.add("Dream Destroying Dolphin Killer");
		comboList.add("EndIsClose Combination");
		comboList.add("Face Melting Hyper Punch");
		comboList.add("Ground Breaking Ultra Strike");
		comboList.add("Hell Destroying Super Attack");
		comboList.add("Insane Follow Up spree");
		comboList.add("Jet Lag Infusing Super Combo");
		comboList.add("Kill Machine Carry Mode");
		comboList.add("Leg Breaking Kick infusion");
		comboList.add("Mega Monster Awesome Combo");
		comboList.add("Never ending Asian Combo Deluxe");
		comboList.add("Oral Sex Giving Combination");
		comboList.add("Power House Spin Kicker");
		comboList.add("Quick Death Bringer Banger");
		comboList.add("Razor Sharp kick Combination");
		comboList.add("Super Mega Death Combo");
		comboList.add("Total Trash Maker");
		comboList.add("Unreal incredible extra sexy Combo");
		comboList.add("Vortex Bringing Sping Kick Flurry");
		comboList.add("Warning For Sick Damage");
		comboList.add("Xtra Mega Super Duper Hyper Damage");
		comboList.add("YouWontSurvive Combo");
		comboList.add("Zebra Slapping Turbo Kicker");
	}
}
