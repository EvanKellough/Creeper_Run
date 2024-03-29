/*
 * This game state handles the creation and loading of games saved to the SaveGame.txt file
 */



package GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;



import Audio.Sound;
import Main.GamePanel;
import Entity.NewGame;
import Entity.NewPlayerSaveInfo;
import Entity.RandomMap;
import Handlers.Keys;
import TileMap.Background;


public class NewGameState extends GameState {
	
	private BufferedImage newgame;
	private BufferedImage loadgame;
	private BufferedImage quit;
	private BufferedImage background;
	private BufferedImage select;
	
	private int currentChoice = 0;
	private String[] options = {
		"Side Scroller",
		"Top Down",
		"Quit"
	};
	
	//centering the UI
	private int width = GamePanel.WIDTH;
	private int height = GamePanel.HEIGHT;
	private int uix = (width / 2) - 82;
	private int uiy = height / 3; //sidescroller button
	private int ui1 = uiy + 60; //topdown button
	private int ui2 = ui1 + 60; //quit button
	
	private Color titleColor;
	private Font titleFont;
	private Color controlColor;
	private Font controlFont;
	
	private Font font;
	private Font font2;
	private Font font3;
	
	public NewGameState(GameStateManager gsm) {
		
		super(gsm);
		
		try {
			// load Background
			background = ImageIO.read(
				getClass().getResourceAsStream("/Backgrounds/background_high.gif")
				)/*.getSubimage(0, 300, 400, 300)*/;
			
			// loading the UI
			newgame = ImageIO.read(
				getClass().getResourceAsStream("/interface/newgame.gif")
			);
			
			loadgame = ImageIO.read(
					getClass().getResourceAsStream("/interface/load.gif")
				);
			
			quit = ImageIO.read(
					getClass().getResourceAsStream("/interface/quit.gif")
				);
			
			select = ImageIO.read(
					getClass().getResourceAsStream("/interface/optionselect.gif")
				);
			

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

		g.drawImage(background, 0, 0, null); //background
		g.drawImage(newgame, uix, uiy, null); //side scroller button
		g.drawImage(loadgame, uix, ui1, null); //topdown button
		g.drawImage(quit, uix, ui2, null); //quit button
		
		//highlights buttons
		if(currentChoice == 0) g.drawImage(select, uix, uiy, null);//new game button
		if(currentChoice == 1) g.drawImage(select, uix, ui1, null); //load game button
		if(currentChoice == 2) g.drawImage(select, uix, ui2, null); //quit button
	}
	
	private void select() {
		if(currentChoice == 0) {
			Sound.menuselect.play();
			NewGame.init();
			//NewGame.init();
			gsm.setState(GameStateManager.NETHERSTATE);
		}
		else if(currentChoice == 1){
			Sound.menuselect.play();
			//LoadGame.init();
			gsm.setState(GameStateManager.NETHERSTATE);
		}
		else if(currentChoice == 2) {
			System.exit(0);
		}
		/*
		if(currentChoice == 0) {
			Sound.menuselect.play();
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
				Sound.menuselect.play();
				currentChoice--;
			}
		}
		if(Keys.isPressed(Keys.DOWN)) {
			if(currentChoice < options.length - 1) {
				Sound.menuselect.play();
				currentChoice++;
			}
		}
	}
	
}