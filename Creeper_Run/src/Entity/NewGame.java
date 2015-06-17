package Entity;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import Entity.NewPlayerSaveInfo;

public class NewGame {
	
	public static void init(){
		int lives = NewPlayerSaveInfo.getLives();
		int health = NewPlayerSaveInfo.getHealth();
		long time = NewPlayerSaveInfo.getTime();
		
		String filename = "SaveGame.txt";
				try{
					PrintWriter outputStream = new PrintWriter(filename);
					outputStream.println(lives); //stores player info in RAM
					outputStream.println(health);
					outputStream.println(time);
					outputStream.close(); //flushes data from RAM to save file
					System.out.println("New Save File Created"); //prints to console
				}catch (FileNotFoundException e){
					e.printStackTrace();
		}
	}
}
