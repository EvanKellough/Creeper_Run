package Entity;

/*
 * This class just stores the Player's data when a new game is created
 */


public class NewPlayerSaveInfo {
	
	public static int lives = 3;
	public static int health = 5;
	public static long time = 0;
	
	public static void init() {
		lives = 3;
		health = 5;
		time = 0;
		
		NewGame.init();
	}
	
	public static int getLives() { return lives; }
	public static void setLives(int i) { lives = i; }
	
	public static int getHealth() { return health; }
	public static void setHealth(int i) { health = i; }
	
	public static long getTime() { return time; }
	public static void setTime(long t) { time = t; }
	
}
