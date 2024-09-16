package com.practice.design_patterns.observer;

public class EmailAlertObserverImpl implements NotificationObserver {

  private String email;

  private StockObservable stockObservable;

  public EmailAlertObserverImpl(String email, StockObservable stockObservable) {
    this.email = email;
    this.stockObservable = stockObservable;
  }

  @Override
  public void update() {
    sendEmail(email, "Product Iphone is back in stock");
  }

  private void sendEmail(String email, String msg) {
    // integrate mailer
    System.out.println("Send email to " + email);
  }
}
