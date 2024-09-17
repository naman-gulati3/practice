package com.practice.lld.parking_lot;

public class Main {

  public static void main(String[] args) {
    ParkingLot parkingLot = ParkingLot.getInstance();
    Level level1 = new Level(1, 10);
    Level level2 = new Level(2, 8);
    parkingLot.addLevel(level1);
    parkingLot.addLevel(level2);

    Vehicle truck = new Car("truck-number123");
    parkingLot.parkVehicle(truck);
    parkingLot.displayAvailability();
  }
}
