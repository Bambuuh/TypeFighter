package typeFighter.Fighters;

import java.util.ArrayList;
import java.util.Random;

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
	private String artLink = "http://southtownexpress.deviantart.com/";
	
	private Character currentInput;
	
	private PrisonFighterCombos combos;
	
	private ArrayList<ComboLetter> currentCombo;
	
	private DrawString drawer;
	
	private Random rand;
	
	private int index = 1;
	private int moveDecider = 0;
	private long lastCheck;
	private long currentTime;
	
	public PrisonFighter(float x, float y, AnimationHandler animationHandler,
			boolean horizontal, boolean vertical, int playerID) {
		super(x, y, animationHandler, horizontal, vertical, playerID);
		
		rand = new Random();
		
		playerAnimation = handler.getPrisonFighter(0, 0, 945, 105, 105, 105, horizontal, false);
		
		combos = new PrisonFighterCombos();
		currentCombo = new ArrayList<ComboLetter>();
		
		drawer = new DrawString(20, Alignment.RIGHT);
		
		
	}

	@Override
	public void input() {
		currentTime = System.currentTimeMillis();
		checkInput();
		chooseAttack();
		
		if (!attacking && move != Move.IDLE && currentTime - lastCheck >= 500) {
			move = Move.IDLE;
			playerAnimation = handler.getPrisonFighter(0, 0, 945, 105, 105, 105, horizontal, false);
		}
		if (moveDecider == index && attacking) {
			attacking = false;
		}
	}

	@Override
	public void update(Player player) {
		
		if (index > currentCombo.size()-1) {
			currentCombo.clear();
			index = 1;
			moveDecider = 1;
		}
		
		if (index == 1 && currentCombo.size() != 0) {
			currentCombo.get(0).setChecked(true);
		}
		
		setGuard(player);
		
		if (currentCombo.size() == 0) {
			currentCombo = combos.startNewCombo(input);
		}
	}

	@Override
	public void render(int delta) {
		playerAnimation.draw(x, y);
		playerAnimation.update(delta);
		if (ID == 1) {
			int i = 0;
			for (ComboLetter comboLetter : currentCombo) {
				i += 12;
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
			
			if (index <= currentCombo.size()-1) {
				if (Character.toLowerCase(currentInput) == Character.toLowerCase(currentCombo.get(index).getChar())) {
					currentCombo.get(index).setChecked(true);
					index++;
			}
		}
	}
	
	public void chooseAttack(){
		int random = rand.nextInt(100);
		if (!attacking && moveDecider < index) {
			lastCheck = System.currentTimeMillis();
			
			if (random >=0 && random <= 33){
				move = Move.HIGH;
				playerAnimation = handler.getHighKick(horizontal);
			}
			if (random >=34 && random <= 66){
				move = Move.MIDDLE;
				playerAnimation = handler.getMidKick(horizontal);
			}
			if (random >=67 && random <= 100){
				move = Move.LOW;
			}
			
			attacking = true;
			moveDecider++;
			random = -1;
		}
	}
	
	private void setGuard(Player player){
		switch (player.getMove()) {
		case HIGH:
			attacked = true;
			this.playerAnimation = handler.getHighBlock(horizontal);
			break;
			
		case MIDDLE:
			attacked = true;
			this.playerAnimation = handler.getHighBlock(horizontal);
			break;
			
		case LOW:
			attacked = true;
			this.playerAnimation = handler.getLowBlock(horizontal);
			break;

		default:
			break;
		}
		if (player.getMove() == Move.IDLE && attacked) {
			attacked = false;
			if (ID == 1) this.playerAnimation = handler.getPrisonFighter(0, 0, 945, 105, 105, 105, false, false);
			if (ID == 2) this.playerAnimation = handler.getPrisonFighter(945, 0, 945, 105, 105, 105, false, false);
		}
	}
	
	private void generateCombo(String combo){
		currentCombo.clear();
		currentCombo = ComboList.generateCombo(combo);
	}
}
