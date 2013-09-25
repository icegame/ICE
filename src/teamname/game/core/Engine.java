package teamname.game.core;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Engine extends JPanel implements Runnable
{
	// Created 9/19/13 at 12:27
	private static final long serialVersionUID = 919131237L;

	private final int FPS = 60;
	
	private boolean running = false;
	private Thread gameThread; 
	
	private Renderer graphics;
	
	private JFrame window;
	
	
	public Engine(JFrame window)
	{
		setVisible(true);
		//this.setSize(window.getWidth(), window.getHeight());
		this.window = window;
		graphics = new Renderer(this, window);
	}
	
	public void init()
	{
		if(running == false)
		{
			if(gameThread == null)
			{
				running = true;
				gameThread = new Thread(this);
				gameThread.start();
			}
		}
	}
	
	public void run()
	{
		long time;
		
		while(running)
		{
			time = System.currentTimeMillis();
			//game.update();
			graphics.draw();
			time = (1000/FPS) - (System.currentTimeMillis() - time);
			
			if(time > 0)
			{
				
			
				try 
				{
					Thread.sleep(time);	
				} catch (InterruptedException e)
				{
				}
			}
		}
	}
	

}
