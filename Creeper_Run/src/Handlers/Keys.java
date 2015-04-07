package Handlers;

import java.awt.event.KeyEvent;

// this class contains a boolean array of current and previous key states
// for the 11keys that are used for this game.
// a key k is down when keyState[k] is true.

public class Keys {
	
	public static final int NUM_KEYS = 16;
	
	public static boolean keyState[] = new boolean[NUM_KEYS];
	public static boolean prevKeyState[] = new boolean[NUM_KEYS];
	
	public static int UP = 0; //menu up
	public static int WEST = 1; //left
	public static int DOWN = 2; //menu down
	public static int EAST = 3; //right
	public static int NORTH = 4; //up
	public static int BUTTON2 = 5; //inventory
	public static int BUTTON3 = 6; //short range attack
	public static int BUTTON4 = 7; //charge attack
	public static int ENTER = 8; //select
	public static int ESCAPE = 9; //pause
	public static int MUTE = 10; //mute soundtrack
	public static int SOUTH = 11; //down
	
	public static void keySet(int i, boolean b) {
		if(i == KeyEvent.VK_UP) keyState[UP] = b; //MENU UP
		else if(i == KeyEvent.VK_A) keyState[WEST] = b; //LEFT
		else if(i == KeyEvent.VK_W) keyState[NORTH] = b; //UP
		else if(i == KeyEvent.VK_D) keyState[EAST] = b; //RIGHT
		else if(i == KeyEvent.VK_S) keyState[SOUTH] = b; //DOWN
		else if(i == KeyEvent.VK_DOWN) keyState[DOWN] = b; //MENU DOWN
		else if(i == KeyEvent.VK_E) keyState[BUTTON2] = b; //FUTURE inventory
		else if(i == KeyEvent.VK_R) keyState[BUTTON3] = b; //SHORT RANGE ATTACK
		else if(i == KeyEvent.VK_SPACE) keyState[BUTTON4] = b; //CHARGE ATTACK
		else if(i == KeyEvent.VK_ENTER) keyState[ENTER] = b; //SELECT
		else if(i == KeyEvent.VK_ESCAPE) keyState[ESCAPE] = b; //PAUSE
		else if(i == KeyEvent.VK_M) keyState[MUTE] = b; //MUTE SOUNDTRACK
	}
	
	public static void update() {
		for(int i = 0; i < NUM_KEYS; i++) {
			prevKeyState[i] = keyState[i];
		}
	}
	
	public static boolean isPressed(int i) {
		return keyState[i] && !prevKeyState[i];
	}
	
	public static boolean anyKeyPress() {
		for(int i = 0; i < NUM_KEYS; i++) {
			if(keyState[i]) return true;
		}
		return false;
	}
	
}
