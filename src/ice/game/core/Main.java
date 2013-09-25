package ice.game.core;

import javax.swing.JFrame;

public class Main extends JFrame
{
	// Created 9/18/13 at 10:57
	private static final long serialVersionUID = 91820131057L;
	
	private Engine gameEngine;
	
	public Main()
	{
		this.setSize(800,600);
		this.setTitle("Game");
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void startEngine()
	{
		setVisible(true);
		gameEngine = new Engine(this);
		this.add(gameEngine);
		gameEngine.init();
		
	}
	
	public static void main(String[] args)
	{
		Main gameWindow = new Main();
		gameWindow.startEngine();

	}

}
