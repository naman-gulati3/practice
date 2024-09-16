package com.practice.abstract_factory;

public class IkeaChair extends ModernChair {

  @Override
  int getCost() {
    return 100;
  }

  @Override
  String getModelNumber() {
    return "IKEA-4412";
  }

  @Override
  String getSupplier() {
    return "Ikea Furniture Co.";
  }
}
