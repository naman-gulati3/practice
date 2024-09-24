package com.practice.machine_coding.flipkart_daily.dto;

import com.practice.machine_coding.flipkart_daily.enums.ProductCategory;

public class Product {

  private final ProductCategory category;
  private final String brand;
  private final String name;
  private final float price;

  public Product(ProductCategory category, String brand, String name, float price) {
    this.category = category;
    this.brand = brand;
    this.name = name;
    this.price = price;
  }

  public ProductCategory getCategory() {
    return category;
  }

  public String getBrand() {
    return brand;
  }

  public String getName() {
    return name;
  }

  public float getPrice() {
    return price;
  }
}
