package typeFighter.combos;

import java.util.ArrayList;

public class ComboList {

	protected ArrayList<String> comboList;
	
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
