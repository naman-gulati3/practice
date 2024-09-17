package com.practice.lld.tic_tac_toe;

public enum Move {
  X('x'),
  O('o');

  private final char symbol;

  Move(char symbol) {
    this.symbol = symbol;
  }

  public char getSymbol() {
    return symbol;
  }
}
