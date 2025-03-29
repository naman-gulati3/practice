package com.practice.machine_coding.flipkart_daily.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Cart {

  private final List<ProductAndQuantity> products;

  public Cart() {
    this.products = new ArrayList<>();
  }

  public List<ProductAndQuantity> getProducts() {
    return products;
  }

  public void addProduct(Product product, int quantity) {
    this.products.add(new ProductAndQuantity(product, quantity));
  }

  public void removeProduct(Product product) {
    this.products.removeIf(p -> p.getProduct().equals(product));
  }

  public void updateProductQuantity(Product product, int quantity) {
    Optional<ProductAndQuantity> productOptional =
        this.products.stream().filter(p -> p.getProduct().equals(product)).findFirst();

    productOptional.ifPresent(productAndQuantity -> productAndQuantity.setQuantity(quantity));
  }
}
