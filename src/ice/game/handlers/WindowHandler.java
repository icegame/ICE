package ice.game.handlers;

import ice.game.core.Engine;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;


public class WindowHandler implements ComponentListener
{
	private Engine gameEngine;
	
	public WindowHandler(Engine gameEngine)
	{
		this.gameEngine = gameEngine;
	}
	
	
	@Override
	public void componentHidden(ComponentEvent ce)
	{

	}

	@Override
	public void componentMoved(ComponentEvent ce)
	{
		

	}

	@Override
	public void componentResized(ComponentEvent ce)
	{
		gameEngine.screenUpdate();

	}

	@Override
	public void componentShown(ComponentEvent ce)
	{
		

	}

}
