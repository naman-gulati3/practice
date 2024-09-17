package com.practice.lld.parking_lot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
  private static ParkingLot instance;

  private List<Level> levels;

  private ParkingLot() {
    levels = new ArrayList<>();
  }

  public static synchronized ParkingLot getInstance() {
    if (instance == null) {
      instance = new ParkingLot();
    }
    return instance;
  }

  public void addLevel(Level level) {
    this.levels.add(level);
  }

  public boolean parkVehicle(Vehicle vehicle) {
    for (Level level : levels) {
      if (level.parkVehicle(vehicle)) {
        return true;
      }
    }
    return false;
  }

  public boolean unparkVehicle(Vehicle vehicle) {
    for (Level level : levels) {
      if (level.unparkVehicle(vehicle)) {
        return true;
      }
    }
    return false;
  }

  public void displayAvailability() {
    for (Level level : levels) {
      level.displayAvailability();
    }
  }
}
