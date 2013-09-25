package ice.game.handlers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class KeyHandler implements KeyListener
{
	public KeyHandler()
	{
		
	}
	
	@Override
	public void keyPressed(KeyEvent ke)
	{
		System.out.println(ke.getKeyChar());
	}

	@Override
	public void keyReleased(KeyEvent ke)
	{

	}

	@Override
	public void keyTyped(KeyEvent ke)
	{

	}

}