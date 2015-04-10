package Main;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import Entity.Title;
import Handlers.Content;

public class Game {
	
	private static BufferedImage icon;
	
	public static void main(String[] args){
		
		JFrame window = new JFrame("Creeper Run");
		window.setIconImage(Toolkit.getDefaultToolkit().getImage("/Sprites/Player/Icon.gif"));
		window.add(new GamePanel());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
	
}
