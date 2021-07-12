package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

/**
 * main class containing render code and main loop
 * @author MichaPehlivan
 */
public class GameOfLife {
	
	static Board board;
	static Window window;
	static Input input = new Input();
	static Thread thread;
	static BufferStrategy bs;
	
	//board and window setup
	public static void start() {
		thread = new Thread();
		thread.start();
		window = new Window("game", 800, 500);
		board = new Board(window.getCanvas().getWidth(), window.getCanvas().getHeight());
		board.setUp();
	}
	
	//renders the board
	public static void render() {
		bs = window.getCanvas().getBufferStrategy();
		if(bs == null) {
			window.getCanvas().createBufferStrategy(2);
		}
		bs = window.getCanvas().getBufferStrategy();
			
		while (true) {
			window.getCanvas().setBackground(Color.black);
			window.requestFocusInWindow();
			Graphics2D g2d = (Graphics2D) bs.getDrawGraphics();
			
			if (!input.getPaused()) {
				g2d.clearRect(0, 0, window.getCanvas().getWidth(), window.getCanvas().getHeight());
				board.updateBoard();
			}

			g2d.setColor(Color.white);
			for (int i = 0; i < board.getBoard().length; i++) {
				for (int j = 0; j < board.getBoard()[0].length; j++) {
					if (board.getState(i, j, board.getBoard())) {
						g2d.fillRect(i * board.getCellSize(), j * board.getCellSize(), board.getCellSize(),
								board.getCellSize());
					}
				}
			}

			g2d.dispose();
			bs.show();
			
			tick(16);
		}
	}
	
	//timing for framerate
	public static void tick(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	//main loop
	public static void main(String[] args) {
		start();
		render();
	}

}
