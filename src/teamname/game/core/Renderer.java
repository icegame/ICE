package teamname.game.core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Renderer {
	// Window size
	private int height;
	private int width;

	// Window objects
	private JPanel canvas;
	private JFrame window;

	// Graphic objects
	private Graphics graphic;
	private Graphics background;
	private BufferedImage doubleBufferImage;

	private boolean graphicsReady = false;

	public Renderer(JPanel canvas, JFrame window) {
		this.canvas = canvas;
		this.window = window;
		System.out.println(canvas.getHeight());
		graphic = canvas.getGraphics();

		height = this.window.getHeight();
		width = this.window.getWidth();
		doubleBufferImage = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		graphicsReady = true;
	}

	public void draw()
	{
		background = doubleBufferImage.getGraphics();
		background.setColor(Color.BLACK);
		background.fillRect(0, 0, width, height);
		
		System.out.println(graphic);
		graphic.drawImage(doubleBufferImage, 0, 0, width, height, window);
	}
}
