package com.practice.lld.snake_game;

public class Player {

  private int id;
  private String name;
  private int currentPosition;


  public Player(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getCurrentPosition() {
    return currentPosition;
  }

  public void setCurrentPosition(int currentPosition) {
    this.currentPosition = currentPosition;
  }
}
