package typeFighter.Fighters;

import org.newdawn.slick.Animation;
import org.newdawn.slick.openal.Audio;

import typeFighter.start.AnimationHandler;
import typeFighter.start.InputReader;
import typeFighter.start.Move;

public class Player {
	
	private Audio soundEffect;
	
	//TODO: import sound effects
	
	protected InputReader input;
	
	protected AnimationHandler handler;
	protected Animation playerAnimation;
	protected Animation hitAnimation;
	
	protected float x;
	protected float y;
	
	protected boolean powerAttack = false;
	protected boolean attacking = false;
	protected boolean attacked = false;
	protected boolean horizontal;
	
	protected int ID;
	protected int health = 10;
	protected int comboCounter = 0;
	
	protected Move move;
	
	public Player(float x, float y, AnimationHandler animationHandler, boolean horizontal, boolean vertical, int playerID){
		hitAnimation = AnimationHandler.getHitExplosion();
		
		handler = animationHandler;
		input = new InputReader();
		move = Move.IDLE;
		
		this.horizontal = horizontal;
		
		ID = playerID;
		this.x = x;
		this.y = y;
	}
	
	public void input(Player player){
		
	}
	
	public void update(Player player, int delta){
		
	}
	
	public void render(int delta){
		
	}

	public Move getMove() {
		return move;
	}

	public void setMove(Move move) {
		this.move = move;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	public void reduceHealth(int health){
		this.health -= health;
	}

	public int getComboCounter() {
		return comboCounter;
	}

	public void setComboCounter(int comboCounter) {
		this.comboCounter = comboCounter;
	}
	
	public void reduceComboCounter(int comboCounter){
		this.comboCounter -= comboCounter;
	}
	
	public void increaseComboCounter(int comboCounter){
		this.comboCounter += comboCounter;
	}

	public Animation getPlayerAnimation() {
		return playerAnimation;
	}

	public void setPlayerAnimation(Animation playerAnimation) {
		this.playerAnimation = playerAnimation;
	}

	public boolean isPowerAttack() {
		return powerAttack;
	}

	public void setPowerAttack(boolean powerAttack) {
		this.powerAttack = powerAttack;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
}
