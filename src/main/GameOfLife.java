package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

public class GameOfLife {

	static Board board;
	static Window window;
	static Thread thread;
	
	public static void start() {
		thread = new Thread();
		thread.start();
		window = new Window("game", 800, 500);
		board = new Board(window.getCanvas().getWidth(), window.getCanvas().getHeight());
		board.setUp();
	}
	
	public static void render() {
		BufferStrategy bs = window.getCanvas().getBufferStrategy();
		if(bs == null) {
			window.getCanvas().createBufferStrategy(2);
		}
		bs = window.getCanvas().getBufferStrategy();
		
		while (true) {
			window.getCanvas().setBackground(Color.black);
			Graphics2D g2d = (Graphics2D) bs.getDrawGraphics();
			g2d.clearRect(0, 0, window.getCanvas().getWidth(), window.getCanvas().getHeight());
			board.updateBoard();
			
			g2d.setColor(Color.white);
			for(int i = 0; i < board.getBoard(0).length; i++) {
				for(int j = 0; j < board.getBoard(0)[0].length; j++) {
					if(board.getState(i, j, board.getBoard(0))) {
						g2d.fillRect(i*board.getCellSize(), j*board.getCellSize(), board.getCellSize(), board.getCellSize());
					}
				}
			}
			
			g2d.dispose();
			bs.show();
			
			try {
				Thread.sleep(16);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		start();
		render();
	}

}
