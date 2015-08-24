/**
 * This is the main class of the Fallout Fan Game Vault 6
 * @author Evan Kellough
 */


package com.zaino.vault6;

import java.awt.*;
import javax.swing.*;

import com.zaino.vault6.*; //imports all game files

public class Game {
	
	public static void main(String[] args){
		boolean lt, rt = false;
		JPanel scene = new JPanel ();
		JButton leftbutton = new JButton ();
		JButton rightbutton = new JButton ();
		
		String scenetext; //describes the situation
		String choicea; //Your left choice
		String choiceb; //Your right choice
		
		int a = 600; //window width
		int b = 600; //window height
		
		//The below section is just for centering the window
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth(); //get screen width
		double height = screenSize.getHeight();//get screen height
		int x = (int) (width); //width of screen converted to int
		int y = (int) (height); //height of screen converted to int
		int xb = (x / 2) - (a / 2); //offset by window size
		int yb = (y / 2) - (b / 2); //offset by window size
		
		JFrame frame;
		frame = new JFrame("Vault 6");
		frame.setVisible( true );
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(1);
		frame.setLocation(xb, yb);
		
		//bounds
		scene.setBounds(0, 0, a, b/2);
		leftbutton.setBounds(0, 300, a/2, b/2);
		rightbutton.setBounds(0, 300, a/2, b/2);
		
		//Eventually I want to add textures to the buttons
		/*scene.setBackground(bg);
		leftbutton.setBackground(bg);
		rightbutton.setBackground(bg);*/
		
	}
	
	
}
