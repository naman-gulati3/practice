package com.practice.lld.elevator_management_system;

import java.util.ArrayList;
import java.util.List;

public class ElevatorController {

  List<Elevator> elevators;

  public ElevatorController(int numElevators, int capacity) {
    elevators = new ArrayList<>();
    for (int i = 0; i < numElevators; i++) {
      Elevator elevator = new Elevator(i + 1, capacity);
      elevators.add(elevator);
      new Thread(elevator::run).start();
    }
  }

  public void requestElevator(int sourceFloor, int destinationFloor) {
    Elevator optimalElevator = findOptimalElevator(sourceFloor);
    optimalElevator.addRequest(new Request(sourceFloor, destinationFloor));
  }

  private Elevator findOptimalElevator(int sourceFloor) {
    Elevator optiomalElevator = null;
    int minDist = Integer.MAX_VALUE;

    for (Elevator elevator : elevators) {
      int dist = Math.abs(sourceFloor - elevator.getCurrentFloor());
      if (dist < minDist) {
        minDist = dist;
        optiomalElevator = elevator;
      }
    }
    return optiomalElevator;
  }
}
