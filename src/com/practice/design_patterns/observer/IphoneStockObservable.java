package com.practice.design_patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class IphoneStockObservable implements StockObservable {

  private final List<NotificationObserver> observerList = new ArrayList<>();
  private int stockCount = 0;

  @Override
  public void add(NotificationObserver notificationObserver) {
    observerList.add(notificationObserver);
  }

  @Override
  public void remove(NotificationObserver notificationObserver) {
    observerList.remove(notificationObserver);
  }

  @Override
  public void notifySubscribers() {
    for (NotificationObserver observer : observerList) {
      observer.update();
    }
  }

  public void setStockCount(int newStockAdded) {
    if (stockCount == 0) {
      notifySubscribers();
    }

    stockCount = stockCount + newStockAdded;
  }

  public int getStockCount() {
    return stockCount;
  }
}
