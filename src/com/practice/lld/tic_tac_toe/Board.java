package com.practice.lld.tic_tac_toe;

public class Board {
  private final char[][] grid;
  private int moveCount;

  public Board() {
    this.grid = new char[3][3];
    initializeBoard();
  }

  private void initializeBoard() {
    for(int i = 0; i < grid.length; i++) {
      for(int j = 0; j < grid[0].length; j++) {
        grid[i][j] = '-';
      }
    }
    moveCount = 0;
  }

  public synchronized void makeMove(int row, int col, char move) {
    if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 'o' || grid[row][col] == 'x') {
      throw new IllegalArgumentException("Invalid move");
    }

    grid[row][col] = move;
    moveCount++;
  }

  public boolean isFull() {
    return moveCount == 9;
  }

  public boolean hasWinner() {
    // row
    for(int i = 0; i < 3; i++) {
      if (grid[i][0] != '-' && grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2]) {
        return true;
      }
    }

      // column
      for(int col = 0; col < 3; col++) {
        if(grid[0][col] != '-' && grid[0][col] == grid[1][col] && grid[1][col] == grid[2][col]) {
          return true;
        }
      }

      // diagonal
      if(grid[0][0] != '-' && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) {
        return true;
      }

      return grid[0][2] != '-' && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0];
  }

  public void printGrid() {
    for(int row = 0; row < 3; row++) {
      for(int col = 0; col < 3; col++) {
        System.out.printf(grid[row][col] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }
}
