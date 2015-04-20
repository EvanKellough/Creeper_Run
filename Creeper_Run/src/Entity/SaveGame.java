package Entity;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class SaveGame {
	
	public static void main (String[]args){
		String filename = "SaveGame.txt";
				try{
					PrintWriter outputStream = new PrintWriter(filename);
					outputStream.println("Player Information"); //stores file in RAM
					outputStream.close(); //flushes data from RAM to file
					System.out.println("Player Game Saved");
				}catch (FileNotFoundException e){
					e.printStackTrace();
				}
		
	}
}
