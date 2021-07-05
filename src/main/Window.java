package main;

import java.awt.Canvas;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Point;

import javax.swing.JFrame;

public class Window extends JFrame {
	
	private static final long serialVersionUID = -7602186186995664418L;
	private Canvas canvas;

	public Window(String title, int width, int height) {
		setSize(width, height);
		setTitle(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocation(new Point(0, 0));
		setVisible(true);
		
		canvas = new Canvas();
		canvas.setSize(width, height);
		canvas.setFocusable(true);
		add(canvas);
	}

	public Window() throws HeadlessException {
		// TODO Auto-generated constructor stub
	}

	public Window(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	public Window(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public Window(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}
	
	//getters and setters
	public Canvas getCanvas() {
		return canvas;
	}
		
	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}

}
