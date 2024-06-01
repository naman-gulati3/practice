package com.practice.lld.parking_lot;

import java.util.ArrayList;
import java.util.List;

public class Level {
  private int floorNumber;
  private List<ParkingSpot> parkingSpots;

  public Level(int floorNumber, int numberOfSpots) {
    this.floorNumber = floorNumber;
    parkingSpots = new ArrayList<>();
    for(int i = 1; i <= numberOfSpots; i++) {
      parkingSpots.add(new ParkingSpot(i));
    }
  }

  public synchronized boolean parkVehicle(Vehicle vehicle) {
    for(ParkingSpot spot : parkingSpots) {
      if(spot.isAvailable() && spot.getVehicleType() == vehicle.getType()) {
        spot.parkVehicle(vehicle);
        return true;
      }
    }
    return false;
  }

  public synchronized boolean unparkVehicle(Vehicle vehicle) {
    for(ParkingSpot spot : parkingSpots) {
      if(!spot.isAvailable() && spot.getParkedVehicle().equals(vehicle)) {
        spot.unparkVehicle(vehicle);
        return true;
      }
    }
    return false;
  }
  public void displayAvailability() {
    for(ParkingSpot spot : parkingSpots) {
      if(!spot.isAvailable()) {
        System.out.printf("Spot is occoupied by %s by type: %s%n",  spot.getParkedVehicle().getRegistrationNumber(),
            spot.getParkedVehicle().getType());
      } else {
        System.out.printf("Spot number %s is free%n",  spot.getSpotNumber());
      }
    }
  }
}
