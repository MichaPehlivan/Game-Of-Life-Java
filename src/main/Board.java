package main;

import java.util.Random;

public class Board {

	private boolean[][] board = new boolean[200][125];
	private boolean[][] newboard = new boolean[200][125];
	Random random = new Random();
	
	public boolean[][] getBoard(int index) {
		if(index == 0) {
			return board;
		}
		else {
			return newboard;
		}
	}
	
	public boolean getState(int x, int y, boolean[][] board) {
		return board[x][y];
	}
	
	public void setState(int x, int y, boolean[][] board, boolean state) {
		board[x][y] = state;
	}
	
	public int countNeighbours(int x, int y) {
		int count = 0;
		
		if(x > 0 && x < board.length-1 && y > 0 && y < board[0].length-1) {
			if(board[x-1][y-1]) {
				count++;
			}
			if(board[x][y-1]) {
				count++;
			}
			if(board[x+1][y-1]) {
				count++;
			}
			if(board[x-1][y]) {
				count++;
			}
			if(board[x+1][y]) {
				count++;
			}
			if(board[x-1][y+1]) {
				count++;
			}
			if(board[x][y+1]) {
				count++;
			}
			if(board[x+1][y+1]) {
				count++;
			}
		}
		
		return count;
	}
	
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
	
	public void updateBoard() {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				newboard[i][j] = getNewState(i, j);
			}
		}
		
		for(int x = 0; x < newboard.length; x++) {
			for(int y = 0; y < newboard[x].length; y++) {
				board[x][y] = newboard[x][y];
			}
		}
	}
	
	public void setUp() {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				setState(i, j, board, random.nextBoolean());
			}
		}
	}

}
