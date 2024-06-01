package com.practice.lld.parking_lot;

import com.practice.lld.parking_lot.Vehicle.VehicleType;

public class ParkingSpot {
  private final int spotNumber;
  private Vehicle parkedVehicle;

  private VehicleType vehicleType;

  public ParkingSpot(int spotNumber, VehicleType vehicleType) {
    this.spotNumber = spotNumber;
    this.vehicleType = vehicleType;
  }

  public ParkingSpot(int spotNumber) {
    this.spotNumber = spotNumber;
    this.vehicleType = VehicleType.CAR;
  }

  public synchronized boolean isAvailable() {
    return parkedVehicle == null;
  }

  public synchronized void parkVehicle(Vehicle vehicle) {
    if(isAvailable() && vehicle.getType() == vehicleType) {
      parkedVehicle = vehicle;
    } else {
      throw new IllegalArgumentException("No parking spot is available");
    }
  }

  public synchronized void unparkVehicle(Vehicle vehicle) {
    this.parkedVehicle = null;
  }

  public int getSpotNumber() {
    return spotNumber;
  }

  public Vehicle getParkedVehicle() {
    return parkedVehicle;
  }

  public VehicleType getVehicleType() {
    return vehicleType;
  }
}
