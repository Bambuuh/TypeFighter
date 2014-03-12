package typeFighter.Fighters;

import org.lwjgl.input.Keyboard;

import typeFighter.combos.PrisonFighterCombos;
import typeFighter.start.AnimationHandler;
import typeFighter.start.Move;

public class PrisonFighter extends Player {

	private PrisonFighterCombos combos;
	
	public PrisonFighter(float x, float y, AnimationHandler animationHandler,
			boolean horizontal, boolean vertical, int playerID) {
		super(x, y, animationHandler, horizontal, vertical, playerID);
		
		playerAnimation = handler.getPrisonFighter(0, 0, 945, 105, 105, 105, horizontal, false);
		
		combos = new PrisonFighterCombos();
	}

	@Override
	public void input() {
		if (!attacking && Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
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
	}

	@Override
	public void render(int delta) {
		playerAnimation.draw(x, y);
		playerAnimation.update(delta);
	}
	
}
