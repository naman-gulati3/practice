package com.practice.design_patterns.observer;

public class ObserverPatternMain {

  public static void main(String[] args) {
    IphoneStockObservable iphoneStockObservable = new IphoneStockObservable();
    NotificationObserver observer1 = new EmailAlertObserverImpl("xyz123@gmail.com",
        iphoneStockObservable);
    NotificationObserver observer2 = new EmailAlertObserverImpl("naman@gmail.com",
        iphoneStockObservable);

    iphoneStockObservable.add(observer1);
    iphoneStockObservable.add(observer2);

    iphoneStockObservable.setStockCount(10);
  }
}
