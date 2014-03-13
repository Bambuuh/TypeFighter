package typeFighter.start;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class AnimationHandler {

	private Image barFight;
	private Image prisonFighter;
	
	public AnimationHandler(){
		try {
			barFight = new Image("res/fightClubBar.png");
			prisonFighter = new Image("res/prisonFighterSheet.png");
		} catch (SlickException e) {
			System.err.println("Could not load image. " + e.getMessage());
		}
	}
	
	public Image getBarFight(){
		return barFight;
	}
	
	public Animation getPrisonFighter(int startX, int startY, int animationLength, int animationHeight, int tileWidth, int tileHeight, boolean horizontal, boolean vertical){
		Animation prisonAnimation;
		SpriteSheet prisonFighterSheet;
		
		prisonFighterSheet = new SpriteSheet(prisonFighter.getSubImage(startX, startY, animationLength, animationHeight).getFlippedCopy(horizontal, vertical), tileWidth, tileHeight);
		prisonAnimation = new Animation(prisonFighterSheet, 200);
		
		return prisonAnimation;
	}
	
	public Animation getHighKick(boolean horizontal){
		Animation prisonAnimation;
		SpriteSheet prisonFighterSheet;
		
		prisonFighterSheet = new SpriteSheet(prisonFighter.getSubImage(0, 210, 130, 109).getFlippedCopy(horizontal, false), 130, 109);
		prisonAnimation = new Animation(prisonFighterSheet, 200);
		
		return prisonAnimation;
	}
	
	public Animation getMidKick(boolean horizontal){
		Animation prisonAnimation;
		SpriteSheet prisonFighterSheet;
		
		prisonFighterSheet = new SpriteSheet(prisonFighter.getSubImage(130, 210, 130, 109).getFlippedCopy(horizontal, false), 130, 109);
		prisonAnimation = new Animation(prisonFighterSheet, 200);
		
		return prisonAnimation;
	}
	
	public Animation getHighBlock(boolean horizontal){
		Animation prisonAnimation;
		SpriteSheet prisonFighterSheet;
		
		prisonFighterSheet = new SpriteSheet(prisonFighter.getSubImage(0, 420, 105, 105).getFlippedCopy(horizontal, false), 105, 105);
		prisonAnimation = new Animation(prisonFighterSheet, 200);
		
		return prisonAnimation;
	}
	
	public Animation getLowBlock(boolean horizontal){
		Animation prisonAnimation;
		SpriteSheet prisonFighterSheet;
		
		prisonFighterSheet = new SpriteSheet(prisonFighter.getSubImage(105, 420, 105, 105).getFlippedCopy(horizontal, false), 105, 105);
		prisonAnimation = new Animation(prisonFighterSheet, 200);
		
		return prisonAnimation;
	}
	
}
