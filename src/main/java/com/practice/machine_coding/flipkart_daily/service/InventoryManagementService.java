package com.practice.machine_coding.flipkart_daily.service;

import com.practice.machine_coding.flipkart_daily.dto.Product;
import com.practice.machine_coding.flipkart_daily.enums.ProductCategory;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public interface InventoryManagementService {

  void addProductToInventory(Product product, int quantity);

  List<Product> searchProduct(@Nullable String brand, @Nullable ProductCategory productCategory,
      @Nullable Float price);
}
