package typeFighter.combos;

import java.util.ArrayList;

import typeFighter.start.InputReader;

public class ComboList {

	protected ArrayList<String> comboList;
	public ArrayList<Character> comboStarter;
	
	
	public ComboList() {
		comboList = new ArrayList<>();
		comboStarter = new ArrayList<>();
		comboStarter.add('a');
		comboStarter.add('b');
		comboStarter.add('c');
		comboStarter.add('d');
		comboStarter.add('e');
		comboStarter.add('f');
		comboStarter.add('g');
		comboStarter.add('h');
		comboStarter.add('i');
		comboStarter.add('j');
		comboStarter.add('k');
		comboStarter.add('l');
		comboStarter.add('m');
		comboStarter.add('n');
		comboStarter.add('o');
		comboStarter.add('p');
		comboStarter.add('q');
		comboStarter.add('r');
		comboStarter.add('s');
		comboStarter.add('t');
		comboStarter.add('u');
		comboStarter.add('v');
		comboStarter.add('w');
		comboStarter.add('x');
		comboStarter.add('y');
		comboStarter.add('z');
		
	}
	
	public ArrayList<ComboLetter> startNewCombo(InputReader input){
		ArrayList<ComboLetter> newCombo = new ArrayList<>();
		char currentInput = input.getInput();
		for (Character c : comboStarter) {
			if (Character.toLowerCase(currentInput) == Character.toLowerCase(c)) {
				newCombo = generateCombo(comboList.get(comboStarter.indexOf(c)));
			}
		}
		return newCombo;
	}
	
	public ArrayList<Character> getComboStarter(){
		return comboStarter;
	}
	
	public ArrayList<String> getComboList(){
		return comboList;
	}
	
	public static ArrayList<ComboLetter> generateCombo( String combo){
		ArrayList<ComboLetter> comboList = new ArrayList<>();
		 for (int x = 0; x < combo.length(); x ++){
	            comboList.add(new ComboLetter(combo.charAt(x)));
	        }
		 return comboList;
	}
	
}
