package com.practice.lld.snake_game;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Board {

  private final Cell[][] cells;
  private final int boardSize;
  private final int numberOfSnakes;
  private final int numberOfLadders;

  public Board(int size, int numberOfSnakes, int numberOfLadders) {
    this.cells = new Cell[100][100];
    this.boardSize = size;
    this.numberOfSnakes = numberOfSnakes;
    this.numberOfLadders = numberOfLadders;
    initializeBoard();
  }

  private void initializeBoard() {

    for (int i = 1; i <= boardSize; i++) {
      cells[generateRowNo(i)][generateColNo(i)] = new Cell();
    }
    generateSnakes();
    generateLadders();
  }

  private void generateSnakes() {
    int snakeCount = 0;
    while (snakeCount < numberOfSnakes) {
      int start = ThreadLocalRandom.current().nextInt(2, boardSize);
      int end = ThreadLocalRandom.current().nextInt(2, boardSize);
      if (start <= end) {
        continue;
      }
      if (cells[generateRowNo(start)][generateColNo(start)].getSnake() == null) {
        cells[generateRowNo(start)][generateColNo(start)].setSnake(new Snake(start, end));
        snakeCount++;
      }

    }
  }

  private void generateLadders() {
    int ladderCount = 0;
    while (ladderCount < numberOfLadders) {
      int start = ThreadLocalRandom.current().nextInt(2, boardSize);
      int end = ThreadLocalRandom.current().nextInt(2, boardSize);
      if (start >= end) {
        continue;
      }
      if (cells[generateRowNo(start)][generateColNo(start)].getLadder() == null &&
          cells[generateRowNo(start)][generateColNo(start)].getSnake() == null) {
        cells[generateRowNo(start)][generateColNo(start)].setLadder(new Ladder(start, end));
        ladderCount++;
      }

    }
  }

  private int generateRowNo(int num) {
    return (int) (num - 1 / Math.sqrt(boardSize));
  }

  private int generateColNo(int num) {
    return (int) (num - 1 % Math.sqrt(boardSize));
  }

  public int getFinalPosition(int position) {
    int row = generateRowNo(position);
    int col = generateColNo(position);
    int finalPosition = position;
    if (cells[row][col].getSnake() != null) {
      System.out.println("Snake bit at: " + position);
      finalPosition = cells[row][col].getSnake().end();


    } else if (cells[row][col].getLadder() != null) {
      System.out.println("Climbed ladder at: " + position);
      finalPosition = cells[row][col].getLadder().end();

    }

    return finalPosition;
  }

  public Cell[][] getCells() {
    return cells;
  }

  public int getBoardSize() {
    return boardSize;
  }

  public int getNumberOfSnakes() {
    return numberOfSnakes;
  }

  public int getNumberOfLadders() {
    return numberOfLadders;
  }

  @Override
  public String toString() {
    return "Board{" +
        "cells=" + Arrays.deepToString(cells) +
        ", boardSize=" + boardSize +
        ", numberOfSnakes=" + numberOfSnakes +
        ", numberOfLadders=" + numberOfLadders +
        '}';
  }
}
