package typeFighter.start;

import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glViewport;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;

import typeFighter.Fighters.PrisonFighter;
import typeFighter.start.DrawString.Alignment;


public class Game {

	public static final int WIDTH = 1280;
	public static final int HEIGHT = 480;
	
	private long lastFrame;
	
	private AnimationHandler animation;
	
	private PrisonFighter fighter1;
	private PrisonFighter fighter2;
	
	public Game(){
		initGL();
		animation = new AnimationHandler();
		
		fighter1 = new PrisonFighter(550, 350, animation, false, false, 1);
		fighter2 = new PrisonFighter(630, 350, animation, true, false, 2);
		
		start();
	}
	
	public void initGL(){
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.setVSyncEnabled(true);
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}


		glViewport(0, 0, WIDTH, HEIGHT);
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();

		glEnable(GL_TEXTURE_2D);
		glClearColor(0.0f, 0.0f, 0.0f, 0.0f);

		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

		glOrtho(0, WIDTH, HEIGHT, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
	}
	
	public void start(){
		while(!Display.isCloseRequested()){
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			
			int delta = getDelta();
			readInput();
			update(delta);
			render(delta);
			
			Display.update();
			Display.sync(60);
		}
	}
	
	public void readInput(){
		fighter1.input(fighter2);
	}
	
	public void update(int delta){
		fighter1.update(fighter2, delta);
		fighter2.update(fighter1, delta);
//		checkForPowerAttack(delta);
		
	}
	
	public void render(int delta){
		animation.getBarFight().draw();
		animation.getHealthBarBorder().draw(0, 10);
		displayHealth();
		fighter2.render(delta);
		fighter1.render(delta);
	}
	
	private void displayHealth(){
		for (int i = 0; i < fighter1.getHealth(); i++) {
			animation.getHealth().draw(109+(48*i), 26);
		}
		for (int i = 0; i < fighter2.getHealth(); i++) {
			animation.getHealth().draw(696+(48*i), 26);
		}
	}
	
	public void checkForPowerAttack(int delta){
		if (fighter1.isPowerAttack()) {
			fighter1.setPlayerAnimation(animation.getPowerPunch());
			fighter2.setPlayerAnimation(animation.getFallAnimation());
			while (fighter1.getPlayerAnimation().getFrame()<=5 && !fighter2.getPlayerAnimation().isStopped()){
				GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
				delta = getDelta();
				animation.getBarFight().draw();
				animation.getHealthBarBorder().draw(0, 10);
				displayHealth();
				if (fighter1.getPlayerAnimation().getFrame() == 5 || fighter1.getPlayerAnimation().isStopped()) {
					fighter2.getPlayerAnimation().draw(fighter2.getX(), fighter2.getY()-35);
					fighter2.getPlayerAnimation().update(delta);
				}
				fighter1.getPlayerAnimation().draw(fighter1.getX(), fighter1.getY()-9);
				fighter1.getPlayerAnimation().update(delta);
				
				Display.update();
				Display.sync(60);
				
			}
			fighter1.setPowerAttack(false);
		}
	}
	
	public int getDelta() {
		long time = getTime();
		int delta = (int) (time - lastFrame);
		lastFrame = time;

		return delta;
	}

	public long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}
	
}
