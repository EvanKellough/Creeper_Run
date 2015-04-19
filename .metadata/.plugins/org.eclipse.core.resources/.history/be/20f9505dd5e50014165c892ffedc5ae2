package GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

//import Audio.JukeBox;
import Entity.PlayerSave;
import Handlers.Keys;
import Main.GamePanel;

public class PauseState extends GameState {
	
	private BufferedImage minecraft;
	private BufferedImage head;
	private Color titleColor;
	private Font titleFont;
	private Color controlColor;
	private Font controlFont;
	private int currentChoice = 0;
	private String[] options = {
		"Level 1",
		"Level 2",
		"Boss Battle",
		"Level 3",
		"Level 4",
		"Level 5",
		"Level 6",
		"Quit"
	};
	private Font font;
	private Font font2;
	private Font font3;
	
	public PauseState(GameStateManager gsm) {
		
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
			Color titleColor = Color.WHITE;
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
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		
		// draw title
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawImage(minecraft, 0, 0, null);
		g.drawString("C R E E P E R   R U N", 30, 40); //Title
		
		// draw menu options
		g.setFont(font3);
		g.setColor(Color.WHITE);
		g.drawString("Main Menu", 145, 75);
		
		//Information
		g.drawString("Tip: There's a hidden easter egg on every level!", 5, 164); //Title
		g.drawString("Hit: M to mute the soundtrack if you don't like c418", 5, 181); //Title
		g.drawString("Based on the popular game Minecraft (Don't sue please)", 5, 198); //Title
		g.drawString("Move: WASD/ Explode:Space / Bite:R / Hit Enter To Start", 5, 215); //Title
		g.drawString("Created by Evan Kellough", 5, 232);

		// draw floating head
		if(currentChoice == 0) g.drawImage(head, 125, 64, null);

	}
	
	public void handleInput() {
		if(Keys.isPressed(Keys.ESCAPE)) gsm.setPaused(false);
		if(Keys.isPressed(Keys.ENTER)) {
			gsm.setPaused(false);
			gsm.setState(GameStateManager.MENUSTATE);
			/*
			JukeBox.stop("level1");
			JukeBox.stop("level2");
			JukeBox.stop("level3");
			JukeBox.stop("level4");
			JukeBox.stop("level5");
			JukeBox.stop("level6");
			JukeBox.stop("level7");
			JukeBox.stop("level8");
			JukeBox.stop("level9");
			JukeBox.stop("level10");
			JukeBox.stop("fanfare");
			JukeBox.stop("credits");
			*/
		}
	}
}
