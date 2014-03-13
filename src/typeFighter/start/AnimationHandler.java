package typeFighter.start;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class AnimationHandler {

	private Image barFight;
	private Image prisonFighter;
	private Image healthBarBorder;
	private Image health;
	private Image falling;
	
	private static Image hitExplosion;
	
	public AnimationHandler(){
		try {
			barFight = new Image("res/fightClubBar.png");
			healthBarBorder = new Image("res/healthBarFight.png");
			health = new Image("res/health.png");
			prisonFighter = new Image("res/prisonFighterSheet.png");
			falling = new Image("res/fallSheet.png");
			hitExplosion = new Image("res/hit.png");
		} catch (SlickException e) {
			System.err.println("Could not load image. " + e.getMessage());
		}
	}
	
	public Image getHealth(){
		return health;
	}
	
	public Image getHealthBarBorder(){
		return healthBarBorder;
	}
	
	public Image getBarFight(){
		return barFight;
	}
	
	public Animation getPrisonFighter(int startX, int startY, int animationLength, int animationHeight, int tileWidth, int tileHeight, boolean horizontal, boolean vertical){
		Animation prisonAnimation;
		SpriteSheet prisonFighterSheet;
		
		prisonFighterSheet = new SpriteSheet(prisonFighter.getSubImage(startX, startY, animationLength, animationHeight).getFlippedCopy(horizontal, vertical), tileWidth, tileHeight);
		prisonAnimation = new Animation(prisonFighterSheet, 150);
		
		return prisonAnimation;
	}
	
	public Animation getHighKick(boolean horizontal){
		Animation prisonAnimation;
		SpriteSheet prisonFighterSheet;
		
		prisonFighterSheet = new SpriteSheet(prisonFighter.getSubImage(0, 220, 520, 110).getFlippedCopy(horizontal, false), 130, 110);
		prisonAnimation = new Animation(prisonFighterSheet, 50);
		
		prisonAnimation.setLooping(false);
		
		return prisonAnimation;
	}
	
	public Animation getMidKick(boolean horizontal){
		Animation prisonAnimation;
		SpriteSheet prisonFighterSheet;
		
		prisonFighterSheet = new SpriteSheet(prisonFighter.getSubImage(0, 330, 548, 110).getFlippedCopy(horizontal, false), 137, 110);
		prisonAnimation = new Animation(prisonFighterSheet, 50);
		
		prisonAnimation.setLooping(false);
		
		return prisonAnimation;
	}
	
	public Animation getLowKick(boolean horizontal){
		Animation prisonAnimation;
		SpriteSheet prisonFighterSheet;
		
		prisonFighterSheet = new SpriteSheet(prisonFighter.getSubImage(0, 440, 408, 110).getFlippedCopy(horizontal, false), 136, 110);
		prisonAnimation = new Animation(prisonFighterSheet, 50);
		
		prisonAnimation.setLooping(false);
		
		return prisonAnimation;
	}
	
	public Animation getHighBlock(boolean horizontal){
		Animation prisonAnimation;
		SpriteSheet prisonFighterSheet;
		
		prisonFighterSheet = new SpriteSheet(prisonFighter.getSubImage(0, 550, 110, 110).getFlippedCopy(horizontal, false), 110, 110);
		prisonAnimation = new Animation(prisonFighterSheet, 200);
		
		return prisonAnimation;
	}
	
	public Animation getLowBlock(boolean horizontal){
		Animation prisonAnimation;
		SpriteSheet prisonFighterSheet;
		
		prisonFighterSheet = new SpriteSheet(prisonFighter.getSubImage(110, 550, 110, 110).getFlippedCopy(horizontal, false), 110, 110);
		prisonAnimation = new Animation(prisonFighterSheet, 200);
		
		return prisonAnimation;
	}
	
	public static Animation getHitExplosion(){
		Animation animation;
		SpriteSheet spriteSheet;
		
		spriteSheet = new SpriteSheet(hitExplosion.getSubImage(0, 0, 480, 38), 32, 38);
		animation = new Animation(spriteSheet, 20);
		
		animation.setLooping(false);
		
		return animation;
	}
	
	public Animation getPowerPunch(){
		Animation prisonAnimation;
		SpriteSheet prisonFighterSheet;
		
		prisonFighterSheet = new SpriteSheet(prisonFighter.getSubImage(0, 761, 684, 119).getFlippedCopy(false, false), 114, 119);
		prisonAnimation = new Animation(prisonFighterSheet, 300);
		
		prisonAnimation.setLooping(false);
		
		return prisonAnimation;
	}
	
	public Animation getFallAnimation(){
		Animation prisonAnimation;
		SpriteSheet prisonFighterSheet;
		
		prisonFighterSheet = new SpriteSheet(falling.getSubImage(0, 0, 2465, 145).getFlippedCopy(false, false), 145, 145);
		prisonAnimation = new Animation(prisonFighterSheet, 300);
		
		prisonAnimation.setLooping(false);
		
		return prisonAnimation;
	}
	
}
