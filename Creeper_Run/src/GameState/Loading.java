package GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

//import javax.imageio.ImageI[[andlers.Keys;
import javax.imageio.ImageIO;

//import Audio.JukeBox;
import Entity.NewPlayerSaveInfo;
import Handlers.Keys;
import Main.GamePanel;
import TileMap.Background;


public class Loading extends GameState {
	
	private BufferedImage head;
	private BufferedImage newgame;
	private BufferedImage quit;
	private BufferedImage zaino;
	private BufferedImage logo;
	
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
	private int uix = (width / 2) - 122;  //82
	private int uilogo = (width / 2) - 320;  //114
	private int uiy = height / 2; //newgame button
	private int ui1 = height / 3; //quit button
	private int uixstring = (width / 2) - 30;
	private int uiystring = uiy + 100;
	
	public Loading(GameStateManager gsm) {
		  
		super(gsm);
		
		try {
			// load zaino Background
			zaino = ImageIO.read(
				getClass().getResourceAsStream("/Backgrounds/dirtlow.png")
				)/*.getSubimage(0, 300, 400, 300)*/;
			
			logo = ImageIO.read(
					getClass().getResourceAsStream("/HUD/creeperrun.png"));
			
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
		
		font = new Font("Times Mew Roman", Font.PLAIN, 14);
		
		// draw bg
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		
		//g.setLocationRelativeTo(null);
		
		// draw title
		g.setColor(titleColor);
		g.setFont(font);
		g.drawImage(zaino, 0, 0, null);
		g.drawString("Hit Enter", uixstring, uiystring);
		
		/*
		// draw floating head
		if(currentChoice == 0) g.drawImage(head, 125, 84, null);
		else if(currentChoice == 1) g.drawImage(head, 125, 104, null);
		*/
		
		g.drawImage(logo, uilogo, ui1, null);
	}
	
	private void select() {
		if(currentChoice == 0) {
			//JukeBox.play("menuselect");
			gsm.setState(GameStateManager.MENUSTATE);
		}
		else if(currentChoice == 1) {
			System.exit(0);
		}
	}
	
	public void handleInput() {
		if(Keys.isPressed(Keys.ENTER)) select();
		}
}