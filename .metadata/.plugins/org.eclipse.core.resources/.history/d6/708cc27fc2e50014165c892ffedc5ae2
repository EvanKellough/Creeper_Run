package GameState;

import GameState.LevelSelect;

import Audio.JukeBox;
import Main.GamePanel;

public class GameStateManager {
	
	private GameState[] gameStates;
	private int currentState;
	
	private PauseState pauseState;
	private boolean paused;
	
	public static final int NUMGAMESTATES = 16;
	public static final int MENUSTATE = 0;
	public static final int LEVELSELECT = 1;
	public static final int GRASSSTATE = 2;
	public static final int NETHERSTATE = 3;
	public static final int CAVESTATE = 4;
	public static final int FORESTSTATE = 5;
	public static final int MOUNTAINSTATE = 6;
	public static final int DESERTSTATE = 7;
	public static final int TUNDRASTATE = 8;
	public static final int MUSHROOMSTATE = 9;
	public static final int STRONGHOLDSTATE = 10;
	public static final int ENDSTATE = 11;
	public static final int ACIDSTATE = 12;
	public static final int LOADSTATE = 13;
	
	public GameStateManager() {
		
		//JukeBox.init();
		
		gameStates = new GameState[NUMGAMESTATES];
		
		pauseState = new PauseState(this);
		paused = false;
		
		currentState = MENUSTATE;
		loadState(currentState);
		
	}
	
	private void loadState(int state) {
		if(state == MENUSTATE)
			gameStates[state] = new MenuState(this);
		else if(state == LEVELSELECT)
			gameStates[state] = new LevelSelect(this);
		else if(state == GRASSSTATE)
			gameStates[state] = new GrassState(this);
		else if(state == NETHERSTATE)
			gameStates[state] = new NetherState(this);
		else if(state == CAVESTATE)
			gameStates[state] = new CaveState(this);
		else if(state == ACIDSTATE)
			gameStates[state] = new AcidState(this);
	}
	
	private void unloadState(int state) {
		gameStates[state] = null;
	}
	
	public void setState(int state) {
		unloadState(currentState);
		currentState = state;
		loadState(currentState);
	}
	
	public void setPaused(boolean b) { paused = b; }
	
	public void update() {
		if(paused) {
			pauseState.update();
			return;
		}
		if(gameStates[currentState] != null) gameStates[currentState].update();
	}
	
	public void draw(java.awt.Graphics2D g) {
		if(paused) {
			pauseState.draw(g);
			return;
		}
		if(gameStates[currentState] != null) gameStates[currentState].draw(g);
		else {
			g.setColor(java.awt.Color.BLACK);
			g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		}
	}
	
}