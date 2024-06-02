package com.practice.lld.vending_machine;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Inventory {
  private Map<Product, Integer> products;

  public Inventory() {
    this.products = new ConcurrentHashMap<>();
  }

  public void addProduct(Product product, int quantity) {
    this.products.put(product, quantity);
  }

  public void removeProduct(Product product) {
    this.products.remove(product);
  }

  public void updateQuantity(Product product, int quantity) {
    this.products.put(product, quantity);
  }

  public int getQuantity(Product product) {
    return this.products.get(product);
  }

  public boolean isAvailable(Product product) {
    return products.containsKey(product) && products.get(product) > 0;
  }
}
