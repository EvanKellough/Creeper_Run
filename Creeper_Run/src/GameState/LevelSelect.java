package GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

//import Audio.JukeBox;
import Main.GamePanel;
import Entity.PlayerSave;
import Handlers.Keys;
import TileMap.Background;


public class LevelSelect extends GameState {
	
	private BufferedImage head;
	private BufferedImage minecraft;
	
	private int currentChoice = 0;
	private String[] options = {
		"Side Scroller",
		"Top Down",
		"Quit"
		/*"Boss Battle",
		"Level 3",
		"Level 4",
		"Level 5",
		"Level 6",
		"Level 7",
		"Level 8",
		"Level 9",
		"Quit"
		*/
	};
	
	private Color titleColor;
	private Font titleFont;
	private Color controlColor;
	private Font controlFont;
	
	private Font font;
	private Font font2;
	private Font font3;
	
	public LevelSelect(GameStateManager gsm) {
		
		super(gsm);
		
		try {
			// load minecraft Background
			minecraft = ImageIO.read(
				getClass().getResourceAsStream("/Backgrounds/minecraft.png")
				).getSubimage(0, 300, 400, 300);
			
			// load floating head
			head = ImageIO.read(
				getClass().getResourceAsStream("/HUD/Hud.gif")
			).getSubimage(0, 12, 12, 11);
			
			// titles and fonts
			titleColor = Color.WHITE;
			titleFont = new Font("Times New Roman", Font.PLAIN, 28);
			controlColor = Color.WHITE;
			controlFont = new Font("Times New Roman", Font.PLAIN, 18);
			
			font = new Font("Arial", Font.PLAIN, 14);
			font2 = new Font("Arial", Font.PLAIN, 10);
			font3 = new Font("Arial", Font.PLAIN, 12);
			
			// load sound fx
			//JukeBox.load("/SFX/menuoption.mp3", "menuoption");
			//JukeBox.load("/SFX/menuselect.mp3", "menuselect");

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void init() {}
	
	public void update() {
		
		// check keys
		handleInput();
		
	}
	
	public void draw(Graphics2D g) {
		
		// draw bg
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		
		// draw title
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawImage(minecraft, 0, 0, null);
		g.drawString("Tests", 130, 20); //Title
		
		// draw menu options
		g.setFont(font);
		g.setColor(Color.WHITE);
		g.drawString("Side Scroller", 145, 115);
		g.drawString("Top Down", 145, 135);
		g.drawString("Quit", 145, 155);
		/*
		g.drawString("The Beginning", 145, 35);
		g.drawString("Nether", 145, 55);
		g.drawString("Human House", 145, 75);
		g.drawString("Level 4 (Coming Soon)", 145,95);
		g.drawString("Level 5 (Coming Soon)", 145, 115);
		g.drawString("Level 6 (Coming Soon)", 145, 135);
		g.drawString("Level 7 (Coming Soon)", 145, 155);
		g.drawString("Level 8 (Coming Soon)", 145, 175);
		g.drawString("Level 9 (Coming Soon)", 145, 195);
		g.drawString("Level 10 (Coming Soon)", 145, 215);
		g.drawString("Quit", 145, 235);
*/
		// draw floating head
		if(currentChoice == 0) g.drawImage(head, 125, 104, null);
		else if(currentChoice == 1) g.drawImage(head, 125, 124, null);
		else if(currentChoice == 2) g.drawImage(head, 125, 144, null);
		/*
		if(currentChoice == 0) g.drawImage(head, 125, 24, null);
		else if(currentChoice == 1) g.drawImage(head, 125, 44, null);
		else if(currentChoice == 2) g.drawImage(head, 125, 64, null);
		else if(currentChoice == 3) g.drawImage(head, 125, 84, null);
		else if(currentChoice == 4) g.drawImage(head, 125, 104, null);
		else if(currentChoice == 5) g.drawImage(head, 125, 124, null);
		else if(currentChoice == 6) g.drawImage(head, 125, 144, null);
		else if(currentChoice == 7) g.drawImage(head, 125, 164, null);
		else if(currentChoice == 8) g.drawImage(head, 125, 184, null);
		else if(currentChoice == 9) g.drawImage(head, 125, 204, null);
		else if(currentChoice == 10) g.drawImage(head, 125, 224, null);
		else if(currentChoice == 11) g.drawImage(head, 125, 244, null);
		//else if(currentChoice == 12) g.drawImage(head, 125, 264, null);
		 */
	}
	
	private void select() {
		if(currentChoice == 0) {
			//JukeBox.play("menuselect");
			PlayerSave.init();
			gsm.setState(GameStateManager.CAVESTATE);
		}
		else if(currentChoice == 1){
			//JukeBox.play("menuselect");
			PlayerSave.init();
			gsm.setState(GameStateManager.NETHERSTATE);
		}
		else if(currentChoice == 2) {
			System.exit(0);
		}
		/*
		if(currentChoice == 0) {
			//JukeBox.play("menuselect");
			PlayerSave.init();
			gsm.setState(GameStateManager.GRASSSTATE);
		}
		else if(currentChoice == 1) {
			gsm.setState(GameStateManager.NETHERSTATE);
		}
		else if(currentChoice == 2) {
			gsm.setState(GameStateManager.CAVESTATE);
		}
		else if(currentChoice == 3) {
			gsm.setState(GameStateManager.ACIDSTATE);
		}
		else if(currentChoice == 4) {
			gsm.setState(GameStateManager.ACIDSTATE);
		}		
		else if(currentChoice == 5) {
			gsm.setState(GameStateManager.ACIDSTATE);
		}		
		else if(currentChoice == 6) {
			gsm.setState(GameStateManager.ACIDSTATE);
		}
		else if(currentChoice == 7) {
			gsm.setState(GameStateManager.ACIDSTATE);
		}
		else if(currentChoice == 8) {
			gsm.setState(GameStateManager.ACIDSTATE);
		}
		else if(currentChoice == 9) {
			gsm.setState(GameStateManager.ACIDSTATE);
		}
		else if(currentChoice == 10) {
			System.exit(0);
			}
			*/
	}
	
	public void handleInput() {
		if(Keys.isPressed(Keys.ENTER)) select();
		if(Keys.isPressed(Keys.UP)) {
			if(currentChoice > 0) {
				//JukeBox.play("menuoption", 0);
				currentChoice--;
			}
		}
		if(Keys.isPressed(Keys.DOWN)) {
			if(currentChoice < options.length - 1) {
				//JukeBox.play("menuoption", 0);
				currentChoice++;
			}
		}
	}
	
}











