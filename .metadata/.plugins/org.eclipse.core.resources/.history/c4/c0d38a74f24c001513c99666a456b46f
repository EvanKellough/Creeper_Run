package GameState;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

//import Audio.JukeBox;
import Handlers.Keys;
import Main.GamePanel;

public class AcidState extends GameState {
	
	private float hue;
	private Color color;
	
	private double angle;
	private BufferedImage player;
	private BufferedImage credits;
	
	public AcidState(GameStateManager gsm) {
		super(gsm);
		//music
		//JukeBox.load("/Music/fanfare.mp3", "fanfare");
		//JukeBox.loop("fanfare", 600, JukeBox.getFrames("fanfare") - 2200);
		
		try {
			player = ImageIO.read(
			getClass().getResourceAsStream(
			"/Sprites/Player/PlayerSprites.gif"
			)).getSubimage(0, 0, 150, 40);
			credits = ImageIO.read(
			getClass().getResourceAsStream(
			"/Resources/HUD/Endingcredits.gif"
			)).getSubimage(0, 0, 40, 40);
		}
		catch(Exception e) {}
	}
	
	public void init() {
		
	}
	
	public void update() {
		handleInput();
		color = Color.getHSBColor(hue, 1f, 1f);
		hue += 0.01;
		if(hue > 1) hue = 0;
		angle += 0.1;
	}
	
	public void draw(Graphics2D g) {
		g.setColor(color);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		AffineTransform at = new AffineTransform();
		at.translate(GamePanel.WIDTH / 2, GamePanel.HEIGHT / 2);
		at.rotate(angle);
		g.drawImage(player, at, null);
		g.drawImage(credits, at, null);
	}
	
	public void handleInput() {
		if(Keys.isPressed(Keys.ESCAPE)){ gsm.setState(GameStateManager.MENUSTATE);
		//JukeBox.stop("fanfare");
		//if(Keys.isPressed(Keys.MUTE)) JukeBox.stop("fanfare");
	}
	}

}
