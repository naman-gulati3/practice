package com.practice.lld.tic_tac_toe;

import java.util.Scanner;

public class Game {

  private final Player player1;
  private final Player player2;
  private final Board board;
  private Player currentPlayer;


  public Game(Player player1, Player player2) {
    this.player1 = player1;
    this.player2 = player2;
    this.board = new Board();
    this.currentPlayer = player1;
  }

  public void play() {
    board.printGrid();

    while (true) {
      if (board.isFull()) {
        System.out.println("Game Draw");
        return;

      }
      System.out.printf("Player %s 's turn%n", currentPlayer.name());
      int row = getValidInput("Enter row (0 - 2):");
      int col = getValidInput("Enter column (0 - 2):");

      try {
        board.makeMove(row, col, currentPlayer.move().getSymbol());
        board.printGrid();

        if (board.hasWinner()) {
          System.out.println(currentPlayer.name() + " won!");
          return;
        }
        switchPlayer();
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }
  }

  private void switchPlayer() {
    currentPlayer = (currentPlayer == player1) ? player2 : player1;
  }

  private int getValidInput(String message) {
    Scanner scanner = new Scanner(System.in);
    int input;

    while (true) {
      System.out.println(message);
      if (scanner.hasNextInt()) {
        input = scanner.nextInt();
        if (input >= 0 && input <= 2) {
          return input;
        }
      } else {
        scanner.next();
      }
      System.out.println("Invalid input, please enter value between 0 and 2");
    }
  }
}
