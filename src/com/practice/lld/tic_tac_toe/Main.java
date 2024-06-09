package com.practice.lld.tic_tac_toe;

public class Main {

  public static void main(String[] args) {
    Player player1 = new Player("naman", Move.X);
    Player player2 = new Player("opponent", Move.O);
    Game game = new Game(player1, player2);
    game.play();
  }
}
