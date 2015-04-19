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
	private BufferedImage newgame;
	private BufferedImage quit;
	private BufferedImage zaino;
	private BufferedImage logo;
	private BufferedImage select;
	
	private int currentChoice = 0;
	private String[] options = {
		"Start",
		"Quit"
	};
	
	private Color titleColor;
	private Font titleFont;
	
	private Font font;
	private Font font2;
	private Font font3;
	
	private int width = GamePanel.WIDTH;
	private int height = GamePanel.HEIGHT;
	private int uix = (width / 2) - 82;
	private int uilogo = (width / 2) - 114;
	private int uiy = height / 2; //newgame button
	private int ui1 = uiy + 60; //quit button
	
	public MenuState(GameStateManager gsm) {
		  
		super(gsm);
		
		try {
			// load zaino Background
			zaino = ImageIO.read(
				getClass().getResourceAsStream("/Backgrounds/background_high.gif")
				)/*.getSubimage(0, 300, 400, 300)*/;
			
			newgame = ImageIO.read(
					getClass().getResourceAsStream("/interface/newgame.gif"));
			
			quit = ImageIO.read(
					getClass().getResourceAsStream("/interface/quit.gif"));
			
			logo = ImageIO.read(
					getClass().getResourceAsStream("/HUD/logo.gif"));
			
			select = ImageIO.read(
					getClass().getResourceAsStream("/interface/optionselect.gif"));
			
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
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		
		//g.setLocationRelativeTo(null);
		
		// draw title
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawImage(zaino, 0, 0, null);
		
		/*
		// draw floating head
		if(currentChoice == 0) g.drawImage(head, 125, 84, null);
		else if(currentChoice == 1) g.drawImage(head, 125, 104, null);
		*/
		
		g.drawImage(logo, uilogo, 10, null);
		g.drawImage(newgame, uix, uiy, null);
		g.drawImage(quit, uix, ui1, null);

		//highlights buttons
		if(currentChoice == 0) g.drawImage(select, uix, uiy, null);
		if(currentChoice == 1) g.drawImage(select, uix, ui1, null);
		
		
		
	}
	
	private void select() {
		if(currentChoice == 0) {
			//JukeBox.play("menuselect");
			PlayerSave.init();
			gsm.setState(GameStateManager.LEVELSELECT);
		}
		else if(currentChoice == 1) {
			System.exit(0);
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