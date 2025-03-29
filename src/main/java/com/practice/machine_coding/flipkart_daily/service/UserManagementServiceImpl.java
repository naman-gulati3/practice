package com.practice.machine_coding.flipkart_daily.service;

import com.practice.machine_coding.flipkart_daily.dto.Cart;
import com.practice.machine_coding.flipkart_daily.dto.Product;
import com.practice.machine_coding.flipkart_daily.dto.User;
import com.practice.machine_coding.flipkart_daily.repository.CartRepository;
import com.practice.machine_coding.flipkart_daily.repository.InventoryRepository;

public class UserManagementServiceImpl implements UserManagementService {

  private final CartRepository cartRepository;

  private final InventoryRepository inventoryRepository;

  public UserManagementServiceImpl(
      CartRepository cartRepository, InventoryRepository inventoryRepository) {
    this.cartRepository = cartRepository;
    this.inventoryRepository = inventoryRepository;
  }

  @Override
  public void addUser(String username, String address) {
    this.cartRepository.addUser(new User(username, address));
  }

  @Override
  public synchronized void addToCart(String username, Product product, int quantity) {
    this.cartRepository.addProductToCart(username, product, quantity);
  }

  @Override
  public void updateCart(String username, Product product, int quantity) {
    if (quantity == 0) {
      this.cartRepository.removeFromCart(username, product);
    } else {
      this.cartRepository.updateCart(username, product, quantity);
    }
  }

  @Override
  public void addBalanceToWallet(String username, float balance) {
    this.cartRepository.addBalance(username, balance);
  }

  @Override
  public Cart getCartInfo(String username) {
    return this.cartRepository.getCartInfo(username);
  }

  @Override
  public synchronized void checkout(String username) {
    Cart userCart = this.cartRepository.getCartInfo(username);
  }
}
