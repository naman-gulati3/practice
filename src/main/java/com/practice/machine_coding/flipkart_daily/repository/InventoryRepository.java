package com.practice.machine_coding.flipkart_daily.repository;

import com.practice.machine_coding.flipkart_daily.dto.Product;
import com.practice.machine_coding.flipkart_daily.dto.ProductAndQuantity;
import com.practice.machine_coding.flipkart_daily.enums.ProductCategory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryRepository {

  private final Map<ProductCategory, List<ProductAndQuantity>> inventoryByCategory;
  private final Map<Product, Integer> inventoryByProduct;

  public InventoryRepository() {
    this.inventoryByProduct = new HashMap<>();
    this.inventoryByCategory = new HashMap<>();
  }

  public void addProduct(Product product, int quantity) {
    List<ProductAndQuantity> productAndQuantities =
        this.inventoryByCategory.getOrDefault(product.getCategory(), new ArrayList<>());
    productAndQuantities.add(new ProductAndQuantity(product, quantity));

    this.inventoryByCategory.put(product.getCategory(), productAndQuantities);

    this.inventoryByProduct.put(product, inventoryByProduct.getOrDefault(product, 0) + quantity);
  }

  public List<Product> getProducts() {
    return this.inventoryByCategory.values().stream()
        .flatMap(Collection::stream)
        .map(ProductAndQuantity::getProduct)
        .toList();
  }
}
