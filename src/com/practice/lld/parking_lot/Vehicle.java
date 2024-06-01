package com.practice.lld.parking_lot;

public abstract class Vehicle {
  enum VehicleType {
  TRUCK,
  BIKE,
  CAR,

    UNKNOWN
}
  private final String registrationNumber;
  private final VehicleType vehicleType;

  public Vehicle(String registrationNumber, VehicleType type) {
    this.registrationNumber = registrationNumber;
    this.vehicleType = type;
  }

   public VehicleType getType() {
    return this.vehicleType;
  }

  public String getRegistrationNumber() {
    return registrationNumber;
  }
}
