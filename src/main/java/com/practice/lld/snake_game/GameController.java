package com.practice.lld.snake_game;

public class GameController {

  public static void main(String[] args) {
    Game game = new Game();
    game.setBoard(100, 4, 3);
    game.addPlayer(1, "Player1");
    game.addPlayer(2, "Player2");
    game.addPlayer(3, "Player3");
    game.addPlayer(4, "Player4");
    game.startGame();
  }
}
