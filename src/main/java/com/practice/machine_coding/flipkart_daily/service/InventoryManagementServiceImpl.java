package com.practice.machine_coding.flipkart_daily.service;

import com.practice.machine_coding.flipkart_daily.dto.Product;
import com.practice.machine_coding.flipkart_daily.enums.ProductCategory;
import com.practice.machine_coding.flipkart_daily.repository.InventoryRepository;
import java.util.List;
import java.util.stream.Stream;
import org.jetbrains.annotations.Nullable;

public class InventoryManagementServiceImpl implements InventoryManagementService {

  private final InventoryRepository inventoryRepository;

  public InventoryManagementServiceImpl(InventoryRepository inventoryRepository) {
    this.inventoryRepository = inventoryRepository;
  }

  @Override
  public void addProductToInventory(Product product, int quantity) {
    inventoryRepository.addProduct(product, quantity);
  }

  @Override
  public List<Product> searchProduct(
      @Nullable String brand, @Nullable ProductCategory productCategory, @Nullable Float price) {
    Stream<Product> productsStream = inventoryRepository.getProducts().stream();

    if (brand != null) {
      productsStream = productsStream.filter(p -> p.getBrand().equals(brand));
    }

    if (productCategory != null) {
      productsStream = productsStream.filter(p -> p.getCategory().equals(productCategory));
    }

    if (price != null) {
      productsStream = productsStream.filter(p -> p.getPrice() == price);
    }

    return productsStream.toList();
  }
}
