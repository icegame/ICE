package ice.game.core;

import ice.game.handlers.KeyHandler;
import ice.game.handlers.WindowHandler;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Engine extends JPanel implements Runnable
{
	// Created 9/19/13 at 12:27
	private static final long serialVersionUID = 919131237L;

	
	//Threading
	private static final int MAX_DELAYS = 5;
	private static final int PERIOD = 6000000;
	private volatile boolean running = false;
	private Thread gameThread; 
	
	private Renderer graphics;
	
	private JFrame window;
	
	//Handlers
	private WindowHandler windowHandle = new WindowHandler(this);
	private KeyHandler keyHandle = new KeyHandler();
	
	public Engine(JFrame window)
	{
		setVisible(true);
		this.setSize(window.getWidth(), window.getHeight());
		this.window = window;
		window.addComponentListener(windowHandle);
		window.addKeyListener(keyHandle);
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
			
			//game.update();
			graphics.draw();
			
			//Smoothing out the game
			long before = System.nanoTime();
			long after = 0L;
			long difference = 0L;
			long sleep = 0L;
			long overSleep = 0L;
			int delays = 0;
			
			if(sleep < PERIOD && sleep > 0)
			{
				try
				{
					Thread.sleep(sleep / 1000000L);
				}
				catch (InterruptedException e)
				{
				
				}
				
				overSleep = 0;
			}
			else if(difference > PERIOD)
			{
				overSleep = difference - PERIOD;
			}
			else if(++delays > MAX_DELAYS)
			{
				System.out.println("Yielding");
				Thread.yield();
				overSleep = 0;
				delays = 0;
			}
			else
			{
				overSleep = 0;
			}
			
			after = System.nanoTime();
			//System.out.println("Before: " + before);
			//System.out.println("After: " + after);
		}
	}
	
	public void screenUpdate()
	{
		int newWidth = window.getWidth();
		int newHeight = window.getHeight();
		
		graphics.updateScreenSize(newWidth, newHeight);
	}

}
