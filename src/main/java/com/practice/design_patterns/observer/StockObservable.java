package com.practice.design_patterns.observer;

public interface StockObservable {

  void add(NotificationObserver notificationObserver);

  void remove(NotificationObserver notificationObserver);

  void notifySubscribers();
}
