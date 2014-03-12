package typeFighter.Fighters;

import java.util.ArrayList;

import org.newdawn.slick.Animation;

import typeFighter.start.AnimationHandler;
import typeFighter.start.Move;

public class Player {
	
	protected AnimationHandler handler;
	protected Animation playerAnimation;
	
	protected float x;
	protected float y;
	
	protected boolean attacking = false;
	protected boolean attacked = false;
	
	protected boolean horizontal;
	
	protected int ID;
	
	protected Move move;
	
	public Player(float x, float y, AnimationHandler animationHandler, boolean horizontal, boolean vertical, int playerID){
		handler = animationHandler;
		
		move = Move.IDLE;
		
		this.horizontal = horizontal;
		
		ID = playerID;
		this.x = x;
		this.y = y;
	}
	
	public void input(){
		
	}
	
	public void update(Player player){
		
	}
	
	public void render(int delta){
		
	}

	public Move getMove() {
		return move;
	}

	public void setMove(Move move) {
		this.move = move;
	}
	
}
