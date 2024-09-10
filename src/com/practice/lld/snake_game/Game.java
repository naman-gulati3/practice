package com.practice.lld.snake_game;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Game {

  private final Queue<Player> players = new ArrayDeque<>();
  private Board board;

  public void addPlayer(int id, String name) {
    Player player = new Player(id, name);
    players.add(player);
    System.out.println("Player added: " + player.getName());
  }

  public void setBoard(int size, int snake, int ladder) {
    board = new Board(size, snake, ladder);
    System.out.println("Board initialized");
    System.out.println("Snake added: " + snake);
    System.out.println("Ladder added: " + ladder);
  }

  public void startGame() {
    List<String> winners = new ArrayList<>();
    while (players.size() > 2) {
      Player player = players.poll();
      System.out.println("Turn: " + player.getName());
      System.out.println(
          "Player: " + player.getName() + " at position " + player.getCurrentPosition());
      int move = DiceRoll.roll();
      System.out.println("Dice shows " + move);
      int currentPosition = player.getCurrentPosition() + move;
      if (currentPosition >= board.getBoardSize()) {
        winners.add(player.getName());
        System.out.println(player.getName() + " won!");
        continue;
      }

      if (currentPosition < board.getBoardSize()) {
        int finalPosition = board.getFinalPosition(currentPosition);
        player.setCurrentPosition(finalPosition);
        System.out.println(player.getName() + " moved to " + finalPosition);
      }
      players.add(player);
      displayResult(winners);
    }
  }

  private void displayResult(List<String> winners) {
    System.out.println("Result");
    int count = 0;
    for (String player : winners) {
      count++;
      System.out.println("Rank " + count + ": " + player);
    }
  }
}
