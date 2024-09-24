package com.practice.machine_coding.flipkart_daily.dto;

public class ProductAndQuantity {

  private final Product product;
  private int quantity;

  public ProductAndQuantity(Product product, int quantity) {
    this.quantity = quantity;
    this.product = product;
  }

  public Product getProduct() {
    return product;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}
