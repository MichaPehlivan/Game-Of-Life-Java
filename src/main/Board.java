package main;

import java.util.Random;

public class Board {

	private boolean[][] board;
	private boolean[][] newboard;
	int cellsize = 4;
	Random random = new Random();
	
	public Board(int width, int height) {
		board = new boolean[width/cellsize][height/cellsize];
		newboard = new boolean[width/cellsize][height/cellsize];
	}
	
	//getters and setters
	public boolean[][] getBoard() {
		return this.board;
	}
	
	public boolean getState(int x, int y, boolean[][] board) {
		return board[x][y];
	}
	
	public void setState(int x, int y, boolean[][] board, boolean state) {
		board[x][y] = state;
	}
	
	public int getCellSize() {
		return this.cellsize;
	}
	
	//counts number of alive cells next to cell
	public int countNeighbours(int x, int y) {
		int count = 0;
		
		for(int i = x-1; i <= x+1; i++) {
			for(int j = y-1; j <= y+1; j++) {
				if(i != x || j != y) {
					try {
						if (getState(i, j, board)) {
							count++;
						} 
					} catch (ArrayIndexOutOfBoundsException e) {
						count += 0;
					}
				}
			}
		}
		
		return count;
	}
	
	//returns state of cell in the next generation
	public boolean getNewState(int x, int y) {
		int count = countNeighbours(x, y);
		boolean state = getState(x, y, board);
		
		if(state && count > 1 && count < 4) {
			return true;
		}
		else if(!state && count == 3) {
			return true;
		}
		
		return false;
	}
	
	//changes states to those of the next generation
	public void updateBoard() {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				setState(i, j, newboard, getNewState(i, j));
			}
		}
		
		for(int x = 0; x < newboard.length; x++) {
			for(int y = 0; y < newboard[x].length; y++) {
				setState(x, y, board, getState(x, y, newboard));
			}
		}
	}
	
	//assigns every cell a random state
	public void setUp() {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				setState(i, j, board, random.nextBoolean());
			}
		}
	}
}
