package com.practice.lld.car_rental_service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reservation {
  private final String reservationId;
  private final Customer customer;
  private final Car car;
  private final LocalDate startDate;
  private final LocalDate endData;
  private final float price;

  public Reservation(
      String reservationId, Customer customer, Car car, LocalDate startDate, LocalDate endData) {
    this.reservationId = reservationId;
    this.customer = customer;
    this.car = car;
    this.startDate = startDate;
    this.endData = endData;
    this.price = calculateTotalPrice();
  }

  public float calculateTotalPrice() {
    long rentedDays = ChronoUnit.DAYS.between(endData, startDate) + 1;
    return this.car.getRentalPricePerDay() * rentedDays;
  }

  public String getReservationId() {
    return reservationId;
  }

  public Customer getCustomer() {
    return customer;
  }

  public Car getCar() {
    return car;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public LocalDate getEndData() {
    return endData;
  }

  public float getPrice() {
    return price;
  }
}
