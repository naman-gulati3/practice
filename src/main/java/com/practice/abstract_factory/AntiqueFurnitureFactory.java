package com.practice.abstract_factory;

public class AntiqueFurnitureFactory implements FurnitureFactory {

  @Override
  public Chair createChair() {
    return new WoodChair();
  }

  @Override
  public Table createTable() {
    return new WoodTable();
  }
}
