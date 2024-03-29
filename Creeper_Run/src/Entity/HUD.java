package Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class HUD {
	
	private Player player;
	
	private BufferedImage heart;
	private BufferedImage life;
	private BufferedImage items;
	private BufferedImage hudbar;
	
	public HUD(Player p) {
		player = p;
		try {
			BufferedImage health = ImageIO.read(
				getClass().getResourceAsStream(
					"/HUD/Hud.gif"
				)
			);
			heart = health.getSubimage(0, 0, 13, 12);
			life = health.getSubimage(0, 12, 12, 11);
			
			/*
			items = ImageIO.read(
					getClass().getResourceAsStream("/HUD/items.gif")
					)/*.getSubimage(0, 300, 400, 300)*/;
			hudbar = ImageIO.read(
					getClass().getResourceAsStream("/HUD/HUD_bar.gif")
					)/*.getSubimage(0, 300, 400, 300)*/;
			
				
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g) {
		//g.drawImage(items, 300-(252 / 2), 290, null);
		//g.drawImage(hudbar, 0, 0, null);
		for(int i = 0; i < player.getHealth(); i++) {
			g.drawImage(heart, 10 + i * 15, 10, null);
		}
		for(int i = 0; i < player.getLives(); i++) {
			g.drawImage(life, 10 + i * 15, 25, null);
		}
		g.setColor(java.awt.Color.WHITE);
		g.drawString(player.getTimeToString(), 280, 30);
	}
	
}













