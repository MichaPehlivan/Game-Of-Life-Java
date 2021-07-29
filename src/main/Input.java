package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * class for handeling input
 * @author MichaPehlivan
 */
public class Input implements KeyListener {
	
	private static boolean paused;

	public Input() {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			paused = !paused;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
	
	//getters and setters
	public static boolean isPaused() {
		return paused;
	}

}
