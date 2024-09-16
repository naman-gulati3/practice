package com.practice.abstract_factory;

public class WoodTable extends AntiqueTable {

  @Override
  int getTableLengthInches() {
    return 0;
  }

  @Override
  String getSupplier() {
    return null;
  }

  @Override
  String getManufacturer() {
    return null;
  }
}
