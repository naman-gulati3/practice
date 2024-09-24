package com.practice.machine_coding.flipkart_daily.repository;

import com.practice.machine_coding.flipkart_daily.dto.Cart;
import com.practice.machine_coding.flipkart_daily.dto.Product;
import com.practice.machine_coding.flipkart_daily.dto.User;
import java.util.HashMap;
import java.util.Map;

public class CartRepository {

  private final Map<String, User> userByName;
  private final Map<String, Cart> userCart;

  public CartRepository() {
    this.userCart = new HashMap<>();
    this.userByName = new HashMap<>();
  }

  public void addUser(User user) {
    this.userByName.put(user.getName(), user);
  }

  public void addProductToCart(String username, Product product, int quantity) {
    Cart userCart = this.userCart.getOrDefault(username, new Cart());
    userCart.addProduct(product, quantity);
  }

  public void removeFromCart(String username, Product product) {
    if (this.userCart.containsKey(username)) {
      Cart cart = this.userCart.get(username);
      cart.removeProduct(product);
    }
  }

  public void updateCart(String username, Product product, int quantity) {
    if (this.userCart.containsKey(username)) {
      Cart cart = this.userCart.get(username);
      cart.updateProductQuantity(product, quantity);
    }
  }

  public void addBalance(String username, float balance) {
    if (this.userByName.containsKey(username)) {
      User user = this.userByName.get(username);
      user.addMoneyToWallet(balance);
    }
  }

  public Cart getCartInfo(String username) {
    return this.userCart.get(username);
  }
}
