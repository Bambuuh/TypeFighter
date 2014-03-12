package typeFighter.combos;

public class ComboLetter {

	private char character;
	private boolean checked;
	
	public ComboLetter(char character) {
		
		this.character = character;
		checked = false;
	}
	
	public char getChar(){
		return character;
	}
	
	public boolean isChecked(){
		return checked;
	}
	
	public void setChecked(boolean checked){
		this.checked = checked;
	}
	
}
