package main;

import java.awt.Canvas;

import javax.swing.JFrame;

/**
 * class for setting up the window for the game
 * @author MichaPehlivan
 */
public class Window extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private Canvas canvas;

	//window setup
	public Window(String title, int width, int height) {
		setSize(width, height);
		setTitle(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		canvas = new Canvas();
		canvas.setSize(width, height);
		canvas.setFocusable(true);
		
		add(canvas);
		addKeyListener(new Input());
		setVisible(true);
	}
	
	//getters and setters
	public Canvas getCanvas() {
		return canvas;
	}
			
	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}

}
