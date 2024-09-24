package com.practice.machine_coding.flipkart_daily.service;

import com.practice.machine_coding.flipkart_daily.dto.Cart;
import com.practice.machine_coding.flipkart_daily.dto.Product;

public interface UserManagementService {

  void addUser(String username, String address);

  void addToCart(String username, Product product, int quantity);

  void updateCart(String username, Product product, int quantity);

  void addBalanceToWallet(String username, float balance);

  Cart getCartInfo(String username);

  void checkout(String username);
}
