package typeFighter.Fighters;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Color;

import typeFighter.combos.ComboLetter;
import typeFighter.combos.ComboList;
import typeFighter.combos.PrisonFighterCombos;
import typeFighter.start.AnimationHandler;
import typeFighter.start.DrawString;
import typeFighter.start.Move;
import typeFighter.start.DrawString.Alignment;

public class PrisonFighter extends Player {

	private String yellow = "#FFFF25";
	private String red = "#FF0000";
	
	private Character currentInput;
	
	private PrisonFighterCombos combos;
	
	private ArrayList<ComboLetter> currentCombo;
	
	private DrawString drawer;
	
	private int index = 1;
	
	public PrisonFighter(float x, float y, AnimationHandler animationHandler,
			boolean horizontal, boolean vertical, int playerID) {
		super(x, y, animationHandler, horizontal, vertical, playerID);
		
		playerAnimation = handler.getPrisonFighter(0, 0, 945, 105, 105, 105, horizontal, false);
		
		combos = new PrisonFighterCombos();
		currentCombo = new ArrayList<ComboLetter>();
		
		drawer = new DrawString(11, Alignment.RIGHT);
		
//		generateCombo(combos.getComboList().get(0));
		
	}

	@Override
	public void input() {
		
		checkInput();
		
		if (!attacking && Keyboard.isKeyDown(Keyboard.KEY_A)) {
			move = Move.HIGH;
			playerAnimation = handler.getHighKick(horizontal);
			attacking = true;
		}
		if (!attacking && Keyboard.isKeyDown(Keyboard.KEY_S)) {
			move = Move.HIGH;
			playerAnimation = handler.getHighKick(horizontal);
			attacking = true;
		}
		if (!attacking && move != Move.IDLE) {
			move = Move.IDLE;
			playerAnimation = handler.getPrisonFighter(0, 0, 945, 105, 105, 105, horizontal, false);
		}
		if (!Keyboard.isKeyDown(Keyboard.KEY_SPACE) && attacking) {
			attacking = false;
		}
	}

	@Override
	public void update(Player player) {
		
		if (index == 1 && currentCombo.size() != 0) {
			currentCombo.get(0).setChecked(true);
		}
		
		switch (player.getMove()) {
		case HIGH:
			attacked = true;
			this.playerAnimation = handler.getHighBlock(horizontal);
			break;

		default:
			break;
		}
		if (player.getMove() == Move.IDLE && attacked) {
			attacked = false;
			if (ID == 1) this.playerAnimation = handler.getPrisonFighter(0, 0, 945, 105, 105, 105, false, false);
			if (ID == 2) this.playerAnimation = handler.getPrisonFighter(945, 0, 945, 105, 105, 105, false, false);
		}
		if (currentCombo.size() == 0) {
			currentCombo = combos.startNewCombo(input);
		}
		System.out.println(currentCombo.size());
	}

	@Override
	public void render(int delta) {
		playerAnimation.draw(x, y);
		playerAnimation.update(delta);
		if (ID == 1) {
			int i = 0;
			for (ComboLetter comboLetter : currentCombo) {
				i +=6.5;
				if (comboLetter.isChecked()) {
					drawer.drawString(x+i, y-200, comboLetter.getChar()+"", Color.decode(yellow));
				} else{
					drawer.drawString(x+i, y-200, comboLetter.getChar()+"", Color.decode(red));
				}
			}
		}
	}
	
	public void checkInput(){
			currentInput = input.getInput();
			
			if (index > currentCombo.size()-1) {
				currentCombo.clear();
				index = 1;
			}
			
			if (index <= currentCombo.size()-1) {
				if (Character.toLowerCase(currentInput) == Character.toLowerCase(currentCombo.get(index).getChar())) {
					currentCombo.get(index).setChecked(true);
					index++;
			}
		}
	}
	
	private void generateCombo(String combo){
		currentCombo.clear();
		currentCombo = ComboList.generateCombo(combo);
	}
}
