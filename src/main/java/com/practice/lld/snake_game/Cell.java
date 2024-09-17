package com.practice.lld.snake_game;

public class Cell {

  private Ladder ladder;
  private Snake snake;

  public Cell() {}

  public Ladder getLadder() {
    return ladder;
  }

  public void setLadder(Ladder ladder) {
    this.ladder = ladder;
  }

  public Snake getSnake() {
    return snake;
  }

  public void setSnake(Snake snake) {
    this.snake = snake;
  }

  @Override
  public String toString() {
    return "Cell{" + "ladder=" + ladder + ", snake=" + snake + '}';
  }
}
