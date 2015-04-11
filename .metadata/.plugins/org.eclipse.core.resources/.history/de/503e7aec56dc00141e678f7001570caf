package GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

//import javax.imageio.ImageI[[andlers.Keys;
import javax.imageio.ImageIO;

//import Audio.JukeBox;
import Entity.PlayerSave;
import Handlers.Keys;
import Main.GamePanel;
import TileMap.Background;

public class MenuState extends GameState {
	
	private BufferedImage head;
	private BufferedImage minecraft;
	
	private int currentChoice = 0;
	private String[] options = {
		"Start",
		"Open World",
		"Quit"
	};
	
	private Color titleColor;
	private Font titleFont;
	
	private Font font;
	private Font font2;
	private Font font3;
	
	public MenuState(GameStateManager gsm) {
		
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
			font = new Font("Arial", Font.PLAIN, 14);
			font2 = new Font("Arial", Font.PLAIN, 10);
			font3 = new Font("Arial", Font.PLAIN, 12);
			
			// load sound fx
			//JukeBox.load("/SFX/sample1.aif", "menuoption");
			//JukeBox.load("/SFX/sample1.aif", "menuselect");

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
		g.drawString("C R E E P E R   R U N", 30, 60); //Title
		g.setFont(font3);
		g.drawString("The untold story of the humble creeper.. Alpha Version 1.1", 5, 198); //Title
		g.drawString("Move: WASD/ Explode:Space / Bite:R / Hit Enter To Start", 5, 215); //Title
		g.setFont(font3);
		g.drawString("Created by Evan Kellough aka Chief Owl the Quasi God", 5, 232);
		
		// draw menu options
		g.setFont(font);
		g.setColor(Color.WHITE);
		g.drawString("New World", 145, 95);
		g.drawString("Quit", 145, 115);
		//g.drawString("Level Select", 145, 135);
		
		// draw floating head
		if(currentChoice == 0) g.drawImage(head, 125, 84, null);
		else if(currentChoice == 1) g.drawImage(head, 125, 104, null);
		else if(currentChoice == 2) g.drawImage(head, 125, 124, null);
		
	}
	
	private void select() {
		if(currentChoice == 0) {
			//JukeBox.play("menuselect");
			PlayerSave.init();
			gsm.setState(GameStateManager.GRASSSTATE);
		}
		else if(currentChoice == 1) {
			System.exit(0);
		}
		else if(currentChoice == 2) {
			//JukeBox.play("menuselect");
			PlayerSave.init();
			gsm.setState(GameStateManager.LEVELSELECT);
		}
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










