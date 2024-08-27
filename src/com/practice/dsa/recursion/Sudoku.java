package com.practice.dsa.recursion;

import java.util.Arrays;

public class Sudoku {

  public static void main(String[] args) {
    char[][] board = new char[][]{
        // 0   1    2    3    4    5    6    7    8
        {'5', '3', '.', '.', '7', '.', '.', '.', '.'}, // 0
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, // 1
        {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, // 2
        {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, // 3
        {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, // 4
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, // 5
        {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, // 6
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, // 7
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'} // 8
    };
    solveSudoku(board);

    System.out.println(Arrays.deepToString(board));
  }

  public static void solveSudoku(char[][] board) {
    solve(board);
  }

  private static boolean solve(char[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == '.') {
          for (char ch = '1'; ch <= '9'; ch++) {
            if (isValid(board, i, j, ch)) {
              board[i][j] = ch;
              if (solve(board)) {
                return true;
              } else {
                board[i][j] = '.';
              }
            }
          }
          return false;
        }
      }
    }
    return true;
  }

  private static boolean isValid(char[][] board, int row, int col, char ch) {
    for (int i = 0; i < 9; i++) {
      // check columns
      if (board[row][i] == ch) {
        return false;
      }

      // // check rows
      if (board[i][col] == ch) {
        return false;
      }

      // check 3x3 box
      // if we are at 5,7 first row of 3x3 box can be found by 3 * (row / 3) i.e row number 3
      // to find the following rows using index i find the first row from above formula and add i / 3 for each iteration of i

      // if we are at 5,7 first column of 3x3 box can be found by 3 * (col / 3) i.e row number 6
      // to find the following columns using index i find the first column from above formula and add i % 3 for each iteration of i

      // Note: 3 * (row / 3) and 3 * (col / 3) only helps to find the first row and first column of bounding 3x3 box
      if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == ch) {
        return false;
      }

    }

//    int rowBoundingStart = 3 * (row / 3);
//    int colBoundingStart = 3 * (col / 3);

//    for (int i = rowBoundingStart; i < rowBoundingStart + 3; i++) {
//      for (int j = colBoundingStart; j < colBoundingStart + 3; j++) {
//        if (board[i][j] == ch) {
//          return false;
//        }
//      }
//    }

    return true;
  }
}
