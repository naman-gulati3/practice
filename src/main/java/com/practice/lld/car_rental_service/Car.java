package com.practice.lld.car_rental_service;

public class Car {
  private String make;
  private String model;
  private int year;
  private String licensePlateNumber;
  private float rentalPricePerDay;

  private boolean isAvailable;

  public Car() {}

  public Car(
      String make, String model, int year, String licensePlateNumber, float rentalPricePerDay) {
    this.make = make;
    this.model = model;
    this.year = year;
    this.licensePlateNumber = licensePlateNumber;
    this.rentalPricePerDay = rentalPricePerDay;
    this.isAvailable = true;
  }

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public String getLicensePlateNumber() {
    return licensePlateNumber;
  }

  public void setLicensePlateNumber(String licensePlateNumber) {
    this.licensePlateNumber = licensePlateNumber;
  }

  public float getRentalPricePerDay() {
    return rentalPricePerDay;
  }

  public void setRentalPricePerDay(float rentalPricePerDay) {
    this.rentalPricePerDay = rentalPricePerDay;
  }

  public boolean isAvailable() {
    return isAvailable;
  }

  public void setAvailable(boolean available) {
    isAvailable = available;
  }
}
